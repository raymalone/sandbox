public class Main {


	public static void main(String[] args) {

		// This was a challenge I was given in an interview and stumbled through
		// it, figured I try to implement
		//
		// Given a string buffer and one temporary variable, how would you
		// revers the order of the words
		// you have to made the modification in the original buffer and can only
		// use a char as a temp place
		// holder.
		// ex: input of "some words" should print "words some"

		StringBuffer sb = new StringBuffer("some words to reverse yoda style");

		reverse(sb);

	}

	public static void reverse(StringBuffer sb) {
		char tempChar;
		int x = sb.length() - 1;
		for (int i = 0; i < (sb.length() - 1)/2 ; i++) {
			tempChar = sb.charAt(i);
			sb.insert(i-i, sb.charAt(x));
			sb.deleteCharAt(i + 1);
			sb.append(tempChar);
			sb.deleteCharAt(x);
			x--;

		}
		System.out.println(sb);

	}

}
