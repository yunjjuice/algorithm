/*
 * BOJ 2636 치즈
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Pos> list; // 치즈의 테두리를 저장할 배열
	static int cheese;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					cheese++;
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		int time = 0;
		while(true) {
			if(cheese == 0) { // 치즈가 모두 녹았다면
				break;
			}
			time++;
			visited = new boolean[N][M]; // 한 시간마다 달라지므로
			list = new ArrayList<>();
			
//			외부 공기를 맵에서 -1로 바꿔준다
			outside(0, 0);
			
//			테두리를 찾는다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visited[i][j] && isEdge(i, j)) {
						bfs(i, j);
					}
				}
			}
			
//			테두리가 녹는다
			for (int i = 0; i < list.size(); i++) {
				Pos tmp = list.get(i);
				map[tmp.x][tmp.y] = 0;
			}
			cheese -= list.size();
		}
		
		System.out.println(time);
		System.out.println(list.size());
	}
	
	private static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new Pos(x, y));
		list.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i < dir.length; i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
				if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1 && isEdge(nx, ny)) {
					list.add(new Pos(nx, ny));
					visited[nx][ny] = true;
					q.offer(new Pos(nx, ny));
				}
			}
		}
	}

	private static boolean isEdge(int x, int y) {
		for (int i = 0; i < dir.length; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(isRange(nx, ny) && map[nx][ny] == -1) { // 한 부분이라도 외부랑 닿아있으면
				return true;
			}
		}
		return false;
	}

	private static void outside(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		map[x][y] = -1;
		visited[x][y] = true;
		q.offer(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i < dir.length; i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
				if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] <= 0) {
					map[nx][ny] = -1;
					visited[nx][ny] = true;
					q.offer(new Pos(nx, ny));
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}

	static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
