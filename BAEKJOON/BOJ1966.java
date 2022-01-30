/*
 * BOJ 1966 프린터 큐
 * Silver 3
 * https://www.acmicpc.net/problem/1966
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Docu> q = new LinkedList<>(); // 실제 프린터 순서를 나타내는 큐
			PriorityQueue<Docu> pq = new PriorityQueue<>(new Comparator<Docu>() {
				@Override
				public int compare(Docu o1, Docu o2) {
					return o2.weight - o1.weight;
				}
			}); // 우선순위 저장 큐
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int weight = Integer.parseInt(st.nextToken());
				q.offer(new Docu(weight, i));
				pq.offer(new Docu(weight, i));
			}
			int cnt = 1;
			while (!pq.isEmpty()) {
				if (q.peek().weight == pq.peek().weight) {
					if (q.peek().order == M) break;
					else {
						cnt++;
						q.poll();
						pq.poll();
					}
				} else {
					q.offer(q.poll());
				}
			}
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static class Docu {
		int weight;
		int order;
		
		public Docu(int weight, int order) {
			this.weight = weight;
			this.order = order;
		}
	}
}
