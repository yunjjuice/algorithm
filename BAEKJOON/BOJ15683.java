/*
 * BOJ 15683 감시
 * Gold 5
 * https://www.acmicpc.net/problem/15683
 */

import java.io.*;
import java.util.*;

public class BOJ15683 {
	static int N, M, ans;
	static int[][] map;
	static List<CCTV> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= map[i][j] && map[i][j] <= 5) {
					list.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		dfs(0, map);
		
		System.out.println(ans);
	}
	
	public static void dfs(int idx, int[][] nMap) {
		if (idx == list.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (nMap[i][j] == 0) cnt++;
				}
			}
			
			ans = Math.min(ans, cnt);
			return;
		}
		
		CCTV cctv = list.get(idx);
		int x = cctv.x;
		int y = cctv.y;
		int[][] vMap = new int[N][M];
		
		switch(cctv.type) {
		case 1:
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nMap[i], M);
				}
				detect(x, y, vMap, d);
				dfs(idx+1, vMap);
			}
			break;
		case 2:
			for (int d = 0; d < 2; d++) {
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nMap[i], M);
				}
				detect(x, y, vMap, d);
				detect(x, y, vMap, d+2);
				dfs(idx+1, vMap);
			}
			break;
		case 3:
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nMap[i], M);
				}
				detect(x, y, vMap, d);
				detect(x, y, vMap, (d+1) % 4);
				dfs(idx+1, vMap);
			}
			break;
		case 4:
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nMap[i], M);
				}
				detect(x, y, vMap, d);
				detect(x, y, vMap, (d+1) % 4);
				detect(x, y, vMap, (d+2) % 4);
				dfs(idx+1, vMap);
			}
			break;
		case 5:
			for (int i = 0; i < N; i++) {
				vMap[i] = Arrays.copyOf(nMap[i], M);
			}
			detect(x, y, vMap, 0);
			detect(x, y, vMap, 1);
			detect(x, y, vMap, 2);
			detect(x, y, vMap, 3);
			dfs(idx+1, vMap);
			break;
		}
	}
	
	public static void detect(int x, int y, int[][] vMap, int d) {
		switch(d) {
		case 0: // 상
			while (x >= 0) {
				if (vMap[x][y] == 6) break;
				vMap[x--][y] = 9;
			}
			break;
		case 1: // 우
			while (y < M) {
				if (vMap[x][y] == 6) break;
				vMap[x][y++] = 9;
			}
			break;
		case 2: // 하
			while (x < N) {
				if (vMap[x][y] == 6) break;
				vMap[x++][y] = 9;
			}
			break;
		case 3: // 좌
			while (y >= 0) {
				if (vMap[x][y] == 6) break;
				vMap[x][y--] = 9;
			}
			break;
		}
	}

	static class CCTV {
		int x, y;
		int type;
		public CCTV(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
}
