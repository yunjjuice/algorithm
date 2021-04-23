/*
 * BOJ 1167 트리의 지름
 * Gold 3
 * https://www.acmicpc.net/problem/1167
 */

import java.io.*;
import java.util.*;

public class BOJ1167 {
	static int V, max, leaf;
	static List<Node>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = 0, v = 0;
			while ((c = Integer.parseInt(st.nextToken())) != -1) {
				v = Integer.parseInt(st.nextToken());
				list[p].add(new Node(c, v));
			}
		}
		
		visited = new boolean[V+1];
		dfs(1, 0);
		visited = new boolean[V+1];
		dfs(leaf, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(int v, int sum) {
		visited[v] = true;
		if (max < sum) {
			max = sum;
			leaf = v;
		}
		for (int i = 0; i < list[v].size(); i++) {
			Node next = list[v].get(i);
			if (!visited[next.v]) {
				dfs(next.v, sum + next.cost);
			}
		}
	}
	
	static class Node {
		int v, cost;

		public Node(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}
	}
}
