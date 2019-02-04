package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String acro = "";
		String phraseReg = "[^a-zA-Z]+";
		String[] words = phrase.split(phraseReg);
		
		for(String w: words) {
			String firstLetter = Character.toString(w.charAt(0));
			firstLetter = firstLetter.toUpperCase();
			acro += firstLetter;
		}
		
		return acro;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(sideOne == sideTwo) {
				if(sideOne == sideThree) {
					return true;
				}
			}
			return false;
		}

		public boolean isIsosceles() {
			if(sideOne == sideTwo && sideOne != sideThree) {
				return true;
			}
			else if(sideOne == sideThree && sideOne != sideTwo) {
				return true;
			}
			else if(sideTwo == sideThree && sideTwo != sideOne) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isScalene() {
			if(sideOne != sideTwo && sideOne != sideThree && sideTwo != sideThree) {
				return true;
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int x = 0;
		
		HashMap<String, Integer> letters = new HashMap<String, Integer>();
		letters.put("A", 1);
		letters.put("E", 1);
		letters.put("I", 1);
		letters.put("O", 1);
		letters.put("U", 1);
		letters.put("L", 1);
		letters.put("N", 1);
		letters.put("R", 1);
		letters.put("S", 1);
		letters.put("T", 1);
		letters.put("D", 2);
		letters.put("G", 2);
		letters.put("B", 3);
		letters.put("C", 3);
		letters.put("M", 3);
		letters.put("P", 3);
		letters.put("F", 4);
		letters.put("H", 4);
		letters.put("V", 4);
		letters.put("W", 4);
		letters.put("Y", 4);
		letters.put("K", 5);
		letters.put("J", 8);
		letters.put("X", 8);
		letters.put("Q", 10);
		letters.put("Z", 10);
		
		string = string.toUpperCase();
		char[] letter = string.toCharArray();
		
		for(char l: letter) {
			x += letters.get(Character.toString(l));
		}
		
		return x;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	
	public String cleanPhoneNumber(String string) {
		String num = "";
		String regex = "[^0-9]+";
		String regex29 = "[2-9]";
		String[] nums = string.split(regex);
		
		for(String s: nums) {
			num += s;
		}
		
		//Making sure 1st and 4th num is between 2-9
		String x = new String(num.substring(0, 1));
		String y = new String(num.substring(3, 4));
		if(!x.matches(regex29) || !y.matches(regex29)) {
			throw new IllegalArgumentException();
		}
		if(num.length() > 11) {
			throw new IllegalArgumentException();
		}
		//Don't know if I should throw another exception in case there are illegal characters in the string
		//They should all have been filtered out with the regex
		//At this point, the test case passes but that is only 
		//because there are illegal characters at 1st and 4th positions
		//but I guess could get through if 1st and 4th are legal but others aren't
		
		return num;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		String regex = "[^a-zA-Z]+";
		String[] word = string.split(regex);
		int count = 0;
		
		for(String w: word) {
			if(m.containsKey(w)) {
				count = m.get(w);
				count++;
				m.put(w, count);
			}
			else {
				m.put(w, 1);
			}
		}
		return m;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<? extends Comparable<T>> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int x = 0;
			int frontPos = 0;
			int endPos = this.sortedList.size();
			int middlePos = (endPos - frontPos) / 2;
			
			while(frontPos != endPos) {
				x = this.sortedList.get(middlePos).compareTo(t);
				
				if(x > 0) {
					//x is in the lower half
					endPos = middlePos;
					middlePos = (endPos + frontPos) / 2;
				}else if(x < 0) {
					//x is in the upper half
					frontPos = middlePos;
					middlePos = (endPos + frontPos) / 2;
				}else {
					//x == 0
					return middlePos;
				}
			}
			x = this.sortedList.get(frontPos).compareTo(t);
			if(x == 0) {
				return frontPos;
			}
			
			return 0;
		}

		public BinarySearch(List<? extends Comparable<T>> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<? extends Comparable<T>> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<? extends Comparable<T>> sortedList) {
			this.sortedList = sortedList;
		}
	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		String pLatin = "";
		String pLatinFull = "";
		String regex = "[aeiouAEIOU]";
		String ay = "ay";
		String[] words = string.split(" ");
		char c1;
		String s1 = "";
		String subS0 = ""; //consonant
		String subS1 = ""; //vowel
		int vowelPos = 0;
		
		for(int i = 0; i < words.length; i++) {
			c1 = words[i].charAt(0);
			s1 = Character.toString(c1);
			if(!s1.matches(regex)) {
				//find position of first vowel
				while(!s1.matches(regex)) {
					vowelPos++;
					s1 = words[i].substring(vowelPos, vowelPos+1);
				}
				
				subS0 = words[i].substring(0, vowelPos);
				//test for q special case
				if(subS0.equals("q")) {
					subS0 += "u";
					subS1 = words[i].substring(vowelPos+1, vowelPos+2);
					pLatin += words[i].substring(vowelPos+1, words[i].length());//middle of word
				}else {
					subS1 = words[i].substring(vowelPos, vowelPos+1);
					pLatin += words[i].substring(vowelPos+1, words[i].length());//middle of word
				}
				
				pLatin = subS1;
				pLatin += subS0;
				pLatin += ay;
				pLatin += " ";
				pLatinFull += pLatin.toString();
			}
			else {
				//word that starts w vowel
				pLatin = words[0];
				pLatin += ay;
				pLatinFull += pLatin;
			}
		}
		pLatinFull = pLatinFull.trim();
		return pLatinFull;
		//need to find different way to split up words
		//should probably also use StringBuilder in this situation
		//getting error with outofboundsexception
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		String s = Integer.toString(input);
		int numDigit = s.length();
		double result = 0.0;
		int total = 0;
		
		for(int i = 0; i < numDigit; i++) {
			int num = Integer.parseInt(s.substring(i, i+1));
			result = (Math.pow(num, numDigit));
			total += result;
		}
		
		if(total == input) {
			return true;
		}
		else {
			return false;	
		}
		
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> factors = new ArrayList<Long>();
		
		long test = 2;
		long n = l;
		
		while(n != 1) {
			if((n % test) != 0) {
				test++;
			}
			else {
				factors.add(test);
				n = n / test; 
			}
		}
		
		//
		//135 % 2 != 0
		//135 % 3 == 0	n -> 45
		//45 % 3 == 0	n -> 15
		//15 % 3 == 0	n -> 5
		//5 % 5 == 0	n -> 1
		
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;
		
		public RotationalCipher(int key) {
			super();
			this.key = key;
		}
		
		public String rotate(String string) {
			StringBuilder sb = new StringBuilder(string);
			StringBuilder x = new StringBuilder();
			char a;
						
			for(int i = 0; i < string.length(); i++) {
				a = sb.charAt(i);
				int charNum = a;
				
				//check if letter
				//A ==65
				//a == 97
				if(charNum >= 65 && charNum < 91) {
					charNum -= 65;
					charNum += key;
					charNum = charNum % 26;
					charNum += 65;
					x.append((char)charNum);
				}
				else if(charNum >= 97 && charNum < 123) {
					charNum -= 97;
					charNum += key;
					charNum = charNum % 26;
					charNum += 97;
					x.append((char)charNum);
				}
				//0 = 48
				else if(charNum >= 48 && charNum < 58) {
					x.append(a);
				}
				else {
					//is other character
					x.append(a);
				}
			}
			String cyph = x.toString();
			
			return cyph;
		}
		
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		int z = 0; //counter to keep track of where i am in array
		int num = 2;
		int[] primes = new int[i];
		
		//goes through each number until primes is full
		//tests if prime
		//if prime puts it into array
		//i is the nth prime so array will only ever be that long
		
		try {
			if(i == 0) {
				throw new IllegalArgumentException();
			}
			if(i == 1) {
				return 2;
			}
			while(z != i) {
				boolean test = false;
				
				for(int j = 2; j <= num/2; j++) {
					if((num % j) == 0) {
						//tests to see if the num is divisible by anything
						//if so can't be a prime
						test = true;
					}
				}
				if(test == false) {
					primes[z] = num;
					z++;
				}
				num++;
			}
		//is this best way to throw exception?
		//looks weird catching it and then throwing it
		}catch(IllegalArgumentException ex) {
			throw new IllegalArgumentException();
		} 
		
		//can just return last element of array since it should always be final element
		return primes[primes.length-1];
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		
		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String regex = "[^a-z0-9]+";
			String s = string.toLowerCase();
			String[] words = s.split(regex);
			StringBuilder x = new StringBuilder();
			String encoded = "";
			StringBuilder en = new StringBuilder();
			char c;
			int charVal;
			
			for(String w: words) {
				x.append(w);
			}
			for(int i = 0; i < x.length(); i++) {
				c = x.charAt(i);
				charVal = c;
				if(charVal >= 97 && charVal <= 122) {
					charVal -= 97;
					charVal = 25 - charVal;
					charVal += 97;
				}
				en.append((char)charVal);
			}
			for(int i = 0; i < en.length(); i++) { 
				if((i % 6) == 0) {
					en.insert(i, " ");
				}
			}
			encoded = en.toString();
			encoded = encoded.trim();
			return encoded;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String decoded = "";
			StringBuilder s = new StringBuilder();
			StringBuilder de = new StringBuilder();
			String[] words = string.split(" ");
			for(String w: words) {
				s.append(w);
			}
			
			for(int i = 0; i < s.length(); i++) {
				char c  = s.charAt(i);
				int charVal = c;
				
				if(charVal >= 97 && charVal <= 122) {
					charVal -= 97;
					charVal = 25 - charVal;
					charVal += 97;
				}
				de.append((char)charVal);
			}
			decoded = de.toString();
			decoded = decoded.trim();
			
			return decoded;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		int multiplier;
		int counter = 0;
		int total = 0;
		String regNum = "[0-9]";
		boolean checkMatch = false;
			
		for(int i = 0; i < string.length(); i++) {
			
			//converts char to string and checks if it matches regex
			checkMatch = Character.toString(string.charAt(i)).matches(regNum);
			
			if(checkMatch) {
				multiplier = 10 - counter;
				int num = Character.getNumericValue(string.charAt(i));
				total += (num * multiplier);
				counter++;
			}
			//if it does not match a num it might be X
			else if(checkMatch = Character.toString(string.charAt(i)).matches("X")) {
				total += 10;
			}
		}
		
		//if divisible by 11 then it is ISBN
		if((total % 11) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		//Could have hashtable/hashset of each key(ascii val) and pair it with a 
		//boolean or value that can determine if it used or not
		String lower = string.toLowerCase();
		String[] words = lower.split(" ");
		String s = "";
		
		for(String w: words) {
			s += w;
		}
		
		boolean test = true;
		
		HashMap<Character, Boolean> alpha = new HashMap<Character, Boolean>();
		alpha.put('a', false);
		alpha.put('b', false);
		alpha.put('c', false);
		alpha.put('d', false);
		alpha.put('e', false);
		alpha.put('f', false);
		alpha.put('g', false);
		alpha.put('h', false);
		alpha.put('i', false);
		alpha.put('j', false);
		alpha.put('k', false);
		alpha.put('l', false);
		alpha.put('m', false);
		alpha.put('n', false);
		alpha.put('o', false);
		alpha.put('p', false);
		alpha.put('q', false);
		alpha.put('r', false);
		alpha.put('s', false);
		alpha.put('t', false);
		alpha.put('u', false);
		alpha.put('v', false);
		alpha.put('w', false);
		alpha.put('x', false);
		alpha.put('y', false);
		alpha.put('z', false);
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(Character.isLetter(c)) {
				
				//need to see if it has already been replaced once
				if(!alpha.get(c)) {
					boolean b = alpha.replace(c, false, true);
					if(b == false) {
						System.out.println("Error replacing values");
						return false;
					}
				}
			}
		}
		
		for(int j = 0; j < 26; j++) {
			int charVal = 'a';
			charVal += j;
			
			boolean isThere = alpha.get((char)charVal);
			test = (test && isThere);
		}
		
		return test;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		Temporal x;
		LocalDate dT;
		LocalDateTime lDT;
		long seconds = 1_000_000_000;
		
		if(given instanceof LocalDate) {
		dT = (LocalDate)given;
		lDT = dT.atStartOfDay();
		lDT = lDT.plusSeconds(seconds);
		}
		else if(given instanceof LocalDateTime) {
			lDT = (LocalDateTime)given;
			lDT = lDT.plusSeconds(seconds);
		}else {
			throw new IllegalArgumentException();
		}
		
		x = lDT;
		return x;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		List<Integer> intList = new LinkedList<Integer>();
		int total = 0;

		for(int j = 0; j < i; j++) {
			for(int k = 0; k < set.length; k++) {
				if((j % set[k]) == 0) {
					intList.add(j);
				}
			}
		}
		//puts elements of list into a set to remove duplicates
		Set<Integer> intSet = new HashSet<>(intList);
		//clears list and puts it back in list
		intList.clear();
		intList.addAll(intSet);

		for(int x: intList) {
			total += x;
		}
		
		return total;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		String reg = "[^0-9]+";
		String[] parts = string.split(" ");
		StringBuilder s = new StringBuilder();
		int d = 0;
		String dString = "";
		int total = 0;
		
		for(String p: parts) {
			s.append(p);
		}
		
		//quick check to see if there is anything that shouldnt be in the string
		for(int i = 0; i < s.length(); i++) {
			dString = Character.toString(s.charAt(i));
			if(dString.matches(reg)) {
				return false;
			}
		}
		
		//Even length string so we can start doubling at first element
		if((s.length() % 2) == 0) {
			for(int i = 0; i < s.length(); i += 2) {
				d = Character.getNumericValue(s.charAt(i));
				d = ((d * 2) % 9);
				dString = Integer.toString(d);
				s.replace(i, i+1, dString);
			}
		}else {
			//else string length must be odd
			//do the same but start int i = 1
			for(int i = 1; i < s.length(); i += 2) {
				d = Character.getNumericValue(s.charAt(i));
				d = ((d * 2) % 9);
				dString = Integer.toString(d);
				s.replace(i, i+1, dString);
			}
		}
 		for(int i = 0; i < s.length(); i++) {
 			d = Character.getNumericValue(s.charAt(i));
 			total += d;
 		}
 		
 		if((total % 10) == 0) {
 			return true;
 		}
 		else {
 			return false;
 		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String[] words = string.split(" ");
		int num1;
		int num2;
		String plus = "plus";
		String minus = "minus";
		String multiplied = "multiplied";
		String divided = "divided";
		String[] actions = new String[4];
		int actionNum = 0;
		
		actions[0] = plus;
		actions[1] = minus;
		actions[2] = multiplied;
		actions[3] = divided;
		
		
		num1 = Integer.parseInt(words[2]);
		//should remove the last character (?) from word
		//probably much easier to use StringBuilder here
		words[words.length-1] = words[words.length-1].substring(0, words[words.length-1].length() - 1);
		num2 = Integer.parseInt(words[words.length-1]); 
		String action = words[3];
		
		for(String a: actions) {
			if((action.compareTo(a)) == 0) {
				break;
			}
			actionNum++;
		}
		
		if(actionNum == 0) {
			return num1 + num2;
		}else if(actionNum == 1) {
			return num1 - num2;
		}else if(actionNum == 2) {
			return num1 * num2;
		}else if(actionNum == 3) {
			return num1 / num2;
		}else {
			throw new IllegalArgumentException();
		}
		
		//Assumes words and numbers are in same position every time
	}

}
