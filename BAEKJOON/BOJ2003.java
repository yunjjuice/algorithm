/*
 * BOJ 2003 수들의 합 2
 * https://www.acmicpc.net/problem/2003
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
	static int N, M, ans;
	static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
				
		int end = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			while(sum < M && end < N) {
				sum += A[end++];
			}
			if(sum == M) {
				ans++;
			}
			sum -= A[i];
		}
		
		System.out.println(ans);
	}
}
