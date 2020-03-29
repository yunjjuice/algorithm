/*
 * BOJ 1707 이분 그래프
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707 {
	static int V, E, ans;
	static ArrayList<Integer>[] list;
	static int[] group;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < K; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			group = new int[V];
			list = new ArrayList[V];
			
			for (int i = 0; i < V; i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				list[a].add(b);
				list[b].add(a);
			}
			
			for (int i = 0; i < V; i++) {
				if(group[i] == 0) {
					group[i] = 1;
					bfs(i);
				}
			}
			
			ans = 1;
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < list[i].size(); j++) {
					if(group[i] == group[list[i].get(j)])
						ans = -1;
				}
			}
			
			System.out.println(ans == -1 ? "NO" : "YES");
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int g = group[cur];
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(group[next] == 0) {
					if(g == 1) group[next] = 2;
					else if(g == 2) group[next] = 1;
					q.offer(next);
				}
			}
		}
	}
}
