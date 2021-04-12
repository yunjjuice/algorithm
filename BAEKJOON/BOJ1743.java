/*
 * BOJ 1743 음식물 피하기
 * Silver 1
 * https://www.acmicpc.net/problem/1743 
 */

import java.io.*;
import java.util.*;

public class BOJ1743 {
	static int N, M, K, ans, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 1;
		}
		
		ans = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					cnt = 1;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y) {
		ans = Math.max(ans, cnt);
		for (int i = 0; i < dir.length; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (!isRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;
			visited[nx][ny] = true;
			cnt++;
			dfs(nx, ny);
		}
	}
	
	public static boolean isRange(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) return true;
		else return false;
	}
}
