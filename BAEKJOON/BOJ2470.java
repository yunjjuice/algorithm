/*
 * BOJ 2470 두 용액
 * Gold 5
 * https://www.acmicpc.net/problem/2470
 */

import java.util.*;
import java.io.*;

public class BOJ2470 {
	static int N;
	static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		int start = 0, end = N - 1, min = Integer.MAX_VALUE;
		int sum = 0, ans1 = 0, ans2 = 0;
		while (start < end) {
			sum = num[start] + num[end];
			if (sum == 0) {
				if (num[start] <= num[end]) {
					ans1 = num[start];
					ans2 = num[end];
				} else {
					ans1 = num[end];
					ans2 = num[start];
				}
				break;
			}
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				if (num[start] <= num[end]) {
					ans1 = num[start];
					ans2 = num[end];
				} else {
					ans1 = num[end];
					ans2 = num[start];
				}
			}
			if (sum < 0) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}
}
