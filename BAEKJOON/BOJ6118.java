/*
 * BOJ 6118 숨바꼭질
 * Silver 1
 * https://www.acmicpc.net/problem/6118
 */

import java.util.*;
import java.io.*;

public class BOJ6118 {
	static int N, M, ans, dist, cnt;
	static List<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dist = -1;
		bfs();
		
		System.out.println(ans + " " + dist + " " + cnt);
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		visited[1] = true;
		q.offer(1);
		int tmp = Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			dist++;
			ans = tmp;
			tmp = Integer.MAX_VALUE;
			cnt = q.size();
			for (int s = 0; s < cnt; s++) {
				int cur = q.poll();
				for (int i = 0; i < list[cur].size(); i++) {
					int next = list[cur].get(i);
					if (visited[next]) continue;
					visited[next] = true;
					q.offer(next);
					tmp = Math.min(tmp, next);
				}
			}
		}
	}
}
