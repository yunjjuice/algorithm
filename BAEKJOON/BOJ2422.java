/*
 * BOJ 2422 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2422 {
	static int N, M;
	static boolean[] used;
	static int[] pick;
	static boolean[][] bad;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		used = new boolean[N+1];
		pick = new int[3];
		bad = new boolean[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bad[a][b] = true;
			bad[b][a] = true;
		}

		ans = 0;
		icecream(0);
		System.out.println(ans);
	}
	
	static void icecream(int cnt) {
		if(cnt == 3) {
			for (int i = 0; i < pick.length; i++) {
				for (int j = 0; j < pick.length; j++) {
					if(i == j) continue;
					if(bad[pick[i]][pick[j]]) return;
				}
			}
			ans++;
//			System.out.println(Arrays.toString(pick));
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(used[i]) continue;
			if(cnt > 0 && pick[cnt-1] >= i) continue;
			used[i] = true;
			pick[cnt] = i;
			icecream(cnt+1);
			used[i] = false;
		}
	}
}
