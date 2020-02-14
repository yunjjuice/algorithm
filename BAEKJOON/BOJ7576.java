/*
 * BOJ 7576 토마토
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		int[][] map = new int[M][N];
		int[][] day = new int[M][N];
		Queue<Tomato> que = new LinkedList<Tomato>();
		for (int i = 0; i < day.length; i++) {
			Arrays.fill(day[i], -1);
		}
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					que.add(new Tomato(i, j));
					day[i][j] = 0;
				}
			}
		}
		
		while(!que.isEmpty()) {
			int y = que.peek().y;
			int x = que.peek().x;
			que.poll();
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny<0 || ny>=map.length || nx<0 || nx>=map[0].length || map[ny][nx]==-1) // 범위 벗어나면 끝
					continue;
				if(map[ny][nx] == 0 && day[ny][nx]==-1) { // 아직 안 익었으면
					day[ny][nx] = day[y][x]+1;
					que.add(new Tomato(ny, nx));
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < day.length; i++) {
			for (int j = 0; j < day[i].length; j++) {
				if(ans < day[i][j])
					ans = day[i][j];
			}
		}
		for (int i = 0; i < day.length; i++) {
			for (int j = 0; j < day[i].length; j++) {
				if(map[i][j]==0 && day[i][j]==-1)
					ans = -1;
			}
		}
		
		System.out.println(ans);
	}
}

class Tomato {
	int x;
	int y;
	public Tomato(int y, int x) {
		this.y = y;
		this.x = x;
	}
}