/*
 * BOJ 11123 양 한마리... 양 두마리...
 * Silver 1
 * https://www.acmicpc.net/problem/11123
 */

import java.io.*;
import java.util.*;

public class BOJ11123 {
	static int T, H, W, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			visited = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '#' && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (!isRange(nx, ny) || visited[nx][ny] || map[nx][ny] != '#') continue;
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
	
	public static boolean isRange(int x, int y) {
		if (0 <= x && x < H && 0 <= y && y < W) return true;
		else return false;
	}
}
