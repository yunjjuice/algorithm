/*
 * BOJ 1987 알파벳
 * Gold 4
 * https://www.acmicpc.net/problem/1987
 */

import java.util.*;
import java.io.*;

public class BOJ1987 {
	static int R, C, ans;
	static char[][] map;
	static boolean[] alpha = new boolean[26];
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ans = -1;
		
		alpha[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y, int cnt) {
		if (ans == 26) return;
		ans = Math.max(ans, cnt);
				
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (!isLen(nx, ny) || alpha[map[nx][ny] - 'A']) continue;
			alpha[map[nx][ny] - 'A'] = true;
			dfs(nx, ny, cnt+1);
			alpha[map[nx][ny] - 'A'] = false;
		}
	}
	
	public static boolean isLen(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) return true;
		return false;
	}
}
