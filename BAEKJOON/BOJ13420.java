/*
 * BOJ 13420 사칙연산
 * Bronze 2
 * https://www.acmicpc.net/problem/13420
 */

import java.io.*;

public class BOJ13420 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			String[] str = br.readLine().split(" ");
			long a = Long.parseLong(str[0]);
			long b = Long.parseLong(str[2]);
			long res = 0;
			if (str[1].equals("+")) {
				res = a + b;
			} else if (str[1].equals("-")) {
				res = a - b;
			} else if (str[1].equals("*")) {
				res = a * b;
			} else if (str[1].equals("/")) {
				res = a / b;
			}
			if (res == Long.parseLong(str[4])) {
				sb.append("correct").append('\n');
			} else {
				sb.append("wrong answer").append('\n');
			}
		}
		System.out.println(sb);
	}
}
