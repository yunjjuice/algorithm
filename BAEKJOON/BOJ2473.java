/*
 * BOJ 2473 세 용액
 * Gold 4
 * https://www.acmicpc.net/problem/2473
 */

import java.io.*;
import java.util.*;

public class BOJ2473 {
	static int N, start, end;
	static long min, ans1, ans2, ans3;
	static long[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		min = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			start = i+1;
			end = N-1;
			while (start < end) {
				long sum = arr[i] + arr[start] + arr[end];
				long gap = Math.abs(sum);
				if (gap < min) {
					min = gap;
					ans1 = arr[i];
					ans2 = arr[start];
					ans3 = arr[end];
				}
				if (sum < 0) start++;
				else end--;
			}
		}
		System.out.println(ans1 + " " + ans2 + " " + ans3);
	}
}
