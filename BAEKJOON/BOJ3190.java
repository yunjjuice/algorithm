/*
 * BOJ 3190 뱀
 * Gold 5
 * https://www.acmicpc.net/problem/3190
 */

import java.util.*;
import java.io.*;

public class BOJ3190 {
	static int N, K, L; // 보드 크기, 사과 개수, 방향 변환 횟수
	static int[][] map;
	static Queue<Info> info = new LinkedList<>();
	static Deque<Pos> dq = new LinkedList<>();
	static int[][] dir = {{0,1}, {-1,0}, {0,-1}, {1, 0}}; // 우상좌하
	static int x = 1, y = 1, d  = 0;
	static int sec;
	// 우 -> 상하 +1 +3
	// 하 -> 우좌 +1 +3
	// 좌 -> 하상 +1 +3
	// 상 -> 좌우 +1 +3
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			info.offer(new Info(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		game();
		
		System.out.println(sec);
	}
	
	public static void game() {
		dq.addFirst(new Pos(1, 1));
		while (true) {
			sec++;
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if (!isLen(nx, ny)) break;
			if (!check(nx, ny)) break;
			dq.addFirst(new Pos(nx, ny));
			if (map[nx][ny] == 1) { // 사과가 있다면 사과는 사라진다
				map[nx][ny] = 0;
			} else { // 사과가 없다면 꼬리가 줄어든다
				dq.removeLast();
			}
			x = nx;
			y = ny;
			if (!info.isEmpty() && info.peek().s == sec) {
				Info i = info.poll();
				if (i.d.equals("L")) { // 왼쪽
					d = (d + 1) % 4;
				} else if (i.d.equals("D")) { // 오른쪽
					d = (d + 3) % 4;
				}
			}
		}
	}
	
	public static boolean check(int x, int y) {
		for (Pos cur : dq) {
			if (cur.x == x && cur.y == y) return false;
		}
		return true;
	}

	public static boolean isLen(int x, int y) {
		if (1 <= x && x <= N && 1 <= y && y <= N) return true;
		return false;
	}

	static class Info {
		int s;
		String d;
		public Info(int s, String d) {
			super();
			this.s = s;
			this.d = d;
		}
	}
	
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
