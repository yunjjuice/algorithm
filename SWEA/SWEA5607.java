/*
 * SWEA 5607 [Professional] 조합 D3 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5607 {
//	static long N, R;
	static int N, R;
	static long ans;
	static final long P = 1234567891;
	static long[] fac = new long[1000001]; // i값에 해당하는 팩토리얼 값을 저장 -> P로 나눈 후 저장한다
	public static void main(String[] args) throws NumberFormatException, IOException {

//		System.out.println("P : " + P);
		fac[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			fac[i] = (i * fac[i-1]) % P;
		}
		
//		for (int i = 0; i < 201; i++) {
//			System.out.println(i + " : " + fac[i]);
//		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());		
			
			ans = ((fac[N] % P) * pow(fac[N-R] * fac[R] % P, P-2)) % P;

//			ans = fac[N] % P;
//			ans *= pow(fac[N-R] * fac[R] % P, P-2) % P;

			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	public static long pow(long n, long p) { // n 밑수 p 제곱값
		if(p == 0) 
			return 1;
		
		long res = (pow(n, p/2)) % P;
		res = (res * res) % P;
		if(p % 2 != 0) { // 홀수면 한 번 더 곱해준다
			res = (res * n) % P;
		}
		
		return res;
	}
}
