/*
 * BOJ 3649 로봇 프로젝트
 * Gold 4
 * https://www.acmicpc.net/problem/3649
 */

import java.io.*;
import java.util.*;

public class BOJ3649 {
	static int x, n;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			x = Integer.parseInt(str) * 10000000;
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			
			int start = 0, end = n-1;
			boolean flag = false;
			while (start < end) {
				int sum = arr[start] + arr[end];
				if (sum == x) {
					flag = true;
					sb.append("yes ").append(arr[start]).append(' ').append(arr[end]).append('\n');
					break;
				} else if (sum < x) {
					start++;
				} else {
					end--;
				}
			}
			
			if (!flag) {
				sb.append("danger").append('\n');
			}
		}
		System.out.print(sb);
	}
}
