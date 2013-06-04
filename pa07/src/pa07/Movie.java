package pa07;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
* a Movie stores the name, id number, release year, and other info
* as taken from the grouplens ml-100 dataset.
*/

public class Movie {
	
	private int id;
	private String title;
	private String theaterRelease;
	private String videoRelease;
	private String url;
	private ArrayList<Review> reviews;
//	private Set<Genre> genres;
	
	// genreVals is the array of genre values
	//private static Genre[] genreVals = Genre.values();
	
	public Movie(){
		this.id = ML100K.movies.size() + 1;
		this.title = "George of the Jungle 500";
		this.theaterRelease = "March 2013";
		this.videoRelease = theaterRelease;
		this.url = "www.random.com";
		this.reviews = new ArrayList<Review>();
	}
	
	public Movie(int id, String title, String theaterRelease, String videoRelease, String url) {
		this.id = id;
		this.title=title;
		this.theaterRelease=theaterRelease;
		this.videoRelease=videoRelease;
		this.url=url;
		this.reviews = new ArrayList<Review>();
//		this.genres = new HashSet<Genre>();
//		// create the Genre set from "0" and "1" strings
//		for (int i=0; i<genreStrings.length; i++){
//			if (genreStrings[i].equals("1")){
//				genres.add(genreVals[i]);
//			}
//		}
	}
	
	/**
	* accessor for the ml-100k id of the movie
	* @return id
	*/
	public int getId(){
		return this.id;
	}
	
	/**
	* accessor for the title of the movie
	* @return title (with release year)
	*/
	public String getTitle(){
		return this.title;
	}
	
	/**
	* accessor for the Theater Release date
	* in the form in form dd-Mmm-yyyy, e.g. 01-Jan-1999
	* @return date it was released in Theaters
	*/
	public String getTheaterRelease(){
		return this.theaterRelease;
	}
	
	/**
	* accessor for the Video Release date
	* in the form in form dd-Mmm-yyyy, e.g. 01-Jan-1999
	* @return date it was released as a Video
	*/
	public String getVideoRelease(){
		return this.videoRelease;
	}
	
	/**
	* the URL of the movie on IMDB.com
	* @return the IMDB.com url for this movie
	*/
	public String getUrl(){
		return this.url;
	}
	
	public static Movie getMovie(String s){
		Movie m2 = new Movie();
		for(Movie m:ML100K.movies){
			if(m.getTitle().equalsIgnoreCase(s)){
				m2 = m;
				break;
			}
		}
		return m2;
	}
	
	/**
	* accessor for the set of genres
	* @return genre set
	*/
//	public Set<Genre> getGenres(){
//		return this.genres;
//	}
	
	/**
	 * returns the ML-100K reviews
	 * @return an ArrayList of reviews from ML-100K
	 */
	public ArrayList<Review> getReviews(){
		return reviews;
	}
	
	/**
	* this returns a simple string representation with the id and title
	* @return a string with the id and title of the movie
	*/
	public String toString(){
		return "m"+id+":"+title;
	}

}
