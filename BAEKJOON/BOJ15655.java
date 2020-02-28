/*
 * BOJ 15655 N과 M (6)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {
	static int n, m;
	static int[] a, pick;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		pick = new int[m];
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
			if(index > 0 && pick[index-1] >= a[i])
				continue;
			pick[index] = a[i];
			solve(index+1);
		}
	}
}
