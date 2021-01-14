/*
 * BOJ 12865 평범한 배낭
 * Gold 5
 * https://www.acmicpc.net/problem/12865
 */

import java.util.*;
import java.io.*;

public class BOJ12865 {
	static int N, K;
	static int[][] dp;
	static int[] w, v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		w = new int[N+1];
		v = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if (j - w[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]]+v[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
