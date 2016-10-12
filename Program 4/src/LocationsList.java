import java.util.ArrayList;
import java.util.Collections;
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
 * This class is designed to create a location list object that holds the 
 * current list of locations being used by the MyFavoritePlaces.java. The class
 * also handles various methods for interacting with the locations list.
 *
 * &lt;p&gt;Bugs: (a list of bugs and other problems)
 *
 */
public class LocationsList {
	private ArrayList<Location> list;

	/**
	 * This class serves as a constructor that creates a location list 
	 * object with an arraylist designed to hold locations
	 */
	public LocationsList(){
		list = new ArrayList<Location>();
	}

	/**
	 * This method is designed to allow locations to be added to the array 
	 * list of locations.
	 *
	 * @param locationToAdd A location to be added to the list
	 */
	public void addLocation(Location locationToAdd){
		list.add(locationToAdd);
	}

	/**
	 * This method is designed to allow locations to be added to the array 
	 * list of locations by calling the arraylist remove() method.
	 * 
	 * @param int An integer that represents the index to be removed from 
	 * the array list 
	 */
	public void deleteLocation(int i){
		list.remove(i);
	}

	/**
	 * This method is designed to retrieve the specified location at the index
	 * that is passed in as an int. 
	 *
	 * @param int An int that sepecifies the index to return
	 * @return Location A location  
	 */
	public Location retrieveLocation(int i){
		return list.get(i);
	}

	/**
	 * This method is designed to test if two locations are duplicates of each 
	 * other. If they are true is returned otherwise false is returned. 
	 *
	 * @param location A location that is compared 
	 * @return boolean A boolean that returns true if the locations are 
	 * duplications, otherwise false
	 */
	public boolean duplicateLocation(Location location){

		for(int i =0; i < list.size();i++){
			if (list.get(i).equals(location)){
				return true; 
			}
		}
		return false; 
	}

	/**
	 * This method is design to return the size of the list
	 *
	 * @return int an integer representing the size of the array list
	 */
	public int getSize(){
		return list.size();
	}

	/**
	 * This method is designed to sort the list of locations using the 
	 * Collections.sort() method
	 */
	public void sortLocation(){
		//Sort the locations using the collections sort method, sorted by its 
		// natural order
		Collections.sort(this.list);
	}


	/**
	 * This method is designed to test the names and address of two locations
	 * and return true if they equal otherwise false if there not. 
	 *
	 * @return boolean true if the two locations equal each other otherwise 
	 * false
	 */
	public boolean testLocation(Location test){

		for (int i =0; i < this.list.size(); i++){

			if( test.getName().equals(list.get(i).getName()) && 
					test.getAdress().equals(list.get(i).getAdress()) ){
				return true; 
			}
		}
		return false;
	}








}
