package pa07;
import java.util.*; 

/**
 * @author Kristen Smith (KSmith22@brandeis.edu)
 * @version 1.0
 *
 */
public class AgeRanker extends MovieRanker{
	private int age;
	
	public AgeRanker(int age){
		this.age = age;
	}
	
	/**
	 * Returns the average rating for this movie for people
	 * of this.age category...
	 * @param m
	 * @return
	 */
	@Override
	public double rateMovie(Movie m) {
		double rating = 0;
		double sum = 0;
		for (Review r:m.getReviews()){
			if (getAgeCategory(r.getUser().getAge()).equalsIgnoreCase(getAgeCategory(this.age))){
				rating = r.getRating();
				sum += rating;
			}
		}
		rating = (sum) / ((double)m.getReviews().size());
		return rating;
	}
	
	public String getAgeCategory(int a){
		String category = "";
		if (a <= 12){
			category += "CHILD";
		} else if (a > 12 && a <= 18){
			category += "TEEN";
		} else if (a > 18 && a <= 24){
			category += "YOUNG ADULT";
		} else if (a > 24 && a <= 33){
			category += "ADULT 1";
		} else if (a > 33 && a <= 43){
			category += "ADULT 2";
		} else if (a > 43 && a <= 55){
			category += "MIDDLE-AGED";
		} else if (a > 55 && a < 65){
			category += "PRE-SENIOR";
		} else {
			category += "SENIOR";
		}
		
		return category;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static MovieRanker createFromUserInfo(Scanner s){
		System.out.println("Enter an age: ");
		int a = s.nextInt();
		return new AgeRanker(a);
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in); // change to "new File"??
		MovieRanker mr = createFromUserInfo(scanner);
		mr.printRecommendations(20);
	}
	
	public int getAge(){
		return age;
	}

}
