/*
 * BOJ 2638 치즈
 * Gold 4
 * https://www.acmicpc.net/problem/2638
 */

import java.util.*;
import java.io.*;

public class BOJ2638 {
	static int N, M, cheese, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheese++;
			}
		}
		
		while (cheese > 0) {
			bfs(0, 0);
			melt();
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static void bfs(int x, int y) {
		visited = new boolean[N][M];
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i < dir.length; i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
				if (!isLen(nx, ny) || map[nx][ny] == 1 || visited[nx][ny]) 
					continue;
				q.offer(new Pos(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	public static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && check(i, j)) {
					map[i][j] = 0;
					cheese--;
				}
			}
		}
	}

	public static boolean check(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < dir.length; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (isLen(x, y) && visited[nx][ny]) cnt++;
		}
		if (cnt >= 2) return true;
		return false;
	}
	
	public static boolean isLen(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) return true;
		return false;
	}
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
