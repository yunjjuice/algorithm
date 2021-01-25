/*
 * BOJ 17404 RGB거리 2
 * Gold 4
 * https://www.acmicpc.net/problem/17404
 */

import java.util.*;
import java.io.*;

public class BOJ17404 {
	static int N;
	static int[][] cost;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			ans = Math.min(ans, solve(i));
		}
		
		System.out.println(ans);
	}
	
	public static long solve(int n) {
		long[][] d = new long[N+1][3];
		d[1][n] = cost[1][n];
		d[1][(n+1) % 3] = Integer.MAX_VALUE;
		d[1][(n+2) % 3] = Integer.MAX_VALUE;
		
		for (int i = 2; i <= N; i++) {
			d[i][0] = cost[i][0] + Math.min(d[i-1][1], d[i-1][2]);
			d[i][1] = cost[i][1] + Math.min(d[i-1][0], d[i-1][2]);
			d[i][2] = cost[i][2] + Math.min(d[i-1][0], d[i-1][1]);			
		}
		
		return Math.min(d[N][(n+1) % 3], d[N][(n+2) % 3]);
	}
}
