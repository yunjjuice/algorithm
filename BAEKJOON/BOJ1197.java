/*
 * BOJ 1197 최소 스패닝 트리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1197 {
	static int V, E;
	static long cost;
	static int[] rank, parent;
	static int[][] edges;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		rank = new int[V+1];
		parent = new int[V+1];
		edges = new int[E][3]; 
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// 가중치로 정렬한다
		Arrays.sort(edges, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}
		
		int cnt = 0;
		cost = 0;
		
		for (int i = 0; i < E; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if(a == b) continue;
			
			unionSet(a, b);
			cost += edges[i][2];
			
			cnt++;
			if(cnt == V-1)
				break;
		}
		
		System.out.println(cost);
	}
	
	public static void makeSet(int x) {
		parent[x] = x;
	}
	
	public static int findSet(int x) {
		if(parent[x] == x)
			return x;
		else {
			parent[x] = findSet(parent[x]);
			return parent[x];
		}
	}
	
	public static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(rank[py] > rank[px]) {
			parent[px] = py;
		} else {
			parent[py] = px;
			if(rank[px] == rank[py])
				rank[px]++;
		}
	}
}
