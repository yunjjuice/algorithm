/*
 * BOJ 2606 바이러스
 * Silver 3
 * https://www.acmicpc.net/problem/2606
 */

import java.util.*;
import java.io.*;

public class BOJ2606 {
	static int V, E;
	static int[][] map;
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		map = new int[V+1][V+1];
		visited = new boolean[V+1];
		StringTokenizer st;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		dfs(1);
		
		System.out.println(ans);
	}
	
	public static void dfs(int n) {
		visited[n] = true;
		
		for (int i = 1; i <= V; i++) {
			if (map[n][i] == 1 && !visited[i]) {
				dfs(i);
				ans++;
			}
		}
	}
}
