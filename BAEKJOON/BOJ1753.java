/*
 * BOJ 1753 최단경로
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
	static int V, E, K;
	static List<Edge>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		K = Integer.parseInt(br.readLine()) - 1; // 시작 정점
		
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			adj[Integer.parseInt(st.nextToken())-1].add(new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		Edge[] dist = new Edge[V];
		boolean[] check = new boolean[V];
		// 출발지 지정 
		dist[K] = new Edge(K, 0);
		pq.offer(dist[K]);
		
		for (int i = 0; i < V; i++) {
			if(i == K) continue;
			dist[i] = new Edge(i, Integer.MAX_VALUE);
			pq.offer(dist[i]);
		}
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			// 연결되지 않는 노드들 처리
			if(e.weight == Integer.MAX_VALUE)
				break;
			
			for (Edge next : adj[e.v]) {
				if(!check[next.v] && dist[next.v].weight > dist[e.v].weight + next.weight) {
					dist[next.v].weight = dist[e.v].weight + next.weight;
					
					pq.remove(dist[next.v]);
					pq.offer(dist[next.v]);
				}
			}
			check[e.v] = true;
		}
		for (Edge e : dist) {
			System.out.println(e.weight == Integer.MAX_VALUE ? "INF" : e.weight);
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int v;
		int weight;
		Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
