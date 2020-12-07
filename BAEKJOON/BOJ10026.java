/*
 * BOJ 10026 적록색약
 * Gold 5
 * https://www.acmicpc.net/problem/10026
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {
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
					bfs(0, i, j);
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
					bfs(1, i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
	
	public static void bfs(int type, int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		visit[x][y] = true;
		
		if (type == 0) {
			while(!q.isEmpty()) {
				Pos cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dir[i][0];
					int ny = cur.y + dir[i][1];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if (visit[nx][ny] || map[cur.x][cur.y] != map[nx][ny]) continue;
					q.offer(new Pos(nx, ny));
					visit[nx][ny] = true;
				}
			}
		} else {
			while(!q.isEmpty()) {
				Pos cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dir[i][0];
					int ny = cur.y + dir[i][1];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if (visit[nx][ny]) continue;
					if (map[cur.x][cur.y]== 'B') {
						if (map[nx][ny] == 'R' || map[nx][ny] == 'G')
							continue;
					}
					if (map[cur.x][cur.y] == 'R' || map[cur.x][cur.y] == 'G') {
						if (map[nx][ny] == 'B')
							continue;
					}
					q.offer(new Pos(nx, ny));
					visit[nx][ny] = true;
				}
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
