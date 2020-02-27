/*
 * BOJ 15651 N과 M (3)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
	static int n, m;
	static int[] pick;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		pick = new int[m];
		sb = new StringBuilder();
		
		solve(0);
		System.out.println(sb);
	}
	
	static void solve(int index) {
		if(index == m) {
			for (int i = 0; i < m; i++) {
				sb.append(pick[i]).append(" ");
//				System.out.print(pick[i] + " ");
			}
//			System.out.println();
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			pick[index] = i;
			solve(index+1);
		}
	}
}
