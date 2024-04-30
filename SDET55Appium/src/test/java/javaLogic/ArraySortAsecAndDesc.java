package javaLogic;

import java.util.Arrays;

public class ArraySortAsecAndDesc {

	
	public static void main(String[] args) {
		int a[]= {3,9,5,1,6,7};
		
		Arrays.sort(a);
		
		System.out.println("Sorted Array");
		for (int i = 0; i<= a.length-1; i++) {
			System.out.print(a[i]+" ");
		}
		
		int firstMin = a[0];
		int firstMax = a[a.length-1];
		System.out.println();
		System.out.println("First Minimum Number "+firstMin);
		System.out.println("First Maximum Number "+firstMax);
	}
}
