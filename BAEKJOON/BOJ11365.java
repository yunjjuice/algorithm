/*
 * BOJ 11365 !밀비 급일
 * Bronze 2
 * https://www.acmicpc.net/problem/11365
 */

import java.io.*;

public class BOJ11365 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			if (str.equals("END")) {
				break;
			}
			StringBuilder tmp = new StringBuilder(str);
			sb.append(tmp.reverse()).append('\n');
		}
		
		System.out.println(sb);
	}
}
