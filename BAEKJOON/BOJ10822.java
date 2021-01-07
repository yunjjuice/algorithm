/*
 * BOJ 10822 더하기
 * Bronze 2
 * https://www.acmicpc.net/problem/10822
 */

import java.io.*;

public class BOJ10822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(",");
		int sum = 0;
		for (String tmp : str) {
			sum += Integer.parseInt(tmp);
		}
		System.out.println(sum);
	}
}
