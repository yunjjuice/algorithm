/*
 * BOJ 12851 숨바꼭질 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {
	static int N, K;
	static boolean[] visited;
	static int time, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치
		visited = new boolean[100001];
		
		time = Integer.MAX_VALUE;
		bfs();
		
		System.out.println(time);
		System.out.println(cnt);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		visited[N] = true;
		q.offer(new int[] {N, 0}); // 위치와 시간
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[1] > time) // 최소시간보다 큰 시간이면 필요없음
				continue;
			if(cur[0] == K) { // 목표에 도착했다면
				if(time > cur[1]) { // 최소시간 갱신
					time = cur[1];
					cnt = 1;
				} else if(time == cur[1]) { // 최소시간이 같다면 방법의 개수 증가
					cnt++;
				}
			}
			
			visited[cur[0]] = true;
			
			int[] next = {cur[0]-1, cur[0]+1, cur[0]*2};
			
			for (int i = 0; i < next.length; i++) {
				if(isLen(next[i]) && !visited[next[i]])
					q.offer(new int[] {next[i], cur[1]+1});
			}
		}
	}
	
	public static boolean isLen(int x) {
		return x>=0 && x<=100000;
	}
}
