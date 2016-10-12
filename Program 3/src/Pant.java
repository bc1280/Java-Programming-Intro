///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// File:             Pant.java
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
// Persons:         None
//
// Online sources:  https://docs.oracle.com  
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * This class constructs a Pant object and handles collisions with fireballs by
 * destroying the pant object and calling the Fire constructor to create a new
 * object at the position the Pant was destroyed.
 *
 */
import java.util.ArrayList;
import java.util.Random;

public class Pant {

	private Graphic graphic;
	private Random randGen;
	/**
	 * This method creates a Pant object with a specified x-y coordinate
	 * position and a random generator. It also initializes its graphic
	 * and graphic type
	 * 
	 * @param float x The X coordinate of the fire ball
	 * @param float y The Y coordinate of the fire ball
	 * @param Random randGen The random generator used by the pant class
	 */
	public Pant(float x, float y, Random randGen) {
		graphic = new Graphic();
		graphic.setType("PANT");
		graphic.setX(x);
		graphic.setY(y);
		this.randGen = randGen;
	}
	/**
	 * This class is designed to be used by other classes as a method for 
	 * getting a Pant objects graphic and returning it to the statement calling
	 * in it. 
	 *
	 * @return Graphic A specified pants graphic variable
	 */
	public Graphic getGraphic(){
		// get pant graphic
		return this.graphic;
	}
	/**
	 * This class handles collisions with fire ball objects. It does this by 
	 * iterating through every single element of the array list and checking
	 * to see if the fire balls are colliding with a pant object. If it is 
	 * colliding with a fire ball the method destroys the fire ball and pant  
	 * then creates a new Fire object at the position of the Pant. The fire 
	 * object is then returned by the method. 
	 *
	 * @param ArrayList fireballs An array list of fire ball objects
	 * @return Fire A fire object if a collision occurs, otherwise null
	 */
	public Fire handleFireballCollisions(ArrayList<Fireball> fireballs){
		for (int i = 0; i < fireballs.size(); i++){
			if (fireballs.get(i).getGraphic().isCollidingWith(graphic) == true){
				//destroy fireball
				fireballs.get(i).destroy();
				// Creating a new Fire object with the currents pants positon, before the 
				// pant gets destroyed
				Fire freshFire = new Fire (graphic.getX(), graphic.getY(), 
						randGen);
				//destroy pant
				graphic.destroy();
				//create new Fire at exact same position
				return freshFire; 

			}
		}
		return null;
	}
	/**
	 * This method allows for other classes to determine whether or not a 
	 * pant object should be removed from the array list. If the pant graphic
	 * is null the method returns true, otherwise it returns false.
	 *
	 * @return boolean True if the Pant object should be removed otherwise false
	 */
	public boolean shouldRemove(){
		//true when this Pant has been hit by a Fireball, otherwise false.
		if ( graphic.getType() == null){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * This method is used to update the Pant object. It draws the object 
	 * with respect to the time of the Game object
	 *
	 * @param int time The time that has passed since the game has begun
	 */
	public void update(int time) {
		graphic.draw();
	}
}
