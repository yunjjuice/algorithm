/*
 * BOJ 1699 제곱수의 합
 * Silver 2
 * https://www.acmicpc.net/problem/1699
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1699 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().toString());
		
		int d[] = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			d[i] = i;
			for (int j = 1; j*j <= i; j++) {
				if (d[i] > d[i-j*j] + 1) {
					d[i] = d[i-j*j] + 1;
				}
			}
		}
		
		System.out.println(d[n]);
	}
}
