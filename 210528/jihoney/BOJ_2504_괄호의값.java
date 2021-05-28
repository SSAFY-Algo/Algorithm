package sc_210528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504_°ýÈ£ÀÇ°ª {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Stack<Character> st = new Stack<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();

		int roundCnt = 0, recCnt = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			switch (c) {
			case '(':
				st.add(c);
				roundCnt++;
				break;
			case '[':
				st.add(c);
				recCnt++;
				break;
			case ')':
				if (roundCnt == 0) {
					System.out.println("0");
					return;
				} else if (st.peek() == '(') {

				}

				break;
			case ']':
				if (recCnt == 0) {
					System.out.println("0");
					return;
				} else if (st.peek() == '[') {

				}

				break;
			}
		}

	}

}
