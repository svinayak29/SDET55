package javaLogic;

import java.util.HashSet;

public class PrintDuplicate {

	public static void main(String[] args) {
		String s ="abaxyba";
		
		HashSet<Character> set = new HashSet<Character>();
		HashSet<Character> duplicates = new HashSet<Character>();
		
		for (Character c : s.toCharArray()) {
			if(!set.add(c)) {
				duplicates.add(c);
			}
		}
		System.out.println("Duplicates charcters in the String "+duplicates);
	}
}
