package javaLogic;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String a = sc.next();
		
		for (int i =a.length()-1; i>=0; i--) {
			System.out.print(a.charAt(i)+"");
		}
		sc.close();
	}

}
