/*
 * BOJ 1717 집합의 표현
 * Gold 4
 * https://www.acmicpc.net/problem/1717
 */

import java.io.*;
import java.util.*;

public class BOJ1717 {
	static int N, M;
	static int[] parent, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		rank = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int comm = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (comm == 0) {
				union(a, b);
			} else if (comm == 1) {
				if (findSet(a) == findSet(b)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		
		System.out.print(sb);
	}
	
	public static int findSet(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px != py) {
			link(px, py);
		}
	}

	public static void link(int px, int py) {
		if (rank[px] > rank[py]) {
			parent[py] = px;
		} else {
			parent[px] = py;
			if (rank[px] == rank[py])
				rank[py]++;
		}
	}
}
