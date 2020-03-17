/*
 * SWEA 4012 요리사
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4012 {
	static int N, half;
	static int[][] S;
	static boolean[] used;
	static int ans;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			half = N / 2;
			S = new int[N][N];
			used = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 입력 확인
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(S[i]));
//			}
			
			// 식재료 개수를 반으로 나눈다
			// 시너지의 합을 구한다
			// 그 중 최소일 때의 답을 구한다
			ans = Integer.MAX_VALUE;
			makeHalf(0,0);
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void makeHalf(int cnt, int cur) {
		if(cur >= N) return;
		if(cnt == half) {
//			System.out.println(Arrays.toString(used));
			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					if(used[i] && used[j])
						sumA += S[i][j];
					else if(!used[i] && !used[j])
						sumB += S[i][j];
				}
			}
			
			ans = Math.min(Math.abs(sumA - sumB), ans);
			return;
		}
		
		for (int i = cur; i < N; i++) {
			used[i] = true;
			makeHalf(cnt+1, i+1);
			used[i] = false;
		}
	}
}