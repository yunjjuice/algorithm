/*
 * BOJ 10809 알파벳 찾기
 * Bronze 2
 * https://www.acmicpc.net/problem/10809
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 25; i++) {
			char tmp = (char) ('a' + i);
			sb.append(S.indexOf(tmp)).append(' ');
		}
		System.out.println(sb);
	}
}
