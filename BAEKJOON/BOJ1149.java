/*
 * BOJ 1149 RGB거리
 * https://www.acmicpc.net/problem/1149
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
	static int N;
	static int[][] house;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		house = new int[N+1][3];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			dp[i][0] = Math.min(house[i][0]+dp[i-1][1], house[i][0]+dp[i-1][2]);
			dp[i][1] = Math.min(house[i][1]+dp[i-1][0], house[i][1]+dp[i-1][2]);
			dp[i][2] = Math.min(house[i][2]+dp[i-1][0], house[i][2]+dp[i-1][1]);
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
}
