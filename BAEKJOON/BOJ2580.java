/*
 * BOJ 2580 스도쿠
 * Gold 4
 * https://www.acmicpc.net/problem/2580
 */

import java.io.*;
import java.util.*;

public class BOJ2580 {
	static int[][] map;
	static List<Pos> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					list.add(new Pos(i, j));
			}
		}
		
		sudoku(0);
	}
	
	public static void sudoku(int depth) {
		if (depth == list.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		int x = list.get(depth).x;
		int y = list.get(depth).y;
		for (int i = 1; i <= 9; i++) {
			if (check(x, y, i)) {
				map[x][y] = i;
				sudoku(depth + 1);
				map[x][y] = 0;
			}
		}
	}
	
	private static boolean check(int x, int y, int value) {
		// 가로
		for (int i = 0; i < 9; i++) {
			if (y != i && map[x][i] == value)
				return false;
		}
		// 세로
		for (int i = 0; i < 9; i++) {
			if (x != i && map[i][y] == value)
				return false;
		}
		// 3*3
		int newX = (x / 3) * 3;
		int newY = (y / 3) * 3;
		for (int i = newX; i < newX + 3; i++) {
			for (int j = newY; j < newY + 3; j++) {
				if (i == x && j == y) continue;
				if (map[i][j] == value)
					return false;
			}
		}
		
		return true;
	}

	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
