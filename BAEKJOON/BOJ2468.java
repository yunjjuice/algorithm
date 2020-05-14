/*
 * BOJ 2468 안전 영역
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int[][] map;
	static boolean[][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		check = new boolean[n][n];
		int maxLen = 0;
		int minLen = Integer.MAX_VALUE;
		StringTokenizer st;
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > maxLen)
					maxLen = map[i][j];
				if (map[i][j] < minLen)
					minLen = map[i][j];
			}
		}

		int ans = 1;
		for (int rain = minLen; rain < maxLen; rain++) {
			for (int i = 0; i < check.length; i++) {
				Arrays.fill(check[i], false);
			}
			Queue<Pos> q = new LinkedList<>();
			int count = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] > rain && !check[i][j]) { // 비에 잠기지 않는 지역
						check[i][j] = true;
						q.offer(new Pos(i, j));
						count++;
						while (!q.isEmpty()) {
							Pos tmp = q.poll();
							for (int k = 0; k < 4; k++) {
								int nx = tmp.x + dx[k];
								int ny = tmp.y + dy[k];
								if (nx >= 0 && nx < n && ny >= 0 && ny < n && !check[nx][ny] && map[nx][ny] > rain) {
									check[nx][ny] = true;
									q.offer(new Pos(nx, ny));
								}
							}
						}
					}
				}
			}
			if (count > ans)
				ans = count;
		}
		System.out.println(ans);

	}

	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}