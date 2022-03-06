/*
 * BOJ 17413 단어 뒤집기 2
 * Silver 3
 * https://www.acmicpc.net/problem/17413
 */

import java.io.*;
import java.util.*;

public class BOJ17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> st = new Stack<>();
		int idx = 0;
		while (idx < S.length()) {
			if (S.charAt(idx) == '<') {
				while (!st.isEmpty()) {
					sb.append(st.pop());
				}
				for (int i = idx; i < S.length(); i++) {
					if (S.charAt(i) == '>') {
						sb.append(S.substring(idx, i+1));
						idx = i+1;
						break;
					}
				}
			} else if (S.charAt(idx) != ' ') {
				st.push(S.charAt(idx++));
			} else if (S.charAt(idx) == ' ') {
				while (!st.isEmpty()) {
					sb.append(st.pop());
				}
				sb.append(' ');
				idx++;
			}
		}
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		System.out.println(sb.toString());
	}
}
