/*
 * SWEA 6782 현주가 좋아하는 제곱근 놀이 D5
 */

import java.util.Scanner;

public class SWEA6782 {
	static long N, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextLong();
			ans = 0;
			
			while(N != 2) {
				double tmp = Math.sqrt(N);
				if((long)tmp == tmp) {
					N = (long)Math.sqrt(N);
				} else {
					long t = (long)tmp;
					ans += Math.pow(t+1, 2) - N;
					N = (long)Math.sqrt(Math.pow(t+1, 2));
				}
				ans++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
