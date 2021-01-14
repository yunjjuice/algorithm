/*
 * BOJ 1806 부분합
 * Gold 4
 * https://www.acmicpc.net/problem/1806
 */

import java.util.*;
import java.io.*;

public class BOJ1806 {
	static int N, S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		int[] num = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int left = 0, right = 0;
		
		while (left <= N && right <= N) {
			if (sum < S) {
				sum += num[right++];
			} else {
				min = Math.min(min, right-left);
				sum -= num[left++];
			}
		}
		
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}
