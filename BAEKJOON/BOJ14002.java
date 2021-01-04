/*
 * BOJ 14002 가장 긴 증가하는 부분 수열 4
 * Gold 4
 * https://www.acmicpc.net/problem/14002
 */

import java.util.*;
import java.io.*;

public class BOJ14002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		int[] node = new int[N];
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (num[j] < num[i]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						node[i] = j;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int max = -1;
		int index = -1;
		for (int i = 0; i < N; i++) {
			if (max < dp[i]) {
				max = dp[i];
				index = i;
			}
		}
		sb.append(max).append('\n');
		
		int[] arr = new int[max];
		int idx = 0;
		while(idx < max && index >= 0) {
			arr[idx++] = num[index];
			index = node[index];
		}
		
		for (int i = max-1; i >= 0; i--) {
			sb.append(arr[i]).append(' ');
		}
				
		System.out.println(sb);
	}
}
