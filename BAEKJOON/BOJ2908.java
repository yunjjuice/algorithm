/*
 * BOJ 2908 상수
 * Bronze 2
 * https://www.acmicpc.net/problem/2908
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		String tmp1 = "", tmp2 = "";
		for (int i = 2; i >= 0; i--) {
			tmp1 += str1.charAt(i) + "";
			tmp2 += str2.charAt(i) + "";
		}
		int num1 = Integer.parseInt(tmp1);
		int num2 = Integer.parseInt(tmp2);
		System.out.println(Math.max(num1, num2));
	}
}
