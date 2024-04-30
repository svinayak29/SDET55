package javaLogic;

import java.util.Arrays;

public class ArrayMinAndMaxLength {

	public static void main(String[] args) {
		String str[]={"ab","xyz","array","a","appex"};
		
		
		String minLength =str[0];
		String maxLength = str[0];
		
		for(String s : str) {
			if(s.length() < minLength.length()) {
				minLength =s;
			}
			if(s.length() >maxLength.length()) {
				maxLength =s;
			}
		}
		System.out.println("First Mininum length in Array "+minLength);
		System.out.println("First Maximaum length in Array "+maxLength);
	}

}
