/*
 * BOJ 1175 배달
 * Gold 1
 * https://www.acmicpc.net/problem/1175
 */

import java.io.*;
import java.util.*;

public class BOJ1175 {
	static int N, M, ans;
	static char[][] map;
	static int[] start;
	static int[][] dest;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		start = new int[2];
		dest = new int[2][2];
		visited = new boolean[N][M][4][4]; // N, M, 방향, 배달장소
		int index = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					start[0] = i;
					start[1] = j;
				} else if (map[i][j] == 'C') {
					dest[index][0] = i;
					dest[index][1] = j;
					index++;
				}
			}
		}
		
		ans = -1;
		bfs();
		System.out.println(ans);
	}
	
	public static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(start[0], start[1], -1, 0));
		for (int i = 0; i < 4; i++) {
			visited[start[0]][start[1]][i][0] = true;
		}
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos cur = q.poll();
				int status = cur.status;
				if (cur.x == dest[0][0] && cur.y == dest[0][1]) {
					if (status != 1) status += 1; 
				} else if (cur.x == dest[1][0] && cur.y == dest[1][1]) {
					if (status != 2) status += 2;
				}
				if (status == 3) {
					ans = time;
					return;
				}
				for (int d = 0; d < 4; d++) {
					if (cur.d == d) continue;
					int nx = cur.x + dir[d][0];
					int ny = cur.y + dir[d][1];
					if (!isRange(nx, ny)) continue;
					if (map[nx][ny] == '#') continue;
					if (visited[nx][ny][d][status]) continue;
					q.offer(new Pos(nx, ny, d, status));
					visited[nx][ny][d][status] = true;
				}
			}
			time++;
		}
	}
	
	private static boolean isRange(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) return true;
		else return false;
	}

	static class Pos {
		int x, y;
		int d;
		int status;
		public Pos(int x, int y, int d, int status) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.status = status;
		}
	}
}
