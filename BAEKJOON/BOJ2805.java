/*
 * BOJ 2805 나무 자르기
 * Silver 3
 * https://www.acmicpc.net/problem/2805
 */

import java.util.*;
import java.io.*;

public class BOJ2805 {
	static int N, M;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		int max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(tree[i], max);
		}
		
		int l = 0, r = max, m = 0;
		long sum = 0;
		while (l <= r) {
			m = (l + r) / 2;
			sum = check(m);
			if (sum >= M) {
				l = m + 1;
			} else if (sum < M) {
				r = m - 1;
			}
		}
		
		System.out.println(r);
	}
	
	public static long check(int h) {
		long sum = 0;
		for (int i = 0; i < tree.length; i++) {
			int tmp = tree[i] - h;
			if (tmp >= 0)
				sum += (tree[i] - h);
		}
		return sum;
	}
}
