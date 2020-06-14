import java.util.Arrays;
import java.util.List;

public class Main {

	/**
	 * Multiples of 3 and 5 If we list all the natural numbers below 10 that are
	 * multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * 
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 */

	public static void findThreeFive() {
		int a = 3;
		int b = 5;
		int sum = 0;

		for (int i = 1; i < 1000; i++) {
			if (i == a) {
				sum += a;
				a += 3;
			}

			if (i == b) {
				sum += b;
				b += 5;
			}
		}
		System.out.println("sum is " + sum);
	}

	/**
	 * Even Fibonacci numbers Each new term in the Fibonacci sequence is generated
	 * by adding the previous two terms. By starting with 1 and 2, the first 10
	 * terms will be:
	 * 
	 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	 * 
	 * By considering the terms in the Fibonacci sequence whose values do not exceed
	 * four million, find the sum of the even-valued terms.
	 */

	public static int evenFibonacciNumbers(int n) {

		int number1 = 0;
		int number2 = 1;
		int sum = 0, sumTotal = 0;

		while (number2 < n) {

			sum = number1 + number2;
			if (sum % 2 == 0) {
				System.out.println(sum);
				sumTotal += sum;
			}
			number1 = number2;
			number2 = sum;
		}
		System.out.println("sum is " + sumTotal);
		return sum;

//		int b = 1;
//		int c = 2, d;
//		long sum = 0;
//		while(c < n) {
//			System.out.println(c);
//		    sum += c;
//		    d = b+(c<<0x01);
//		    c = d+b+c;
//		    b = d;
//		}
//		return (int) sum;
	}

	/**
	 * Largest prime factor The prime factors of 13195 are 5, 7, 13 and 29.
	 * 
	 * What is the largest prime factor of the number 600851475143 ?
	 */

	public static int largestPrimeFactor(long n) {
		int i;

		for (i = 2; i < n; i++) {
			if (n % i == 0) {
				n /= i;
				i--;
			}
		}
		return i;
	}

	/**
	 * Largest palindrome product A palindromic number reads the same both ways. The
	 * largest palindrome made from the product of two 2-digit numbers is 9009 = 91
	 * × 99.
	 * 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	public static int largestPalindromeProduct() {
		int a = 999, palindrome = 0, product;
		for (int i = a; i > 99; i--) {
			for (int j = i; j > 99; j--) {
				product = i * j;
				if (isPalindrome(product) && product > palindrome) {
					palindrome = product;
				}
			}
		}
		return palindrome;
	}

	private static boolean isPalindrome(Integer product) {
		StringBuilder string = new StringBuilder(product.toString());
		return product.toString().equals(string.reverse().toString());
	}

	/**
	 * Smallest multiple 2520 is the smallest number that can be divided by each of
	 * the numbers from 1 to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible by all of the
	 * numbers from 1 to 20?
	 */
	public static int smallestMultiple(int n) {
		int i = n;

		while (true) {
			if (isMultiple(i, n)) {
				break;
			}
			i++;
		}
		return i;
	}

	private static boolean isMultiple(int number, int total) {
		for (int i = 1; i < total; i++) {
			if (number % i != 0)
				return false;
		}
		return true;
	}

	/**
	 * Sum square difference The sum of the squares of the first ten natural numbers
	 * is,
	 * 
	 * 1^2+2^2+...+10^2=385 n*(n+1)*(2n+1)/6 The square of the sum of the first ten
	 * natural numbers is,
	 * 
	 * (1+2+...+10)^2=55^2=3025 n*(n+1)/2. Hence the difference between the sum of
	 * the squares of the first ten natural numbers and the square of the sum is
	 * 3025−385=2640.
	 * 
	 * Find the difference between the sum of the squares of the first one hundred
	 * natural numbers and the square of the sum.
	 */
	public static int sumSquareDifference(int n) {
		int squareSum = n * (n + 1) / 2;
		int sumSquare = n * (n + 1) * (2 * n + 1) / 6;
		return squareSum * squareSum - sumSquare;
	}

	/**
	 * Eight houses, represented as cells, are arranged in a straight line. Each day
	 * every cell competes with its adjacent cells (neighbors). An integer value of
	 * 1 represents an active cell and a value of O represents an inactive cell. If
	 * the neighbors on both the sides of a cell are either active or inactive, the
	 * cell becomes inactive on the next day, otherwise the cell becomes active. The
	 * two cells on each end have a single adjacent cell, so assume that the
	 * unoccupied space on the opposite side is an inactive cell. Even after
	 * updating the cell state, consider its previous state when updating the state
	 * of other cells. The state information of all cells should be updated
	 * simultaneously. Write an algorithm to output the state of the cells after the
	 * given number of days.
	 * 
	 * Input The input to the function/method consists of two arguments:
	 * 
	 * states, a list of integers representing the current state of cells; days, an
	 * integer representing the number of days.
	 * 
	 * Output Return a list of integers representing the state of the cells after
	 * the given number of days.
	 * 
	 * Note
	 * 
	 * The elements of the list states contains Os and 1s only.
	 * 
	 * 
	 * Testcase 1:
	 * 
	 * Input:
	 * 
	 * [1, 0, 0, 0, 0, 1, 0, 0], 1
	 * 
	 * Expected Return Value:
	 * 
	 * 0 1 0 0 1 0 1 0
	 * 
	 * Testcase 2:
	 * 
	 * Input:
	 * 
	 * [1, 1, 1, 0, 1, 1, 1, 1], 2
	 * 
	 * Expected Return Value:
	 * 
	 * 0 0 0 0 1 1 0
	 */

	// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED // DEFINE ANY CLASS AND
	// METHOD NEEDED // CLASS BEGINS, THIS CLASS IS REQUIRED

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

	public static int[] cellCompete(int[] states, int days) {
		// WRITE YOUR CODE HERE
		int[] copy;
		for (int d = 1; d <= days; d++) {
			copy = states.clone();
			state: for (int i = 0; i < copy.length; i++) {
				if (i == 0 || i == copy.length - 1) {
					if (i == 0 && copy[i+1] == 0 || i == copy.length - 1 && copy[i - 1] == 0) {
						states[i] = 0;
						continue state;
					} else {
						states[i] = 1;
						continue state;
					}
				}
				if(copy[i-1] == copy[i + 1])
					states[i] = 0;
				else
					states[i] = 1;
			}
		}
		return states;
	} //

	public static void main(String[] args) {
		int[] arr = { 1, 0, 0, 0, 0, 1, 0, 0 };
		System.out.println(Arrays.toString(cellCompete(arr, 1)));// 4000000
	}

	/**
	 * The greatest common divisor (GCD), also called highest common factor (HCF) of
	 * N numbers is the largest positive integer that divides all numbers without
	 * giving a remainder.
	 * 
	 * Write an algorithm to determine the GCD of N positive integers.
	 * 
	 * Input The input to the function/method consists of two arguments num, an
	 * integer representing the number of positive integers (N).
	 * 
	 * arr, a list of positive integers.
	 * 
	 * Output Return an integer representing the GCD of the given positive integers.
	 * 
	 * Example
	 * 
	 * Input:
	 * 
	 * num = 5 arr = [2, 4, 6, 8, 10] Output:
	 * 
	 * 2
	 * 
	 * Explanation:
	 * 
	 * The largest positive integer that divides all the positive integers 2, 4, 6,
	 * 8, 10 without a remainder is 2.
	 * 
	 * So, the output is 2.
	 * 
	 * 
	 * Test Case 1:
	 * 
	 * Input:
	 * 
	 * 5, [2, 3, 4, 5, 6]
	 * 
	 * Expected Return Value:
	 * 
	 * 1 1
	 * 
	 * Testcase 2:
	 * 
	 * Input:
	 * 
	 * 5, [2, 4, 6, 8, 10]
	 * 
	 * Expected Return Value:
	 * 
	 * 2
	 */
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

	// WRITE YOUR CODE HERE

	public int generalizedGCD(int num, int[] arr) {
		return num;

	} // METHOD SIGNATURE ENDS
}
