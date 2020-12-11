/*
 * BOJ 1175 단어 공부
 * Bronze 1
 * https://www.acmicpc.net/problem/1157
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int[] alpha = new int[26];
		for (int i = 0; i < str.length(); i++) {
			alpha[str.charAt(i) - 'A']++;
		}
		int max = -1;
		char ans = '?';
		for (int i = 0; i < alpha.length; i++) {
			if (max < alpha[i]) {
				max = alpha[i];
				ans = (char) ('A' + i);
			} else if (max == alpha[i]) {
				ans = '?';
			}
		}
		System.out.println(ans);
	}
}
