///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            Eliza 
// Files:            Eliza.java
// Semester:         Comp Sci 302 Spring 2016
//
// Author:           Paul Howard
// Email:            pghoward@wisc.edu
// CS Login:         phoward
// Lecturer's Name:  Jim Williams
// Lab Section:      312
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If pair programming is allowed:
//                   1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//                   2. choose a partner wisely
//                   3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//                      a. one partner creates the team
//                      b. the other partner must join the team
//                   4. complete this section for each program file.
//
// Pair Partner:     Bill Chang
// Email:          	 bchang24@wisc.edu
// CS Login:         // TO DO 
// Lecturer's Name:  Jim Williams
// Lab Section:     312
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but tutors, roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:  1.) https://docs.oracle.com/javase/7/docs
//					 	api/overview-summary.html 
//                     (used for referencing java.lang methods and syntax)
//					2.) http://stackoverflow.com/questions/7520432/
//						what-is-the-difference-between-vs-equals-in-java
//					   (used for referencing difference between == and .equals)
//					
//////////////////////////// 80 columns wide //////////////////////////////////


import java.util.Scanner;

/**
 * Represents a virtual machine therapist that responds to user input 
 * and acts as a emotional therapist for the user
 *
 * &lt;p&gt;Bugs: A bug where the userInput was just the user hitting "enter"
 * 	was causing a null pointer exception. This was resolved by using a 
 * combination of DeMorgans law, a the java.lang method .equals(). Refer to 
 * the method processInput 
 *
 */

public class Eliza {

	/*/*
	 * This method randomly picks one of the strings from the list. If list 
	 * is null or has 0 elements then null is returned.
	 * 
	 * @param list An array of strings to choose from.
	 * @return One of the strings from the list.
	 */		
	public static String chooseString( String [] list) {
		//If list length is null or 0 return null
		if (list == null || list.length == 0) {
			return null; 
		}
		//Else randomly choose a string from list[] and return the string  
		else { int index = Config.RNG.nextInt(list.length);
		return list[index];
		}
	}

	/**
	 * If the word is found in the wordList then the index of the word
	 * is returned, otherwise -1 is returned. If there are multiple matches
	 * the index of the first matching word is returned. If either word or 
	 * wordList is null then -1 is returned.
	 * 
	 * @param word  A word to search for in the list.
	 * @param wordList  The list of Strings in which to search.
	 * @return The index of list where word is found, or -1 if not found.
	 */
	public static int inList( String word, String []wordList) {
		//Returning -1 if word is null or if wordList is null
		if ( wordList == null || word == null){
			return -1; 
		}
		//If wordList or word isn't null
		else if ( wordList != null || word != null){
			//Loop through every every array element 
			for ( int i = 0; i < wordList.length; i++){
				//If the wordList[i] has the same string as word
				//return word
				if (wordList[i].equals(word)){
					return i;
				}

			}
		}
		//Default return -1
		return -1;
	}



	/**
	 * Combines the Strings in list together with a space between each
	 * and returns the resulting string. If list is null then null is
	 * returned.
	 * 
	 * @param list An array of words to be combined.
	 * @return A string containing all the words with a space between each.
	 */
	public static String assemblePhrase( String[] list) {
		//If list[] is null return null 
		if ( list == null){ 
			return null;
		}
		//Else if list[] is not null 
		else{
			// Declare empty string returnPhrase to store return string 
			String returnPhrase = "";
			//Iterate every element of list[] 
			for (int i = 0; i < list.length; i++){
				//Join every element with a space between 
				returnPhrase += " "+ list[i];
			}
			//Return returnPhrase trimmed 
			return returnPhrase.trim(); 
		}
	}

	/**
	 * Returns the longest sentence, based on the String length, from 
	 * the array of sentences. Removes spaces from the beginning and
	 * end of each sentence before comparing lengths. If sentences is null
	 * or has a length of 0 then null is returned.
	 * 
	 * Note: String trim method may be useful.
	 * 
	 * @param sentences The array of sentences passed in.
	 * @return The longest sentence without spaces at the beginning or end.
	 */
	public static String findLongest( String [] sentences) {
		//If sentence equals null or sentence length is null return null 
		if (sentences == null || sentences.length == 0){
			return null;
		}
		//Else if sentence is not null 
		else{
			// Declare an empty string maxLength for storing longest string 
			String maxLength = "";
			//Iterate every element of sentences[]
			for (int i = 0; i < sentences.length; i++){
				//Declare longestPossiblity as sentence[i] trimmed
				String longestPossibility = sentences[i];
				longestPossibility.trim();
				//Compare lengths of longestPossibility to maxLength
				if (longestPossibility.length() > maxLength.length()){
					// If longestPossibility is longer store longestPossibility 
					// as new max length 
					maxLength = longestPossibility;	
				}	 
			}
			//Return maxLength 
			return maxLength;
		}
	}

	/**
	 * Counts the number of times the substring is in the str. Does not 
	 * count overlapping substrings separately. If either parameter 
	 * substring or str is null then -1 is returned.
	 * 
	 * Note: String methods indexOf may be useful for finding whether
	 *       substring occurs within str. One of the indexOf methods
	 *       has a parameter that says where to start looking in the str.
	 *       This might be useful to find the substring again in str, 
	 *       once you have found a substring once.
	 * 
	 * @param str The string to be searched.
	 * @param substring The string to be searched for within str.
	 * @return The number of times substring is found within str or -1 if
	 *         either parameter is null parameter.
	 */
	public static int howMany( String substring, String str) {
		//Checking to see if substring or string is null, if so return null
		if ( substring == null || str.equals(null)){
			return -1;
		}
		else {
			//Declare counter to store occurrence of substring  
			int counter = 0;
			//Declare startIndex to store index after substring once found
			int startIndex = 0;
			//While startIndex is not -1
			while(startIndex != -1){
				//Starting at startIndex search str for substring
				//A value greater than 0 should be found if a occurrence of 
				// substring occurs ahead of startIndex
				startIndex = str.indexOf(substring,startIndex);
				//If a occurrence substring is found ahead of the startIndex 
				if(startIndex != -1){
					//Increase counter
					counter ++;
					//Set the startIndex equal to the index of the last char in
					//the most recent occurrence of substring in str
					startIndex += substring.length();
				}
			}
			//Return amount of substring occurrences in str 
			return counter;
		}
	}
	/**
	 * This method performs the following processing to the userInput.
	 * - substitute spaces for all characters but (alphabetic characters, 
	 *   numbers, and ' , ! ? .).
	 * - Change (,!?.) to (!). Parenthesis not included.
	 * 
	 * @param userInput The characters that the user typed in.
	 * @return The character array containing the valid characters.
	 */	
	public static char [] filterChars( String userInput ) {
		char [] filterChars = new char[userInput.length()];
		for(int i = 0; i < userInput.length(); i++) {
			// return null if no user input
			if ( userInput == "") {
				return null;
			// numbers remain the same
			} else if ( Character.isDigit( userInput.charAt(i) ) == true ) {
				filterChars[i] = userInput.charAt(i);
			// alphabets remain the same
			} else if ( Character.isAlphabetic( userInput.charAt(i) ) == true 
					) {
				filterChars[i] = userInput.charAt(i);
			// replace ,!?. with !
			} else if ( userInput.charAt(i) == ',' || userInput.charAt(i) 
					== '!'
					|| userInput.charAt(i) == '?' || userInput.charAt(i) 
					== '.') {
				filterChars[i] = '!';
			// make sure \ doesn't change
			} else if ( userInput.charAt(i) == '\'' ) {
				filterChars[i] = '\'';
			// substitute spaces for the rest of characters
			} else {
				filterChars[i] = ' ';
			}
		}
		return filterChars; //replace with appropriate return value
	}


	/**
	 * Reduces all sequences of 2 or more spaces to 1 space within the 
	 * characters array. If any spaces are removed then the same number
	 * of Null character '\u0000' will fill the elements at the end of the
	 * array.
	 * 
	 * @param characters The series of characters that may have more than one
	 *     space in a row when calling. On return the array of characters will
	 *     not have more than one space in a row and there may be '\u0000'
	 *     characters at the end of the array.
	 */
	public static void removeDuplicateSpaces( char [] characters) {
		//If user hits enter the following if statement will detect an empty 
		// array char and return without altering characters[], the program 
		// will print a Config.NO_MATCH_RESPONSES after running through the  
		// next methods 
		if( characters.length-1 == -1){
			return;
		}		
		char [] newCharacters = new char[characters.length];
		int k = 0; // instrument for record characters while not affecting 
		//newCharacters
		for ( int i = 0; i+k < characters.length - 1; i++) {
			if ( characters[i+k] != ' ') {
				// if it's not space at i
				newCharacters[i] = characters[i+k];
			} else if ( characters[i+k] == ' ' && characters[i+k+1] != ' ') {
				// if it's a space at i but not space at i+1
				newCharacters[i] = characters[i+k];
			} else if ( characters[i+k] == ' ' && characters[i+k+1] == ' ') {
				// if both characters at i and i+1 are spaces
				while ( characters[i+k+1] == ' ' && i+k+1 != characters.length 
						- 1) {
					// try to figure out when will the space end or until we 
					//reach its end
					k++;
				}
				newCharacters[i] = characters[i+k];
				if ( i + k + 1 == characters.length - 1) {
					for ( int j = 0; j < k; j++) {
						newCharacters[i+1+j] = '\u0000';
					}
				}
			}
		}
		// now determine characters[characters.length - 1]
		if ( characters[characters.length - 1] != ' ') {
			newCharacters[characters.length - 1 - k] = 
					characters[characters.length - 1];
		} else if ( characters[characters.length - 1] == ' ' && 
				characters[characters.length - 2] == ' ') {
			newCharacters[characters.length - 1 - k] = '\u0000';
		} else if ( characters[characters.length - 1] == ' ' && 
				characters[characters.length - 2] != ' ') {
			newCharacters[characters.length - 1 - k] = 
					characters[characters.length - 1];
		}
		for ( int j = 0; j < k; j++) {
			newCharacters[characters.length - 1 - j] = '\u0000';
		}
		for ( int i = 0; i < characters.length; i++) {
			characters[i] = newCharacters[i];
		}
	}

	/**
	 * Looks for each word in words within the wordList. 
	 * If any of the words are found then true is returned, otherwise false.
	 * 
	 * @param words List of words to look for.
	 * @param wordList List of words to look through.
	 * @return Whether one of the words was found in wordList.
	 */
	public static boolean findAnyWords(String[] words, String []wordList ) {
		//Establishing a for loop to cycle through all elements of the wordList 
		for (int i = 0; i < words.length; i++){
			//Establishing a for loop to test the element "i" of the wordList 
			// with every element of the array words 
			for (int z = 0; z < wordList.length;z++){
				//If an element of wordList equals an element of the array
				//word then return true 
				if (words[i].equals(wordList[z])){
					return true;
				}
			}
		}
		//Default return false if no words are found in wordList 
		return false; 
	}
	/**
	 * This method performs the following processing to the userInput and 
	 * returns the longest resulting sentence.
	 * 1) Converts all characters to lower case  
	 * 		See String toLowerCase() method.
	 * 2) Removes any extra spaces at the beginning or end of the input
	 * 		See String trim() method.
	 * 3) Substitute spaces for all characters but alphabetic characters, 
	 *    numbers, and ',.!? and then substitute ! for ,.?
	 *      See filterChars method.
	 * 4) Reduce all sequences of 2 or more spaces to be one space.
	 *      See removeDuplicateSpaces method.
	 * 5) Divide input into separate sentences based on !
	 *      Construct a String from a character array with 
	 *      	String str = new String( arrayName);
	 *      See String split method.
	 *      Example: String[] sentences = str.split("!");
	 * 6) Determine which sentence is longest in terms of characters and
	 *    return it. 
	 *      See findLongest method.
	 * 
	 * @param userInput The characters that the user typed in.
	 * @return The longest sentence from the input.
	 */
	
	public static String initialProcessing( String userInput) {
		if ( userInput.equals(null)) {
			return null; // Return null if null
		} else {
			userInput = userInput.toLowerCase(); // (1) toLowerCase
			userInput = userInput.trim(); //(2) trim
			char[] userInputChar = userInput.toCharArray(); // change from 
			//string type to char []
			userInputChar = filterChars( userInput ); // (3) filterChars
			removeDuplicateSpaces( userInputChar ); // (4)removeDuplicateSpaces
			userInput = String.valueOf(userInputChar); // return changes 
			//back to string
			String userInputSplit[] = userInput.split("!"); // (5) split
			return findLongest(userInputSplit).trim(); // (6) findLongest 
			//and return
		} //replace with appropriate return value
	}
	/**
	 * This method creates a new words list replacing any words it finds in
	 * the *beforeList* with words in the *afterList*. An array of the 
	 * resulting *words* is returned.  
	 * 
	 * @param words List of words to look through.
	 * @param beforeList List of words to look for.
	 * @param afterList List of words to replace, if the corresponding word in
	 *  the before list is found in the words array.
	 * @return The new list of words with replacements.
	 */
	public static String[] replacePairs(String []words, String [] beforeList
			, String [] afterList) {

		// Creating an array matchingStringArray with the same length as 
		// words to store the matched words at index of afterList
		String [] matchingStringArray = new String[words.length]; 
		//Iterate through every element of words for comparison 
		for (int i= 0; i < words.length; i++){
			// Using inList to compare the elements in words[] to the elements
			// in beforeList[]
			if (Eliza.inList( words[i], beforeList) != -1){
				//If a words[] string is matched in beforeList,use the same  
				// index with in the array afterList to store as
				//matchingStringArray
				matchingStringArray[i] = afterList[Eliza.inList( words[i],
						beforeList)];	 
			} 
			//Else store the unmatched word at the same index of words
			else {
				matchingStringArray[i] = words[i];
			}
		}
		//Assembling matchingStringArray and splitting by spaces 
		return assemblePhrase(matchingStringArray).split("\\s");
	}

	/**
	 * Checks to see if the pattern matches the sentence. In other words, 
	 * checks to see that all the words in the pattern are in the sentence 
	 * in the same order as the pattern. If the pattern matches then this
	 * method returns the phrases before, between and after the 
	 * pattern words. If the pattern does not match then null is returned.
	 * 
	 * @param pattern The words to match, in order, in the sentence.
	 * @param sentence Each word in the sentence.
	 * @return The phrases before, between and after the pattern words
	 * 		or null if the pattern does not match the sentence.
	 */	
	public static String [] findPatternInSentence( String [] pattern, 
			String [] sentence) {
		// Create returnSentence variable as the return value of this method
		String[] returnSentence = new String[ pattern.length + 1 ];
		for (int i = 0; i <= pattern.length; i++) {
			returnSentence[i] = "";
		}
		// Instrumental variable for locating which position
		// of pattern we're on
		int tempIndex = 0;
		// The location of returnSentence
		int p = 0;
		for ( int i = 0; i < pattern.length; i++) {
			// if input is null, return null
			if( tempIndex >= sentence.length) {
				return null;
			} else {
				for ( int j = tempIndex; j < sentence.length; j++) {
					// when found match, then we work on constructing 
					// returnSentence at element p
					if ( sentence[j].equals(pattern[i])) {
						for ( int k = tempIndex; k < j; k ++ ) {
							returnSentence[p] = returnSentence[p] + " " 
						+ sentence[k];
						}
						returnSentence[p] = returnSentence[p].trim();
						p++;
						tempIndex = j + 1;
						break;
					} 
					// if the pattern i still cannot be found at the last word 
					// of the sentence, then return null
					else if ( !sentence[j].equals(pattern[i]) && j ==
							sentence.length - 1) {
						return null;
					} else {
						continue;
					}
				}
			}
		}
		// constructing the very last element of the returnSentence
		for ( int k = tempIndex; k < sentence.length; k++ ) {
			returnSentence[pattern.length] = returnSentence[pattern.length] +
					" " + sentence[k];
		}
		returnSentence[pattern.length] = returnSentence[pattern.length].trim();
		return returnSentence;
	}

	/**
	 * Replaces words in the phrase if they are in the 
	 * Config.POST_PROCESS_BEFORE with the corresponding words from 
	 * Config.POST_PROCESS_AFTER.
	 * 
	 * @param phrase One or more words separated by spaces.
	 * @return A string composed of the words from phrase with replacements.
	 */
	public static String prepareUserPhrase( String phrase) {
		String newPhrase = "";
		// split phrase input by space
		String phraseSplit[] = phrase.split(" ");
		for ( int j = 0; j < phraseSplit.length; j++) {
			// by checking the before list one by one, replacing the 
			// correspond word if matched
			for ( int i = 0; i < Config.POST_PROCESS_BEFORE.length; i++) {
				while ( phraseSplit[j].equals(Config.POST_PROCESS_BEFORE[i])) {
					phraseSplit[j] = Config.POST_PROCESS_AFTER[i];
				}
			}
		}
		// turn it back from string array to string
		for ( int i = 0; i < phraseSplit.length; i++) {
			newPhrase += phraseSplit[i] + " ";
		}
		return newPhrase.trim();
	}
	/**
	 * Prepares a response based on the draftResponse. If draftResponse
	 * contains <1>, <2>, <3> or <4> then the corresponding userPhrase
	 * is substituted for the <1>, <2>, etc.  The userPhrase however must
	 * be prepared by exchanging words that are in Config.POST_PROCESS_BEFORE
	 * with the corresponding words from Config.POST_PROCESS_AFTER.
	 * 
	 * @param draftResponse A response sentence potentially containing <1>, 
	 *             <2> etc.
	 * @param userPhrases An array of phrases from the user input.
	 * @return A string composed of the words from sentence with replacements.
	 */
	public static String prepareResponse( String draftResponse, 
			String []userPhrases) {
		//Create return string for storing the altered and conjoined string
		String returnString ="";
		//Creating a preReturnArray of same length as userPhrases
		String[] preReturnArray = new String [userPhrases.length];
		//Pass every element of userPhrases to prepareUserPhrase and store at
		// the same index in preReturnArray 
		for (int i = 0; i < userPhrases.length; i++){
			preReturnArray[i] = prepareUserPhrase(userPhrases[i]); 
		}
		//Check to see if either <1>, <2>, <3>, or <4> is within the 
		// draftResponse, if so replace the <num> with its respective element 
		// in preReturnArray
		if ( draftResponse.contains("<1>")){ 
			returnString = draftResponse.replaceFirst("<1>", preReturnArray[0]);
		}
		else if (draftResponse.contains("<2>")){  
			returnString = draftResponse.replaceFirst("<2>", preReturnArray[1]);

		}
		else if (draftResponse.contains("<3>")){  
			returnString = draftResponse.replaceFirst("<3>", preReturnArray[2]);

		}
		else if (draftResponse.contains("<4>")){  
			returnString = draftResponse.replaceFirst("<4>", preReturnArray[3]);

		}
		// If draftResponse does not contain <num> then return the string as is 
		else {
			return draftResponse;
		}
		//Return modified and trimmed string 
		return returnString.trim();
	}

	/**
	 * Looks through Config.RESPONSE_TABLE to find the first pattern 
	 * that matches the words. When a pattern is matched then a response 
	 * is randomly chosen from the corresponding list of responses.
	 * If the response has a parameter denoted with <1>, <2> 
	 * etc. the parameter is replaced with the 0th, 1st, etc String
	 * from the user phrases returned by the findPatternInSentence method.
	 * 
	 * @param words The words of a sentence.
	 * @return The completed response ready to be shown to the user.
	 */

	public static String matchResponse( String [] words) {
		// if words[] contains null return a string form NO_MATCH_RESPONSES
		if ( words == null){
			return chooseString(Config.NO_MATCH_RESPONSES);
		}
		//Else words does not equal null
		else{
			//Loop through every element of RESPONSE_TABLE
			for(int z = 0; z < Config.RESPONSE_TABLE.length;z++){
				// If calling findPatternInSentence does not return null and 
				// words are found in a pattern of RESPONSE_TABLE
				if ( findPatternInSentence(Config.RESPONSE_TABLE[z][0], words) 
						!= null){
					// Set returnString as prepareResponse, prepareResponse is 
					// filled with two parameters
					// Parameter 1: Using chooseString pick a response  
					// from RESPONSE_TABLE at the index [z][1]
					// Parameter 2: The pattern found in RESPONSE_TABLE that 
					// matches
					// words[]
					return prepareResponse(chooseString
							(Config.RESPONSE_TABLE[z][1]),findPatternInSentence
							(Config.RESPONSE_TABLE[z][0], words));
				}
			}
		}
		// As a default choose a string from NO_MATCH_RESPONSES if words[]
		// does match a pattern in NO_MATCH_RESPONSES  
		return chooseString(Config.NO_MATCH_RESPONSES);
	}

	/**
	 * Takes the input as a parameter and returns a response. If any of the
	 * QUIT_WORDS are found then null is returned. 
	 * 
	 * @param userInput The problem sentence(s) the user types in.
	 * @return A response string to be shown to the user or null if a QUIT_WORD
	 *         is found.
	 */
	public static String processInput(String userInput) {
		if( userInput.length() > 1 && !userInput.equals("")){
			// Run initial processing to determine which sentence is longest 
			//in terms of characters
			userInput = initialProcessing(userInput);
			String userInputSplit[] = userInput.split(" ");
			// If any of the QUIT_WORDS are found then null is returned. 
			if( findAnyWords( userInputSplit, Config.QUIT_WORDS) ) {
				return null;
			}
			// replace pairs according to process before list and after list
			userInputSplit = replacePairs( userInputSplit,
					Config.PRE_PROCESS_BEFORE, Config.PRE_PROCESS_AFTER);
			// replace with appropriate return value by matchResponse method
			return matchResponse(userInputSplit); 
		}
		// return random sentence from no match response if input nothing 
		// or invalid value
		return chooseString(Config.NO_MATCH_RESPONSES);
	}


	/**
	 * This method displays an INITIAL_MESSAGE, accepts typed input, calls 
	 * the processInput method, and prints out the response (of processInput)
	 * until the response is null at which point the FINAL_MESSAGE is shown
	 * and the program terminates.
	 */
	public static void interactive() {
		Scanner sc = new Scanner(System.in);
		System.out.println( "Eliza: " + Config.INITIAL_MESSAGE);
		System.out.print("Patient: ");
		String userInput = sc.nextLine();
		while ( userInput != null && inList(userInput, Config.QUIT_WORDS) 
				== -1){			
			System.out.println("Eliza: " + processInput(userInput));
			System.out.print("Patient: ");
			userInput = sc.nextLine();
		}
		System.out.println( Config.FINAL_MESSAGE);		
	}



	/**
	 * Program execution starts here.
	 * @param args unused
	 */  	
	public static void main(String[] args) {

		interactive();

	}
}
