/*
 * BOJ 14889 스타트와 링크
 * Silver 3
 * https://www.acmicpc.net/problem/14889
 */

import java.util.*;
import java.io.*;

public class BOJ14889 {
	static int N, ans;
	static int[][] map;
	static boolean[] select;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		select = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		solve(1, 0);
		System.out.println(ans);
	}
	
	public static void solve(int index, int cnt) {
		if (cnt == N/2) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j) continue;
					if (select[i] && select[j]) {
						sum1 += map[i][j];
					} else if (!select[i] && !select[j]) {
						sum2 += map[i][j];
					}
				}
			}
			ans = Math.min(ans, Math.abs(sum1 - sum2));
			if (ans == 0) {
				System.out.println(ans);
				System.exit(0);
			}
			return;
		}
		
		for (int i = index; i <= N; i++) {
			if (select[i]) continue;
			select[i] = true;
			solve(i+1, cnt+1);
			select[i] = false;
		}
	}
}
