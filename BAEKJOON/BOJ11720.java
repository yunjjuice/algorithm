/*
 * BOJ 11720 숫자의 합
 * Bronze 2
 * https://www.acmicpc.net/problem/11720
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(str.charAt(i)+"");
		}
		System.out.println(sum);
	}
}
