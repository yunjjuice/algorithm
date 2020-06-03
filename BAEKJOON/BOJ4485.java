/*
 * BOJ 4485 녹색 옷 입은 애가 젤다지?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485 {
	static int N;
	static int[][] map, dist;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		while(true) {
			tc++;
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
//			입력 확인
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			sb.append("Problem ").append(tc).append(": ").append(dijkstra()).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static int dijkstra() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		dist[0][0] = map[0][0];
		pq.offer(new Pos(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Pos cur = pq.poll();
			for (int i = 0; i < dir.length; i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
				if(isLen(nx, ny)) {
					if(dist[nx][ny] > dist[cur.x][cur.y] + map[nx][ny]) {
						dist[nx][ny] = dist[cur.x][cur.y] + map[nx][ny];
						pq.offer(new Pos(nx, ny, dist[nx][ny]));
					}
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		return dist[N-1][N-1];
	}
	
	public static boolean isLen(int x, int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
	
	static class Pos implements Comparable<Pos>{
		int x, y, cost;

		public Pos(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return this.cost - o.cost;
		}
	}
}
