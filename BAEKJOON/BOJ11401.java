/*
 * BOJ 11401 이항 계수 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11401 {
	static long[] fac = new long[4000001];
	static final int MOD = 1000000007;
	static int N, K;
	public static void main(String[] args) throws IOException {
		fac[1] = 1;
		for (int i = 2; i <= 4000000; i++) {
			fac[i] = (i * fac[i-1]) % MOD;
		}
		
//		System.out.println(fac[4000000]);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long ans = ((fac[N] % MOD) * (pow(fac[N-K] * fac[K] % MOD, MOD-2) % MOD)) % MOD;
		System.out.println(ans);
		
	}
	
	public static long pow(long n, long p) {
		if(p == 0)
			return 1;
		
		long result = (pow(n, p/2)) % MOD;
		result = (result * result) % MOD;
		if(p % 2 != 0) { // 홀수라면
			result = (result * n) % MOD;
		}
		return result;
	}
}
