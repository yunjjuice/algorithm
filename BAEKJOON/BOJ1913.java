/*
 * BOJ 1913 달팽이
 * Silver 4
 * https://www.acmicpc.net/problem/1913
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1913 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int x = 0, y = 0;
		
		int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int[][] map = new int[N][N];
		int n = N/2;
		int m = N/2;
		
		int val = 1; // 입력값
		int length = 1; // 가야 하는 길이
		int cnt = 0; // 현재까지 간 길이
		int rotate = 0; // 회전횟수
		int d = 0;
		while (val <= N*N) {
			map[n][m] = val++;
			if (map[n][m] == target) {
				x = n;
				y = m;
			}
			
			n += dir[d][0];
			m += dir[d][1];
			
			cnt++;
			if (length == cnt) {
				cnt = 0;
				d = (d + 1) % 4;
				rotate++;
				
				if ((rotate % 2) == 0) {
					length++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		sb.append(x+1).append(' ').append(y+1);
		
		System.out.print(sb);
	}
}
