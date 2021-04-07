/*
 * BOJ 16398 행성 연결
 * Gold 4
 * https://www.acmicpc.net/problem/16398
 */

import java.io.*;
import java.util.*;

public class BOJ16398 {
	static int N;
	static List<Edge> list;
	static int[] parent, rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		rank = new int[N+1];
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if (i < j) list.add(new Edge(i, j, cost));
			}
		}
		Collections.sort(list);
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		long cost = 0;
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			Edge e = list.get(i);
			int px = findSet(e.x);
			int py = findSet(e.y);
			
			if (px != py) {
				union(px, py);
				cost += e.cost;
				cnt++;
				if (cnt == N-1) break;
			}
		}
		
		System.out.println(cost);
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

	public static int findSet(int x) {
		if (parent[x] == x) { 
			return x;
		} else {
			parent[x] = findSet(parent[x]);
			return parent[x];
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int x, y;
		int cost;
		public Edge(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}
