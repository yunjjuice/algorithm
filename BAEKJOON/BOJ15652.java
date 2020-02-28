/*
 * BOJ 15652 N과 M (4)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
	static int n, m;
	static int[] pick;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		pick = new int[m+1];
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
		
		for (int i = 1; i <= n; i++) {
			if(index > 0 && pick[index-1] > i)
				continue;
			pick[index] = i;
			solve(index+1);
		}
	}
}
