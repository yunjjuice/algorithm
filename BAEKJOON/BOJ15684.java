/*
 * BOJ 15684 사다리 조작
 * Gold 5
 * https://www.acmicpc.net/problem/15684
 */

import java.util.*;
import java.io.*;

public class BOJ15684 {
	static int N, M, H;
	static int[][] map;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H+2][N*2+2]; // +2로 한 이유 : 선 추가할 때 범위체크 귀찮아서..
		for (int i = 1; i <= H; i++) {
			for (int j = 2; j < N*2+1; j+=2) {
				map[i][j] = 1;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b*2+1] = 1;
		}
		
		if (H > 3 && isOddNum()) {
			System.out.println(-1);
			return;
		}
		
		for (int i = 0; i <= 3; i++) {
			max = i;
			makeLadder(1, 0);
		}
		
		System.out.println(-1);
	}
	
	public static boolean isOddNum() {
		int odd = 0;
		for (int j = 3; j <= N*2; j+=2) {
			int num = 0;
			for (int i = 1; i <= H; i++) {
				if (map[i][j] == 1) num++;
			}
			if (num % 2 == 1) odd++;
		}
		return odd > 3;
	}

	public static void makeLadder(int y, int cnt) {
		if (cnt == max) {
			if (check()) {
				System.out.println(cnt);
				System.exit(0);
			}
			return;
		}
		
		for (int i = y; i <= H; i++) {
			for (int j = 3; j <= N*2; j+=2) {
				if (isPossible(i, j)) {
					map[i][j] = 1;
					makeLadder(i, cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static boolean isPossible(int x, int y) {
		if (map[x][y] == 0 && map[x][y-2] == 0 && map[x][y+2] == 0)
			return true;		
		return false;
	}
	
	public static boolean check() {
		int x = 1, y = 2;
		for (int n = 2; n <= N*2; n+=2) {
			x = 1;
			y = n;
			boolean[][] visited = new boolean[H+1][N*2+1];
			visited[x][y] = true;
			while(true) {
				if (map[x][y-1] == 1 && !visited[x][y-1]) {
					y -= 1;
				} else if (map[x][y+1] == 1 && !visited[x][y+1]) {
					y += 1;
				} else if (map[x+1][y] == 1 && !visited[x+1][y]) {
					x += 1;
				} else {
					break;
				}
				visited[x][y] = true;
			}
			if (y != n) return false;
		}
		
		return true;
	}
}
