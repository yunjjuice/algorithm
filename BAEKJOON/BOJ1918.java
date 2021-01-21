/*
 * BOJ 1918 후위 표기식
 * Gold 4
 * https://www.acmicpc.net/problem/1918
 */

import java.util.*;
import java.io.*;

public class BOJ1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> opr = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				opr.push(ch);
			} else if (ch == ')') {
				while (opr.peek() != '(') {
					sb.append(opr.pop());
				}
				opr.pop();
			} else if ('A' <= ch && ch <= 'Z') {
				sb.append(ch);
			} else if (ch == '*' || ch == '/') {
				while (!opr.isEmpty() && (opr.peek() == '*' || opr.peek() == '/')) {
					sb.append(opr.pop());
				}
				opr.push(ch);
			} else if (ch == '+' || ch == '-') {
				while (!opr.isEmpty() && opr.peek() != '(') {
					sb.append(opr.pop());
				}
				opr.push(ch);
			}
		}
		
		while (!opr.isEmpty()) {
			sb.append(opr.pop());
		}
		
		System.out.println(sb);
	}
}
