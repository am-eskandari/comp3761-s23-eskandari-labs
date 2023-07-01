package com.example.comp3761s23eskandari.labs.lab06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class lab06 {
	public static void main(String[] args) throws FileNotFoundException {
		q1("love.txt");
		System.out.println();
		System.out.println(q2("q2input.txt"));
		System.out.println();
		q3("q3test.txt");
	}

	static void q1(String file) throws FileNotFoundException {
		System.out.println("Question 1 - Word Count (File: " + file + ")");
		Scanner reader = new Scanner(new FileReader(file));

		Map<String, Integer> wordCountMap = new TreeMap<>();

		while (reader.hasNext()) {
			String word = reader.next().toLowerCase();
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}

		reader.close();

		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

	static boolean q2(String file) throws FileNotFoundException {
		System.out.println("Question 2 - Distinct Words Check (File: " + file + ")");
		Scanner reader = new Scanner(new FileReader(file));

		Set<String> wordSet = new HashSet<>();

		while (reader.hasNext()) {
			String word = reader.next().toLowerCase();
			if (wordSet.contains(word)) {
				reader.close();
				return false;
			}
			wordSet.add(word);
		}

		reader.close();
		return true;
	}

	static void q3(String file) throws FileNotFoundException {
		System.out.println("Question 3 - Fictitious Excuse Identification (File: " + file + ")");
		Scanner reader = new Scanner(new FileReader(file));

		int keyWordsCount = reader.nextInt();
		int excuseCount = reader.nextInt();

		reader.nextLine(); // Skip the rest of the first line

		Set<String> keywords = new HashSet<>();
		List<String> excuses = new ArrayList<>();

		// Read keywords
		for (int i = 0; i < keyWordsCount; i++) {
			keywords.add(reader.nextLine().trim().toLowerCase());
		}

		// Read excuses
		for (int i = 0; i < excuseCount; i++) {
			String excuse = reader.nextLine().toLowerCase();
			excuses.add(excuse);
		}

		reader.close();

		Map<Integer, List<String>> excuseKeywordCountMap = new TreeMap<>(Collections.reverseOrder());
		Set<String> uniqueExcuses = new HashSet<>();

		// Evaluate excuses
		for (String excuse : excuses) {
			int keywordCount = 0;

			for (String keyword : keywords) {
				int index = excuse.indexOf(keyword);
				while (index != -1) {
					keywordCount++;
					index = excuse.indexOf(keyword, index + keyword.length());
				}
			}

			if (!uniqueExcuses.contains(excuse)) {
				List<String> excuseList = excuseKeywordCountMap.getOrDefault(keywordCount, new ArrayList<>());
				excuseList.add(excuse);
				excuseKeywordCountMap.put(keywordCount, excuseList);
				uniqueExcuses.add(excuse);
			}
		}

		// Print max excuses
		int maxKeywordCount = excuseKeywordCountMap.keySet().iterator().next();
		List<String> maxKeywordExcuses = excuseKeywordCountMap.get(maxKeywordCount);

		for (String excuse : maxKeywordExcuses) {
			System.out.println(excuse);
		}
	}
}
