/*
 * BOJ 10815 숫자 카드
 * Silver 4
 * https://www.acmicpc.net/problem/10815
 */

import java.util.*;
import java.io.*;

public class BOJ10815 {
	static int N, M;
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
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int m = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(m) + " ");
		}
		
		System.out.println(sb);
	}
	
	public static int binarySearch(int n) {
		int l = 0;
		int r = num.length - 1;
		int m = 0;
		
		while (l <= r) {
			m = (l + r) / 2;
			if (num[m] == n) {
				return 1;
			} else if (num[m] < n) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		
		return 0;
	}
}
