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
 * Counts the uppercase digits of a given string.
 *
 * @author csiebler
 */
public class UpperCountThread extends Thread {
    
    private final String str;
    private int count;
    
    /**
     * Constructor 
     * 
     * @param str user input
     */
    public UpperCountThread(String str) {
        super("UpperCountThread");
        this.str = str;
        this.count = 0;
    }
    
    /**
     * Execution segment
     */
    @Override
    public void run() {
        for (int i = 0; i < str.length(); ++i) {
            if (Character.isUpperCase(str.charAt(i))) {
                count++;
            }
        }
    }
    
    /**
     * Get count
     * @return uppercase digit count of the string
     */
    public int getCount() {
        return count;
    }
    
}
