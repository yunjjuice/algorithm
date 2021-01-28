/*
 * BOJ 2512 예산
 * Silver 3
 * https://www.acmicpc.net/problem/2512
 */

import java.util.*;
import java.io.*;

public class BOJ2512 {
	static int N, M, max;
	static int[] budget;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		budget = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		max = -1;
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, budget[i]);
		}
		M = Integer.parseInt(br.readLine());
		
		int l = 1, r = max, m = 0;
		int ans = 0;
		while (l <= r) {
			m = (l + r) / 2;
			int total = 0;
			for (int i = 0; i < N; i++) {
				if (budget[i] >= m)
					total += m;
				else 
					total += budget[i];
			}
			if (total > M) {
				r = m - 1;
			} else {
				ans = Math.max(ans, m);
				l = m + 1;
			}
		}
		
		System.out.println(ans);
	}
}
