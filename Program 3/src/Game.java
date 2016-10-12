///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            Game.java
// Files:            Game.java
// Semester:         302 Spring 2016
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
//Pair Partner:      Bill Chang
// Email:            bchang24@wisc.edu
// CS Login:         billc
// Lecturer's Name:  Jim Williams
// Lab Section:      312
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but tutors, roommates, relatives, strangers, etc do.
//
// Persons:          None
//
// Online sources:   https://docs.oracle.com  
//////////////////////////// 80 columns wide //////////////////////////////////
import java.awt.Window;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * This class creates a Game object that consists of Water, Fire, Fireballs, 
 * Pants, and a Hero. The game also is created with either random positioning
 * of characters or specific placement of characters if a level file is used 
 * while creating the game. Lastly the game calls update methods and collison
 * methods on all of the other objects in the game. 
 * 
 *
 */
public class Game 
{	
	//Creating a new reference of Hero called hero and setting the heros 
	// starting position to the center screen with a controlType
	private Hero hero;
	//Creating a new reference array of Water called water 
	private Water []water;
	// Creating a new Arraylist of Pant's called pants
	private ArrayList<Pant> pants;
	//Creating a new Arraylist of Fireballs  
	private ArrayList<Fireball> fireballs;
	//Creating a new ArrayList of Fire 
	private ArrayList<Fire> fires;

	private Random randGen = new Random();
	/**
	 * This method creates a new Game by declaring Arrays of water and an
	 * Arraylist of fireballs, fire, and pants. Lastly it determines whether  
	 * or not the game should create a random game or a pre constructed game 
	 * based off of the String parameter passed into the constructor. 
	 *
	 * @param String level Used to determine if a random game or specific game 
	 * should 
	 * be created
	 * @param Random randGen A random generator used through out the game object
	 */
	public Game(String level, Random randGen) {
		this.randGen = randGen;
		//Initializing the water array to 8 elements 
		water = new Water[8];
		// Initializing a new ArrayList fireballs
		fireballs = new ArrayList<Fireball>();
		// Initializing a new ArrayList fire
		fires = new ArrayList<Fire>();
		//Initializing the pant array list to 20 elements 
		pants = new ArrayList<Pant>();

		if ( level == "RANDOM"){
			this.createRandomLevel();
		}
		else if ( level != "RANDOM"){
			this.loadLevel(level);			
		}

	}
	/**
	 * This method iterates through every element of the arrays of water, fire
	 * fireball, and pant objects. While iterating through the elements it 
	 * the object respective update methods and fireball collision methods.
	 * Lastly depending on the amount of fires, pants or heros, the method
	 * will return a string that commands the game to either continue, advance, 
	 * or quit
	 *
	 * @param int time A variable that records the amount of time that the game
	 *  has
	 * been running for
	 * @return A string that commands the main program to continue, advance, or
	 * quit the game. 
	 */
	public String update(int time)
	{
		// Updating hero by time and passing the water[] to the hero update 
		// method
		hero.update(time, water);

		// Iterating through every element of water[]
		for( int w = 0; w < water.length; w++){
			//If the water[w] does not equal null
			if(water[w] != null){
				//Update water[w] by time 
				water[w] = water[w].update(time);
			}
		}

		// Updating each pant by calling there update methods
		for( int p = 0; p < pants.size(); p++){
			// Updating each object of pants
			pants.get(p).update(time); 
			// Creating a new object from the return of the pants fireball
			// collison method
			Fire  testFire = pants.get(p).handleFireballCollisions(fireballs);
			// If the returned value from the pants collison method 
			// is not null add it the fires arraylist
			if ( testFire != null){
				fires.add(testFire);
			}
		}


		//Updating every fireball object 
		for ( int b = 0; b < fireballs.size(); b++){
			fireballs.get(b).update(time);
		}

		//Updating every fire object 
		for ( int f = 0; f < fires.size(); f++){
			//If the fire object does not equal null
			if ( fires.get(f) != null){
				// Create a test variable fromt he fire update method, this also 
				// updates the current fire object
				Fireball addBawl = fires.get(f).update(time);
				//If the object does not equal null then add the new ball to
				// the arrayList of
				// fireballs
				if (addBawl != null){
					fireballs.add(addBawl);
				}
			}
		}

		//If Hero-Fireball collisions happens, then return QUIT (lose)
		if ( hero.handleFireballCollisions(fireballs) == true){
			return "QUIT";
		}

		//Fireball-Water collisions
		for ( int b = 0; b < fireballs.size(); b++){
			fireballs.get(b).handleWaterCollisions(water);
		}

		//Fire-Water collisions
		for ( int f = 0; f < fires.size(); f++){
			// If the fire object does not equal null run the handle collison 
			// method 
			if( fires.get(f) != null){
				fires.get(f).handleWaterCollisions(water);
			}
		}

		//Check if fireballs should be removed
		for ( int b = 0; b < fireballs.size(); b++){
			if(fireballs.get(b).shouldRemove() == true){
				//remove b if b should be removed and add shift following array
				// forward
				fireballs.remove(b);
			}
		}

		//Check if fires should be removed
		for ( int f = 0; f < fires.size(); f++){
			if(fires.get(f).shouldRemove() == true){
				//remove f if f should be removed
				fires.remove(f);
			}
		}

		//Check if pants should be removed
		for ( int p = 0; p < pants.size(); p++){
			if(pants.get(p).shouldRemove() == true){
				//remove p if p should be removed 
				pants.remove(p);
			}
		}

		//Check victory condition (no more fire)
		if (fires.size() == 0){
			return "ADVANCE";
		}

		//Check lost condition (no more pants)
		if (pants.size() == 0){
			return "QUIT";
		}

		return "CONTINUE";
	}	
	/**
	 * This method is designed to create a HUD displayed in the games 
	 * window. This HUD method returns the amount of Fire and Pant objects left.
	 *
	 * @return A string that can display the amount of Pant and Fire objects
	 * left 
	 */
	public String getHUDMessage() { 
		// Printing out the realtime status upper left
		String x = "Pants Left: ";
		x += pants.size();
		x += "\n";
		x += "Fires Left: ";
		x += fires.size();
		return x; 
	}
	/**
	 * This method creates a random game in the even that no game type is 
	 * specified in a Games constructor parameters. The random game is created
	 * by using the games random generator to randomly place Pant and Fire 
	 * objects. Lastly it calls for a hero to be constructed at the center
	 * of the application window with a random control type. 
	 */
	public void createRandomLevel() { 
		// Creating a new Hero Object 
		hero = new Hero(Engine.getWidth()/2,Engine.getHeight()/2,
				randGen.nextInt(3)+1);

		// Declaring each pant with a random position 
		// Initializing every element of the Pant[] array with a Pants object at 
		// randomly generated x and y coordinates 
		for( int p = 0; p < 20; p++){
			pants.add(p, new Pant((randGen.nextFloat() * 
					((float)Engine.getWidth() - 0) + 1) - 0,
					(randGen.nextFloat() * 
							((float)Engine.getHeight() - 0) +1) - 0, randGen)); 
		}

		// Initializing the fires to an array list 
		for( int f = 0; f < 6; f++){
			fires.add(f, new Fire((randGen.nextFloat() * 
					((float)Engine.getWidth() - 0)+1) - 0,(randGen.nextFloat()
							* ((float)Engine.getHeight() - 0) +
							1) - 0, randGen)); 
		}

	}
	/**
	 * This method creates a specified game in the event that a string
	 * containing a "level" instruction string is passed into the parameter
	 * of the game class. The method takes this string of instructions and 
	 * filters through the various words to determine proper x-y coordinates
	 * of where to construct Pant and Fire objects. It also filters the string
	 * to find the x-y coordinates of the Hero and its specified control type.
	 * @param String level 
	 */
	public void loadLevel(String level) { 
		//Splitting the level string into an array by \\s, , , @ , and :
		String[] splitLevel = level.split("\\s|\\,|\\@|\\:");
		// Creating a saving variable for control type and initializing to 3 as 
		// a default
		int controlType = 3;
		// Iterating through every element of the splitLevel array
		for(int i =0; i < splitLevel.length; i++){
			// If the element is equal to "ControlType" save that element as 
			//controType
			if(splitLevel[i].equals("ControlType")){
				controlType = Integer.parseInt(splitLevel[i+2]);
			}
			// If the element is equal to "HERO" the 3rd element after this 
			// element will be the x coordinate, and the 5th next element will 
			// be the y coordinate. Using these x and y coordinates create a 
			// new Hero object with the saved control type 
			if(splitLevel[i].equals("HERO")){
				hero = new Hero(Float.parseFloat(splitLevel[i+3]),
						Float.parseFloat(splitLevel[i+5]), controlType);
			}
			// If the element is equal to "FIRE" the 3rd element after this 
			// element will be the x coordinate, and the 5th next element will 
			// be the y coordinate. Using these x and y coordinates create a 
			// new Fire object and add it the the fires ArrayList
			if(splitLevel[i].equals("FIRE")){
				fires.add(new Fire(Float.parseFloat(splitLevel[i+3]),
						Float.parseFloat(splitLevel[i+5]), randGen));
			}
			// If the element is equal to "PANT" the 3rd element after this 
			// element will be the x coordinate, and the 5th next element will 
			// be the y coordinate. Using these x and y coordinates create a 
			// new Pant object and add it the the pants ArrayList
			if(splitLevel[i].equals("PANT")){
				pants.add(new Pant(Float.parseFloat(splitLevel[i+3]),
						Float.parseFloat(splitLevel[i+5]), randGen));
			}
		}
	}
	/**
	 * This method serves as the main method for the entire game and intiates
	 * the begging of the engine and the game. 
	 */
	public static void main(String[] args)
	{
		Application.startEngineAndGame(args);		
	}
}

