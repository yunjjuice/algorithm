/*
 * BOJ 1941 소문난 칠공주
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1941 {
	static char[][] map;
	static boolean[] v;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		v = new boolean[25];
		String str = null;
		for (int i = 0; i < 5; i++) {
			str = br.readLine();
			map[i] = str.toCharArray();
		}
		
//		for (int i = 0; i < 5; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		// 25명중에 7명 고르기
		for (int i = 0; i < 25; i++) {
			dfs(i, 1, 0, 0);			
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int idx, int cnt, int sCnt, int yCnt) {
		if(yCnt >= 4) return; // 임도연파가 다수면 종료
		if(map[idx/5][idx%5] == 'S') {
			sCnt++;
		} else if(map[idx/5][idx%5] == 'Y') {
			yCnt++;
		}
		
		if(cnt == 7) {
			if(sCnt >= 4) { // 이다솜파가 다수인지
				if(bfs(idx)) { // 연결되어 있는지
					ans++;
				}
			}
			return;
		}
		
		v[idx] = true;
		for (int i = idx+1; i < 25; i++) { 
			if(v[i]) continue; 
			dfs(i, cnt+1, sCnt, yCnt);
			
		}
		v[idx] = false;
	}
	
	private static boolean bfs(int idx) {
		boolean[][] vi = new boolean[5][5];
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(idx/5, idx%5));
		vi[idx/5][idx%5] = true;
		int cnt = 1; // 연결된 정점들의 개수
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
				if(!isRange(nx, ny)) continue;
				if(!v[nx*5+ny]) continue; // 선택된 적 없다면 
				if(vi[nx][ny]) continue; // 이미 방문했다면
				vi[nx][ny] = true;
				q.offer(new Pos(nx, ny));
				cnt++;
			}
		}
		
		if(cnt == 7)
			return true;
		
		return false;
	}

	static boolean isRange(int x, int y) {
		return 0 <= x && x < 5 && 0 <= y && y < 5;
	}
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
