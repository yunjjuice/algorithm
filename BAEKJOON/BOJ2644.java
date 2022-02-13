/*
 * BOJ 2644 촌수계산
 * Silver 2
 * https://www.acmicpc.net/problem/2644
 */

import java.util.*;
import java.io.*;

public class BOJ2644 {
	static int n;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		System.out.println(bfs(start, dest));
	}
	
	public static int bfs(int start, int dest) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		visited[start] = true;
		q.offer(new int[]{start, 0});
		while (!q.isEmpty()) {
			int[] next = q.poll();
			if (next[0] == dest) {
				return next[1];
			}
			for (int i = 1; i <= n; i++) {
				if (visited[i] || map[next[0]][i] == 0) continue;
				visited[i] = true;
				q.offer(new int[]{i, next[1] + 1});
			}
		}
		
		return -1;
	}
}
