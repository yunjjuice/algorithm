/*
 * BOJ 1935 후위 표기식 2
 * Silver 3
 * https://www.acmicpc.net/problem/1935
 */

import java.io.*;
import java.util.*;

public class BOJ1935 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		float[] num = new float[26];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Float> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			float a = 0, b = 0;
			switch (str.charAt(i)) {
			case '+':
				b = st.pop();
				a = st.pop();
				st.push(a+b);
				break;
			case '-':
				b = st.pop();
				a = st.pop();
				st.push(a-b);
				break;
			case '*':
				b = st.pop();
				a = st.pop();
				st.push(a*b);
				break;
			case '/':
				b = st.pop();
				a = st.pop();
				st.push(a/b);				
				break;
			default:
				int idx = str.charAt(i) - 'A';
				st.push(num[idx]);
				break;
			}
		}
		
		System.out.println(String.format("%.2f", st.pop()));
	}
}
