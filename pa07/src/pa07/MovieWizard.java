package pa07;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

/**
 * MovieWizards generate movie rankings for a user
 * based on a short text-based interview. 
 * @author tim
 *
 */
public class MovieWizard {

	/**
	 * Make a movie recommendation for the user.
	 * Keep looping until user wants to quit
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String response;
		do {
			System.out.println("\n\n*********\n");
			MovieRanker mr = SuperRanker.createFromUserInfo(scanner);	
			mr.printRecommendations(10);	
			System.out.println("Try again? (y or n)");
			response = scanner.next().trim();
		} while (response.equals("y"));
		System.out.println("Goodbye\n");
		
		//testPredictor();
	}
	
//	public static void testPredictor(){
//		//ArrayList<Review> testSet = ML100K.testSet;
//		
//		Predictor p = new Predictor();
//		double prediction = Math.round(p.predict(p.getUser(), p.getMovie()));
////		System.out.println("The sum of all reviews byOccupation/byGender: "+ p.getSum());
////		System.out.println("The length of byOccupation/byGender: "+p.getLength());
//		System.out.println("The predicted rating for the movie is: "+prediction);
//		System.out.println("The actual rating the user gave the movie: 1");
//	}

}
