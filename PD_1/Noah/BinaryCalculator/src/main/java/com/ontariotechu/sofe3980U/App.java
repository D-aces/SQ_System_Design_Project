package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;

/**
 * Demonstrates the use of the Binary class
 */
public class App 
{
	/**
	* Main program:  The entry point of the program. The local time will be printed first,
	*      Then it will create two binary variables, add them and print the result.
	*
	* @param args: not used
	*/
    public static void main(String[] args)
    {
		LocalTime currentTime = new LocalTime();// the current local time

		System.out.println(String.format(
			"Greetings!\n> Current local time: %s:%s\n", currentTime.getHourOfDay(), currentTime.getMinuteOfHour()
			));//Print the current local time

		//Create two binary variables
		Binary binary1 = new Binary("00010001000");
        System.out.println("First binary number: " + binary1.getValue());

		Binary binary2 = new Binary("111000");
        System.out.println("Second binary number: " + binary2.getValue());

		Binary sum = Binary.add(binary1, binary2);//Add the two binary variables
		Binary or = Binary.or(binary1, binary2);//Bitwise OR the two binary variables
		Binary and = Binary.and(binary1, binary2);//Bitwise AND the two binary variables
		Binary mult = Binary.mult(binary1, binary2);//Multiply the two binary variables

		//Print the results
		System.out.println("\n~Results~");
		System.out.println("Summation: " + sum.getValue());
		System.out.println("Bitwise OR: " + or.getValue());
		System.out.println("Bitwise AND: " + and.getValue());
		System.out.println("Multiplication: " + mult.getValue());

		//Final message
		System.out.println("\n> Thank you! <");
    }
}