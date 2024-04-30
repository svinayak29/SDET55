package javaLogic;

public class ReverseTheWordsString {

	public static void main(String[] args) {
		String s = "My Name Is Vinayak";
		
		
		String words[] = s.split(" ");
		 for (int i = words.length-1; i>=0; i--) {
			System.out.print(words[i]+" ");
		}

	}

}
