/*
 * SWEA 9659 다항식 계산 D4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9659 {
	static int N, M;
	static int[] t, a, b;
	static long[] f;
	static final int p = 998244353;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= TC; tc++) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			f = new long[N+1];
			t = new int[N+1];
			a = new int[N+1];
			b = new int[N+1];
			for (int i = 2; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				t[i] = Integer.parseInt(st.nextToken());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				int x = Integer.parseInt(st.nextToken());
				f[0] = 1;
				f[1] = x;
				for (int j = 2; j <= N; j++) {
					if(t[j] == 1) {
						f[j] = (f[a[j]] + f[b[j]]) % p;
					}else if(t[j] == 2) {
						f[j] = (a[j] * f[b[j]]) % p;
					}else if(t[j] == 3) {
						f[j] = (f[a[j]] * f[b[j]]) % p;
					}
				}
				sb.append(f[N]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
