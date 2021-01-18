/*
 * BOJ 1325 효율적인 해킹
 * Silver 2
 * https://www.acmicpc.net/problem/1325
 */

import java.util.*;
import java.io.*;

public class BOJ1325 {
	static int N, M;
	static boolean[] used;
	static int[] com;
	static ArrayList[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		
		int max = Integer.MIN_VALUE;
		com = new int[N+1];
		for (int i = 1; i <= N; i++) {
			used = new boolean[N+1];
			dfs(i);
		}
		
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, com[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (com[i] == max) sb.append(i + " ");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int n) {
		used[n] = true;
		for (int i = 0; i < list[n].size(); i++) {
			int next = (int) list[n].get(i);
			if (used[next]) continue;
			com[next]++;
			dfs(next);
		}
	}
}
