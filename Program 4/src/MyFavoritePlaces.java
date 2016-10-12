import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Scanner;
///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  MyFavoritePlaces.java
//File:             MyFavoritePlaces.java
//Semester:         302 Spring 2016
//
//Author:           pghoward@wisc.edu
//CS Login:         phoward
//Lecturer's Name:  Jim Williams
//Lab Section:      312
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//Pair Partner:     Bill Chang
//Email:            bchang24@wisc.edu
//CS Login:         billc
//Lecturer's Name:  Jim Williams
//Lab Section:      312
//
////////////////////STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//fully acknowledge and credit all sources of help,
//other than Instructors and TAs.
//
//Persons:         None
//
//Online sources:   https://docs.oracle.com  
////////////////////////////80 columns wide //////////////////////////////////
/**
 * This class is designed to create a program that can interact with a list of 
 * locations. Locations can be added, deleted, written into files, compared and
 * sorted, and read as files.
 *
 */
public class MyFavoritePlaces {
	// Creating a new location list object to store the locations in 
	// an array list 
	private static LocationsList locationList = new LocationsList();

	/**
	 *This method is designed to take a file and add every location in the 
	 *file to the location list. If the file already exists than the location 
	 *is not added to the list.
	 *
	 * @param fileToRead A file to read
	 */
	public static void readFile(File fileToRead){

		//Try scanning the fileToRead, and setting delimiter to ";" and "\\n"
		try(Scanner fileScan = new Scanner(fileToRead).useDelimiter(";|\\n")){
			//If the file successfully scans read the file and place each place 
			// within the file into the Locations list.
			while(fileScan.hasNext()){
				Location locationToAdd = new Location(fileScan.next(), 
						fileScan.next(), Float.parseFloat(fileScan.next()), 
						Float.parseFloat(fileScan.next()) );
				//If the location to add is already in the location list,
				// display response to user saying the location already 
				// exists
				if ( locationList.testLocation(locationToAdd) == true){
					System.out.println("Place " + locationToAdd.getName() + 
							" already in list.");
				}
				//Else if the location does not already exists in the location
				// List then add it to the list
				else if(locationList.testLocation(locationToAdd) == false){
					locationList.addLocation(locationToAdd);
				}
			}
			//Closing the scanner
			fileScan.close();
		} 

		//If the file cannot be read tha33n print a pleasing error statement 
		//for 
		// the user that specifies the file
		catch (FileNotFoundException e) {
			System.out.print("Unable to read from file: " + 
		fileToRead.getName() + "\n");
		}
	}


	/**
	 * This method is designed to write a file using the current locations
	 * within the location list. If the file does not exist the a 
	 * FileNotFoundException is caught and the user is prompted an error 
	 * message
	 *
	 * @param fileToWrite A file to write
	 */
	public static void writeFile(File fileToWrite){


		//Try creating a writer from that uses the passed in file 
		try(PrintWriter writer = new PrintWriter(fileToWrite)){
			//For every element currently in the location list 
			//add a new instance of the location to the locations list
			for(int i = 0; i < locationList.getSize(); i++){
				writer.write(locationList.retrieveLocation(i).getName() + ";" 
			+ locationList.retrieveLocation(i).getAdress()+ ";" +
						locationList.retrieveLocation(i).getLatitude()+ ";" + 
			locationList.retrieveLocation(i).getLongitude() + "\n");
				writer.close();
			}
		}
		//If the writer cannot find the file then print a error statement for
		//  the user that specifies the file that gave the error
		catch(FileNotFoundException e){
			System.out.print("Unable to write to file: " + 
		fileToWrite.getName());

		}


	}



	/**
	 * This method is designed to take the current working directory and 
	 * return a string with the current files in the directory
	 *
	 * @return String A string containing the current files in the 
	 * working directory 
	 */
	public static String returnFileList(){
		//Create an empty return string
		String returnString = ""; 
		// Create a file object with the directory path
		File folder = new File(".");
		for ( File file : folder.listFiles()) {
			// Cycle through every file in the directory and add the ones 
			// that end in ".mfp" to the return string
			if ( file.getName().endsWith(".mfp")) {
				returnString += file.getName() + "\n" + "\t";
			} 
		}
		//Return the return string full of places to display
		return returnString; 
	}




	/**
	 * This method is the main method and is designed to run the program and
	 * prompt the user to make selections for location list action.
	 */
	public static void main(String[] args) {



		//Creating a new scanner for tracking user input 
		Scanner input = new Scanner(System.in).useDelimiter("\\n");
		//Creating a boolean that determines whether or not a user inputs quit 
		// or not. 
		boolean userQuitting = false; 
		//Initializing a string variable to store a string of the users 
		// selection form the menu prompt
		String userSelection;
		//Initializing a char variable to convert the String of the users 
		//selection form the menu prompt, this is for use in a switch 
		char charUserSelection; 

		//While the user quitting variable is false run the program menu -
		// displays and prompts
		while (userQuitting == false){

			//While there are no locations added to the list 
			if( locationList.getSize() == 0){
				//Sorting List Locaiton
				locationList.sortLocation();
				//Printing out main menu to console if list size is less than 
				//zero 
				System.out.println("My Favorite Places 2016" + "\n" + 
				"--------------------------");
				System.out.println("No places loaded." + "\n" +
				"--------------------------");
				System.out.print("A)dd R)ead Q)uit : ");
				//Recording the users input selection as a string 
				userSelection = input.next();
				//If the users selection is empty use a while loop until the 
				// they make a selection using a letter
				while(userSelection.isEmpty()){
					System.out.print
					("Please make a selection using a single letter: ");
					userSelection = input.nextLine();
				}
				//Converting a string selection to a char selection for use 
				// in the following switch
				charUserSelection =  userSelection.charAt(0); 

				//Using a switch statement to choose the proper course of 
				//action 
				// depending on the userSelection
				switch (charUserSelection){

				case 'q': 
				case 'Q': 
					System.out.println
					( "Thank you for using My Favorite Places 2016!" );
					userQuitting = true; 
					break;

				case 'a': 
				case 'A': 
					//Create a new location object. Then prompt the user to 
					// enter  the  and name  
					Location locationAddition = new Location();
					locationList.addLocation(locationAddition);
					System.out.print( "Enter the name: " );
					locationAddition.setName(input.next());
					System.out.print( "Enter the address: " );
					try {
						//Use the users next string response to find a 
						// JSON. Then parse the JSON as a GResponse object
						GResponse newGResponse = GeocodeResponse.
								parse(Geocoding.find(input.next()));
						//Use this newly created JSON object to store the 
						// address, lattitude, and longitude
						locationAddition.setAdress(newGResponse.
								getFormattedAddress());
						locationAddition.setLatitude((float) 
								newGResponse.getLatitude());
						locationAddition.setLongitude((float) 
								newGResponse.getLongitude());
						//Resorting locations after adding a new location

					} catch (IOException e) {
						//If an IO exception is thrown print a statement 
						// to inform the user
						System.out.print("The adress could not be read.");
					}

					break;


				case 'r':
				case 'R':
					//Printing out the current files to the console using 
					// the returnFileList() method
					System.out.print("Available Files:" +"\n" + "\t");
					System.out.println(returnFileList());
					//Prompting the user to select a file and then 
					//use the input to create a new File and 
					// using this with readFile() to read the file
					System.out.print("Enter filename: ");
					File fileToRead = new File(input.next());
					readFile(fileToRead);
					System.out.println("");
					break; 

				default:
					System.out.println("");
					break;
				}
			}


			//If the list size is greater than zero print the following 
			// menu and selections 
			if (locationList.getSize() > 0){
				//Sorting list 
				locationList.sortLocation();
				//Printing out menu header 
				System.out.println("My Favorite Places 2016" + "\n" + 
				"--------------------------");
				//Using a for loop to print out every name of locations
				// stored on the arrayList
				if(Location.getCurrent() == null){
					for(int i = 0; i < locationList.getSize(); i++){
						System.out.println((i+1) + ") " + 
					locationList.retrieveLocation(i).getName());
					}
				}

				else{
					System.out.println("distance from " + Location.
							getCurrent().getName());
					for(int i = 0; i < locationList.getSize(); i++){
						System.out.print((i+1) + ") " + locationList.
								retrieveLocation(i).getName() + " (");
						System.out.format("%.2f", locationList.
								retrieveLocation(i).getDistance());
						System.out.print(" miles)\n");
					}
				}








				//Printing out divider followed by the console output that 
				// prompts a user to make an action selection 
				System.out.println("--------------------------");
				System.out.print("A)dd S)how E)dit D)elete"
						+ " C)urrent R)ead W)rite Q)uit : ");

				//Recording the users input selection as a string 
				userSelection = input.next();
				//If the users selection is empty use a while loop until the 
				// they make a selection using a letter
				while(userSelection.isEmpty()){
					System.out.print("Please make a selection using a "
							+ "single letter: ");
					userSelection = input.nextLine();
				}
				//Converting a string selection to a char selection for use 
				// in the following switch
				charUserSelection =  userSelection.charAt(0); 

				//Beginning a switch that executes to proper code in respect
				// to the users input selection 
				switch(charUserSelection){

				case 'A':
				case 'a':
					//Create a new location object. Then prompt the user to 
					// enter  the  and name  
					Location locationAddition = new Location();
					locationList.addLocation(locationAddition);
					System.out.print( "Enter the name: " );
					locationAddition.setName(input.next());
					System.out.print( "Enter the address: " );
					try {
						//Use the users next string response to find a 
						// JSON. Then parse the JSON as a Gresponse object
						GResponse newGResponse = GeocodeResponse.
								parse(Geocoding.find(input.next()));
						//Use this newly created JSON object to store the 
						// address, lattitude, and longitude
						locationAddition.setAdress(newGResponse.
								getFormattedAddress());
						locationAddition.setLatitude((float) newGResponse
								.getLatitude());
						locationAddition.setLongitude((float) newGResponse.
								getLongitude());
					} catch (IOException e) {
						//If an IO exception is thrown print a statement 
						// to inform the user
						System.out.print("The adress could not be read.");
					}
					System.out.println("");
					break;

				case 'S':
				case 's':
					System.out.print("Enter number of place to Show: ");
					//Storing user selection as next scanned input minus 
					//one to 
					//account for crossover from numbered list to the index 
					//number 
					int userPlaceSelection = input.nextInt() - 1; 
					// While the userPlaceSelection is not a number from the 
					// list prompt the user to select another number 
					while(userPlaceSelection >= locationList.getSize() ||
							userPlaceSelection < 0){
						System.out.print("Please enter a number from the list:"
								+ " ");
						userPlaceSelection = input.nextInt() - 1; 
					}
					//Printing out name, address, lattitude, and longitude, 
					//and URL 
					System.out.println(locationList.retrieveLocation
							(userPlaceSelection).getName());
					System.out.println(locationList.retrieveLocation
							(userPlaceSelection).getAdress());
					System.out.println(String.format("%2.6f", locationList.
							retrieveLocation(userPlaceSelection).getLatitude())
							+ "," + String.format("%2.6f",locationList.
									retrieveLocation(userPlaceSelection).
									getLongitude()));
					System.out.println(locationList.
							retrieveLocation(userPlaceSelection).getURL());
					//Try opening a web page form the concatenated URL
					try {
						Geocoding.openBrowser(locationList.
								retrieveLocation(userPlaceSelection).getURL());
					} catch (IOException | URISyntaxException e1) {
						//If an exception is caught prompt the user an 
						//appropriate message
						System.out.print("The address could not be "
								+ "found on Google maps.");
					}
					//Prompting the user to press enter in order to continue 
					//with 
					//the program
					System.out.println("Press Enter to continue." + "\n");
					Scanner enterContinue = new Scanner(System.in);
					enterContinue.nextLine();
					break; 

				case 'E': 
				case 'e':
					System.out.print("Enter number of place to Edit: ");
					int userPlaceSelectionE = input.nextInt() - 1; 

					while(userPlaceSelectionE >= locationList.getSize() || 
							userPlaceSelectionE < 0) {
						System.out.print("Please enter a number from the"
								+ " list: ");
						userPlaceSelectionE = input.nextInt() -1;
					}
					//Printing out the current location name selected 
					//by the user
					System.out.println("Current name: " + locationList.
							retrieveLocation(userPlaceSelectionE).getName());


					System.out.print( "Enter a new name: " );
					locationList.retrieveLocation(userPlaceSelectionE).
					setName(input.next());
					//Printing out the current location address selected by 
					//the user
					System.out.println("Current address: " + locationList.
							retrieveLocation(userPlaceSelectionE).getAdress());
					System.out.print( "Enter a new address: " );
					try {
						//Use the users next string response to find a 
						// JSON. Then parse the JSON as a Gresponse object
						GResponse newGResponse = GeocodeResponse.
								parse(Geocoding.find(input.next()));
						//Use this newly created JSON object to store the 
						// address, lattitude, and longitude
						locationList.retrieveLocation(userPlaceSelectionE).
						setAdress(newGResponse.getFormattedAddress());
						locationList.retrieveLocation(userPlaceSelectionE).
						setLatitude((float) newGResponse.getLatitude());
						locationList.retrieveLocation(userPlaceSelectionE).
						setLongitude((float) newGResponse.getLongitude());
					} catch (IOException e) {
						//If an IO exception is thrown print a statement 
						// to inform the user
						System.out.print("The adress could not be read.");
					}
					
					break;

				case 'D':
				case 'd':
					System.out.print("Enter number of place to Delete: ");
					int userPlaceSelectionD = input.nextInt() - 1; 
					while(userPlaceSelectionD >= locationList.getSize() ||
							userPlaceSelectionD < 0) {
						System.out.print("Please enter a number "
								+ "from the list: ");
						userPlaceSelectionD = input.nextInt() -1;
					}
					System.out.println(locationList.retrieveLocation
							(userPlaceSelectionD).getName() + " deleted." );
					locationList.deleteLocation(userPlaceSelectionD);
					//Prompting the user to press enter in order to continue 
					//with 
					//the program
					System.out.println("Press Enter to continue." + "\n");
					enterContinue = new Scanner(System.in);
					enterContinue.nextLine();
					break;  


				case 'C':
				case 'c':
					System.out.print("Enter number of place to be "
							+ "Current place: ");
					int userPlaceSelectionC = input.nextInt() - 1;
					while(userPlaceSelectionC >= locationList.getSize() || 
							userPlaceSelectionC < 0){
						System.out.print("Please enter a number from "
								+ "the list: ");
						userPlaceSelectionC = input.nextInt() - 1;
					}
					Location.setCurrent(locationList.retrieveLocation(
							userPlaceSelectionC));
					System.out.println(locationList.retrieveLocation(
							userPlaceSelectionC).getName() + " "
									+ "set as Current place.");

					System.out.print("Press Enter to continue." + "\n");
					enterContinue = new Scanner(System.in);
					enterContinue.nextLine();
					break; 


				case 'R':
				case 'r':
					//Printing out the current files to the console using 
					// the returnFileList() method
					System.out.print("Available Files:" +"\n" + "\t");
					System.out.println(returnFileList());
					//Prompting the user to select a file and then 
					//use the input to create a new File and 
					// using this with readFile() to read the file
					System.out.print("Enter filename: ");
					File fileToRead = new File(input.next());
					readFile(fileToRead);
					break; 

				case 'W':
				case 'w':
					System.out.println("Current Files:");
					System.out.println("\t" + returnFileList());
					System.out.print("Enter filename: ");
					File fileToWrite = new File(input.next());
					writeFile(fileToWrite);
					System.out.println("");
					break; 

				case 'q': 
				case 'Q': 
					System.out.print( "Thank you for using My Favorite "
							+ "Places 2016!" );
					userQuitting = true; 
					break;

				}
			}
		}
	}	
}

