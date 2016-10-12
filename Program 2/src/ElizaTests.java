import java.util.Arrays;
///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Title:            ElizaTests
//Files:            ElizaTests.java
//Semester:         Comp Sci 302 Spring 2016
//
//Author:           Paul Howard
//Email:            pghoward@wisc.edu
//CS Login:         phoward
//Lecturer's Name:  Jim Williams
//Lab Section:      312
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//If pair programming is allowed:
//1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//2. choose a partner wisely
//3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//a. one partner creates the team
//b. the other partner must join the team
//4. complete this section for each program file.
//
//Pair Partner:     Bill Chang
//Email:          	bchang24@wisc.edu
//CS Login:         // TO DO 
//Lecturer's Name:  Jim Williams
//Lab Section:      312
//
////////////////////STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//must fully acknowledge and credit those sources of help.
//Instructors and TAs do not have to be credited here,
//but tutors, roommates, relatives, strangers, etc do.
//
//Persons:          Identify persons by name, relationship to you, and email.
//Describe in detail the the ideas and help they provided.
//
//Online sources:   avoid web searches to solve your problems, but if you do
//search, be sure to include Web URLs and description of 
//of any information you find.
////////////////////////////80 columns wide //////////////////////////////////

/**
 * Contains various tests for testing the Eliza program for efficiency and
 * correctness in responses, data manipulation, and inputs.
 *
 */

public class ElizaTests {

	/**
	 * Tests the chooseString method of the Eliza.java class to assure its
	 * correctness
	 *
	 */
	public static void testChooseString() {

		// is one of the 3 strings chosen?
		String[] strList = { "The", "happy", "cat" };
		String choice = Eliza.chooseString(strList);
		if (choice != null && (choice.equals("The") || choice.equals("happy") 
				|| choice.equals("cat"))) {
			System.out.println("testChooseString 1 passed.");
		} else {
			System.out.println("testChooseString 1 failed.");
		}

		// if I call it 100 times, are the choices approximately random?
		int countThe = 0;
		int countHappy = 0;
		int countCat = 0;
		for (int i = 1; i <= 100; i++) {
			choice = Eliza.chooseString(strList);
			if (choice != null) {
				if (choice.equals("The")) {
					countThe++;
				} else if (choice.equals("happy")) {
					countHappy++;
				} else if (choice.equals("cat")) {
					countCat++;
				}
			}
		}
		if (countThe >= 20 && countThe <= 45 && countHappy >= 20 && countHappy 
				<= 45 && countCat >= 20
				&& countCat <= 45) {
			System.out.println("testChooseString 2 passed. " + countThe + "," 
				+ countHappy + "," + countCat);
		} else {
			System.out.println("testChooseString 2 failed. " + countThe + "," 
		+ countHappy + "," + countCat);
		}
		// additional test suggestions:
		// What should happen when an array with a single string is provided?
		String[] strList2 = { "String" };
		String choice2 = Eliza.chooseString(strList2);
		if (choice2 != null && (choice2.equals("String"))) {
			System.out.println("testChooseString 3 passed.");
		} else {
			System.out.println("testChooseString 3 failed.");
		}
		// What should happen when null is passed to chooseString?
		String[] strList3 = { null };
		String choice3 = Eliza.chooseString(strList3);
		if (choice3 != null && (choice3.equals("The") || 
				choice3.equals("happy") || choice3.equals("cat"))) {
			System.out.println("testChooseString 4 failed.");
		} else if (choice3 == null) {
			System.out.println("testChooseString 4 passed.");
		}
	}

	/**
	 * Tests the testInList method of the Eliza.java class to assure its
	 * correctness
	 *
	 */
	public static void testInList() {
		String[] quitWords = { "bye", "goodbye", "quit", "bye" };
		int index = Eliza.inList("bye", quitWords);
		if (index >= 0) {
			System.out.println("testInList 1 passed.");
		} else {
			System.out.println("testInList 1 failed.");
		}

		index = Eliza.inList("seeya", quitWords);
		if (index == -1) {
			System.out.println("testInList 2 passed.");
		} else {
			System.out.println("testInList 2 failed.");
		}

		// test suggestion:
		// What should happen if "good" is looked for within the quitWords
		// above?
		// If the word good is searched for the word index should not be
		// returned as it is not the complete word
		String[] quitWords2 = { "bye", "goodbye", "quit", "bye" };
		int index2 = Eliza.inList("good", quitWords2);
		if (index2 == -1) {
			System.out.println("testInList 3 passed.");
		} else {
			System.out.println("testInList 3 failed.");
		}
		// Which index is returned if a word is listed more than once
		// in the list?
		// The index of the first word found will be returned
		String[] quitWords3 = { "bye", "goodbye", "quit", "bye" };
		int index3 = Eliza.inList("bye", quitWords3);
		if (index3 == 0) {
			System.out.println("testInList 4 passed.");
		} else if (index3 == 3) {
			System.out.println("testInList 4 failed.");
		}
	}

	/**
	 * Tests the testAssemblePhrase method of the Eliza.java class to assure 
	 * its correctness
	 *
	 */
	public static void testAssemblePhrase() {
		String[] words = { "This", "is a", "sentence" };
		String sentence = Eliza.assemblePhrase(words);

		String expectedSentence = "This is a sentence";

		if (sentence.equals(expectedSentence)) {
			System.out.println("testAssembleSentence 1 passed.");
		} else {
			System.out.println("testAssembleSentence 1 failed '" +
		sentence + "'");
		}

		// suggested test: What should happen when null is passed in?
		// Null should be returned
		String[] words2 = null;
		String sentence2 = Eliza.assemblePhrase(words2);
		if (sentence2 == null) {
			System.out.println("testAssembleSentence 2 passed.");
		} else {
			System.out.println("testAssembleSentence 2 failed '" 
		+ sentence + "'");
		}
	}

	/**
	 * Tests the testFindLongest method of the Eliza.java class to assure its
	 * correctness
	 *
	 */
	public static void testFindLongest() {
		String[] sentences = { "short", "This is longer.", 
				"This is the longest one.", "s" };
		String longest = Eliza.findLongest(sentences);
		if (longest == sentences[2]) {
			System.out.println("testFindLongest 1 passed.");
		} else {
			System.out.println("testFindLongest 1 failed.");
		}

		// what additional tests can you create?
		// If two sentences of the same length are passed in the first
		// longest string should be returned
		String[] sentences2 = { "Imperium", "Republic" };
		String longest2 = Eliza.findLongest(sentences2);
		if (longest2 == sentences2[0]) {
			System.out.println("testFindLongest 2 passed.");
		} else {
			System.out.println("testFindLongest 2 failed.");
		}
	}

	/**
	 * Tests the testHowMany method of the Eliza.java class to assure its
	 * correctness
	 *
	 */
	public static void testHowMany() {
		int countSpaces = Eliza.howMany(" ", " you me ");
		if (countSpaces == 3) {
			System.out.println("testHowMany 1 passed.");
		} else {
			System.out.println("testHowMany 1 failed.  countSpaces == " 
		+ countSpaces);
		}

		int countNum = Eliza.howMany("<2>", "What makes you think I am <2>?");
		if (countNum == 1) {
			System.out.println("testHowMany 2 passed.");
		} else {
			System.out.println("testHowMany 2 failed.  countNum == " 
		+ countNum);
		}
		// Additional Test
		// If a substring does not exist within a string then the count should
		// be returned as 0
		int countNothing = Eliza.howMany("snow", "Winter is coming");
		if (countNothing == 0) {
			System.out.println("testHowMany 3 passed.");
		} else {
			System.out.println("testHowMany 3 failed." + countNothing);
		}
	}

	/**
	 * Tests the testFilterChars method of the Eliza.java class to assure its
	 * correctness
	 *
	 */
	// TODO
	public static void testFilterChars() {
		String userInput = "w? #t   i't e   4t m-s!";
		char[] expectedChars = { 'w', '!', ' ', ' ', 't', ' ',
				' ', ' ', 'i', '\'', 't', ' ', 'e', ' ', ' ', ' ', '4',
				't', ' ', 'm', ' ', 's', '!' };
		char[] characters = Eliza.filterChars(userInput);
		if (userInput.length() == characters.length) {
			System.out.println("testFilterChars 1 passed.");
		} else {
			System.out.println("testFilterChars 1 failed.");
		}
		boolean error = false;
		for (int i = 0; i < expectedChars.length; i++) {
			if (expectedChars[i] != characters[i]) {
				System.out.print(
						String.format("characters[%d] '%c' expected '%c'\n", 
								i, characters[i], expectedChars[i]));
				error = true;
			}
		}
		if (error) {
			System.out.println("testFilterChars 2 failed.");
		} else {
			System.out.println("testFilterChars 2 passed.");
		}

		// Additional tests:

	}

	/**
	 * Tests the testRemoveDuplicateSpaces method of the Eliza.java class to
	 * assure its correctness
	 *
	 */
	public static void testRemoveDuplicateSpaces() {
		char[] chars1 = { 'a', 't', ' ', '.', ' ', ' ', 'g', ' ', ' ', 'h',
				' ' };
		Eliza.removeDuplicateSpaces(chars1);
		char[] expectedResult = { 'a', 't', ' ', '.', ' ', 'g', ' ', 'h', 
				' ', '\u0000', '\u0000' };

		boolean error = false;
		String errorStr = "";
		for (int i = 0; i < expectedResult.length; i++) {
			if (chars1[i] != expectedResult[i]) {
				errorStr += String.format("chars1[%d] '%c' expected '%c'\n", 
						i, chars1[i], expectedResult[i]);
				error = true;
			}
		}
		if (error) {
			System.out.println("testRemoveDuplicateSpaces 1 failed. "
		+ errorStr);
		} else {
			System.out.println("testRemoveDuplicateSpaces 1 passed.");
		}

		// Additional tests: If the input array contains nothing or the user
		// hits enter then the method ends and the array remains unchanged
		char[] chars2 = {};
		char[] expectedChars = chars2;
		Eliza.removeDuplicateSpaces(chars2);
		if (chars2 == expectedChars) {
			System.out.println("testRemoveDuplicateSpaces 2 passed. ");
		} else {
			System.out.println("testRemoveDuplicateSpaces 2 failed.");
		}

	}

	/**
	 * Tests the testFindAnyWords method of the Eliza.java class to assure its
	 * correctness
	 *
	 */
	public static void testFindAnyWords() {
		String[] someWords = { "Going", "now", "goodbye" };
		boolean found = Eliza.findAnyWords(someWords, Config.QUIT_WORDS);
		if (found) {
			System.out.println("testFindAnyWords 1 passed.");
		} else {
			System.out.println("testFindAnyWords 1 failed.");
		}

		String[] someMoreWords = { "Hello", "how", "are", "you" };
		found = Eliza.findAnyWords(someMoreWords, Config.QUIT_WORDS);
		if (!found) {
			System.out.println("testFindAnyWords 2 passed.");
		} else {
			System.out.println("testFindAnyWords 2 failed.");
		}

		// Additional test: If a list of words with multiple occurrences of the
		// same word are found return true for the first occurrence

		String[] someEvenMoreWords = { "I", "quit", "now", "goodbye", "I",
				"quit" };
		found = Eliza.findAnyWords(someEvenMoreWords, Config.QUIT_WORDS);
		if (found) {
			System.out.println("testFindAnyWords 3 passed.");
		} else {
			System.out.println("testFindAnyWords 3 failed.");
		}

	}

	/**
	 * Tests the testInitialProcessing of the Eliza.java class to assure its
	 * correctness
	 *
	 */
	// TODO
	public static void testInitialProcessing() {
		String sentence = Eliza.initialProcessing("What? This isn't the " + " "
				+ "   4th messy-sentence!");
		if (sentence != null && sentence.equals(
				"this isn't the 4th messy sentence")) {
			System.out.println("testInitialProcessing 1 passed.");
		} else {
			System.out.println("testInitialProcessing 1 failed:" + sentence);
		}

		// additional tests
	}

	/**
	 * Tests the testReplacePairs method of the Eliza.java class to assure its
	 * correctness
	 *
	 */
	public static void testReplacePairs() {
		String[] someWords = { "i'm", "cant", "recollect" };
		String[] beforeList = { "dont", "cant", "wont", "recollect", "i'm" };
		String[] afterList = { "don't", "can't", "won't", "remember", "i am" };
		String[] result = Eliza.replacePairs(someWords, beforeList, afterList);
		if (result != null && result[0].equals("i") && result[1].equals("am") 
				&& result[2].equals("can't")
				&& result[3].equals("remember")) {
			System.out.println("testReplacePairs 1 passed.");
		} else {
			System.out.println("testReplacePairs 1 failed.");
		}

		// Additional tests: If a someWords are passed that do not match any of
		// beforeListwords then the string should be returned unmodified
		String[] someWords2 = { "I", "do", "not", "recall" };
		String[] beforeList2 = { "dont", "cant", "wont", "recollect", "i'm" };
		String[] afterList2 = { "don't", "can't", "won't", "remember",
				"i am" };
		String[] result2 = Eliza.replacePairs(someWords2, beforeList2, 
				afterList2);
		if (result2 != null && result2[0].equals("I") && 
				result2[1].equals("do") && result2[2].equals("not")
				&& result2[3].equals("recall")) {
			System.out.println("testReplacePairs 2 passed.");
		} else {
			System.out.println("testReplacePairs 2 failed.");
		}
	}

	/**
	 * Tests the testFindPatternInSentence method of the Eliza.java class to
	 * assure its correctness
	 *
	 */
	// TODO
	public static void testFindPatternInSentence() {
		String[] pattern1 = { "computer" };
		String[] sentence1 = { "are", "you", "a", "computer" };

		String[] matches = Eliza.findPatternInSentence(pattern1, sentence1);
		if (matches != null && matches.length == 2 
				&& matches[0].equals("are you a") && matches[1].equals("")) {
			System.out.println("testFindPatternInSentence 1 passed.");
		} else {
			System.out.println("testFindPatternInSentence 1 failed.");
			System.out.println(Arrays.toString(matches));
		}

		String[] pattern2 = { "computer" };
		String[] sentence2 = { "computer", "are", "you" };

		matches = Eliza.findPatternInSentence(pattern2, sentence2);
		if (matches != null && matches.length == 2 && matches[0].equals("") 
				&& matches[1].equals("are you")) {
			System.out.println("testFindPatternInSentence 2 passed.");
		} else {
			System.out.println("testFindPatternInSentence 2 failed.");
			System.out.println(Arrays.toString(matches));
		}

		String[] pattern5 = { "computer" };
		String[] sentence5 = { "does", "that", "computer", "on", "your",
				"desk", "work" };
		matches = Eliza.findPatternInSentence(pattern5, sentence5);
		if (matches != null && matches.length == 2
				&& matches[0].equals("does that")
				&& matches[1].equals("on your desk work")) {
			System.out.println("testFindPatternInSentence 3 passed.");
		} else {
			System.out.println("testFindPatternInSentence 3 failed.");
			System.out.println(Arrays.toString(matches));
		}

		String[] pattern6 = { "you", "me" };
		String[] sentence6 = { "why", "don't", "you", "like", "me" };
		matches = Eliza.findPatternInSentence(pattern6, sentence6);
		if (matches != null && matches.length == 3 && 
				matches[0].equals("why don't") && matches[1].equals("like")
				&& matches[2].equals("")) {
			System.out.println("testFindPatternInSentence 4 passed.");
		} else {
			System.out.println("testFindPatternInSentence 4 failed.");
			System.out.println(Arrays.toString(matches));
		}

		String[] pattern7 = { "you", "me" };
		String[] sentence7 = { "me", "don't", "like", "you" };
		matches = Eliza.findPatternInSentence(pattern7, sentence7);
		if (matches == null) {
			System.out.println("testFindPatternInSentence 5 passed.");
		} else {
			System.out.println("testFindPatternInSentence 5 failed.");
			System.out.println(Arrays.toString(matches));
		}

		// additional tests
	}

	/**
	 * Tests the testPrepareUserPhrase method of the Eliza.java class to assure
	 * its correctness
	 *
	 */
	// TODO
	public static void testPrepareUserPhrase() {
		String someWords = "i'm happy";
		String result = Eliza.prepareUserPhrase(someWords);
		if (result != null && result.equals("you are happy")) {
			System.out.println("testPrepareUserPhrase 1 passed.");
		} else {
			System.out.println("testPrepareUserPhrase 1 failed. '" + 
		result + "'");
		}
		// additional tests
	}

	/**
	 * Tests the testPrepareResponse method of the Eliza.java class to assure
	 * its correctness
	 *
	 */
	public static void testPrepareResponse() {
		String draftResponse = "Really, <3>?";
		String[] userPhrases = { "", "", "about my dog" };
		String response = Eliza.prepareResponse(draftResponse, userPhrases);

		String expectedResponse = "Really, about your dog?";

		if (response.equals(expectedResponse)) {
			System.out.println("testPrepareResponse 1 passed.");
		} else {
			System.out.println("testPrepareResponse 1 failed. '" 
		+ response + "'");
		}

		// Additional Test: If a draftResponse2 is passed in that does not
		// contain
		// a <number> then the draftResponse2 string should be
		// returned unmodified

		String draftResponse2 = "Do you dream often?";
		String[] userPhrases2 = { "", "", "about my dog" };
		String response2 = Eliza.prepareResponse(draftResponse2,
				userPhrases2);
		if (response2.equals(draftResponse2)) {
			System.out.println("testPrepareResponse 2 passed.");
		} else {
			System.out.println("testPrepareResponse 2 failed. '" +
		draftResponse2 + "'");
		}
	}

	/**
	 * Tests the testMatchResponse method of the Eliza.java class to assure its
	 * correctness
	 *
	 */
	public static void testMatchResponse() {
		String[] words1 = { "are", "you", "a", "computer" };
		String response1 = Eliza.matchResponse(words1);
		if (Eliza.inList(response1, Config.RESPONSE_TABLE[0][1]) >= 0) {
			System.out.println("testMatchResponse 1 passed.");
		} else {
			System.out.println("testMatchResponse 1 failed." + response1);
		}

		String[] words2 = { "you", "are", "like", "my", "father" };
		String response2 = Eliza.matchResponse(words2);
		if (response2 != null && response2.contains("like your father")) {
			System.out.println("testMatchResponse 2 passed.");
		} else {
			System.out.println("testMatchResponse 2 failed.");
		}

		// Additional tests: If words3 contains a string null then on of the
		// NO_MATCH_RESPONSES should be returned

		String[] words3 = null;
		String response3 = Eliza.matchResponse(words3);
		if (response3 != null && Eliza.inList(response3,
				Config.NO_MATCH_RESPONSES) >= 0) {
			System.out.println("testMatchResponse 3 passed.");
		} else {
			System.out.println("testMatchResponse 3 failed.");
		}

	}

	private static void testProblem(String problem) {
		// supporting method for testProcessInput
		System.out.println("Patient:  " + problem);
		System.out.println("Eliza: " + Eliza.processInput(problem));
	}

	public static void testProcessInput() {
		// note: the responses may vary as they are randomly selected and the
		// random generator results will vary based on the previous times it
		// has been called. Therefore, see if each response is appropriate.

		// The following are selected phrases from:
		// http://web.stanford.edu/group/SHR/4-2/text/dialogues.html
		testProblem("Men are all alike.");
		testProblem("They're always bugging us about something specific or "
				+ "other.");
		testProblem("Well, my boyfriend made me come here.");
		testProblem("He says I'm depressed much of the time.");
		testProblem("It's true. I'm unhappy.");
		testProblem("I need some help, that much seems certain.");
		testProblem("Perhaps I could learn to get along with my mother.");
		testProblem("My mother takes care of me.");
		testProblem("My father.");
		testProblem("You are like my father in some ways.");
		testProblem("You are not very aggressive but I think you don't want me"
		+ " to notice that.");
		testProblem("You don't argue with me.");
		testProblem("You are afraid of me.");
		testProblem("My father is afraid of everybody.");
		testProblem("Bullies.");
	}

	public static void main(String[] args) {
		// feel free to comment out tests that are not of current interest
		// in order to focus on certain tests. Eventually, all the tests
		// should run successfully.

		testChooseString();

		testInList();
		testAssemblePhrase();
		testFindLongest();
		testHowMany();
		testFilterChars();
		testRemoveDuplicateSpaces();
		testFindAnyWords();
		testInitialProcessing();
		//
		testReplacePairs();
		testFindPatternInSentence();
		testPrepareUserPhrase();
		testPrepareResponse();
		//
		testMatchResponse();
		testProcessInput();

	}
}
