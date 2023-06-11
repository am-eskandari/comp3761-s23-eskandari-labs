package com.example.comp3761s23eskandari.labs.lab03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {

	/*
	 * Returns an ArrayList of words from a file.
	 */
	static ArrayList<String> read(String file) throws FileNotFoundException
	{
		ArrayList<String> list 	= new ArrayList<String>();
		Scanner reader			= new Scanner(System.in);

		reader = new Scanner(new FileReader(file));
		
		while(reader.hasNext()) // reads the file until end of file is reached
			list.add(reader.next()); //stores these words in an array

		reader.close();

		return list;
	}

	/*
	 * Sequential Search or Linear Search is a brute force technique which forces
	 * the program to loop through each index until the key value is found.
	 * Normally the technique would have an efficiency of O(n) if the program is looking
	 * for a single key. However, in this case the efficiency should be O(n^2) as we are
	 * comparing 2 different ArrayLists and the outer loop is dependent of the inner loop.
	 * Efficiency : O(n^2)
	 */
	static void seqSearch(ArrayList<String> test, ArrayList<String> words)
	{
		double startTime, elapsedTime;
		ArrayList <String> wordsNotFound = new ArrayList<String>();
		int count 				= 0;

		startTime = System.currentTimeMillis();

		// Implement seqSearch
		for(String testWord : test){
			boolean found = false;
			for(String word : words){
				if(testWord.equalsIgnoreCase(word)){
					found = true;
					break;
				}
			}
			if(!found){
				count++;
				wordsNotFound.add(testWord);
			}
		}

		elapsedTime = (System.currentTimeMillis() - startTime) * 1000;
		System.out.println("Sequential Search:\t" + count + " words not found. " + elapsedTime + " microseconds.");
		System.out.println("Words not found:\t" + wordsNotFound);
	}

	/*
	 *  Binary search is a method in which the 'middle' index of reference array
	 *  and the 'key' value is always compared. In each comparison, the middle
	 *  index adjusts depending if the key is < or > or = to the middle.
	 *  Looping through the test_data is (n) times, and comparing it using
	 *  binary search technique is (logn).Thus, program is supposed to run (n)(logn) times
	 *  Efficiency : O(nlogn)
	 */
	static void binSearch(ArrayList<String> test, ArrayList<String> words)
	{
		double startTime, elapsedTime;
		ArrayList <String> wordsNotFound	= new ArrayList<String>();
		int count 				= 0;

		startTime = System.currentTimeMillis();

		// Implement binSearch
		for(String testWord : test){
			boolean found = binarySearch(words, testWord);
			if(!found){
				count++;
				wordsNotFound.add(testWord);
			}
		}

		elapsedTime = (System.currentTimeMillis() - startTime) * 1000;
		System.out.println("Binary Search:\t\t" + count + " words not found. " + elapsedTime + " microseconds.");
		System.out.println("Words not found:\t" + wordsNotFound);
	}

	// Auxiliary method for binary search
	static boolean binarySearch(ArrayList<String> words, String key){
		int low = 0;
		int high = words.size() - 1;

		while(low <= high){
			int mid = low + (high - low) / 2;
			int result = key.compareToIgnoreCase(words.get(mid));

			if(result < 0){
				high = mid - 1;
			} else if(result > 0){
				low = mid + 1;
			} else{
				return true;
			}
		}

		return false;
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList <String> test		= read("lab3_testdata.txt");
		ArrayList <String> words	= read("lab3_wordlist.txt");

		seqSearch(test, words);
		System.out.println();
		binSearch(test,words);
	}

}
