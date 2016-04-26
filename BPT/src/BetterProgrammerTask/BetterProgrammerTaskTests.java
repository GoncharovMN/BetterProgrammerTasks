package BetterProgrammerTask;

import java.util.ArrayList;
import java.util.List;
import static BetterProgrammerTask.BetterProgrammerTask.*;

import BetterProgrammerTask.BetterProgrammerTask.Node;

public class BetterProgrammerTaskTests {
	public static void Task1_isPalindromeTests(){
		isPalindrome("");
		assert isPalindrome("abcba") == true;
		assert isPalindrome("dsaqweaabcbaaewqasd") == true;
		assert isPalindrome("aabcdba") == false;
		assert isPalindrome("ab") == false;
	}
	
	public static void Task2_getRequiredNumberOfBits(){
		assert getRequiredNumberOfBits(-3) == 0;
		assert getRequiredNumberOfBits(1) == 1;
		assert getRequiredNumberOfBits(5) == 3;
		assert getRequiredNumberOfBits(8) == 4;
		assert getRequiredNumberOfBits(63) == 6;
	}
	
	public static void Task3_getLargestRootToLeafSum(){
		class NodeTest implements Node {
	    	
	    	private int value;
	    	private List<Node> childrens;
	    	
	    	public NodeTest(int value){
	    		this.value = value;
	    		childrens = new ArrayList<Node>();
	    	}
	    	
	    	public int getValue(){
	    		return value;
	    	}
	    	
	    	public void setValue(int newVal){
	    		value = newVal;
	    	}
	    	
	    	public List<Node> getChildren(){
	    		return childrens;
	    	}
	    	
	    	public void setChildren(NodeTest newNode){
	    		childrens.add(newNode);
	    	}
	    }
		
		NodeTest root = new NodeTest(5), 
				node11 = new NodeTest(5), 
				node12 = new NodeTest(5), 
				node13 = new NodeTest(5), 
				node21 = new NodeTest(5), 
				node22 = new NodeTest(5), 
				node23 = new NodeTest(5), 
				node24 = new NodeTest(5);
		
		root.setChildren(node11); root.setChildren(node12); root.setChildren(node13);
		node11.setChildren(node21); node11.setChildren(node22);	node12.setChildren(node23); node12.setChildren(node24);

		assert getLargestRootToLeafSum(root) == 15;
		
		node13.setValue(20);
		assert getLargestRootToLeafSum(root) == 25;
		
		node13.setValue(5);
		node12.setValue(-1);
		node23.setValue(15);
		assert getLargestRootToLeafSum(root) == 19;

		assert getLargestRootToLeafSum(node12) == 14;
		
		assert getLargestRootToLeafSum(node21) == 5;
	}
	
	public static void Task4_getProbability(){ 
		assert getProbability(1, 1) == 1d/6;
		assert getProbability(2, 1) == 14d/36;
		assert getProbability(2, 2) == 1d/36;
		
		assert getProbability(20, 21) == 0d;
		assert getProbability(-1, 1) == 0d;
		assert getProbability(1, -1) == 0d;
	}
}
