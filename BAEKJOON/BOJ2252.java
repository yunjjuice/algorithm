/*
 * BOJ 2252 줄 세우기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252 {
	static int N, M;
	static List<Integer>[] list;
	static int[] inDegree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		inDegree = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			inDegree[y]++; // 진입차수 증가
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			int cur = q.poll();
			result.add(cur);
			for (int i = 0; i < list[cur].size(); i++) {
				int tmp = list[cur].get(i);
				
				inDegree[tmp]--;
				
				if(inDegree[tmp] == 0) {
					q.offer(tmp);
				}
			}
		}
		
//		System.out.println(result.toString());
		
		for (Integer i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
