/*
 * BOJ 16926 배열 돌리기 1
 * Silver 2
 * https://www.acmicpc.net/problem/16926
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] used;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < R; r++) {
			used = new boolean[N][M];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (!used[i][j]) {
						rotate(i, j);
					}					
				}
			}			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb.toString());
	}
	
	public static void rotate(int i, int j) {
		used[i][j] = true;
		
		// <-
		int tmp = map[i][j];
		for (int m = j; m < M-1-j; m++) {
			map[i][m] = map[i][m+1];
			used[i][m] = true;
		}
		
		// ^
		for (int n = i; n < N-1-i; n++) {
			map[n][M-1-j] = map[n+1][M-1-j];
			used[n][M-1-j] = true;
		}
		
		// ->
		for (int m = M-1-j; m > j; m--) {
			map[N-1-i][m] = map[N-1-i][m-1];
			used[N-1-i][m] = true;
		}
		
		for (int n = N-1-i; n > i; n--) {
			map[n][j] = map[n-1][j];
			used[n][j] = true;
		}
		
		map[i+1][j] = tmp;
	}
}