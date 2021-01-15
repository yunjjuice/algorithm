/*
 * BOJ 2589 보물섬
 * Gold 5
 * https://www.acmicpc.net/problem/2589
 */

import java.util.*;
import java.io.*;

public class BOJ2589 {
	static int c, r;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new char[c][r];
		for (int i = 0; i < c; i++) {
			String s = br.readLine();
			for (int j = 0; j < r; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		ans = Integer.MIN_VALUE;
		
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (map[i][j] == 'L') {
					visit = new boolean[c][r];
					bfs(i, j);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void bfs(int x, int y) {
		int cnt = 0;
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		visit[x][y] = true;
		while (!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dir[i][0];
					int ny = cur.y + dir[i][1];
					if (!isLen(nx, ny) || visit[nx][ny] || map[nx][ny] == 'W') continue;
					q.offer(new Pos(nx, ny));
					visit[nx][ny] = true;
					ans = Math.max(ans, cnt);
				}
			}
		}
	}
	
	public static boolean isLen(int x, int y) {
		if (0 <= x && x < c && 0 <= y && y < r)
			return true;
		return false;
	}

	static class Pos {
		int x;
		int y;
		public Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
