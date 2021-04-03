/*
 * BOJ 2146 다리 만들기
 * Gold 3
 * https://www.acmicpc.net/problem/2146
 */

import java.io.*;
import java.util.*;

public class BOJ2146 {
	static int N, min;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) map[i][j] = -1;
			}
		}
		
		// 각 섬을 구분해준다
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1 && !visited[i][j]) {
					numbering(i, j, num);
					num++;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		// 숫자를 가진 섬에서 가장자리인 부분에서 다리만들기를 시작한다
		// 다른 숫자를 가진 섬을 발견하면 길이를 확인한다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0 && isEdge(i, j)) {
					makeBridge(i, j, map[i][j]);
				}
			}
		}
		
		System.out.println(min);
	}
	
	public static void makeBridge(int x, int y, int num) {
		visited = new boolean[N][N];
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		visited[x][y] = true;
		int length = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos cur = q.poll();
				if (map[cur.x][cur.y] > 0 && map[cur.x][cur.y] != num) {
					min = Math.min(min, length);
					return;
				}
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dir[d][0];
					int ny = cur.y + dir[d][1];
					if (!isRange(nx, ny) || visited[nx][ny]) continue;
					q.offer(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
			length++;
		}
	}

	public static boolean isEdge(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (!isRange(nx, ny)) continue;
			if (map[nx][ny] == 0) return true;
		}
		return false;
	}
	
	public static void numbering(int x, int y, int num) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		visited[x][y] = true;
		map[x][y] = num;
		
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dir[d][0];
				int ny = cur.y + dir[d][1];
				if (!isRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;
				q.offer(new Pos(nx, ny));
				visited[nx][ny] = true;
				map[nx][ny] = num;
			}
		}
	}
	
	public static boolean isRange(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) return true;
		else return false;
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
