/*
 * BOJ 3184 양
 * Silver 2
 * https://www.acmicpc.net/problem/3184
 */

import java.util.*;
import java.io.*;

public class BOJ3184 {
	static int R, C, oCnt, vCnt, oTmpCnt, vTmpCnt;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		oCnt = 0; 
		vCnt = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'v') vCnt++;
				else if (map[i][j] == 'o') oCnt++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '#' && !visited[i][j]) {
					oTmpCnt = 0;
					vTmpCnt = 0;
					dfs(i, j);
					if (oTmpCnt > vTmpCnt) vCnt -= vTmpCnt;
					else oCnt -= oTmpCnt;
				}
			}
		}
		
		System.out.println(oCnt + " " + vCnt);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		if (map[x][y] == 'v') vTmpCnt++;
		else if (map[x][y] == 'o') oTmpCnt++;
		for (int d = 0; d < dir.length; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			if (visited[nx][ny] || map[nx][ny] == '#') continue;
			dfs(nx, ny);
		}
	}
}
