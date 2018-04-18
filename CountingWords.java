/*LaToya Anderson
 * CISC1115
 * April 18, 2018
 * 
 * This program reads in and prints text, line by line and calls
 * a series of methods to read in, counts the total number of
 * occurrences of each word and prints the list of words and their
 * counts.
 */
import java.util.Scanner;
import java.io.*;


public class CountingWords {
	/*Input: word - string array that stores sentences read in from files 
	 * 		 wordCount - int array that stores number of word occurrences 
	 * 
	 * Process: Reads in sentences into string array line by line and
	 * 				counts number of word occurrences
	 * 
	 * Output: Returns wordCount to main
	 * 
	 */
	public static void readInCount(String[] word, int[] wordCount) throws IOException {
		
		//Holds lyrics read in from file
		String lyrics;
		
		File myDNA = new File("C:/Users/staff/Desktop/DNALyrics.txt");
		
		Scanner seeDNA = new Scanner(myDNA);
		
		PrintWriter outPut = new PrintWriter(System.out);
		
		
		while(seeDNA.hasNext()) {
			lyrics = seeDNA.nextLine();
			System.out.println(lyrics);
			
		}
		
		
		//return wordCount;
		
	}

	/*Input: word - string array that stores sentences from _______ method
	 * 		 wordCount - int array that stores number of word occurrences
	 * 
	 * Process: Prints each word and their occurrence number line by line
	 * 
	 * Output: Prints each word and their occurrence number line by line 
	 * 				to output file
	 * 		 	Void return
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		//Max array size
		final int MAX = 100;
		
		//String array for lyrics
		String[] word = new String[MAX];
		
		//Int array for word count
		int[] wordCount = new int[MAX];
		
		readInCount(word, wordCount);
		

	}

}
