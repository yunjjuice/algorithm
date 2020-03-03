/*
 * SWEA 7699 수지의 수지 맞는 여행
 * 방문 처리를 2차원 배열, 1차원 배열, 비트마스크로 이용해보았다
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SWEA7699_Lec {
	static int result;
	static int R, C; // 행, 열
//	static char[][] map;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 
	static int[] dy = {-1, 1, 0, 0};
//	static int[][] v; // true, flase
//	static int[] v; // 0 방문 안함, 1 방문
	static int v;
//	static Set<Character> set = new HashSet(); 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			result = 0; // 최대값, 최소값
//			set.clear();
			// 입력
			R = sc.nextInt();
			C = sc.nextInt();
//			map = new char[R][C];
			map = new int[R][C];
//			v = new int[R][C]; // 0 초기화, 1 방문안함,
//			v = new int[26];
			v = 0;
			for (int i = 0; i < R; i++) {
				String s = sc.next();
				for (int j = 0; j < C; j++) {
//					map[i][j] = s.charAt(j);
					map[i][j] = s.charAt(j) - 'A';
				}
			}
			// 처리
			dfs(1-1, 1-1, 1);
			
			// 출력
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	static void dfs(int x, int y, int cnt) {
		// 종료
		result = Math.max(result, cnt);
		if(cnt == 26) {
			return;
		}
		// 실행 & 재귀호출
		// 2차원 배열
//		v[y][x] = 1;
//		set.add(map[y][x]);
		// 2차원 배열
//		v[map[y][x]] = 1;
		// 비트마스크
		v |= 1 << map[y][x];
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			// 범위 체크
			if(nx < 0 || nx >= C || ny < 0 || ny >= R) 
				continue;
			// 방문체크
			// 2차원
//			if(v[ny][nx] == 1)
//				continue;
			// 1차원
//			if(v[map[ny][nx]] == 1)
//				continue;
			// 비트마스크
			if((v & 1 << map[ny][nx]) != 0)
				continue;
			// 알파벳 중복 체크
//			if(set.contains(map[ny][nx]))
//				continue;
			// 재귀호출
			dfs(nx, ny, cnt+1);
			// 원상복귀
			// 2차원
//			v[ny][nx] = 0;
//			set.remove(map[ny][nx]);
			// 1차원
//			v[map[ny][nx]] = 0;
			// 비트마스크
			v &= ~(1 << map[ny][nx]);
		}
	}
}
