/*
 * BOJ 10026 적록색약
 * Gold 5
 * https://www.acmicpc.net/problem/10026
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026_dfs {
	static int N;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0},  {0, -1},  {0, 1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		StringBuilder sb = new StringBuilder();
		
		// 적록색약 아닌 사람
		visit = new boolean[N][N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					dfs(0, i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt).append(' ');
		
		// 적록색약인 사람
		visit = new boolean[N][N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					dfs(1, i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
	
	public static void dfs(int type, int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (visit[nx][ny]) continue;
			if (type == 0) { // 적록색약 아님
				if (map[x][y] == map[nx][ny])
					dfs(type, nx, ny);
			} else { // 적록색약
				if (map[x][y] == 'B') {
					if (map[nx][ny] == 'R' || map[nx][ny] == 'G')
						continue;
				} else if (map[x][y] == 'R' || map[x][y] == 'G') {
					if (map[nx][ny] == 'B')
						continue;
				}
				dfs(type, nx, ny);
			}
		}
	}
	
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
