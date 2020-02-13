/*
 * SWEA 1861 정사각형 방 D4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1861 {
	static int[] dy = {-1, 1, 0, 0}; // 상하좌우
	static int[] dx = {0, 0, -1, 1};
	static int[][] map;
	static int ans;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] countMap = new int[n][n];
			
			ans = Integer.MAX_VALUE; // 어떤 수가 적혀있는지
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					count = 1;
					dfs(i, j);
					if(max < count) {
						max = count;
						ans = map[i][j]; // 새로운 값 저장
					} else if(max == count) {
						ans = Math.min(ans, map[i][j]);
					}
				}
			}
			System.out.println("#" + testCase + " " + ans + " " + max);
		}
	}
	
	public static void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny<0 || ny>=map.length || nx<0 || nx>=map.length)
				continue;
			if((map[y][x]+1) == map[ny][nx]) {
				count++;
				dfs(ny, nx);
			}
		}
	}
}
