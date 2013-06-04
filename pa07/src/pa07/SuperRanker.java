package pa07;

import java.util.Scanner;

/**
 * This ranker is created by interviewing the user.
 * The user info is used to define a rankMovie method
 * that will rank movies using the user's info and
 * the data from the ML100K dataset
 * @author Kristen Smith
 * @version 1.0
 *
 */
public class SuperRanker extends MovieRanker {
	private static User addedUser;

	/**
	 * Explicit Constructor. Generates a userID for the user,
	 * creates the new user (see User.java), and adds the user
	 * to the ArrayList of users in the ML100K dataset.
	 * @param age
	 * @param gender
	 * @param occupation
	 * @param zip
	 */
    public SuperRanker(int age, String gender, String occupation, String zip){
    	int ID = ML100K.users.size() + 1;
    	//ML100K.numUsers++;
    	this.addedUser = new User (ID, age, gender, occupation, zip);
    	//ML100K.users.add(addedUser);
    }
	
    /**
	 * Create a ranker based on info from the user
	 * this method will ask the user several questions
	 * and based on the answers create a SuperRanker
	 * object that will rank using the user info
	 * @return a SuperRanker object
	 */
	public static SuperRanker createFromUserInfo(Scanner s){
	    // you should interact with the user to get information about them
	    // that you can store in fields of this SuperRanker class
		System.out.println("What is your age? ");
		int age = s.nextInt();
		System.out.println("What is your gender? ");
		String gender = s.next();
		System.out.println("What is your occupation? ");
		String occupation = s.next();
		System.out.println("What is your zipcode? ");
		String zip = s.next();	    
		return new SuperRanker(age, gender, occupation, zip);
	}
	
	@Override
	public String toString(){
	    return "SuperRanker";
	}
	
	
	
	/**
	 * Getter method.
	 * @return the user the prediction is being made for
	 */
	public User superUser(){
		return addedUser;
	}

	/**
	 * Uses a Predictor to make a prediction for this user
	 * and movie <m>
	 * @param m the movie the prediction is being made for
	 * @return the predicted rating for movie m.
	 */
	@Override
	public double rateMovie(Movie m) {
	    // Use the fields of this class and the ML100K dataset to rate
	    // the movie m by looking at all reviews of the movie and seeing
	    // how closely the reviewers of the movie match the user you are
	    // making recommendations for. This stub method just returns a 3
	    // for every movie...
		Predictor p = new Predictor();		
		double rating = p.predict(superUser(), m);
		return rating;
	}
	
	

}
