/*
 * BOJ 1922 네트워크 연결
 * Gold 4
 * https://www.acmicpc.net/problem/1922
 */

import java.io.*;
import java.util.*;

public class BOJ1922 {
	static int N, M, cost;
	static Edge[] graph;
	static int[] parent, rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new Edge[M];
		parent = new int[N];
		rank = new int[N];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			graph[i] = new Edge(a, b, cost);
		}
		
		Arrays.sort(graph);
		
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			Edge e = graph[i];
			int px = findSet(e.a);
			int py = findSet(e.b);
			
			if (px != py) {
				union(px, py);
				cost += e.cost;
				cnt++;
				if (cnt == N-1) break;
			}
		}
		
		System.out.println(cost);
	}
	
	// 부모 노드를 찾는다
	public static int findSet(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = findSet(parent[x]);
			return parent[x];
		}
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
	
	static class Edge implements Comparable<Edge> {
		int a, b;
		int cost;
		public Edge(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}
