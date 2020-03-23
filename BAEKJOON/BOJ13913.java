/*
 * BOJ 13913 숨바꼭질 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ13913 {
	static int N, K;
	static int min;
	static int[] path;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		path = new int[100001];
		visited = new boolean[100001];
		Arrays.fill(path, -1);
		
		StringBuilder sb = new StringBuilder();
		sb.append(bfs()).append('\n');

//		System.out.println(Arrays.toString(path));
		int tmp = K;
		Stack<Integer> s = new Stack<Integer>();
		do {
			s.push(tmp);
			tmp = path[tmp];
		} while(tmp != -1);
		
		while(!s.isEmpty()) {
			sb.append(s.pop()).append(' ');
		}
		System.out.println(sb);
	}
	
	static int bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		visited[N] = true;
		q.offer(new Pos(N, 0));
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
//			System.out.println(cur.x + " " + cur.cnt);
			if(cur.x == K) return cur.cnt;
			int[] nx = {cur.x - 1, cur.x + 1, cur.x * 2};
			for (int j = 0; j < 3; j++) {
				if(nx[j] >= 0 && nx[j] <= 100000 && !visited[nx[j]]) {
					visited[nx[j]] = true;
					path[nx[j]] = cur.x;
					if(nx[j] == K) return cur.cnt+1;
					q.offer(new Pos(nx[j], cur.cnt+1));
				}
			}				
		}
		return -1;
	}
	
	static class Pos {
		int x;
		int cnt;
		
		public Pos(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
}
