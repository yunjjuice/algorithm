/*
 * BOJ 2156 포도주 시식 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
	static int n;
	static int[] wine, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		wine = new int[n+1];
		dp = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		if (n == 1) {
			dp[1] = wine[1];
		} else if (n == 2) {
			dp[2] = wine[1] + wine[2];
		} else {
			dp[1] = wine[1];
			dp[2] = dp[1] + wine[2];
			dp[3] = Math.max(dp[2], Math.max(wine[1] + wine[3], wine[2] + wine[3]));
			for (int i = 4; i <= n; i++) {
				dp[i] = Math.max(dp[i-1], dp[i-2] + wine[i]);
				dp[i] = Math.max(dp[i], dp[i-3] + wine[i-1] + wine[i]);
			}
		}
		System.out.println(dp[n]);
	}
}