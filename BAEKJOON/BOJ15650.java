/*
 * BOJ 15650 N과 M (2)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
	static int n, m;
	static boolean used[];
	static int pick[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		used = new boolean[n+1];
		pick = new int[m];
		
		solve(0);
	}
	
	static void solve(int index) {
		if(index == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(pick[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(used[i])
				continue;
			if(index > 0 && pick[index-1] > i)
				continue;
			used[i] = true;
			pick[index] = i;
			solve(index+1);
			used[i] = false;
		}
	}
}
