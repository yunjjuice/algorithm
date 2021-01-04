/*
 * BOJ 12015 가장 긴 증가하는 부분 수열 3
 * Gold 2
 * https://www.acmicpc.net/problem/12738
 * 참고 링크 : https://codedoc.tistory.com/414
 * https://jason9319.tistory.com/113
 * https://dragon-h.tistory.com/36
 */

import java.util.*;
import java.io.*;

public class BOJ12738 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		int index = 0;
		dp[index++] = num[0];
		for (int i = 1; i < N; i++) {
			if (dp[index-1] < num[i]) {
				dp[index++] = num[i];
				continue;
			}
			int start = 0;
			int end = index;
			int mid = 0;
			while (start < end) {
				mid = (start + end) / 2;
				if (dp[mid] >= num[i]) {
					end = mid;
				} else if (dp[mid] < num[i]) {
					start = mid + 1;
				}
			}
			dp[end] = num[i];
		}
		
		System.out.println(index);
	}
}
