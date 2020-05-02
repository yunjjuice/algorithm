/*
 * BOJ 2193 이친수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] d = new long[91];
		d[1] = 1;
		d[2] = 1;
		for (int i = 3; i <= N; i++) {
			d[i] = d[i-2] + d[i-1];
		}
		System.out.println(d[N]);
	}
}
