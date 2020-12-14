/*
 * BOJ 11725 트리의 부모 찾기
 * Silver 2
 * https://www.acmicpc.net/problem/11725
 */

import java.util.*;
import java.io.*;

public class BOJ11725 {
	static boolean[] visit;
	static int[] parent;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		parent = new int[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void dfs(int i) {
		visit[i] = true;
		
		for (int v : list[i]) {
			if (visit[v]) continue;
			parent[v] = i;
			dfs(v);
		}
	}
}
