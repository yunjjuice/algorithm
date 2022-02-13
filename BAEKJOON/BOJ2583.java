/*
 * BOJ 2583 영역 구하기
 * Silver 1
 * https://www.acmicpc.net/problem/2583
 */

import java.util.*;
import java.io.*;

public class BOJ2583 {
	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			makeRect(lx, ly, rx, ry);
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] != 1) {
					list.add(bfs(i, j));
				}
			}
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append('\n');
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(' ');
		}

		System.out.println(sb);
	}

	public static void makeRect(int lx, int ly, int rx, int ry) {
		for (int i = ly; i < ry; i++) {
			for (int j = lx; j < rx; j++) {
				map[i][j] = 1;
			}
		}
	}
	
	public static int bfs(int x, int y) {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new int[]{x, y, cnt++});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dir[i][0];
				int ny = cur[1] + dir[i][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] != 0) continue;
				visited[nx][ny] = true;
				q.offer(new int[]{nx, ny, cnt++});
			}
		}

		return cnt;
	}
}
