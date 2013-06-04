package pa06;
import java.util.*;

/**
 * Assignment: PA06
 * @author Kristen Smith (ksmith22@brandeis.edu)
 * @version 4.0
 * 4/16/13 1:16 PM
 *
 */
public class EditDistance {
	private static String startWd;
	private static String endWd;
	private static boolean gameOver; //does this really need to be static?
	private static Set<String> sameLengthWds; //does this really need to be static?
	
	/**
	 * Implicit/default constructor
	 */
	public EditDistance(){
		startWd = null;
		endWd = null;
//		this.startLength = 0;
//		this.endLength = 0;
		gameOver = false;
		sameLengthWds = new TreeSet<String>();
	}
	
	/**
	 * Does the main work of the program--
	 * Iterates through the map created in entireMap()
	 * and tries to find the "endWd"
	 */
	public static void mainGameLoop(){
		//Records how each word was generated
		//Retrieves all words edit step 1 away from the startWd
		Map<String, Set<String>> tmp = entireMap();

		//Holds the words we just looked at/the path in reverse order
		Map<String,String> prevWord = new TreeMap<String, String>();
		
		//Holds the words we have not obtained "oneLetterDifferent" for from
		//the map of all the dictionary words (tmp)
		List<String> nextWord = new LinkedList<String>();
		
		//To hold the values for nextWord, so we can modify them
		//within the loop that iterates over nextWord
		List<String> nextTemp = new LinkedList<String>();

		//Initialize prevWord, nextWord, and nextTemp before we enter the main loop
		prevWord.put(startWd, " FIRSTWORD");
		for(String s:tmp.get(startWd)){
			if(!s.equals(startWd)){	
				prevWord.put(s,startWd);
				nextWord.add(s);
				nextTemp.add(s);
			}
		}		
		
		//Keeps track of the iterations
		int count = 0;			
		//So loop keeps going until it finds the word/hits a very high number
		boolean isEmpty = false; 
		
		//Main game loop
		while(!isEmpty){
			String w = nextTemp.get(0);
			
			//To make sure the loop is not entered again when the game is over
			if(gameOver == true){
				break;
			}
			
			//Print out the info for each "list" to see where we are
			//(uncomment for testing purposes)
//			System.out.println("************************** " + count);			
//			System.out.println("nextWord = " + nextWord);
//			System.out.println("nextTemp = " + nextTemp);
//			System.out.println("prevWord = " + prevWord);
			
			//Holds the set of Strings that have one letter different
			//from word <w> -- obtained from the map of all words in the dictionary.
			Set<String> theList = tmp.get(w);
			
			//remove w because it is redundant
			theList.remove(w); 	
			
			//System.out.println("\ntheList for "+ w + " is: " + theList + "\n"); //For testing purposes
			
			//Remove w because it is redundant
			nextTemp.remove(w);				
			
			//Important--make sure we haven't already added <t>
			//to the prevWord map!!
			for(String t:theList){					
				if(!nextTemp.contains(t) && 
				   !t.equals(startWd) && 
				   gameOver == false &&
				   !prevWord.containsKey(t))
				{					
				   nextTemp.add(t);
				   prevWord.put(t,w);
				}
				//Test to see if we have found the goal/end word
				//If so, print the trail of words from end back to start
				//and then break so the outer while loop doesn't keep going.
				if(t.equals(endWd)){
					//If you want to see how many times the outer loop
					//has iterated, uncomment this print statement...
					//System.out.println("Count = "+count);
					count = 0;
					System.out.println("Found the end word!\n");
					System.out.println("Path: ");
					String r = t;
					String nextWd = r;
					while(!nextWd.equals(startWd)){
						System.out.println(nextWd);
						nextWd = prevWord.get(r);
						r = nextWd;
						count++;
						if(count > 50){
							break;
						}
					}
					System.out.println(startWd);
					System.out.println("\nIt took " + count + " steps to find.\n");
					gameOver = true;					
					break;
				}										
			}
			count++;
			
			//In case the goal word cannot be found, and the path is impossible,
			//break after we hit a high number of iterations so this doesn't go
			//on infinitely (topic-->quack hits 1177, which is 45 edit distance).			
			if(count > 1400 && gameOver == false){
				System.out.println("The word path cannot be found or is impossible. Sorry.");
				break;
			}
			
		}			
	}
	
	/**
	 * Generates a map from all the words in dict.txt to the set of words
	 * which are only one letter different from each word. Each word in dict.txt
	 * is a key.
	 * @param wds ??
	 * @return the set containing words which differ by one letter from the startWd
	 */
	public static Map<String, Set<String>> entireMap(){
		Map<String, Set<String>> oneCharDiff = new TreeMap<String, Set<String>>();
		Set<String> keys = new TreeSet<String>();
		
		//Necessary?
		for(String s: Words.words){
			keys.add(s);
		}
		
		char[] alphabet = 
			{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		for(String key: keys){
			//Set<String> sameLength = getSameLengthWds(key);//cut?
			Set<String> matches = new TreeSet<String>();
			
			for(int i = 0; i < key.length();i++){
				for(int j = 0; j < alphabet.length; j++){
					String wd2 = key.substring(0, i) + alphabet[j] + key.substring(i+1);					
					if(keys.contains(wd2)){
						matches.add(wd2);
					}
				}
			}
			oneCharDiff.put(key, matches);
		}
		return oneCharDiff;
	}
	
	//Does this really need to be static?
	/**
	 * 
	 * @return
	 */
	public static boolean gameOver(){
		return sameLengthWds().contains(endWd);
	}
	
	/**
	 * Returns the set of all words in dict.txt
	 * of length <startLength> that can be obtained
	 * by changing only one letter in word <startWd>.
	 * 
	 * NOTE: Ended up not using this method in <entireMap()>
	 * because it slowed down the runtime considerably.
	 * @param startWd
	 * @return all words from dict.txt which have the same length as startWd
	 */
	public static Set<String> getSameLengthWds(String wd){
		ArrayList<String> allWords = Words.words;
		Set<String> temp = new TreeSet<String>();
		for(String s:allWords){
			if (s.length() == wd.length()){
				temp.add(s);
				sameLengthWds.add(s);
			}
		}		
		
		return temp;
	}
	
	/**
	 * 
	 * @return the TreeSet of words the same length
	 * as the input wd. See getSameLengthWds(String wd).
	 */
	public static Set<String> sameLengthWds(){
		return sameLengthWds;
	}
	
	/**
	 * (Getter method)
	 * @return the endWd the user entered
	 */
	public String getEndWd(){
		return endWd;
	}
	
	/**
	 * (getter method)
	 * @return the startWd the user entered
	 */
	public String getStartWd(){
		return startWd;
	}
	
	//does this really need to be static?
	/**
	 * Used by the main method
	 * @return the endWord's length
	 */
	public static int getEndLength(){
		return endWd.length();
	}
	
	/**
	 * Used in the main method
	 * @return the length of the startWd's length
	 */
	public static int getStartLength(){
		return startWd.length();
	}

	/**
	 * Prompts user for the start and end words.
	 * @param args
	 */
	public static void main(String[] args) throws ConcurrentModificationException {
		Scanner s = new Scanner(System.in);
		System.out.println("Please type your start word: ");
		startWd = s.next();
		System.out.println("Please type the end word of the same character length as the start word: ");
		endWd = s.next();
		
		//Keeps prompting the user until two words of the same character length are entered.
		while (getStartLength() != getEndLength()){
			System.out.println("You have not typed two words of the same character length.");
			System.out.println("\nPlease type your start word: ");
			startWd = s.next();
			System.out.println("Please type the end word of the same character length as the start word: ");
			endWd = s.next();
		}
				mainGameLoop();
	}
}
