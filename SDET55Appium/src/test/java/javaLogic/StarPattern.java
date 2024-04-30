package javaLogic;

public class StarPattern {

	public static void main(String[] args) {
		
		print(5,5);
	}
	
	public static void print(int row,int column) {
		for (int i =1;i<=row; i++) {
			for (int j=1; j<=i; j++) {
			System.out.print("*");	
			}
			System.out.println();
		}
	}
	
}