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
	/*Input: word - array of strings
	 * Process: Reads in file into a string which is then
	 * 				tokenized into a string array and counts
	 * 				total number of strings in array
	 * Output: Returns total number of strings read 
	 * 			into array to main
	 * 
	 */
	public static int readInCount(String[] word) 
			throws IOException {
		
		//Holds lyrics read in from file
		String lyrics;
		
		//Holds total number of words
		int wordTotal = 0;
		
		File myDNA = new File("/home/latoya/workspace/" +
				"WordCount/src/DNALyrics.txt");
		
	
		//Calls Scanner class and instantiates object
		Scanner seeDNA = new Scanner(myDNA);
		
		PrintWriter outPut = new PrintWriter(System.out);
		
		
		//Read in DNALyrics into String
		while(seeDNA.hasNext()) {
			lyrics = seeDNA.nextLine();
			word = lyrics.split(" ");	
		}
		
		//holds lyrics array length
		wordTotal = word.length;
	
		//method that counts total word occurrences
		lyricWordCount(word,wordTotal);
		
		return wordTotal;
	}
	
	/*Input: lyric - string array that stores sentences from method
	 * 		 wordIndex - integer that of total array index
	 * 
	 * Process: Counts each word occurrence number line by line
	 * 
	 * Output: Counts each word occurrence and sends to sort method
	 * 		 	Void return
	 */
	public static void lyricWordCount(String[] lyric, 
			int wordIndex) throws IOException{
		
		//holds each String from array to count occurrence
		String holdWord;
		
		//Array of word occurrences
		int[] wordCount = new int[100];
	
				//Loops through array to count word occurrences
				for(int index = 0; index <= wordIndex-1; index++){
					
					//holds each word as array is iterated
					holdWord = lyric[index];

					//Calls method to word occurrences
					wordCount[index] = multipleWords(lyric, 
							holdWord, wordIndex);
					}
				
					//method that deletes word repeats
					deleteRepeat(lyric,wordCount,wordIndex);
				
	
	}
	/*Input: lyrics - string array that stores sentences
	 * 				 read in from DNALyrics.txt
	 * 		holdWord - string that holds each word being tested
	 * 		index - integer array that stores number 
	 * 					of word occurrences 
	 * Process: Compares word to string array and reads in 
	 * 				occurrences into integer array
	 * Output: Returns wordCount to main
	 * 
	 */
	public static int multipleWords (String[] lyrics, 
			String holdWord, int index){
		
		//counter for word occurrences
		int wordCount = 0;
		
		//integer for word occurrences
		int[] wordCounts = new int[100];
		
		
		//Iterates through array to check for multiple words
		for(int i = 0; i < index; i++)
			if(lyrics[i].equals(holdWord))
				wordCount++;
		
		/*returns number of word occurrences back 
		to lyricWordCount method*/
		return wordCount;
		
	}
	/*Input: lyrics - string array of lyrics
	 * 		 wordCount - integer array of word occurrences
	 * 		 wordIndex - length of array
	 * Process: Deletes duplicate words and numbers in arrays
	 * 				and sends new array to be sorted alphabetically
	 * Output: Prints updated array to file
	 * 
	 */
		
	public static void deleteRepeat(String[] lyrics, 
			int[] wordCount, int wordIndex)throws IOException
	{
		PrintWriter outPutFile = new PrintWriter("/home/latoya/" +
				"workspace/WordCount/src/DNASoredCountedLyrics.txt");
	
		//loops through array to remove duplicates
		for(int i = 0; i < wordIndex; i++){
			
			for(int j = i+1; j < wordIndex; j++){
						
				if(lyrics[i].equals(lyrics[j])){
					lyrics[j] = lyrics[wordIndex-1];
					wordCount[j] = wordCount[wordIndex-1];
					wordIndex--;
					j--;
				}
			}
		}
		
		//method that sorts lyrics in alphabetical order
		sortLyrics(lyrics,wordCount,wordIndex);
	
		//loops through array to be printed to file
		for(int index = 0; index<wordIndex-1; index++)
			outPutFile.println(lyrics[index] + " " + wordCount[index]);
		
		outPutFile.flush();
		outPutFile.close();
	}
	
	/*Input: lyrics - string array of lyrics
	 * 		 wordCount - integer array of word occurrences
	 * 		 wordIndex - integer that holds array length
	 * Process: Sorts through array and alphabetizes
	 * Output: Rearranges strings and their parallel array occurrences
	 * 			in alphabetical order
	 */
	
	public static void sortLyrics(String[] lyrics, 
			int[] wordCount, int wordIndex){
		
		//Holds each iterated string
		String tempLyric;
		
		//Holds each iterated integer
		int tempCount;
		
		/*iterates through both arrays and sorts it
		in alphabetical order* using bubble sort*/
		for(int index = 0; index < (wordIndex-1); index++){
			for(int pos = (index+1); pos < wordIndex; pos++)
				if(lyrics[pos].compareToIgnoreCase(lyrics[index]) < 0)
				{
					tempLyric = lyrics[pos];
					tempCount = wordCount[pos];
					
					lyrics[pos] = lyrics[index];
					wordCount[pos] = wordCount[index];
					
					lyrics[index] = tempLyric;
					wordCount[index] = tempCount;

				}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		
		//Holds empty string array to send to method
		int wordTotal = 0;
		
		//Max array size
		final int MAX = 100;
		
		//String array for lyrics
		String[] word = new String[MAX];
		
		/*Calls method to read in DNALyrics.txt
		 and returns index */
		wordTotal = readInCount(word);
		
	}

}
