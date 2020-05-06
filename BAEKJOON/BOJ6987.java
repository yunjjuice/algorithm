/*
 * BOJ 6987 월드컵
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6987 {
	static int[][] score;
	static int ans;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 4; t++) {
			score = new int[6][3]; // 6개팀 승리, 비김, 짐
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; i++) {
				score[i][0] = Integer.parseInt(st.nextToken());
				score[i][1] = Integer.parseInt(st.nextToken());
				score[i][2] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			dfs(0, 1, score);
			sb.append(ans).append(' ');
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(int ta, int tb, int[][] score) { // 팀1, 팀2
		if(tb == 6) { // 팀2가 끝까지 돌았으면 팀1을 새로운 팀으로 바꿔서 계산
			dfs(ta+1, ta+2, score);
			return;
		}
		
		if(ta > 4) { // (0,1) (0,2) (0,3) ... (4,6) (5,6)
			for (int i = 0; i < score.length; i++) {
				for (int j = 0; j < score[i].length; j++) {
					if(score[i][j] > 0) {
						ans = 0;
						return;
					}
				}
			}
			ans = 1;
			return;
		}
		
		// 팀1 이기고 팀2 지는 경우
		if(score[ta][0] > 0 && score[tb][2] > 0) {
			score[ta][0]--;
			score[tb][2]--;
			dfs(ta, tb+1, score);
			score[ta][0]++; // 다시 돌려놔준다
			score[tb][2]++;
		}
		
		// 비긴 경우
		if(score[ta][1] > 0 && score[tb][1] > 0) {
			score[ta][1]--;
			score[tb][1]--;
			dfs(ta, tb+1, score);
			score[ta][1]++; 
			score[tb][1]++;
		}
		
		// 팀2 지고 팀1 이기는 경우
		if(score[ta][2] > 0 && score[tb][0] > 0) {
			score[ta][2]--;
			score[tb][0]--;
			dfs(ta, tb+1, score);
			score[ta][2]++; 
			score[tb][0]++;
		}
	}
}
