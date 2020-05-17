/*
 * BOJ 2458 키 순서
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2458 {
	static int N, M;
	static boolean[][] map;
	static boolean[] v;
	static int cnt, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = true; // y가 x보다 큼
		}
		
		for (int i = 1; i <= N; i++) {
			v = new boolean[N+1];
			cnt = 0;
			up(i); // 나보다 큰 애들 찾기
			down(i); // 나보다 작은 애들 찾기
			
			if(cnt == N-1)
				ans++;
		}
		
		System.out.println(ans);
	}
	
	private static void down(int idx) {
		v[idx] = true;
		for (int i = 1; i <= N; i++) {
			if(v[i]) continue;
			if(!map[i][idx]) continue;
			cnt++;
			down(i);
		}
	}
	
	private static void up(int idx) {
		v[idx] = true;
		for (int i = 1; i <= N; i++) {
			if(v[i]) continue;
			if(!map[idx][i]) continue; 
			cnt++;
			up(i);
		}
	}
}
