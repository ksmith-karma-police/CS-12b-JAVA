/**
 * 
 */
package pa06;
import java.io.*;
import java.util.*;

/**
 * @author Kristen Smith
 * @version 1.0
 * 4/9/13 9:30 PM
 *
 */
public class Words {
	private static int numWords;	
	public static String[] theWords;
	
	public static ArrayList<String> words = new ArrayList<String>();
	
	/**
	 * Calls the methods to read the size of the dictionary
	 * and read the file containing the words in the dictionary
	 */
	static{
		File dictionary = new File("dict.txt");
		readDataSize(dictionary);
		readWords(dictionary);
		theWords = null;
	}
	
	/**
	 * 
	 * @param f
	 */
	public static void readDataSize(File f){
		int count = 0;
		try{
			Scanner s = new Scanner(f);
			while(s.hasNext()){
				count++;
				s.nextLine();
			}
			Words.numWords = count;
		} catch(FileNotFoundException e){
			System.out.println("Error reading datasize of words.txt e="+e);
		}
		
	}
	
	/**
	 * 
	 * @param f
	 */
	public static void readWords(File f){
		theWords = new String[numWords+1];
		try{
			Scanner s = new Scanner(f);
			s.useDelimiter("\\n");
			for(int i = 0; i < numWords; i++){
				String wd = s.next();
				words.add(wd);
				theWords[i] = wd;
			}
			
		} catch(Exception e){
			System.out.println("Error in readWords(File f) e= "+e);
		}
	}

}
