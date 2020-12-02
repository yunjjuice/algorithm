/*
 * BOJ 17144 미세먼지 안녕!
 * Gold 5
 * https://www.acmicpc.net/problem/17144
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17144 {
	static int R, C, T;
	static int[][] map;
	static Queue<Pos> q;
	static int[][] airCleaner;
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		q = new LinkedList<>();
		airCleaner = new int[2][2];
		int airIndex = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					q.offer(new Pos(i, j));
				} else if (map[i][j] == -1) {
					airCleaner[airIndex][0] = i;
					airCleaner[airIndex][1] = j;
					airIndex++;
				}
			}
		}
		
		for (int t = 0; t < T; t++) {
			// 1. 미세먼지 확산
			spread();
			// 2. 공기청정기 작동
			airClean();
		}
		
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] <= 0) continue;
				ans += map[i][j];
			}
		}
		
		System.out.println(ans);
	}

	public static void spread() {
		int size = q.size();
		int[][] copy = new int[R][C];
		copy[airCleaner[0][0]][airCleaner[0][1]] = -1;
		copy[airCleaner[1][0]][airCleaner[1][1]] = -1;
		while(!q.isEmpty()) {
			int cnt = 0; // 확산된 구역 개수
			Pos cur = q.poll();
			int mise = map[cur.x][cur.y];
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if (map[nx][ny] == -1) continue;
				cnt++;
				copy[nx][ny] += (mise / 5);
			}
			copy[cur.x][cur.y] += mise - ((mise / 5) * cnt);
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}
	
	public static void airClean() {
		// 공기 청정기 위쪽
		int x = airCleaner[0][0];
		int y = airCleaner[0][1];
		for (int i = x-1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		for (int i = 0; i < C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		for (int i = 0; i < x; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for (int i = C-1; i > 1 ; i--) {
			map[x][i] = map[x][i-1];
		}
		map[x][1] = 0;
		
		// 공기 청정기 아래쪽
		x = airCleaner[1][0];
		y = airCleaner[1][1];
		for (int i = x+1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for (int i = 0; i < C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		for (int i = R-1; i > x ; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for (int i = C-1; i > y ; i--) {
			map[x][i] = map[x][i-1];
		}
		map[x][1] = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) q.offer(new Pos(i, j));
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
