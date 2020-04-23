/**
 * BOJ 9663 N-Queen
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
	static int N, ans;
	static int[] cols;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cols = new int[N];
		
		dfs(0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int level) {
		if(level == N) {
			ans++;
		} else {
			for (int i = 0; i < N; i++) {
				cols[level] = i;
				if(isPossible(level))
					dfs(level+1);
			}
		}
	}
	
	public static boolean isPossible(int level) {
		for (int i = 0; i < level; i++) {
			if((cols[i] == cols[level]) || (Math.abs(level-i) == Math.abs(cols[level]-cols[i])))
				return false;
		}
		return true;
	}
}
