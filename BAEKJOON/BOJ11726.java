/*
 * BOJ 11726 2xn 타일링 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] d = new int[1001];
		d[1] = 1;
		d[2] = 2;
		for (int i = 3; i <= N; i++) {
			d[i] = (d[i-2] + d[i-1]) % 10007;
		}
		
		System.out.println(d[N]);
	}
}
