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

/**
 * Analyzes a given string to see if it is a palindrome.
 *
 * @author csiebler
 */
public class IsPalindromeThread extends Thread {

    private final String str;
    private boolean palindrome;

    /**
     * Constructor
     *
     * @param str user input
     */
    public IsPalindromeThread(String str) {
        super("IsPalindromeThread");
        this.str = str;
        palindrome = false;
    }

    /**
     * Execution segment
     */
    @Override
    public void run() {
        palindrome = str.equals(new StringBuilder(str).reverse().toString());
    }

    /**
     * Is palindrome
     *
     * @return True if string is a palindrome. False if string is not a
     * palindrome.
     */
    public boolean isPalindrome() {
        return palindrome;
    }

}
