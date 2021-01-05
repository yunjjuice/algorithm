/*
 * BOJ 1238 파티
 * Gold 3
 * https://www.acmicpc.net/problem/1238
 */

import java.util.*;
import java.io.*;

public class BOJ1238 {
	static int N, M, X;
	static int[] d; // 최소 비용 임시 저장
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		List<Pos>[] list = new ArrayList[N+1];
		List<Pos>[] reverseList = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			reverseList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[x].add(new Pos(y, cost));
			reverseList[y].add(new Pos(x, cost));
		}
		
		int[] dist1 = dijkstra(list);
		int[] dist2 = dijkstra(reverseList);
		
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			ans = Integer.max(ans, dist1[i]+dist2[i]);
		}
		
		System.out.println(ans);
	}
	
	public static int[] dijkstra(List<Pos>[] list) {
		d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(X, 0));
		d[X] = 0;
		while(!pq.isEmpty()) {
			int cur = pq.peek().y;
			int cost = pq.peek().cost;
			pq.poll();
			if (d[cur] < cost) continue;
			for (int i = 0; i < list[cur].size(); i++) {
				// 선택된 노드의 인접 노드
				int next = list[cur].get(i).y;
				// 선택된 노드를 인접 노드를 거쳐서 가는 비용
				int nextCost = cost + list[cur].get(i).cost;
				// 기존의 최소 비용보다 저렴하면 교체한다
				if (nextCost < d[next]) {
					d[next] = nextCost;
					pq.offer(new Pos(next, nextCost));
				}
			}
		}
		
		return d;
	}
	
	static class Pos implements Comparable<Pos> {
		int y; // 도착점
		int cost;
		public Pos(int y, int cost) {
			super();
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Pos o) {
			return this.cost - o.cost;
		}
	}
}
