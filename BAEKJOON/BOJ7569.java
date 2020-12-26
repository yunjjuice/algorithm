/*
 * BOJ 7569 토마토
 * Silver 1
 * https://www.acmicpc.net/problem/7569
 */

import java.util.*;
import java.io.*;

public class BOJ7569 {
	static int N, M, H;
	static int[][][] map;
	static int[][] dir = {{-1,0,0}, {1,0,0}, {0,-1,0}, {0,1,0}, {0,0,1}, {0,0,-1}}; // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 
	static Queue<Pos> q = new LinkedList<>();
	static int ans = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						q.offer(new Pos(i, j, k));
					}
				}
			}
		}
		
		bfs();
		check();
		
		System.out.println(ans);
	}
	
	public static void check() {
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][k] == 0) {
						ans = -1;
						return;
					}
				}
			}
		}
	}

	public static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos cur = q.poll();
				for (int i = 0; i < dir.length; i++) {
					int nx = cur.x + dir[i][0];
					int ny = cur.y + dir[i][1];
					int nz = cur.z + dir[i][2];
					if (!isRange(nx, ny, nz) || map[nx][ny][nz] != 0 ) continue;
					map[nx][ny][nz] = 1;
					q.offer(new Pos(nx, ny, nz));
				}
			}
			ans++;
		}
	}
	
	public static boolean isRange(int x, int y, int z) {
		if (0 <= x && x < N && 0 <= y && y < M && 0 <= z && z < H)
			return true;
		return false;
	}
	
	static class Pos {
		int x;
		int y;
		int z;
		public Pos(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
