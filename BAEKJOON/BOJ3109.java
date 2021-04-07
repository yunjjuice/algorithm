/*
 * BOJ 3109 빵집
 * Gold 2
 * https://www.acmicpc.net/problem/3109
 */

import java.io.*;
import java.util.*;

public class BOJ3109 {
	static int R, C, cnt;
	static char[][] map;
	static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			dfs(i, 0);
		}
		
		System.out.println(cnt);
	}
	
	public static boolean dfs(int x, int y) {
		if (y == C-1) {
			cnt++;
			return true;
		}
		
		for (int i = 0; i < dir.length; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (!isRange(nx, ny) || map[nx][ny] == 'x') continue;
			map[nx][ny] = 'x';
			if (dfs(nx, ny)) return true;
		}
		
		return false;
	}
	
	public static boolean isRange(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) return true;
		else return false;
	}
}
