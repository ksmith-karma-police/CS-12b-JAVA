package pa07;
import java.util.*;

/**
 * A Predictor has a method to predict the rating a user will give to a movie.
 * It is assumed to be called on a movie the user has not yet seen...
 * @author Kristen Smith
 * @version 4.0
 */

public class Predictor {
	private User u;
	private Movie m;
//  private int userAge;
	
	
	public double predict(User u, Movie m){
		ArrayList<Review> reviews = m.getReviews();
		ArrayList<Review> byGender = getByGender(reviews, m, u.getGender());
		ArrayList<Review> byAge = getByAge(byGender, m, u.getAge());
		ArrayList<Review> byJob = getByOccupation(byAge, m, u.getOccupation());

		
		//1.077: gender/job/age
		
		double mean = 0;	
		if(!zeroSize(byGender)){
			mean = calcMean(byGender);
			return mean;
		} else if (zeroSize(byGender) && !zeroSize(byJob)){
			mean = calcMean(byJob);
			return mean;
		} else if (zeroSize(byJob) && !zeroSize(byAge)){
			mean = calcMean(byAge);		
			return mean;
		} else {						
			mean = calcMean(reviews);
			//System.out.println("Error. Mean = " + mean);
			return mean;
		}		
	}
	
	/**
	 * Cuts down on redundancy in finding the mean of various
	 * filtered ArrayList<Review(s)> in the predict(User u, Movie m) method.
	 * @param revs the filtered list to find the average rating from
	 * @return the average rating for this list
	 */
	public double calcMean(ArrayList<Review> revs){
		double sum = 0;
		double rating = 0;
		double mean = 0;
		for (Review r:revs){
			rating = r.getRating();
			sum += rating;
		}
		if (sum != 0.0){
			mean = sum / revs.size();
			mean = checkMean(mean);
		} else if (sum == 0){ //Necessary so we don't get means of 0.0, which cause an error in PredictorTester
			mean = 0.5;
		}
		return mean;
	}
	
	/**
	 * Makes sure the mean returned is in the correct range
	 * for PredictorTester
	 * @param d
	 * @return the "checked" mean 
	 */
	public double checkMean(double d){
		if (d < 1.0 ){
			return 1.0;
		} else if (d > 5.0){
			return 5.0;
		} else {
			return d;
		}
	}
	
	public boolean zeroSize(ArrayList<Review> list){
		return list.size() == 0 || list == null;
	}

	
	/**
	 * Filters the ArrayList of reviews for this movie by those who fall into
	 * the same age category as the user we are making the prediction for.
	 * @param mReviews all the reviews for this movie
	 * @param m the movie we are making a prediction for
	 * @param age the user's age
	 * @return an ArrayList filtered by those reviewed the movie
	 * who match the same age category as 
	 * the user.
	 */
	public ArrayList<Review> getByAge(ArrayList<Review> mReviews, Movie m, int age){
		ArrayList<Review> byAge = new ArrayList<Review>();
		
		//More accurate than using exact age
		for (Review r:mReviews){
			int age2 = r.getUser().getAge();
			if (age <= 12 && age2 <= 12){
				byAge.add(r);
			} else if (age > 12 && age <= 18 
					&& age2 > 12 && age2 <= 18){
				byAge.add(r);
			} else if (age > 18 && age <= 24
					&& age2 > 18 && age2 <= 24){
				byAge.add(r);				
			} else if (age > 24 && age <= 33
					&& age2 > 24 && age2 <= 33){
				byAge.add(r);
			} else if (age > 33 && age <= 43 &&
					age2 > 33 && age2 <= 43){
				byAge.add(r);
			} else if (age > 43 && age <= 55 &&
					age2 > 43 && age2 <= 55){
				byAge.add(r);
			} else if (age > 55 && age <= 65 &&
					age2 > 55 && age2 <= 65){
				byAge.add(r);
			} else if (age > 65 && age2 > 65){
				byAge.add(r);
			}
		}
		return byAge;		
	}
	
	/**
	 * For testing purposes
	 * @param age
	 * @return thea ge category this user falls into
	 */
	public String getAgeCategory(int age){
		String category = "";
		if (age <= 12){
			category += "CHILD";
		} else if (age > 12 && age <= 18){
			category += "TEENAGER";
		} else if (age > 18 && age <= 24){
			category += "YOUNG ADULT";				
		} else if (age > 24 && age <= 33){
			category += "ADULT 1";
		} else if (age > 33 && age <= 43){
			category += "ADULT 2";
		} else if (age > 43 && age <= 55){
			category += "MIDDLE-AGED";
		} else if (age > 55 && age <= 65){
			category += "PRE-SENIOR";
		} else if (age > 65){
			category += "SENIOR";
		}
	return category;
	}
	
	/**
	 * 
	 * @param revs
	 * @param m
	 * @param gender
	 * @return
	 */
	public ArrayList<Review> getByGender(ArrayList<Review> revs, Movie m,String gender){
		ArrayList<Review> byGender = new ArrayList<Review>();
		for (Review r: revs){
			String reviewerGender = r.getUser().getGender();
			if (reviewerGender.equalsIgnoreCase(gender)){
				byGender.add(r);
			}
		}
		
		return byGender;
	}
	
	/**
	 * 
	 * @param revs
	 * @param m
	 * @param uOcc
	 * @return
	 */
	public ArrayList<Review> getByOccupation(ArrayList<Review> revs, Movie m, String uOcc){
		ArrayList<Review> byOccupation = new ArrayList<Review>();
		for(Review r:revs){
			String revOccupation = r.getUser().getOccupation();
			if(revOccupation.equalsIgnoreCase(uOcc)){
				byOccupation.add(r);
			}
		}
		return byOccupation;
	}
	
	/**
	 * For testing purposes (see MovieWizard)
	 * @return the movie we are predicting the rating for
	 */
	public Movie getMovie(){
		return this.m;
	}
	
	public void setMovie(Movie m2){
		this.m = m2;
	}
	
	/**
	 * For testing purposes (see MovieWizard)
	 * @return the user for whom we are trying to make a prediction
	 */
	public User getUser(){
		return this.u;
	}
	
}
