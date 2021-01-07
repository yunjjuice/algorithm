/*
 * BOJ 1769 3의 배수
 * Silver 5
 * https://www.acmicpc.net/problem/1769
 */

import java.io.*;

public class BOJ1769 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;
		while (str.length() > 1) {
			cnt++;
			int sum = 0;
			for (int i = 0; i < str.length(); i++) {
				sum += str.charAt(i) - '0';
			}
			str = sum + "";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt);
		if (Integer.parseInt(str) % 3 == 0) {
			sb.append('\n').append("YES");
		} else {
			sb.append('\n').append("NO");
		}
		
		System.out.println(sb);
	}
}
