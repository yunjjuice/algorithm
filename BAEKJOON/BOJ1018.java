/*
 * BOJ 1018 체스판 다시 칠하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
	static int n, m;
	static int ans;
	static char[][] map;
	static char[] chess1 = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
	static char[] chess2 = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		// 입력 확인
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		ans = Integer.MAX_VALUE;
		for (int i = 0; i <= n-8; i++) {
			for (int j = 0; j <= m-8; j++) {
				solve(i, j);
			}
		}
		
		System.out.println(ans);
	}
	
	public static void solve(int c, int r) {
		// 맨위왼쪽이 흰색이라고 가정
		int change1 = 0;
		for (int i = c; i < c+8; i++) {
			if(i%2 == 0) {
				for (int j = r; j < r+8; j++) {
					if(map[i][j] != chess1[j-r]) {
						change1++;
					}
				}
			} else {
				for (int j = r; j < r+8; j++) {
					if(map[i][j] != chess2[j-r]) {
						change1++;
					}
				}
			}
		}
		// 맨위왼쪽이 검은색이라고 가정
		int change2 = 0;
		for (int i = c; i < c+8; i++) {
			for (int j = r; j < r+8; j++) {
				if(i%2 == 0) {
					if(map[i][j] != chess2[j-r]) {
						change2++;
					}
				} else {
					if(map[i][j] != chess1[j-r]) {
						change2++;
					}
				}
			}
		}
		
		int tmp = Math.min(change1, change2);
		if(ans > tmp)
			ans = tmp;
	}
}
