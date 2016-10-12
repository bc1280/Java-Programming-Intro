import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  MyFavoritePlaces.java
//File:             Location.java
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
 * This class is designed to create a Location object with a name, address
 * latitude, and longitude.
 *
 *
 */
public class Location implements Comparable<Location> {
	private String name;
	private String address;
	private float latitude;
	private float longitude;
	private static Location currentLocation; 


	/**
	 * This method serves as a default constructor for the Location class
	 *
	 */
	public Location(){
	}

	/**
	 * This method serves as a constructor for Location objects
	 *
	 * @param name A string to set the Location address field 
	 * @param address A string to set the Location address field 
	 * @param latitude A float to set the Location latitude field 
	 * @param longitude A float to set the Location longitude field
	 */
	public Location(String name, String address, float latitude,
			float longitude){	
		this.name = name;
		this.address = address; 
		this.latitude = latitude; 
		this.longitude = longitude;
	}

	/**
	 * A getter method to get the Locations private name field
	 * @return A string representing the locations name
	 */
	public String getName(){
		return name;

	}

	/**
	 * A setter method to set the Locations private name field
	 * @param newName A string to set the Location name field 
	 */
	public void setName(String newName){
		name = newName;
	}

	/**
	 * A getter method to get the Locations private address field
	 * @return A string representing the locations address
	 */
	public String getAdress(){
		return address; 
	}

	/**
	 * A setter method to set the Locations private address field
	 * @param newAddress A string to set the Location address field 
	 */
	public void setAdress(String newAddress){
		address = newAddress;
	}

	/**
	 * A getter method to get the Locations private latitude field
	 * @return A float representing the locations latitude
	 */
	public float getLatitude(){
		return latitude; 
	}

	/**
	 * A setter method to set the Locations private latitude field
	 * @param newLatitude A float to set the Location latitude field 
	 */
	public void setLatitude(float newLatitude){
		latitude = newLatitude; 
	}

	/**
	 * A getter method to get the Locations private longitude field
	 * @return A float representing the locations longitude
	 */
	public float getLongitude(){
		return longitude;

	}

	/**
	 * A setter method to set the Locations private longitude field
	 * @param newLongitude A float to set the Location addrlongitudeess field 
	 */
	public void setLongitude(float newLongitude){
		longitude = newLongitude; 
	}

	/**
	 * This method compares the names of two locations. It returns true 
	 * if the names are equal and false if not
	 *
	 * @param one A Location to compare
	 * @param two A Location to compare
	 * @return A boolean value describing the comparison of the two locations
	 */
	
	public boolean equals(Location one, Location two){

		if (one.name == two.name && one.address== two.address){
			return true;
		}
		return false; 
	}

	/**
	 * This method is designed to retrieve a URL string using
	 * the Locations data fields
	 *
	 * @return A string representing the URL of a Locaiton instance
	 */
	public String getURL(){
		String newURL = "https://www.google.com/maps/place/" + 
	address.replaceAll(" ", "+") + "/@" + this.latitude+"," + this.longitude
	+ ",17z/";
		return newURL;
	}

	/**
	 * This method gets the distance between two Locaiton instances using 
	 * the Geocoding.distance() method
	 *
	 * @return A double value that is the distance between two instances of 
	 * Locations
	 */
	public double getDistance(){
		// return the distance between two locations, as calculated by  the 
		// geocoding distance method 
		return Geocoding.distance(currentLocation.latitude, 
				currentLocation.longitude, this.latitude, this.longitude);
	}

	/**
	 * A getter method to get the Locations private static currentLocation field
	 * @return the locations currentLocation
	 */
	public static Location getCurrent(){
		return currentLocation;
	}

	/**
	 * A setter method to set the Locations private static currentLocation 
	 * field
	 * @param setter A Location to set the Locations currentLocation field 
	 */
	public static void setCurrent(Location setter){
		currentLocation = setter;
	}

	/**
	 * This method is designed to compare two Locations. If the current 
	 * location is null then the locations are compared alphabetically by 
	 * there names. Otherwise, the Locations are compared by their distance
	 * from the set currentLocation.
	 * 
	 *
	 * @param comparable A Location to compare to the currentLocation and 
	 * this Location instance 
	 * @return An int that is -1, 0, or 1 depending on if the Location
	 */
	@Override
	public int compareTo(Location comparable) {
		//If current location equals null
		if(currentLocation == null){
			//Create and int to specify the char index to compare between two 
			// string
			int i = 0; 
			// While the chars are equal and i is still less the length of 
			// both location names
			while(this.name.charAt(i) == comparable.name.charAt(i) && i <
					this.name.length() && i < comparable.name.length()){
				i++;
			}
			//return the signum difference between the two chars as an int
			return (int) Math.signum(this.name.charAt(i) -
					comparable.name.charAt(i));



		}
		//If the current location does not equal null than compare the 
		// distances of the two locations
		else{
			//return the signum  difference of value of the two locations 
			// as an int 
			return (int) Math.signum(this.getDistance() - 
					comparable.getDistance());
		}

	}




}
