/*
 * BOJ 14921 용액 합성하기
 * Gold 5
 * https://www.acmicpc.net/problem/14921
 */

import java.io.*;
import java.util.*;

public class BOJ14921 {
	static int N, start, end, min;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		start = 0;
		end = N - 1;
		while (start < end) {
			int sum = arr[start] + arr[end];
			if (Math.abs(min) > Math.abs(sum)) {
				min = sum;
			}
			if (sum < 0) start++;
			else end--;
		}
		
		System.out.println(min);
	}
}
