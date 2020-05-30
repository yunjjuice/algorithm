/*
 * BOJ 17141 연구소 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17141 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Virus> virus;
	static int[] select; // 조합을 위한 배열
	static boolean[] used;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int emptyCnt, virusCnt, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		virus = new ArrayList<>();
		virusCnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					emptyCnt++;
				if(map[i][j] == 2) {
					virus.add(new Virus(i, j));
				}
			}
		}
		
		select = new int[M];
		used = new boolean[virus.size()];
		ans = Integer.MAX_VALUE;
		// 전체 바이러스 개수 중 M개를 선택한다
		comb(0, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	static void comb(int idx, int cnt) {
		if(cnt == M) {
//			System.out.println(Arrays.toString(select));
			bfs();
			return;
		}
		
		for (int i = idx; i < virus.size(); i++) {
			if(used[i]) continue;
			select[cnt] = i;
			used[i] = true;
			comb(idx+1, cnt+1);
			used[i] = false;
		}
	}
	
	static void bfs() {
		int tmpEmpty = emptyCnt + (virus.size()-M);
		
		
		visited = new boolean[N][N];
		Queue<Virus> q = new LinkedList<>();
		for (int i = 0; i < select.length; i++) {
			Virus v = virus.get(select[i]);
			q.offer(v);
			visited[v.x][v.y] = true;
		}
		
		int time = -1;
		while(!q.isEmpty()) {
			int size = q.size();
			time++;
			if(time > ans) return;
			for (int qs = 0; qs < size; qs++) {
				Virus cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dir[i][0];
					int ny = cur.y + dir[i][1];
					if(!isLen(nx, ny) || visited[nx][ny] || map[nx][ny] == 1)
						continue;
					visited[nx][ny] = true;
					q.add(new Virus(nx, ny));
					tmpEmpty--;
				}
			}
		}

//		System.out.println("tmpEmpty : " + tmpEmpty);
//		System.out.println("time : "+time);
		
		if(tmpEmpty == 0) {
			ans = Math.min(ans, time);
		}
	}
	
	static boolean isLen(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}

	static class Virus {
		int x, y;

		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
