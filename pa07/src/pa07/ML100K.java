package pa07;

import java.io.File;
import java.util.*;

/**
* This class holds all of the data from the ML-100K movie dataset.
* The users, movies, and reviews are loaded into
* public static ArrayList variables.
* This class uses a static initializer since this is
* core data that will be read once and will never change. This also
* gives an example of how to use static initializers.
*/
public class ML100K {
	

	/**
	* the ArrayList<User> of users from the ml-100k dataset
	*/
	public static ArrayList<User> users = new ArrayList<User>();
 
	/**
	* the ArrayList<Movie> of movies from the ml-100k dataset
	*/
	public static ArrayList<Movie> movies = new ArrayList<Movie>();

	/**
	* the ArrayList<Review> of reviews from the ml-100k dataset
	*/
	public static ArrayList<Review> reviews = new ArrayList<Review>();
	
	//public static Set<String> genres = new HashSet<String>();
	
	/**
	* a testing set of 10000 reviews from the ml-100k dataset
	*/
	public static ArrayList<Review> testSet = new ArrayList<Review>();

	/*
	 * and here are private, temporary arrays used to lookup 
	 * users, movies, and reviews by id number
	 * These are only used when the data is being read and stored in the
	 * ArrayLists...
	 */
	private static User[] theUsers; // an array of users indexed by the user id	
	private static Movie[] theMovies; // an array of movies indexed by movie id
	private static Review[] theReviews; // an array of movie reviews by users
	//public static String[] theGenres;
	
	private static int numMovies; //= 1682;
	private static int numUsers; // = 943;
	private static int numReviews; //= 100000;
	//private static int numGenres;



	
	
	// when we load this class the system will
	// execute the static initializer code below, 
	// and this will initialize the 
	// users, movies, and reviews arrays using the ml-100k data
	static {
		readDataSize(new File("ml-100k/u.info"));
		readUsers(new File("ml-100k/u.user"));
		readMovies(new File("ml-100k/u.item"));
		readReviews(new File("ml-100k/u.data"));	
		// finally, free up the space used to store users,movies,reviews by id
		theMovies=null;
		theUsers=null;
		theReviews=null;
	}
	
	private static void readDataSize(File file){
		try{
			Scanner scanner = new Scanner(file);
			ML100K.numUsers = scanner.nextInt();
			scanner.nextLine(); // skips the rest of the line
			ML100K.numMovies = scanner.nextInt();
			scanner.nextLine();
			ML100K.numReviews = scanner.nextInt();
			scanner.nextLine();
			
		}catch(java.io.FileNotFoundException e){
			System.out.println("Error in ReadDataSize: e="+e);
		}
	}
	
	private static void readUsers(File file){
		// user data is stored as  id|age|sex|occupation|zipcode

		theUsers = new User[numUsers+1];
		try{
			java.util.Scanner scanner = new java.util.Scanner(file);
			scanner.useDelimiter("\\|");
			for(int i = 0; i<numUsers; i++){
				int id = scanner.nextInt();
				int age = scanner.nextInt();
				String sex = scanner.next();
				String occupation = scanner.next();
				String zipcode=scanner.nextLine().trim(); // skip to next line
				//System.out.println(id+" "+age+" "+sex+" "+occupation+" "+zipcode);
				User u = new User(id,age,sex,occupation,zipcode);
				users.add(u);
				theUsers[id]=u;
				//System.out.println(users[id]);
			}
		} catch (Exception e) {
			System.out.println("Error in Recommender.readUsers: "+e);
		}
	}
	
	private static void readMovies(File file){
		// user data is stored as  id|title|tRelease|vRelease|url|....

		theMovies = new Movie[numMovies+1];
		try{
			java.util.Scanner scanner = new java.util.Scanner(file);
			scanner.useDelimiter("\\|");
			for(int i = 0; i<numMovies; i++){
				int id = scanner.nextInt();
				String title = scanner.next();
				String tRelease = scanner.next();
				String vRelease = scanner.next();
				String url=scanner.next();
				scanner.nextLine(); // skil to the next line ..
				//System.out.println(id+"|"+title+"|"+tRelease+"|"+vRelease+"|"+url);
				Movie m = new Movie(id, title, tRelease, vRelease, url);
				theMovies[id] = m;
				movies.add(m);
				//System.out.println(users[id]);
			}
		} catch (Exception e) {
			System.out.println("Error in Recommender.readMovies: "+e);
		}
	}
	
	public static int getNumMovies(){
		return numMovies;
	}
	
	public static Movie[] getMovies(){
		return (movies.toArray(new Movie[numMovies]));
	}
	
	
	private static void readReviews(File file){
		// user data is stored as  userId, movieID,rating,timestamp

		theReviews = new Review[numReviews];
		try{
			java.util.Scanner scanner = new java.util.Scanner(file);
			scanner.useDelimiter("[\\t\\r\\n]");// tab or end of line characters
			for(int i = 0; i<numReviews; i++){
				int userId = scanner.nextInt();
				int movieId = scanner.nextInt();
				int rating = scanner.nextInt();
				int timestamp =scanner.nextInt(); // skip to the next line ..
				//scanner.nextLine(); // skip the white space at the end of the line
				//System.out.println(userId+"|"+movieId+"|"+rating+"|"+timestamp);
				Movie m = theMovies[movieId];
				User u = theUsers[userId];
				Review r = new Review(u,m,rating,timestamp);
				theReviews[i]=r;
				
				if (i<10000) {
					testSet.add(r);
				}else{
					reviews.add(r);
					// here we add the review to its movie's list of reviews
					m.getReviews().add(r);
				}
				//System.out.println(reviews[i]);
			}
		} catch (Exception e) {
			System.out.println("Error in Recommender.readReviews: "+e);
		}
	}


	
}
