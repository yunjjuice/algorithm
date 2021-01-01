/*
 * BOJ 2565 전깃줄
 * Silver 1
 * https://www.acmicpc.net/problem/2565
 */

import java.util.*;
import java.io.*;

public class BOJ2565 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] num = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			num[i][0] = a;
			num[i][1] = b;
		}
		
		Arrays.sort(num, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int[] d = new int[N];
		for (int i = 0; i < N; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (num[i][1] > num[j][1]) {
					d[i] = Math.max(d[i], d[j] + 1);
				}
			}
		}
				
		int max = -1;
		for (int i = 0; i < d.length; i++) {
			if (max < d[i])
				max = d[i];
		}
		
		System.out.println(N - max);
	}
}
