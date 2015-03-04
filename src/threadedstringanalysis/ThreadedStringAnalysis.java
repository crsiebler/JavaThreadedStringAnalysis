/*
 * Copyright (c) 2015 Cory Siebler
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package threadedstringanalysis;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objective of the program is to read a string from the keyboard and determine 
 * how many digits, uppercase letters, and determine if the string is 
 * palindrome or not. Three threads need to be implemented for each of the 
 * tasks above.
 *
 * @author csiebler
 */
public class ThreadedStringAnalysis {
    
    private static final Logger LOGGER = Logger.getLogger(ThreadedStringAnalysis.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String str = scan.nextLine();
        
        // Create an instance of the string analysis threads
        DigitCountThread digitCountThread = new DigitCountThread(str);
        UpperCountThread upperCountThread = new UpperCountThread(str);
        IsPalindromeThread isPalindromeThread = new IsPalindromeThread(str);
        
        // Start thread instances created above
        digitCountThread.start();
        upperCountThread.start();
        isPalindromeThread.start();
        
        // Wait for the three threads to complete
        while (!digitCountThread.getState().equals(Thread.State.TERMINATED)
                && !upperCountThread.getState().equals(Thread.State.TERMINATED)
                && !isPalindromeThread.getState().equals(Thread.State.TERMINATED)) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
        
        // Display digit count, upper count and weather the string is a palindrome or not
        System.out.println(digitCountThread.getCount());
        System.out.println(upperCountThread.getCount());
        System.out.println(isPalindromeThread.isPalindrome());
    }

}
