/*
 * BOJ 1726 로봇
 * https://www.acmicpc.net/problem/1726
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1726 {
	static int M, N;
	static int[][] map;
	static int[] robot;
	static int[] dest;
	static boolean[][][] visited;
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // 동 서 남 북
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		robot = new int[3];
		dest = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			robot[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			dest[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		// end input		
		
		visited = new boolean[M][N][4];
		ans = Integer.MAX_VALUE;
		
		Queue<Pos> q = new LinkedList<>();
		visited[robot[0]][robot[1]][robot[2]] = true;
		q.offer(new Pos(robot[0], robot[1], robot[2], 0));
		
		while (!q.isEmpty()) {
			int cx = q.peek().x;
			int cy = q.peek().y;
			int cd = q.peek().d;
			int cc = q.peek().cnt;
			q.poll();
			
			if (cc >= ans) continue;
			if (cx == dest[0] && cy == dest[1] && cd == dest[2]) {
				if (cc < ans) {
					ans = cc;
					continue;
				}
			}
			
			// 이동
			for (int i = 1; i <= 3; i++) {
				int nx = cx + i * dir[cd][0];
				int ny = cy + i * dir[cd][1];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N) break;
				if (map[nx][ny] == 1) break;
				if (!visited[nx][ny][cd]) {
					visited[nx][ny][cd] = true;
					q.offer(new Pos(nx, ny, cd, cc+1));
				}
			}
			
			// 방향 전환
			for (int i = 1; i <= 2; i++) {
				int nd = changeDir(i, cd);
				
				if (!visited[cx][cy][nd]) {
					visited[cx][cy][nd] = true;
					q.offer(new Pos(cx, cy, nd, cc+1));
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static int changeDir(int i, int dir) {
		int res = -1;
		switch (dir) {
		case 0: // 동
			if (i == 1) res = 2;
			else if (i == 2) res = 3;
			break;
		case 1: // 서
			if (i == 1) res = 3;
			else if (i == 2) res = 2;			
			break;
		case 2: // 남
			if (i == 1) res = 1;
			else if (i == 2) res = 0;			
			break;
		case 3: // 북
			if (i == 1) res = 0;
			else if (i == 2) res = 1;						
			break;
		}
		
		return res;
	}
	
	static class Pos {
		int x;
		int y;
		int d;
		int cnt;
		public Pos(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}
}
