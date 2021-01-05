/*
 * BOJ 1916 최소비용 구하기
 * Gold 5
 * https://www.acmicpc.net/problem/1916
 */

import java.util.*;
import java.io.*;

public class BOJ1916 {
	static int N, M;
	static List<Pos>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] d = dijkstra(start);
		System.out.println(d[end]);
	}
	
	public static int[] dijkstra(int start) {
		int[] d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(start, 0));
		while(!pq.isEmpty()) {
			int cur = pq.peek().v;
			int cost = pq.peek().cost;
			pq.poll();
			if (d[cur] < cost) continue;
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i).v;
				int nextCost = cost + list[cur].get(i).cost;
				if (nextCost < d[next]) {
					d[next] = nextCost;
					pq.offer(new Pos(next, nextCost));
				}
			}
		}
		
		return d;
	}
	
	static class Pos implements Comparable<Pos> {
		int v;
		int cost;
		public Pos(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}
		@Override
		public int compareTo(Pos o) {
			return this.cost - o.cost;
		}
	}
}
