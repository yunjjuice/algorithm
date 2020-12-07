/*
 * BOJ 16236 아기 상어
 * Gold 4
 * https://www.acmicpc.net/problem/16236
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int sx, sy, size = 2, cnt, dist;
	static List<Fish> fishes = new ArrayList<>();
	static int ans;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		}
		
		// 상어 이동
		boolean flag = true;
		while(flag) {
			bfs(sx, sy);
			if (fishes.size() == 0) break;
			Collections.sort(fishes);
			Fish fish = fishes.get(0);
			sx = fish.x;
			sy = fish.y;
			map[sx][sy] = 0;
			cnt++;
			if (cnt == size) {
				cnt = 0;
				size++;
			}
			ans += fish.dist;
		}
		
		System.out.println(ans);
	}
	
	public static void bfs(int x, int y) {
		visit = new boolean[N][N];
		fishes.clear();
		Queue<Fish> q = new LinkedList<>();
		q.offer(new Fish(x, y, 0));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			int qs = q.size();
			for (int s = 0; s < qs; s++) {
				Fish cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dir[i][0];
					int ny = cur.y + dir[i][1];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if (visit[nx][ny] || map[nx][ny] > size) continue;
					if (0 < map[nx][ny] && map[nx][ny] < size) {
						fishes.add(new Fish(nx, ny, cur.dist+1));
					}
					q.offer(new Fish(nx, ny, cur.dist+1));
					visit[nx][ny] = true;
				}
			}
			if (fishes.size() > 0) break;
		}
	}

	static class Fish implements Comparable<Fish> {
		int x;
		int y;
		int dist;
		public Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Fish o) {
			if (this.dist != o.dist) return this.dist - o.dist;
			else if (this.x != o.x) return this.x - o.x; 
			else return this.y - o.y;
		}
	}
}
