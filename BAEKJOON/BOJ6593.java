/*
 * BOJ 6593 상범빌딩
 * Gold 5
 * https://www.acmicpc.net/problem/6593
 */

import java.util.*;
import java.io.*;

public class BOJ6593 {
	static int L, R, C;
	static char[][][] map;
	static boolean[][][] visit;
	static int[][] dir = {{0,1,0}, {0,-1,0}, {1,0,0}, {-1,0,0}, {0,0,1}, {0,0,-1}}; // 동서남북상하
	static int sx, sy, sz, ex, ey, ez;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			
			map = new char[L][R][C];
			visit = new boolean[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = str.charAt(k);
						if (map[i][j][k] == 'S') {
							sx = j; sy = k; sz = i;
						} else if (map[i][j][k] == 'E') {
							ex = j; ey = k; ez = i;
						}
					}
				}
				br.readLine();
			}
			
			int sec = bfs(sx, sy, sz);
			if (sec == -1) {
				sb.append("Trapped!").append('\n');
			} else {
				sb.append("Escaped in ").append(sec).append(" minute(s).").append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static int bfs(int x, int y, int z) {
		Queue<Pos> q = new LinkedList<>();
		visit[z][x][y] = true;
		q.offer(new Pos(x, y, z));
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos cur = q.poll();
				for (int i = 0; i < 6; i++) {
					int nx = cur.x + dir[i][0];
					int ny = cur.y + dir[i][1];
					int nz = cur.z + dir[i][2];
					if (!isLen(nx, ny, nz) || map[nz][nx][ny] == '#' || visit[nz][nx][ny]) continue;
					if (nx == ex && ny == ey && nz == ez) return cnt+1;
					visit[nz][nx][ny] = true;
					q.offer(new Pos(nx, ny, nz));
				}
			}
			cnt++;
		}
		
		return -1;
	}

	public static boolean isLen(int x, int y, int z) {
		if (0 <= x && x < R && 0 <= y && y < C && 0 <= z && z < L) 
			return true;
		return false;
	}
	
	static class Pos {
		int x, y, z;

		public Pos(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
