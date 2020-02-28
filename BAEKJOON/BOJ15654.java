/*
 * BOJ 15654 N과 M (5)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
	static int n, m;
	static int[] a;
	static int[] pick;
	static boolean[] used;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		pick = new int[m];
		used = new boolean[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		sb = new StringBuilder();
		solve(0);
		System.out.println(sb);
	}
	
	static void solve(int index) {
		if(index == m) {
			for (int i = 0; i < m; i++) {
				sb.append(pick[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(used[i])
				continue;
			pick[index] = a[i];
			used[i] = true;
			solve(index+1);
			used[i] = false;
		}	
	}
}
