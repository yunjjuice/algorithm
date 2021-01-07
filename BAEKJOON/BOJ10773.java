/*
 * BOJ 10773 제로
 * Silver 4
 * https://www.acmicpc.net/problem/10773
 */

import java.io.*;

public class BOJ10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			arr[idx] = Integer.parseInt(br.readLine());
			if (arr[idx] == 0) {
				sum -= arr[--idx];
			} else {
				sum += arr[idx++];
			}
		}
		
		System.out.println(sum);
	}
}
