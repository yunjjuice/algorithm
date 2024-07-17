/*
 * BOJ 1051 숫자 정사각형
 * Silver 3
 * https://www.acmicpc.net/problem/1051
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1051 {
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j) + "");
			}
		}
		
		int res = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				int len = 0;
				while (n+len < N && m+len < M) {			
					if (map[n][m+len] == map[n][m] && map[n+len][m] == map[n][m] && map[n+len][m+len] == map[n][m]) {
						res = Integer.max(res, ((len+1) * (len+1)));
					}
					len++;
				}
			}
		}
		
		System.out.println(res);
	}
}
