/*
 * SWEA 4530 극한의 청소 작업 D4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4530 {
	static long A, B;
	static long ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= TC; tc++) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine(), " ");
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			ans = Math.abs(calc(A) - calc(B));
			if((A<0 && B>0) || (A>0 && B<0)) { // 하나는 음수, 하나는 양수일 경우 중간에 낀 0을 빼줘야 함
				ans -= 1;
			}

			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	public static long calc(long n) {
		long m = Math.abs(n);
		String str = m + "";
		int len = str.length();
		
		long cnt = 0;
		while(len-- > 0) {
			long value = (long) (m / Math.pow(10, len)); // 각 자릿수의 값을 구한다
			if(value > 4) { // 4를 넘어가면 4x, 4xx, 4xxx같이 4로 시작하는 것들이 사라지는 거라서 미리 1을 빼준다. -> 사실 잘 이해안됨 ㅠ
				value -= 1;
			}
			cnt += (Math.pow(9, len) * value); // 9000이라 치면 9*1000 -> 1000은 9진수로 생각한다
											// 0~9 중에서 4 하나만 빠지면 0~8개의 숫자이므로 9진수로 생각한다
			m %= Math.pow(10, len);
		}
		
		if(n < 0) return -cnt; // 원래 값이 음수면 음수로 돌려준다
		return cnt;
	}
}
