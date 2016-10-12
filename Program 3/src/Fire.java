///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// File:             Fire.java
// Semester:         302 Spring 2016
//
// Author:           pghoward@wisc.edu
// CS Login:         phoward
// Lecturer's Name:  Jim Williams
// Lab Section:      312
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     Bill Chang
// Email:            bchang@wisc.edu
// CS Login:         bchang
// Lecturer's Name:  Jim Williams
// Lab Section:      312
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          None
//
// Online sources:   https://docs.oracle.com  
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.Random;
/**
 * This class constructs Fire objects that spew Fireball objects. 
 * These Fire objects call the Fireball contructor and create a fireball
 * at the coordinates of any Fire object. In addition this class handles 
 * collisions with water objects and reacts to the scenario by decrementing 
 * a Fire objects heat and destroying the water object.
 *
 */
public class Fire {
	private Graphic graphic;
	private Random randGen;
	private int fireballCountdown;
	private int heat = 40;
	/**
	 * This method constructs a new Fire object with a specific x-y coordinate. 
	 * In addition it declares a random generator, graphic, and graphic type 
	 * for the Fire object. Lastly it initializes a fireballCountdown timer
	 * that creates a time that a spewed fire ball will exists for. 
	 *
	 * @param float x The X coordinate of the fireball
	 * @param float y The Y coordinate of the fireball
	 * @param random randGen random generator used by the fire class
	 */
	public Fire(float x, float y, Random randGen) {
		graphic = new Graphic();
		graphic.setType("FIRE");
		graphic.setX(x);
		graphic.setY(y);
		this.randGen = randGen;

		// Generating a random time in milliseconds for the fire to exist,
		// between 5999 and 3000 milliseconds
		fireballCountdown = (randGen.nextInt(3000) + 3000);



	}
	/**
	 * This method provides a way for the Fires graphic to be accessed from 
	 * other classes. 
	 *
	 * @return The graphic of a specific Fire object.
	 */
	public Graphic getGraphic(){
		//get fire graphic
		return this.graphic;
	}
	/**
	 * This method determines whether or not a Fire object is colliding with any
	 * elements of an array of water objects. If it is colliding it decrements
	 *  the heat of a Fire object, destroys the water object, and sets the 
	 *  water object equal to null.
	 *
	 * @param Water[] water An array of water objects
	 * @return void
	 */
	public void handleWaterCollisions(Water[] water) {
		for (int i = 0; i < water.length; i++){
			if (water[i] != null){
				if (graphic.isCollidingWith(water[i].getGraphic())== true) {
					// when water collide with fire, fire's heat reduced by 1
					heat--;
					// water[i] reference set to null and destroy water graphic
					water[i].getGraphic().destroy();
					water[i] = null;
				}
			}
		}
	}
	/**
	 *This method determines whether or not a Fire should be removed from the 
	 * the arrayList of Fire objects. If the heat of a Fire object is less than
	 * one than the method returns true. 
	 * @return True if the Fires heat is less than one, otherwise False
	 */
	public boolean shouldRemove(){
		// remove fire if its heat is less then 1
		if ( this.heat < 1){
			return true; 
		}
		return false; 
	}
	/**
	 * This method updates the Fireball by drawing its motion, decrementing
	 * its fireballCountdown timer, destroying the Fire if its heat is less 
	 * than one, and lastly creates a new Fireball at the Fires coordinates
	 * if the fireball countdown timer is less than 0.
	 *
	 * @param int time A variable that represents the time that has passed since 
	 * the game was created 
	 * @return A new Fire ball if the fireballCountdown timer is less than 0,
	 * otherwise null.
	 */	
	public Fireball update(int time) {
		//Drawing the fireball graphic
		graphic.draw();

		//Decrement fireballs time of existence 
		fireballCountdown-=time;

		// If fire is extinguished, then fire ball will never be created
		if(heat < 1){
			graphic.destroy();
			return null;
		}

		// If the fireballs time has reached zero milliseconds
		if(fireballCountdown <= 0){
			//Creating a new fireball at the position of the fire with a random
			// direction between 0 and 2Pi
			Fireball newFiyahBawl = new Fireball(graphic.getX(),graphic.getY(), 
					(float) ((randGen.nextFloat()*( (2 * Math.PI) - 0) ) - 1));
			fireballCountdown = (randGen.nextInt(3000) + 3000);
			return newFiyahBawl;
		}

		// return null if the fireballCountDown is still greater than zero
		else{
			return null;
		}
	}
}


