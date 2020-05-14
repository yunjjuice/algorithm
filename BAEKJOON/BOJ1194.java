/*
 * BOJ 1194 달이 차오른다, 가자.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1194 {
	static int N, M;
	static char[][] map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Pos minsik;
	static boolean[][][] visited; 
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0')
					minsik = new Pos(i, j, 0);
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		visited = new boolean[N][M][1 << 7]; // key 비트마스크 사용, 최대 6개의 키를 가질 경우 111111
		System.out.println(bfs());
		
		
	}
	
	private static int bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(minsik);
		visited[minsik.x][minsik.y][minsik.key] = true;
		
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int qs = 0; qs < size; qs++) {
				Pos cur = q.poll();
				int x = cur.x;
				int y = cur.y;
//				System.out.println("time : " + time +", cur : "+ cur.toString());
				if(map[x][y] == '1') {
					return time;
				}
				for (int i = 0; i < dir.length; i++) {
					int nx = x + dir[i][0];
					int ny = y + dir[i][1];
					int key = cur.key;
					
//					if(!isIn(nx, ny)) continue;
					if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
					
					if(map[nx][ny] == '#') continue;
					if('a'<= map[nx][ny] && map[nx][ny] <= 'f') { 
						key |= 1 << (map[nx][ny] - 'a' + 1);
					} 
					if('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
						int door = map[nx][ny] - 'A' + 1;
						if((key & (1<<door)) == 0) {  // 키가 없다
							continue;
						}
					}
					
					if(visited[nx][ny][key]) continue;
					
					visited[nx][ny][key] = true;
					q.offer(new Pos(nx, ny, key));
				}
			}
			time++;
		}
		
		return -1;
	}

	static class Pos {
		int x, y, key;

		public Pos(int x, int y, int key) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", key=" + key + "]";
		}	
	}
}
