///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// File:             Hero.java
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
/**
 * This class constructs a Hero object when called form the Game 
 * class. In addition this class handles collision with fireball objects 
 * by destroying the hero object and the water object. Lastly the heros
 * update method handles the three control choices that allow the user to move
 * the hero.
 *
 *
 */

import java.util.ArrayList;

public class Hero {
	// Private data fields used to define the structure of objects
	private Graphic graphic;
	private float speed;
	private int controlType;

	/**
	 * This method creates a Hero object with a specified x-y coordinate
	 * position, control type. It also initializes its speed, and graphic type.
	 * 
	 * @param float x The X coordinate of the fire ball
	 * @param float y The Y coordinate of the fire ball
	 * @param int controlType The control type to be used to specify the 
	 * characters controls
	 */
	public Hero(float x, float y, int controlType) {
		// Initializing graphic to a new Graphic()
		graphic = new Graphic();
		// Setting the setType of hero to "HERO"
		graphic.setType("HERO");
		// Setting the speed of the hero to .12f
		speed = 0.12f;
		// Setting position of the hero and the control type based on the
		// parameters of the Hero method
		this.controlType = controlType;
		graphic.setX(x);
		graphic.setY(y);
	}

	/**
	 * This method provides a way for other classes to reach the Heros private
	 * graphic variable.
	 * 
	 * @return the graphic variable of the Hero object
	 */
	public Graphic getGraphic() {
		// get hero graphic
		return this.graphic;
	}

	/**
	 * This class handle the collision of fire balls with the hero object.
	 * If any of the fire balls in a fire ball array list are colliding with the
	 * Hero the method will return true. Otherwise it will return false if no
	 * fire balls are colliding with the Hero.  
	 *
	 * @param ArrayList fireballs An array list of fire balls
	 * @return True if a fire ball is colliding with the hero, otherwise false. 
	 */
	public boolean handleFireballCollisions(ArrayList<Fireball> fireballs) {
		// To check if all fire balls collide with hero, return true if one of
		// the fire ball does
		for (int i = 0; i < fireballs.size(); i++) {
			if (graphic.isCollidingWith(fireballs.get(i).getGraphic()) == true){
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is designed to update and draw the hero method.In addition it
	 * determines what control statements to use based on the control type of 
	 * the hero. In addition it handles creating water objects at the position 
	 * of the hero. Lastly it controls the motion of the hero based on the user 
	 * input form a keyboard or mouse. 
	 *
	 * @param int time A variable of time that represents the amount of time 
	 * that 
	 * has passed since the game has begun
	 * @param Water[] waterArray A array of water objects.
	 */
	public void update(int time, Water[] waterArray) {
		// Stating draw method to draw the graphics position as time progresses
		graphic.draw();
		// Begin switch statement for controls
		switch (controlType) {

		// Control Type 1
		case 1:
			controlType = 1;
			if (Engine.isKeyHeld("D")) {
				graphic.setDirection(0);
				graphic.setX(graphic.getX() + (speed * time));

			} else if (Engine.isKeyHeld("A")) {
				graphic.setDirection((float) Math.PI);
				graphic.setX(graphic.getX() - (speed * time));
			} else if (Engine.isKeyHeld("W")) {
				graphic.setDirection(3 * (float) Math.PI / 2);
				graphic.setY(graphic.getY() - (speed * time));
			} else if (Engine.isKeyHeld("S")) {
				graphic.setDirection((float) Math.PI / 2);
				graphic.setY(graphic.getY() + (speed * time));
			}
			break;

			// Control Type 2
		case 2:
			controlType = 2;
			graphic.setDirection(Engine.getMouseX(), Engine.getMouseY());

			if (Engine.isKeyHeld("D")) {
				graphic.setX(graphic.getX() + (speed * time));

			} else if (Engine.isKeyHeld("A")) {
				graphic.setX(graphic.getX() - (speed * time));
			} else if (Engine.isKeyHeld("W")) {
				graphic.setY(graphic.getY() - (speed * time));
			} else if (Engine.isKeyHeld("S")) {
				graphic.setY(graphic.getY() + (speed * time));
			}
			break;

			// Control Type 3
		case 3:
			controlType = 3;
			graphic.setDirection(Engine.getMouseX(), Engine.getMouseY());
			if (Math.pow(Engine.getMouseX() - graphic.getX(), 2)
					+ Math.pow(Engine.getMouseY() - graphic.getY(), 2) >= 400) {
				graphic.setX((float) (graphic.getX() + (speed * time * 
						(Engine.getMouseX() - graphic.getX())
						/ Math.pow(Math.pow(Engine.getMouseX() - 
								graphic.getX(), 2)
								+ Math.pow(Engine.getMouseY() - 
										graphic.getY(), 2), 0.5))));
				graphic.setY((float) (graphic.getY() + 
						(speed * time * (Engine.getMouseY() - graphic.getY())
						/ Math.pow(Math.pow(Engine.getMouseX() - 
								graphic.getX(), 2)
								+ Math.pow(Engine.getMouseY() - 
										graphic.getY(), 2), 0.5))));
			}
			break;
		}
		// If space is pressed create a water object
		if (Engine.isKeyHeld("SPACE") || Engine.isKeyHeld("MOUSE")) {
			// Searching every element of waterArray for a null element
			for (int z = 0; z < waterArray.length; z++) {
				// If element is null
				if (waterArray[z] == null) {
					// Create a new Water for that object at the point of the
					// hero and facing the same way as the hero
					waterArray[z] = new Water(graphic.getX(), graphic.getY(),
							graphic.getDirection());
					break;
				}
			}
		}
	}

}
