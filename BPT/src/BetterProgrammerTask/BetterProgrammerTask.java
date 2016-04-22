package BetterProgrammerTask;

import java.util.*;

public class BetterProgrammerTask {

// Task 1
    public static boolean isPalindrome(String s) {
        /*
          Definition: A palindrome is a string that reads the same forward and backward.
          For example, "abcba" is a palindrome, "abab" is not.
          Please implement this method to
          return true if the parameter is a palindrome and false otherwise.
         */
    	for(int i = 0, j = s.length() - 1; i < s.length() >> 1; i++, j--){
    		if(s.charAt(i) != s.charAt(j)) return false;
    	}
    	return true;
    }

 // Task 2
    public static int getRequiredNumberOfBits(int N) {
        /*
          Please implement this method to
          return the number of bits which is just enough to store any integer from 0 to N-1 inclusively
          for any int N > 0
          Example: to store 5 integers from 0 to 4 you need 3 bits: 000, 001, 010, 011, 100 and 101
        */
    	if(N < 0) return 0;
    	int result = 0;
    	do{
    		result++;
    		N >>= 1;
    	} while (N > 0);
    	return result;
    }
    
 // Task 3
 // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }
    
    public static int getLargestRootToLeafSum(Node root) {
        /*
          A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
          to the root node inclusively.
          A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

          Please implement this method to
          return the largest root-to-leaf sum in the tree.
         */
    	int result = 0;
    	for(Node node : root.getChildren()){
    		int sum = getLargestRootToLeafSum(node);
    		if(sum > result) result = sum;
    	}
    	return result + root.getValue();
    }
    
 // Task 4    

    public static double getProbability(int Y, int X) {
        /*
          If you roll Y standard six-sided dice, what’s the probability that you get at least X 4s?
          To calculate that you should divide the number of comibnations with X or more 4s
          by the total number of possible combinations.
         */
    	
    	if(X > Y || X < 1 || Y < 1) return 0;
    	
    	double sumOfComb4s = 0;
    	
    	for(int i = X; i <= Y; i++){
    		double numOfCombFreeDices = Math.pow(6, Y-i);
    		double numOfComb4sDices = (recfact(X+1, Y-X) / (factorial(Y-X)));
    		sumOfComb4s += numOfCombFreeDices*numOfComb4sDices;
    	}
    	double sumOfCombAll = Math.pow(6, Y);
    	return sumOfComb4s / sumOfCombAll;
    }
    
    static Long recfact(long start, long n) {
        long i;
        if (n == 0){
        	return new Long(1);
        }
        else if (n <= 16) { 
        	Long r = start;
            for (i = start + 1; i < start + n; i++) r *= i;
            return r;
        }
        i = n / 2;
        return recfact(start, i) * recfact(start + i, n - i);
    }
    static Long factorial(long n) { return recfact(1, n); }

    
    
}

