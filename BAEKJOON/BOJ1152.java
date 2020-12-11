/*
 * BOJ 1152 단어의 개수
 * Bronze 2
 * https://www.acmicpc.net/problem/1152
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		while(st.hasMoreTokens()) {
			cnt++;
			st.nextElement();
		}
		System.out.println(cnt);
	}
}
