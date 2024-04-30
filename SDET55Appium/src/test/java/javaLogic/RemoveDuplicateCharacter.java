package javaLogic;

import java.util.HashSet;

public class RemoveDuplicateCharacter {

	public static void main(String[] args) {
		String s ="abaxyba";
		HashSet<Character> set = new HashSet<Character>();
		
		for (Character c : s.toCharArray()) {
			set.add(c);
			
		}
		
		System.out.println(set);

	}

}
