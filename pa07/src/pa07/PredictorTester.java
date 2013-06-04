 package pa07;
 
 import java.util.ArrayList;
 
 
 /**
  * The Prediction Tester creates a Predictor
  * and then uses it to predict each user's rating
  * of each reviewed movie.
  * @author tim
  */
 public class PredictorTester {
 	
 	public static void main(String[] args){
 		Predictor predictor = new Predictor();
 		int[] errDist = new int[10];
 		int[][] errs = new int[6][6];
 		ArrayList<Review> testSet = ML100K.testSet; 
 		
 		double error = 0;
 		for(Review r:testSet){
 			// make a prediction
 			double p = predictor.predict(r.getUser(), r.getMovie());
 			// round it to the nearest integer
 			p = Math.round(p);
 			// get the actual user's rating of the movie
 			double rating = r.getRating();
 			// store the error in a table
 			// with errDist[i] = count for error of i-4
 			errDist[(int)(p-rating)+4]++;
 			// count the prediction vs actual value
 			errs[(int)p][(int)rating]++;
 			// add the square of the error to thisError
 			// which is used to compute the RMS
 			double thisError = (p-rating)*(p-rating);
 			error += thisError;
 			//System.out.println(""+thisError+"review:"+r+":"+p+","+rating);
 		}
 		
 		printErrorDist(errDist);
 		printErrorTable(errs);
 
 		// Finally, print out the Root Mean Square Error
 		// this is what we want to minimize ...
 		double rms = Math.sqrt(error/ML100K.testSet.size());
 		System.out.println("Root Mean Square Error ="+rms);
 
 		
 	}
 	
 	private static void printErrorDist(int[] errDist){
 		System.out.println("error distribution");
 		System.out.println("frequence of pred-actual");
 		for(int j=-4;j<=4;j++){
 			System.out.println("err["+j+"]="+errDist[j+4]);
 		}	
 	}
 	
 	private static void printErrorTable(int[][] errs){
 		// print out the prediction/actual value matrix
 		// first print the headers
 		System.out.println("row=prediction, col=value");
 		System.out.print("\t\t\t");
 		for (int k=1;k<=5;k++) {
 			System.out.print("\tactual="+k);
 		}
		System.out.println();
		
		for (int j=1;j<=5;j++){
 			System.out.print("pred="+j+"\t\t");
 			for(int k=1;k<=5; k++)
 				System.out.print("\t\t"+errs[j][k]);
			System.out.println();
 		}
 	}

 }
