/*
 * BOJ 15663 N과 M (9)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15663 {
	static int n, m;
	static int[] a, pick;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[10001];
		pick = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[Integer.parseInt(st.nextToken())]++;
		}
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
		
		for (int i = 1; i <= 10000; i++) {
			if(a[i] == 0)
				continue;
			pick[index] = i;
			a[i]--;
			solve(index+1);
			a[i]++;
		}
	}
}
