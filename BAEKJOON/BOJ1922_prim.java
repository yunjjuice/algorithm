/*
 * BOJ 1922 네트워크 연결
 * Gold 4
 * https://www.acmicpc.net/problem/1922
 */

import java.io.*;
import java.util.*;

public class BOJ1922_prim {
	static int N, M, cost;
//	static Edge[] graph;
	static int[] parent, costs;
	static int[][] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = cost;
		}
		parent = new int[N];
		costs = new int[N];
		
		int r = 0;
		for (int i = 0; i < graph[r].length; i++) {
			if(graph[r][i] > 0) {
				parent[i] = r;
				costs[i] = graph[r][i];
			} else {
				parent[i] = -1;
				costs[i] = Integer.MAX_VALUE;
			}
		}
		
		parent[r] = r;
		costs[r] = 0;
		boolean[] selected = new boolean[N];
		selected[r] = true;
		
		for (int i = 1; i < N; i++) {
			int minIndex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < costs.length; j++) {
				if(!selected[j] && min > costs[j]) {
					min = costs[j];
					minIndex = j;
				}
			}
			r = minIndex;
			selected[r] = true;
			
			for (int j = 0; j < graph[r].length; j++) {
				if(!selected[j] && graph[r][j] != 0 && costs[j] > graph[r][j]) {
					costs[j] = graph[r][j];
					parent[j] = r;
				}
			}
			
		}
		for (int i = 0; i < costs.length; i++) {
			cost += costs[i];
		}
		
		System.out.println(cost);
	}
}
