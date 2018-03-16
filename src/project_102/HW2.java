package project_102;

import java.io.*;
import java.util.*;

public class HW2 {

	static Set<String> engset = new HashSet<>();
	static Set<String> frenchset = new HashSet<>();
	static Map<String, Integer> cybertron = new HashMap<>();
	//static Map<String, String> decepticon = new HashMap<>();

	// Prints a list of words that appear in both files.

	public static void intersection(String filename1, String filename2) {
		try (Scanner in1 = new Scanner(new FileReader(filename1));
				Scanner in2 = new Scanner(new FileReader(filename2))) {
			// Fill in.
			System.out.println("Printing Intersection: ");
			while (in1.hasNextLine()) {
				engset.add(in1.nextLine());
			}
			while (in2.hasNextLine()) {
				// frenchset.add(in2.nextLine());
				String aString = in2.nextLine();
				if (engset.contains(aString)) {

					System.out.println(aString);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints all words in the file that occur at least k times
	// (print the word followed by the number of occurrences in parentheses).
	// Each line in the file contains only one word.
	public static void frequentWords(String filename, int k) {
		try (Scanner in = new Scanner(new FileReader(filename))) {
			// Fill in.
			System.out.println();
			System.out.println("Printing Frequent Words: ");
			while (in.hasNextLine()) {
				String autobots = in.nextLine();
				if (cybertron.containsKey(autobots)) {
					cybertron.put(autobots, cybertron.get(autobots) + 1);
				} else {
					cybertron.put(autobots, 1);
				}
			}
			Set<Map.Entry<String, Integer>> jetfire = cybertron.entrySet();
			for (Map.Entry<String, Integer> i : jetfire) {
				if (i.getValue() >= k) {
					System.out.print(i.getKey() + " (");
					System.out.println(i.getValue() + ")");
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Returns the string with the characters sorted alphabetically.
	private static String sortString(String s) {
		char[] array = s.toCharArray();
		Arrays.sort(array);
		return new String(array);
	}

	// Prints all sets of anagrams, one set per line.
	// Each line in the file contains only one word.
	public static void anagrams(String filename) {
		Map<String, HashSet<String>> map = new HashMap<>();
		try (Scanner in = new Scanner(new FileReader(filename))) {
			// Fill in.
			String key;
			String sorted;
			while (in.hasNextLine()) {
				key = in.nextLine();
				sorted = sortString(key);
				HashSet<String> value = map.get(sorted);
				if (value == null) {
					map.put(sorted, value = new HashSet<>());
				}
				value.add(key);
			}
			System.out.println("\nPrinting Angrams: ");
			for (String i : map.keySet()) {
				Set<String> autobots = map.get(i);
				if (autobots.size() > 1)
					System.out.println(autobots);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		  /*String english =
		  "/home/adnanrahin/eclipse-workspace/Data_structure_Class/src/project_102/english_words.txt";
		  String french =
		  "/home/adnanrahin/eclipse-workspace/Data_structure_Class/src/project_102/french_words.txt";
		  intersection(english, french); frequentWords(english, 2); anagrams(english);*/
		 
		intersection("english_words.txt", "french_words.txt");
		frequentWords("english_words.txt", 2);
		anagrams("english_words.txt");
	}
}
