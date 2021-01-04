/*
 * BOJ 14003 가장 긴 증가하는 부분 수열 5
 * Gold 1
 * https://www.acmicpc.net/problem/14003
 */

import java.util.*;
import java.io.*;

public class BOJ14003 {
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
		int idx = 0;
		dp[idx++] = num[0];
		for (int i = 1; i < N; i++) {
			if (dp[idx-1] < num[i]) {
				node[i] = idx;
				dp[idx++] = num[i];
			} else {
				int start = 0;
				int end = idx;
				int mid = 0;
				while (start < end) {
					mid = (start + end) / 2;
					if (dp[mid] >= num[i]) {
						end = mid;
					} else {
						start = mid + 1;
					}
				}
				dp[end] = num[i];
				node[i] = end;
			}
		}
		
		int t = idx - 1;
		Stack<Integer> s = new Stack<>();
		for (int i = N-1; i >= 0; i--) {
			if (node[i] == t) {
				s.push(num[i]);
				t--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(idx).append('\n');
		
		while(!s.isEmpty()) {
			sb.append(s.pop()).append(' ');
		}
		
		System.out.println(sb);
	}
}
