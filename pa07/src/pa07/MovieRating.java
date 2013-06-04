package pa07;

/**
 * A MovieRating is a pair consisting of a 
 * link to a Movie and a numerical rating
 * 
 * @author tim
 *
 */
public class MovieRating implements Comparable<MovieRating> {
	Movie movie;
	double rating;
	
	/**
	 * Create a pair consisting of a movie and a rating
	 * @param movie
	 * @param rating
	 */
	MovieRating(Movie movie, double rating){
		this.movie = movie;
		this.rating = rating;
	}
	
	/**
	 * Compare this MovieRating to another one
	 * using the rating field, return an int
	 * as specified by the Comparable interface
	 */
	public int compareTo(MovieRating other){
		if (this.rating > other.rating) return -1;
		if (this.rating < other.rating) return 1;
		return 0;
	}
	
	public String toString(){
		return this.rating+": "+this.movie.getTitle();
	}

}
