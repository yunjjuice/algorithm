/**
 * BOJ 16234 인구 이동
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
	static int N, L, R, ans;
	static int[][] map;
	static boolean[][] visited;
	static List<Pos> list;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		
		ans = -1; // 처음 들어가자마자 일단 ++ 해주므로 -1부터 시작한다
		
		boolean flag = true;
		while(flag) { // 맵 전체를 훑으면 인구이동 횟수 +1
			visited = new boolean[N][N];
			ans++;
			flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j]) continue;
					Queue<Pos> q = new LinkedList<Pos>(); 
					list = new ArrayList<Pos>(); // 인구이동하는 나라의 좌표
					list.add(new Pos(i, j));
					int total = map[i][j];
					
					// 인구 이동이 필요한 곳을 탐색한다
					visited[i][j] = true;
					q.add(new Pos(i, j));
					while(!q.isEmpty()) {
						Pos now = q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = now.x + dir[k][0];
							int ny = now.y + dir[k][1];
							if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
							int dif = Math.abs(map[now.x][now.y] - map[nx][ny]);
							if(L <= dif && dif <= R) {
								flag = true;
								q.add(new Pos(nx, ny));
								list.add(new Pos(nx, ny));
								total += map[nx][ny];
								visited[nx][ny] = true;
							}
						}
					}
					
					// 인구 이동을 한다
					int update = total/list.size();
					for (Pos pos : list) {
						map[pos.x][pos.y] = update;
					}
				}
			} 
		}
		
		System.out.println(ans);
	} // end of main
	
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
