/*
 * 프로그래머스 프렌즈4블록 레벨2
 */

import java.util.*;

public class Programmers_Lv2_프렌즈4블록 {
	public static void main(String[] args) {
		String[] str = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		int a = solution(4, 5, str);
		System.out.println(a);
		
		String[] str2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		a = solution(6, 6, str2);
		System.out.println(a);
	}

	public static int solution(int m, int n, String[] board) { // m:높이, n:폭
		int answer = 0;

		ArrayList<int[]> list = new ArrayList<int[]>(); // 4개가 되는 좌표 맨왼쪽위를 저장해둔다

		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}

		boolean flag = true;
		while (flag) { // 4개짜리가 없을 때까지 돌아야 한다
			boolean[][] visited = new boolean[m][n];
			int cnt = 0;
			list.clear();
			
			// 4개짜리를 찾는다
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] != '0' && map[i][j] == map[i + 1][j] && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j + 1]) {
						list.add(new int[] { i, j });
						cnt++;
					}
				}
			}
			
			if (cnt == 0) {
				flag = false;
				break; // 4개짜리를 더이상 못 찾으면 게임 끝
			}

			// 4개짜리를 지워준다
			for (int i = 0; i < list.size(); i++) {
				int[] cur = list.get(i);
				
				map[cur[0]][cur[1]] = '0';
				map[cur[0] + 1][cur[1]] = '0';
				map[cur[0]][cur[1] + 1] = '0';
				map[cur[0] + 1][cur[1] + 1] = '0';
				
				visited[cur[0]][cur[1]] = true;
				visited[cur[0] + 1][cur[1]] = true;
				visited[cur[0]][cur[1] + 1] = true;
				visited[cur[0] + 1][cur[1] + 1] = true;
			}

			// 확인용
//			for (int i = 0; i < map.length; i++) {
//				System.out.println(map[i]);
//			}
//			System.out.println();

			// 빈칸 개수를 세준다
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j]) {
						answer += 1;
					}
				}
			}

			// 내려준다
			for (int i = m - 1; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '0')
						continue;

					int nx = i;
					char c = map[i][j];
					map[i][j] = '0';
					while (true) {
						if (nx + 1 >= m || map[nx + 1][j] != '0')
							break;
						nx++;
					}
					map[nx][j] = c;
				}
			}
			// 확인용
//			for (int i = 0; i < map.length; i++) {
//				System.out.println(map[i]);
//			}
		}

		return answer;
	}
}
