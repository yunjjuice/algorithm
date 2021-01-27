/*
 * BOJ 1654 랜선 자르기
 * Silver 3
 * https://www.acmicpc.net/problem/1654
 */

import java.util.*;
import java.io.*;

public class BOJ1654 {
	static int K, N, ans;
	static long l, m, r;
	static int[] cables;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cables = new int[K];
		r = -1;
		for (int i = 0; i < K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
			r = Math.max(r, cables[i]);
		}
		
		l = 1;
		m = 0;
		ans = -1;
		while (l <= r) {
			m = (l + r) / 2;
			int cnt = 0;
			for (int i = 0; i < K; i++) {
				cnt += cables[i] / m;
			}
			if (cnt >= N) {
				ans = (int) Math.max(ans, m);
				l = m + 1;
			} else if (cnt < N) {
				r = m - 1;
			}
		}
		
		System.out.println(ans);
	}
}
