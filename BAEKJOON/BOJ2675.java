/*
 * BOJ 2675 문자열 반복
 * Bronze 2
 * https://www.acmicpc.net/problem/10809
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			for (int i = 0; i < S.length(); i++) {
				for (int j = 0; j < R; j++) {
					sb.append(S.charAt(i));
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
