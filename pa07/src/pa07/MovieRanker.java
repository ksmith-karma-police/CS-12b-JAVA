package pa07;

import java.util.ArrayList;
import java.util.Collections;

/**
 * MovieRanker provides methods to rank the ML100K movies
 * @author tim
 *
 */
public abstract class MovieRanker {

	/**
	 * Create a sorted ranking of all the ML100K movies
	 * based on the score returned by the rankMovie method
	 * @return sorted list of movies
	 */
	public ArrayList<MovieRating> rankMovies(){
		ArrayList<MovieRating> ranking = new ArrayList<MovieRating>();
		for (Movie m:ML100K.movies){
			double r = rateMovie(m);
			MovieRating mr = new MovieRating(m,r);
			ranking.add(mr);
		}
		Collections.sort(ranking);
		return ranking;
	}
	
	/**
	 * This provides a numerical rating for a movie
	 * @param m the movie to rank
	 * @return a rating (possibly using ML100K data)
	 */
	public abstract double rateMovie(Movie m);
	
	
	/**
	 * Rank all the movies and print them out
	 */
	public void printRecommendations(int max){
				// rank the movies and print out the results
		ArrayList<MovieRating> ranking = this.rankMovies();

		// print out the top ranked movies
		System.out.println("Ranking: "+this);
		int count=0;
		for(MovieRating mr:ranking) {
			System.out.println(count+" M :"+mr);
			count++;
			if (count > max) break;
		}
	}

}
