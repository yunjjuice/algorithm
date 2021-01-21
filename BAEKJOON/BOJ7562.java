/*
 * BOJ 7562 나이트의 이동
 * Silver 2
 * https://www.acmicpc.net/problem/7562
 */

import java.util.*;
import java.io.*;

public class BOJ7562 {
	static int N, sx, sy, ex, ey;
	static boolean[][] visited;
	static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			sb.append(bfs(sx, sy)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int bfs(int x, int y) {
		int cnt = 0;
		Queue<Pos> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new Pos(x, y));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos cur = q.poll();
				if (cur.x == ex && cur.y == ey) return cnt;
				for (int i = 0; i < dir.length; i++) {
					int nx = cur.x + dir[i][0];
					int ny = cur.y + dir[i][1];
					if (!isLen(nx, ny) || visited[nx][ny]) continue;
					visited[nx][ny] = true;
					q.offer(new Pos(nx, ny));
				}
			}
			cnt++;
		}
		
		return cnt;
	}
	
	public static boolean isLen(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) return true;
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
