/*
 * SWEA 6719 성수의 프로그래밍 강좌 시청 D4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA6719 {
	static int N, K;
	static int[] M;
	static float ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			M = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				M[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(M);
			ans = 0;
			for (int i = N-K; i < N; i++) {
				ans = (ans+M[i])/2;
//				System.out.println(i + " , " + ans);
			}
			
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
