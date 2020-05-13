/*
 * BOJ 2631 줄 세우기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2631 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		int[] d = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if(num[j]<num[i] && d[i]<d[j]+1) 
					d[i]++;
			}
			max = Math.max(d[i], max);
		}
		
//		System.out.println(Arrays.toString(num));
//		System.out.println(Arrays.toString(d));
		int ans = N - max;
		System.out.println(ans);
	}
}
