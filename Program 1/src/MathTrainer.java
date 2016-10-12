///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:  Program1.java
// File:             MathTrainer.java
// Semester:         Spring 2016
//
// Author:           Bill Chang
// CS Login:         billc

// Credits:          none
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Scanner;
import java.util.Random;


public class MathTrainer 
{
	public static void main(String[] args) 
	{
		char usermoperation;
		int correctnumber = 0;
		
		System.out.println( "Hello and welcome to the Math Trainer!\n"
				+ "======================================");

		// Allow a person to enter the math operation he wants to practice.
        Scanner one = new Scanner(System.in);
		System.out.println( "Which math operation would you like to practice?"
				+ "\n\t[A]ddition\n\t[S]ubtraction\n\t[M]ultiplication\n\t"
				+ "[D]ivision\n\t[R]emainder\nEnter your choice:");
		usermoperation = one.next(".").charAt(0);
		
		// Generate Addition Problem
		if ( (usermoperation == 'A') || (usermoperation == 'a') ){
			// Generate Random Question(s)
			Random randGen = new Random(Config.RANDOM_SEED);
			int correctChance = randGen.nextInt(Config.MAX_VALUE - 
					Config.MIN_VALUE + 1);
			for ( int i = 1; i <= Config.NUMBER_OF_QUESTIONS; i++){
				Scanner usermsolutionone = new Scanner(System.in);
				if ( i > 1 ) {
					correctChance = randGen.nextInt(Config.MAX_VALUE - 
							Config.MIN_VALUE + 1);
				}
				int a1 = correctChance + Config.MIN_VALUE;
				int a2 = randGen.nextInt(Config.MAX_VALUE - Config.MIN_VALUE 
						+ 1) + Config.MIN_VALUE;
				int solution1 =  a1  +  a2 ;
				System.out.printf( "What is the solution to the problem:"
						+ " %d + %d = ", a1, a2);
				// Determine if the Answer is Right or not 
				if (usermsolutionone.hasNextDouble()){
					double usermsolution1 = usermsolutionone.nextDouble();
					if ( usermsolution1 - solution1 == 0 ){
						correctnumber ++;
						System.out.println("That is correct!");
					} else {
						System.out.printf("The correct solution is %d.\n",
								solution1);
						// Creating Table of Solutions
						System.out.printf("       | ");
						double a2min, a2max, a1min, a1max;
						if ( a2 - 2 < Config.MIN_VALUE ){
							a2min = Config.MIN_VALUE;
						} 
						else {
							a2min = a2 - 2;
						}
						if ( a2 + 2 > Config.MAX_VALUE ){
							a2max = Config.MAX_VALUE;
						}
						else {
							a2max = a2 + 2;
						}
						if ( a1 - 2 < Config.MIN_VALUE ){
							a1min = Config.MIN_VALUE;
						}
						else {
							a1min = a1 - 2;
						}
						if ( a1 + 2 > Config.MAX_VALUE ){
							a1max = Config.MAX_VALUE;
						}
						else {
							a1max = a1 + 2;
						}
						for ( double p = a2min; p <= a2max; p++){
							System.out.printf("%6.2f ", p);
						}
						System.out.printf("\n");
						System.out.printf("---------");
						for ( int p = 1; p <= (a2max - a2min +1); p++){
							System.out.printf("-------");					
						}
						System.out.printf("\n");
						for ( double p = a1min; p <= a1max; p++){
							System.out.printf("%6.2f |", p);
							for ( double q = a2min; q <= a2max; q++){
								System.out.printf(" %6.2f", p+q);
							}
							System.out.printf("\n");
						}
					}
				} else {
					System.out.printf("All solutions must be entered as"
							+ " decimal numbers.\nThe correct solution is %d."
							+ "\n", solution1);
					System.out.printf("       | ");
					double a2min, a2max, a1min, a1max;
					if ( a2 - 2 < Config.MIN_VALUE ){
						a2min = Config.MIN_VALUE;
					} 
					else {
						a2min = a2 - 2;
					}
					if ( a2 + 2 > Config.MAX_VALUE ){
						a2max = Config.MAX_VALUE;
					}
					else {
						a2max = a2 + 2;
					}
					if ( a1 - 2 < Config.MIN_VALUE ){
						a1min = Config.MIN_VALUE;
					}
					else {
						a1min = a1 - 2;
					}
					if ( a1 + 2 > Config.MAX_VALUE ){
						a1max = Config.MAX_VALUE;
					}
					else {
						a1max = a1 + 2;
					}
					for ( double p = a2min; p <= a2max; p++){
						System.out.printf("%6.2f ", p);
					}
					System.out.printf("\n");
					System.out.printf("---------");
					for ( int p = 1; p <= (a2max - a2min +1); p++){
						System.out.printf("-------");					
					}
					System.out.printf("\n");
					for ( double p = a1min; p <= a1max; p++){
						System.out.printf("%6.2f |", p);
						for ( double q = a2min; q <= a2max; q++){
							System.out.printf(" %6.2f", p+q);
						}
						System.out.printf("\n");
					}
				}
			}
			System.out.print("*** You answered " + correctnumber + " out of "
			+ Config.NUMBER_OF_QUESTIONS + " questions correctly.\n");
		} 
		// Generate Subtraction Problem
		else if ( (usermoperation == 'S') || (usermoperation == 's') ){
			// Generate Random Question(s)
			Random randGen = new Random(Config.RANDOM_SEED);
			int correctChance = randGen.nextInt(Config.MAX_VALUE -
					Config.MIN_VALUE + 1);
			for ( int i = 1; i <= Config.NUMBER_OF_QUESTIONS; i++){
				Scanner usermsolutionone = new Scanner(System.in);
				if ( i > 1 ) {
					correctChance = randGen.nextInt(Config.MAX_VALUE -
							Config.MIN_VALUE + 1);
				}
				int s1 = correctChance + Config.MIN_VALUE;
				int s2 = randGen.nextInt(Config.MAX_VALUE - Config.MIN_VALUE +
						1) + Config.MIN_VALUE;
				int solution1 =  s1  -  s2 ;
				System.out.printf( "What is the solution to the problem:"
						+ " %d - %d = ", s1, s2);
				// Determine if the Answer is Right or not 
				if (usermsolutionone.hasNextDouble()){
					double usermsolution1 = usermsolutionone.nextDouble();
					if ( usermsolution1 - solution1 == 0 ){
						correctnumber ++;
						System.out.println("That is correct!");
					} else {
						System.out.printf("The correct solution is %d.\n",
								solution1);
						// Creating Table of Solutions
						System.out.printf("       | ");
						double s2min, s2max, s1min, s1max;
						if ( s2 - 2 < Config.MIN_VALUE ){
							s2min = Config.MIN_VALUE;
						} 
						else {
							s2min = s2 - 2;
						}
						if ( s2 + 2 > Config.MAX_VALUE ){
							s2max = Config.MAX_VALUE;
						}
						else {
							s2max = s2 + 2;
						}
						if ( s1 - 2 < Config.MIN_VALUE ){
							s1min = Config.MIN_VALUE;
						}
						else {
							s1min = s1 - 2;
						}
						if ( s1 + 2 > Config.MAX_VALUE ){
							s1max = Config.MAX_VALUE;
						}
						else {
							s1max = s1 + 2;
						}
						for ( double p = s2min; p <= s2max; p++){
							System.out.printf("%6.2f ", p);
						}
						System.out.printf("\n");
						System.out.printf("---------");
						for ( int p = 1; p <= (s2max - s2min +1); p++){
							System.out.printf("-------");					
						}
						System.out.printf("\n");
						for ( double p = s1min; p <= s1max; p++){
							System.out.printf("%6.2f |", p);
							for ( double q = s2min; q <= s2max; q++){
								System.out.printf(" %6.2f", p-q);
							}
							System.out.printf("\n");
						}
					}
				} else {
					System.out.printf("All solutions must be entered as"
							+ " decimal numbers.\nThe correct solution is %d."
							+ "\n", solution1);
					System.out.printf("       | ");
					double s2min, s2max, s1min, s1max;
					if ( s2 - 2 < Config.MIN_VALUE ){
						s2min = Config.MIN_VALUE;
					} 
					else {
						s2min = s2 - 2;
					}
					if ( s2 + 2 > Config.MAX_VALUE ){
						s2max = Config.MAX_VALUE;
					}
					else {
						s2max = s2 + 2;
					}
					if ( s1 - 2 < Config.MIN_VALUE ){
						s1min = Config.MIN_VALUE;
					}
					else {
						s1min = s1 - 2;
					}
					if ( s1 + 2 > Config.MAX_VALUE ){
						s1max = Config.MAX_VALUE;
					}
					else {
						s1max = s1 + 2;
					}
					for ( double p = s2min; p <= s2max; p++){
						System.out.printf("%6.2f ", p);
					}
					System.out.printf("\n");
					System.out.printf("---------");
					for ( int p = 1; p <= (s2max - s2min +1); p++){
						System.out.printf("-------");					
					}
					System.out.printf("\n");
					for ( double p = s1min; p <= s1max; p++){
						System.out.printf("%6.2f |", p);
						for ( double q = s2min; q <= s2max; q++){
							System.out.printf(" %6.2f", p-q);
						}
						System.out.printf("\n");
					}
				}
			}
			System.out.print("*** You answered " + correctnumber + " out of "
			+ Config.NUMBER_OF_QUESTIONS + " questions correctly.\n");
		}
		// Generate Multiplication Problem
		else if ( (usermoperation == 'M') || (usermoperation == 'm') ){
			// Generate Random Question(s)
			Random randGen = new Random(Config.RANDOM_SEED);
			int correctChance = randGen.nextInt(Config.MAX_VALUE -
					Config.MIN_VALUE + 1);
			for ( int i = 1; i <= Config.NUMBER_OF_QUESTIONS; i++){
				Scanner usermsolutionone = new Scanner(System.in);
				if ( i > 1 ) {
					correctChance = randGen.nextInt(Config.MAX_VALUE -
							Config.MIN_VALUE + 1);
				}
				int m1 = correctChance + Config.MIN_VALUE;
				int m2 = randGen.nextInt(Config.MAX_VALUE - Config.MIN_VALUE +
						1) + Config.MIN_VALUE;
				int solution1 =  m1  *  m2 ;
				System.out.printf( "What is the solution to the problem:"
						+ " %d x %d = ", m1, m2);
				// Determine if the Answer is Right or not 
				if (usermsolutionone.hasNextDouble()){
					double usermsolution1 = usermsolutionone.nextDouble();
					if ( usermsolution1 - solution1 == 0 ){
						correctnumber ++;
						System.out.println("That is correct!");
					} else {
						System.out.printf("The correct solution is %d.\n",
								solution1);
						// Creating Table of Solutions
						System.out.printf("       | ");
						double m2min, m2max, m1min, m1max;
						if ( m2 - 2 < Config.MIN_VALUE ){
							m2min = Config.MIN_VALUE;
						} 
						else {
							m2min = m2 - 2;
						}
						if ( m2 + 2 > Config.MAX_VALUE ){
							m2max = Config.MAX_VALUE;
						}
						else {
							m2max = m2 + 2;
						}
						if ( m1 - 2 < Config.MIN_VALUE ){
							m1min = Config.MIN_VALUE;
						}
						else {
							m1min = m1 - 2;
						}
						if ( m1 + 2 > Config.MAX_VALUE ){
							m1max = Config.MAX_VALUE;
						}
						else {
							m1max = m1 + 2;
						}
						for ( double p = m2min; p <= m2max; p++){
							System.out.printf("%6.2f ", p);
						}
						System.out.printf("\n");
						System.out.printf("---------");
						for ( int p = 1; p <= (m2max - m2min +1); p++){
							System.out.printf("-------");					
						}
						System.out.printf("\n");
						for ( double p = m1min; p <= m1max; p++){
							System.out.printf("%6.2f |", p);
							for ( double q = m2min; q <= m2max; q++){
								System.out.printf(" %6.2f", p*q);
							}
							System.out.printf("\n");
						}
					}
				} else {
					System.out.printf("All solutions must be entered as"
							+ " decimal numbers.\nThe correct solution is %d."
							+ "\n", solution1);
					System.out.printf("       | ");
					double m2min, m2max, m1min, m1max;
					if ( m2 - 2 < Config.MIN_VALUE ){
						m2min = Config.MIN_VALUE;
					} 
					else {
						m2min = m2 - 2;
					}
					if ( m2 + 2 > Config.MAX_VALUE ){
						m2max = Config.MAX_VALUE;
					}
					else {
						m2max = m2 + 2;
					}
					if ( m1 - 2 < Config.MIN_VALUE ){
						m1min = Config.MIN_VALUE;
					}
					else {
						m1min = m1 - 2;
					}
					if ( m1 + 2 > Config.MAX_VALUE ){
						m1max = Config.MAX_VALUE;
					}
					else {
						m1max = m1 + 2;
					}
					for ( double p = m2min; p <= m2max; p++){
						System.out.printf("%6.2f ", p);
					}
					System.out.printf("\n");
					System.out.printf("---------");
					for ( int p = 1; p <= (m2max - m2min +1); p++){
						System.out.printf("-------");					
					}
					System.out.printf("\n");
					for ( double p = m1min; p <= m1max; p++){
						System.out.printf("%6.2f |", p);
						for ( double q = m2min; q <= m2max; q++){
							System.out.printf(" %6.2f", p*q);
						}
						System.out.printf("\n");
					}
				}
			}
			System.out.print("*** You answered " + correctnumber + " out of " +
			Config.NUMBER_OF_QUESTIONS + " questions correctly.\n");
		} 
		// Generate Division Problem
		else if ( (usermoperation == 'D') || (usermoperation == 'd') ){
			// Generate Random Question(s)
			Random randGen = new Random(Config.RANDOM_SEED);
			int correctChance = randGen.nextInt(Config.MAX_VALUE -
					Config.MIN_VALUE + 1);
			for ( int i = 1; i <= Config.NUMBER_OF_QUESTIONS; i++){
				Scanner usermsolutionone = new Scanner(System.in);
				if ( i > 1 ) {
					correctChance = randGen.nextInt(Config.MAX_VALUE -
							Config.MIN_VALUE + 1);
				}
				int d1 = correctChance + Config.MIN_VALUE;
				int d2 = randGen.nextInt(Config.MAX_VALUE - Config.MIN_VALUE +
						1) + Config.MIN_VALUE;
				double solution1 = (d1*1.0) / (d2*1.0);
				System.out.printf( "What is the solution to the problem:"
						+ " %d / %d = ", d1, d2);
				// Determine if the Answer is Right or not 
				if (usermsolutionone.hasNextDouble()){
					double usermsolution1 = usermsolutionone.nextDouble();
					if ( Math.abs(usermsolution1 - solution1) <
							Config.CLOSE_ENOUGH ){
						correctnumber ++;
						System.out.println("That is correct!");
					} else {
						System.out.printf("The correct solution is %6.2f.\n",
								solution1);
						// Creating Table of Solutions
						System.out.printf("       | ");
						double d2min, d2max, d1min, d1max;
						if ( d2 - 2 < Config.MIN_VALUE ){
							d2min = Config.MIN_VALUE;
						} 
						else {
							d2min = d2 - 2;
						}
						if ( d2 + 2 > Config.MAX_VALUE ){
							d2max = Config.MAX_VALUE;
						}
						else {
							d2max = d2 + 2;
						}
						if ( d1 - 2 < Config.MIN_VALUE ){
							d1min = Config.MIN_VALUE;
						}
						else {
							d1min = d1 - 2;
						}
						if ( d1 + 2 > Config.MAX_VALUE ){
							d1max = Config.MAX_VALUE;
						}
						else {
							d1max = d1 + 2;
						}
						for ( double p = d2min; p <= d2max; p++){
							System.out.printf("%6.2f ", p);
						}
						System.out.printf("\n");
						System.out.printf("---------");
						for ( int p = 1; p <= (d2max - d2min +1); p++){
							System.out.printf("-------");					
						}
						System.out.printf("\n");
						for ( double p = d1min; p <= d1max; p++){
							System.out.printf("%6.2f |", p);
							for ( double q = d2min; q <= d2max; q++){
								System.out.printf(" %6.2f", p/q);
							}
							System.out.printf("\n");
						}
					}
				} else {
					System.out.printf("All solutions must be entered as"
							+ " decimal numbers.\nThe correct solution is"
							+ " %6.2f.\n", solution1);
					System.out.printf("       | ");
					double d2min, d2max, d1min, d1max;
					if ( d2 - 2 < Config.MIN_VALUE ){
						d2min = Config.MIN_VALUE;
					} 
					else {
						d2min = d2 - 2;
					}
					if ( d2 + 2 > Config.MAX_VALUE ){
						d2max = Config.MAX_VALUE;
					}
					else {
						d2max = d2 + 2;
					}
					if ( d1 - 2 < Config.MIN_VALUE ){
						d1min = Config.MIN_VALUE;
					}
					else {
						d1min = d1 - 2;
					}
					if ( d1 + 2 > Config.MAX_VALUE ){
						d1max = Config.MAX_VALUE;
					}
					else {
						d1max = d1 + 2;
					}
					for ( double p = d2min; p <= d2max; p++){
						System.out.printf("%6.2f ", p);
					}
					System.out.printf("\n");
					System.out.printf("---------");
					for ( int p = 1; p <= (d2max - d2min +1); p++){
						System.out.printf("-------");					
					}
					System.out.printf("\n");
					for ( double p = d1min; p <= d1max; p++){
						System.out.printf("%6.2f |", p);
						for ( double q = d2min; q <= d2max; q++){
							System.out.printf(" %6.2f", p/q);
						}
						System.out.printf("\n");
					}
				}
			}
			System.out.print("*** You answered " + correctnumber + " out of "
			+ Config.NUMBER_OF_QUESTIONS + " questions correctly.\n");
		} 
		// Generate Remainder Problem
		else if ( (usermoperation == 'R') || (usermoperation == 'r') ){
			// Generate Random Question(s)
			Random randGen = new Random(Config.RANDOM_SEED);
			int correctChance = randGen.nextInt(Config.MAX_VALUE -
					Config.MIN_VALUE + 1);
			for ( int i = 1; i <= Config.NUMBER_OF_QUESTIONS; i++){
				Scanner usermsolutionone = new Scanner(System.in);
				if ( i > 1 ) {
					correctChance = randGen.nextInt(Config.MAX_VALUE -
							Config.MIN_VALUE + 1);
				}
				int r1 = correctChance + Config.MIN_VALUE;
				int r2 = randGen.nextInt(Config.MAX_VALUE - Config.MIN_VALUE +
						1) + Config.MIN_VALUE;
	        	int solution1 =  r1  %  r2 ;
	        	System.out.printf( "What is the solution to the problem:"
	        			+ " %d %% %d = ", r1, r2);
				// Determine if the Answer is Right or not 
	        	if (usermsolutionone.hasNextDouble()){
	        		double usermsolution1 = usermsolutionone.nextDouble();
	        		if ( usermsolution1 - solution1 == 0 ){
						correctnumber ++;
	        			System.out.println("That is correct!");
	        		} else {
						System.out.printf("The correct solution is %d.\n",
								solution1);
						// Creating Table of Solutions
						System.out.printf("       | ");
						double r2min, r2max, r1min, r1max;
						if ( r2 - 2 < Config.MIN_VALUE ){
							r2min = Config.MIN_VALUE;
						} 
						else {
							r2min = r2 - 2;
						}
						if ( r2 + 2 > Config.MAX_VALUE ){
							r2max = Config.MAX_VALUE;
						}
						else {
							r2max = r2 + 2;
						}
						if ( r1 - 2 < Config.MIN_VALUE ){
							r1min = Config.MIN_VALUE;
						}
						else {
							r1min = r1 - 2;
						}
						if ( r1 + 2 > Config.MAX_VALUE ){
							r1max = Config.MAX_VALUE;
						}
						else {
							r1max = r1 + 2;
						}
						for ( double p = r2min; p <= r2max; p++){
							System.out.printf("%6.2f ", p);
						}
						System.out.printf("\n");
						System.out.printf("---------");
						for ( int p = 1; p <= (r2max - r2min +1); p++){
							System.out.printf("-------");					
						}
						System.out.printf("\n");
						for ( double p = r1min; p <= r1max; p++){
							System.out.printf("%6.2f |", p);
							for ( double q = r2min; q <= r2max; q++){
								System.out.printf(" %6.2f", p%q);
							}
							System.out.printf("\n");
						}
					}
				} else {
					System.out.printf("All solutions must be entered as"
							+ " decimal numbers.\nThe correct solution is %d."
							+ "\n", solution1);
					System.out.printf("       | ");
					double r2min, r2max, r1min, r1max;
					if ( r2 - 2 < Config.MIN_VALUE ){
						r2min = Config.MIN_VALUE;
					} 
					else {
						r2min = r2 - 2;
					}
					if ( r2 + 2 > Config.MAX_VALUE ){
						r2max = Config.MAX_VALUE;
					}
					else {
						r2max = r2 + 2;
					}
					if ( r1 - 2 < Config.MIN_VALUE ){
						r1min = Config.MIN_VALUE;
					}
					else {
						r1min = r1 - 2;
					}
					if ( r1 + 2 > Config.MAX_VALUE ){
						r1max = Config.MAX_VALUE;
					}
					else {
						r1max = r1 + 2;
					}
					for ( double p = r2min; p <= r2max; p++){
						System.out.printf("%6.2f ", p);
					}
					System.out.printf("\n");
					System.out.printf("---------");
					for ( int p = 1; p <= (r2max - r2min +1); p++){
						System.out.printf("-------");					
					}
					System.out.printf("\n");
					for ( double p = r1min; p <= r1max; p++){
						System.out.printf("%6.2f |", p);
						for ( double q = r2min; q <= r2max; q++){
							System.out.printf(" %6.2f", p%q);
						}
						System.out.printf("\n");
					}
				}
			}
			System.out.print("*** You answered " + correctnumber + " out of " +
			Config.NUMBER_OF_QUESTIONS + " questions correctly.\n");
		} else {
			System.out.printf( "I'm sorry, I only understand choices of:"
					+ " A, S, M, D, or R.\n");
		}      
		System.out.println( "=====================================\n"
				+ "Thank you for using the Math Trainer!");
		// Implement Program - Math Trainer
	}
}
