/*
 * BOJ 5427 불
 * Gold 4
 * https://www.acmicpc.net/problem/5427
 */

import java.io.*;
import java.util.*;

public class BOJ5427 {
	static int T, w, h, ans;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Pos> person, fire;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2]; // 탈출 확인을 쉽게 하기 위해 +2씩 크게 만듦 
			visited = new boolean[h+2][w+2];
			person = new LinkedList<>();
			fire = new LinkedList<>();
			for (int i = 1; i <= h; i++) {
				String str = br.readLine();
				for (int j = 1; j <= w; j++) {
					map[i][j] = str.charAt(j-1);
					if (map[i][j] == '@') {
						person.offer(new Pos(i, j));
						visited[i][j] = true;
						map[i][j] = '.';
					} else if (map[i][j] == '*') {
						fire.offer(new Pos(i, j));
					}
				}
			}
			
			ans = Integer.MAX_VALUE;
			bfs();
			if (ans == Integer.MAX_VALUE) {
				sb.append("IMPOSSIBLE\n");
			} else {
				sb.append(ans).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static void bfs() {
		int time = 0;
		while (!person.isEmpty()) {
			// 불이 먼저 퍼진다
			int qs = fire.size();
			for (int s = 0; s < qs; s++) {
				Pos cur = fire.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dir[i][0];
					int ny = cur.y + dir[i][1];
					if (nx <= 0 || h+1 <= nx || ny <= 0 || w+1 <= ny) continue;
					if (map[nx][ny] == '*' || map[nx][ny] == '#') continue;
					fire.offer(new Pos(nx, ny));
					map[nx][ny] = '*';
				}
			}
			
			// 사람이 이동한다
			qs = person.size();
			for (int s = 0; s < qs; s++) {
				Pos cur = person.poll();
				if (cur.x == 0 || cur.x == h+1 || cur.y == 0 || cur.y == w+1) {
					ans = Math.min(ans, time);
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dir[i][0];
					int ny = cur.y + dir[i][1];
					if (map[nx][ny] == '*' || map[nx][ny] == '#') continue;
					if (visited[nx][ny]) continue;
					person.offer(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
			time++;
		}
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
