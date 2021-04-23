/*
 * BOJ 1967 트리의 지름
 * Gold 4
 * https://www.acmicpc.net/problem/1967
 */

import java.io.*;
import java.util.*;

public class BOJ1967 {
	static int n, max, leaf;
	static List<Node>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st = null;
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			list[p].add(new Node(c, cost));
			list[c].add(new Node(p, cost));
		}
		
		max = Integer.MIN_VALUE;
		// 루트 노드에서 가장 멀리 있는 노드 찾아와 leaf에 저장
		visited = new boolean[n];
		dfs(0, 0);
		// leaf부터 시작해서 제일 지름이 큰 값을 찾는다
		visited = new boolean[n];
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
