/*
 * BOJ 11055 가장 큰 증가 부분 수열
 * Silver 2
 * https://www.acmicpc.net/problem/11055
 */

import java.util.*;
import java.io.*;

public class BOJ11055 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] sum = new int[N];
		
		for (int i = 0; i < N; i++) {
			sum[i] = num[i];
			for (int j = 0; j < i; j++) {
				if (num[j] < num[i]) {
					sum[i] = Math.max(sum[i], sum[j] + num[i]);
				}
			}
		}
		
		int max = -1;
		for (int i = 0; i < N; i++) {
			if (max < sum[i]) {
				max = sum[i];
			}
		}
		
		System.out.println(max);
	}
}
