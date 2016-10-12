///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// File:             Fireball.java
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
// Online sources:   https://docs.oracle.com  
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * This class constructs Fireball objects that spew from  Fire 
 * objects. The class also tracks the Fireball to see if it collides
 * with a water object and reacts to the scenario by destroying 
 * Fireball object and the Water object. Lastly it updates every Fireball object
 * in relationship to time 
 *
 * 
 *
 */
public class Fireball {
	private Graphic graphic;
	private float speed;
	private boolean isAlive;
	/**
	 * This method constructs a new Fire ball object with a specific x-y 
	 * coordinate and a direction in which the fire ball faces. It also sets 
	 * the
	 * speed, graphic, and a variable that record whether its alive or not.
	 *
	 * @param float x The X coordinate of the fire ball
	 * @param float y The Y coordinate of the fire ball
	 * @param float direction Angle The direction the fire ball faces when 
	 * its created
	 */
	public Fireball(float x, float y, float directionAngle) {
		graphic = new Graphic();
		graphic.setType("FIREBALL");
		graphic.setDirection(directionAngle);
		speed = 0.2f;
		isAlive = true;
		graphic.setX(x);
		graphic.setY(y);


	}
	/**
	 * This method provides a way for other classes to reach the fire balls
	 * private graphic variable. 
	 * 
	 * @return The graphic variable of the specified Fire ball object
	 */
	public Graphic getGraphic(){
		// get fireball graphic
		return this.graphic;
	}
	/**
	 * This method determines whether or not the fire ball is colliding with any
	 * elements of an array of water objects. If it is colliding it destroys
	 *  the fire ball object.
	 *
	 * @param Water[] water An array of water objects
	 * @return void
	 */
	public void handleWaterCollisions(Water[] water){
		for (int i = 0; i < water.length; i++){
			if (water[i] != null){
				if (graphic.isCollidingWith(water[i].getGraphic()) == true) {
					// the Fireball?s isAlive set to false and its Graphic is 
					// destroyed
					destroy();
					// water[i] reference set to null
					water[i].getGraphic().destroy();
					water[i] = null;
				}
			}
		}
	}
	/**
	 * This method allows for other classes to destroy a fire balls objects
	 * by changing the fire balls isAlive field to false and by destroying the 
	 * object.
	 *
	 * @return void
	 */	
	public void destroy(){
		isAlive = false; 
		graphic.destroy();
	}
	/**
	 * This method is used to determine whether or not a fire ball should be 
	 * removed from an arrayList of fire balls. If its isAlive field is false
	 * it will return true otherwise it returns false
	 *
	 * @return False if the fire ball is Alive, and True if the fire ball isn't
	 * alive
	 */	
	public boolean shouldRemove(){
		//true when Fireball has either gone off the screen or collided with a 
		// Water or Pant object, and false otherwise.
		if (isAlive == false){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * This method is used to update the motion of the fire ball object and
	 * destroy the fire ball if it has traveled further than 100 pixels 
	 * past the edge of the application window
	 *
	 * @param int time The time in which has passed since the game was 
	 * constructed
	 * @return void
	 */	
	public void update(int time) {
		// If the fireball is alive continue to draw the graphic in the 
		// direction its traveling
		if (isAlive = true){
			graphic.draw();
			graphic.setX((float) (graphic.getX() + 
					(speed * time * (graphic.getDirectionX()))));
			graphic.setY((float) (graphic.getY() + 
					(speed * time * (graphic.getDirectionY()))));
			//If the fireball is outside of the window destroy the graphic
			// and set isAlive to false
			if (graphic.getX() == Engine.getWidth() + 100 || graphic.getX() == 
					0-100 || graphic.getY() == Engine.getHeight() + 100 || 
					graphic.getY() == 0-100){
				graphic.destroy();
				isAlive = false; 
			}
		}

	}
}
