/*
 * BOJ 11722 가장 긴 감소하는 부분 수열
 * Silver 2
 * https://www.acmicpc.net/problem/11722
 */

import java.util.*;
import java.io.*;

public class BOJ11722 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[N];
		for (int i = 0; i < N; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (num[i] < num[j]) {
					d[i] = Math.max(d[i], d[j] + 1);
				}
			}
		}
		
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, d[i]);
		}
		
		System.out.println(max);
	}
}
