package pa07;

import java.util.Scanner;

/**
 * This ranks movies based on the female reviews only
 * @author tim
 *
 */
public class GenderRanker extends MovieRanker {

	private String sex;
	
	/**
	 * @param sex
	 */
	public GenderRanker(String sex) {
		this.sex = sex;
	}

	/**
	 * This ranks movies based on the sex of the user
	 * and it finds the total rating points for movies
	 * with a rating of 3 or more...
	 * @see pa05.MovieRanker#rateMovie(pa05.Movie)
	 */
	@Override
	public double rateMovie(Movie m) {
		double rating=0;
		for (Review r:m.getReviews()){
			User u = r.getUser();
			if (sex.equals(u.getGender())) {
				if (r.getRating()>=3)
					rating += r.getRating();
			}
		}
		return rating;
	}
	
	/**
	 * Creates a new GenderRanker using the gender the user inputs.
	 * @param scanner
	 * @return
	 */
	public static MovieRanker createFromUserInfo(Scanner scanner){
	  System.out.println("Enter a gender: (M or F)");
	  String sex = scanner.next();
	  return new GenderRanker(sex);
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in); // change to "new File"??
		MovieRanker mr = createFromUserInfo(scanner);
		mr.printRecommendations(20);
	}

}
