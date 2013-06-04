package pa07;

/**
* A Review has four components.
* <ul>
*   <li> the user making the review </li>
*   <li> the movie being reviewed </li>
*   <li> the rating (an integer from 0 to 5) </li>
*   <li> the timestamp of the review (number of seconds in 1/1/1970)</li>
* </ul>
*/
public class Review {

	/* NOTE: we are only creating public accessors since we don't want
	 * any clients changing the fields of a Review. It should be read-only
	 */
	
	private int rating;
	private Movie movie;
	private User user;
	private int timestamp;
	
	/**
	*  A review is created by specifying a userId, a movieId, a rating,
	*  and a timestamp indicating the number of seconds since 1/1/70.
	*/
	public Review(User u, Movie m, int rating, int timestamp){
		this.rating = rating;
		this.movie = m;
		this.user = u;
	}
	
	 
	/**
	* Accessor for the rating field of the review
	* @return the rating of the movie as specifed by the user
	*/
	public int getRating(){
		return this.rating;
	}
	
	/** 
	* Accessor for the movie field of the review
	* @return the movie which was rated by the user
	*/
	public Movie getMovie(){
		return this.movie;
	}
	
	/**
	* Accessor for the user field of the review
	* @return the user who rated the movie 
	*/
	public User getUser(){
		return this.user;
	}
	
	/**
	* create a user-readable string version of the review
	* with the rating, the movie title, and info about the user
	*/
	public String toString(){
		return ""+rating+"-"+this.movie.getTitle()+":"+this.user+":"+this.timestamp;
	}

}

