///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// File:             Water.java
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
// Online sources: https://docs.oracle.com  

//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * This class is designed to construct water objects that are shot by the Hero
 * object. These water objects can be used to extinguish any Fire object or 
 * Fireball objects. The class also provides a update methods for updating every
 * instance of a water object and destroys the water object after it travels 
 * a distance of 200 pixels. 
 *
 */
public class Water {
	// Declaring various instances for the graphic 
	private Graphic graphic;
	private float speed;
	private float distanceTraveled;
	/**
	 * This method constructs a new water object with a specific x-y 
	 * coordinate and a direction in which the water faces. It also sets the
	 * speed, graphic, and a variable that record the distance that a 
	 * water object has traveled for.
	 *
	 * @param float x The X coordinate of the water
	 * @param float y The Y coordinate of the water
	 * @param float direction The direction the water faces when its created
	 */
	public Water(float x, float y, float direction) {
		// Initializing graphic to a new Graphic()
		graphic = new Graphic();
		// Setting graphic to a WATER graphic
		graphic.setType("WATER");
		// Setting the speed of the water to .7f
		speed = 0.7f;
		// Setting distance as 0
		distanceTraveled = 0;
		// Setting the position and direction of the water drop
		// according to the parameter of the Water class
		graphic.setX(x);
		graphic.setY(y);
		graphic.setDirection(direction);

	}
	/**
	 * This method provides a way for other classes to reach the water objects
	 * private graphic variable. 
	 * 
	 * @return Graphic The graphic variable of the specified Fire ball object
	 */
	public Graphic getGraphic(){
		// get water graphic
		return this.graphic;
	}
	/**
	 * This method is used to update the motion of the water object and
	 * destroy the water if it has traveled further than 200 pixels 
	 * from its point of origin
	 *
	 * @param int time The time in which has passed since the game was
	 *  constructed
	 */	
	public Water update(int time) {
		graphic.draw();
		//Setting the water graphic to move continuously in the direction it is
		// initially facing 
		graphic.setX((float) (graphic.getX() + 
				(speed * time * (graphic.getDirectionX()))));
		graphic.setY((float) (graphic.getY() + 
				(speed * time * (graphic.getDirectionY()))));
		// Calculating distance by the idea that change in distance is 
		// speed(pixels/second)*time(seconds) = distance(pixels)
		distanceTraveled += (speed*time);
		// If distance traveled is less than or equal to 200
		if (distanceTraveled <= 200){
			return this;
		}
		// When distance is greater than 200 destroy the graphic and return null
		graphic.destroy();
		return null;
	}

}
