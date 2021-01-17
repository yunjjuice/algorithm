/*
 * BOJ 2573 빙산
 * Gold 4
 * https://www.acmicpc.net/problem/2573
 */

import java.util.*;
import java.io.*;

public class BOJ2573 {
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
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
			}
		}
		
		// 1. 빙산이 몇 개의 덩어리로 나뉘었는지 확인한다
		// 2. 빙산이 물에 닿은 부분만큼 녹는다
		int piece = 0;
		while ((piece = check()) <= 1) {
			if (piece == 0) {
				ans = 0;
				break;
			}
			melt();
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static void melt() {
		visited = new boolean[N][M];
		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					q.offer(new Pos(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
				if (!isLen(nx, ny) || visited[nx][ny] || map[nx][ny] > 0) continue;
				cnt++;
			}
			
			if (map[cur.x][cur.y] - cnt < 0) {
				map[cur.x][cur.y] = 0;
			} else {
				map[cur.x][cur.y] -= cnt;				
			}
		}
	}

	public static int check() {
		visited = new boolean[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] > 0) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new Pos(x, y));
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
				if (!isLen(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;
				visited[nx][ny] = true;
				q.offer(new Pos(nx, ny));
			}
		}
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
