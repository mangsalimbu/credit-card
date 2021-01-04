/* 
 	Author: Mangsa Limbu Pheudin
 	Course: CSC-260-003
 	Date: 3-05-2019
 	Assignment: #5
 	Instructor: Professor Fry
 */

// This program checks whether the entered card number is valid or not and also determines the type of the card

import java.util.Scanner;

public class CreditCard {
	public static void main(String[] args) {
		// Creates new scanner variable.
		Scanner input = new Scanner(System.in);
		// Prompts user to enter a card number.
		System.out.print("Enter a credit card number as a long integer: ");
		// Assigns variable from user to ccNum
		long ccNum = input.nextLong();
		// If-else to check whether the number is valid or not.
		if(isValid(ccNum)) {
			System.out.println(ccNum + " is valid");
			System.out.println("Type is: " + getType(ccNum));
		} else {
			System.out.println(ccNum + " is invalid");
		}
		input.close();
	}
	// Determines the types of the card.
	public static String getType(long num) {
		int d =1;
		// If-else statement to match the initial number and return the correct value.
		if (getPrefix(num, d) == 4) {
            return ("Visa");
        } else if (getPrefix(num, d) == 5) {
        	return ("Master");
        } else if (getPrefix(num, d) == 3) {
        	return ("American Express");
        }
          else if (getPrefix(num,d)==6) {
        	return ("Discover");
        }
		return null;
 
	}
	//  Determines if the card is valid or not.
	public static boolean isValid(long ccNum) {
		// If-else statement to check if the card number is valid or not.
        if ((getSize(ccNum) >= 13 && getSize(ccNum) <= 16) && (prefixMatched(ccNum, 4)||prefixMatched(ccNum, 5)||prefixMatched(ccNum, 37)||prefixMatched(ccNum, 6)) &&((sumOfEvensPlaceDoubled(ccNum) + sumOfOddsPlace(ccNum)) % 10 == 0)) {
            return true;
        } else {
            return false;
        }
	}
	// Method to get the length of the number
	public static int getSize(long n) {
		int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
	}
	// Boolean method to return true if it matches the size of the card number.
	public static boolean prefixMatched(long num, int d) {
		
	        return getPrefix(num, getSize(d)) == d; 
	   
	}
	// Method to get the first digit of the card number.
	public static long getPrefix(long num, int k) {
		if (getSize(num) < k) {
            return num;
        } else {

            int size = (int) getSize(num);

            for (int i = 0; i < (size - k); i++) {
                num = num / 10;
            }

            return num;

        }
	}
	// Method to calculate the sum of even place from behind.
	public static int sumOfEvensPlaceDoubled(long num) {
		int result = 0;
        long temp = 0;

        while (num > 0) {
            temp = num % 100;
            result += getDigit((int) (temp / 10) * 2);
            num = num / 100;
        }

        return result;
	}
	// Method to get the sum of odd numbers from behind.
	public static int sumOfOddsPlace(long num) {
		int result = 0;

        while (num > 0) {
            result += (int) (num % 10);
            num = num / 100;
        }

        return result;
	}
	// Method to get the digit out.
	public static int getDigit(int num) {
        if (num <= 9) {
            return num;
        } else {
            int fDigit = num % 10;
            int sDigit = (int) (num / 10);

            return fDigit + sDigit;
        }
	}
}
