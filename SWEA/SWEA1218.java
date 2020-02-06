/*
 * SWEA 1218 괄호 짝짓기 D4
 */

import java.util.Scanner;
import java.util.Stack;

public class SWEA1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 10; testCase++) {
			int len = sc.nextInt();
			String s = sc.next();
			Stack st = new Stack();
			for (int i = 0; i < len; i++) {
				char ch = s.charAt(i);
				if (st.isEmpty()) { // 비어있으면 넣는다
					st.push(ch);
					continue;
				} else { // 비어있지 않으면
					// 검사
					if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
						st.push(ch);
						continue;
					}
					if (((char) st.peek() == '(' && ch == ')') || ((char) st.peek() == '[' && ch == ']')
							|| ((char) st.peek() == '{' && ch == '}') || ((char) st.peek() == '<' && ch == '>')) { 																		// 삭제
						st.pop(); // 짝이 맞으면 삭제
						continue;
					}
					st.push(ch);
				}
			}
			int ans = 0;
			if(st.isEmpty())
				ans = 1;
			else
				ans = 0;
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
