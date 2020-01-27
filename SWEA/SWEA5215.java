// 5215 햄버거 다이어트

import java.util.Scanner;

public class SWEA5215 {
	static int TC, N, L, ans;
	static int[] T; // 맛에 대한 점수
	static int[] K; // 칼로리
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		for (int testCase = 1; testCase <= TC; testCase++) {
			N = sc.nextInt();
			L = sc.nextInt();
			T = new int[N];
			K = new int[N];
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				T[i] = sc.nextInt();
				K[i] = sc.nextInt();
			}
			dfs(0, 0, 0);
			System.out.println("#" + testCase + " " + ans);
		}
	}
	
	public static void dfs(int cnt, int t, int k) {
		if(k > L){ // 칼로리의 합이 제한 칼로리보다 높으면 
			return;
		}
		else if(cnt == N) {
			ans = Math.max(ans, t);
		}else {
			dfs(cnt+1, t, k);
			dfs(cnt+1, t+T[cnt], k+K[cnt]);
		}
	}
}
