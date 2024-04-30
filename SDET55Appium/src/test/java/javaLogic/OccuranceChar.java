package javaLogic;

public class OccuranceChar {

	public static void main(String[] args) {
		String s = "abaxyba";
		
		char target ='a';
		int count =0;
		for(int i=0;i<=s.length()-1;i++) {
			if(s.charAt(i)==target) {
				count++;
			}
		}
		
		System.out.println("Number of Occurance of "+target+" : "+count);
	}
}
