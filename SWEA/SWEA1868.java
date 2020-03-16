/*
 * SWEA 1868 파핑파핑 지뢰찾기 D4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1868 {
	static int N;
	static char[][] map;
	static int[][] map2;
	static boolean[][] visited;
	static int ans;
	static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			map2 = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			// 입력 확인
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			// 지뢰가 있는 칸을 제외한 다른 모든 칸의 숫자들이 표시되려면 최소 몇 번의 클릭을 해야 하는지
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '*') {
						map2[i][j] = -1;
						continue;
					}
					int cnt = 0;
					for (int k = 0; k < dir.length; k++) {
						int nc = i + dir[k][0];
						int nr = j + dir[k][1];
						if(isRange(nc, nr) && map[nc][nr] == '*')
							cnt++;
					}
					map2[i][j] = cnt;
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map2[i]));
//			}
			
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map2[i][j] == 0 && !visited[i][j]) {
						bfs(i, j);
						ans++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map2[i][j] > 0 && !visited[i][j])
						ans++;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	private static void bfs(int c, int r) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(c);
		q.offer(r);
		visited[c][r] = true;
		while(!q.isEmpty()) {
			int cc = q.poll();
			int cr = q.poll();
			for (int i = 0; i < dir.length; i++) {
				int nc = cc + dir[i][0];
				int nr = cr + dir[i][1];
				if(isRange(nc, nr) && !visited[nc][nr]) {
					if(map2[nc][nr] == 0) {
						q.offer(nc);
						q.offer(nr);
						visited[nc][nr] = true;
					} else if(map2[nc][nr] > 0) {
						visited[nc][nr] = true;
					}
				}
			}
		}
		
	}

	static boolean isRange(int c, int r) {
		if(c >= 0 && c < N && r >= 0 && r < N)
			return true;
		return false;
	}
}
