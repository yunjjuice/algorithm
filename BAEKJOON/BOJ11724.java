/*
 * BOJ 11724 연결 요소의 개수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
	static int N, M;
	static boolean[][] map;
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				bfs(i);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	static void bfs(int a) {
		visited[a] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(a);
		while(!q.isEmpty()) {
			int front = q.poll();
			for (int i = 1; i <= N; i++) {
				if(map[front][i] && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
