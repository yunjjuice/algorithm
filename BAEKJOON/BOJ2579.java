/*
 * BOJ 2579 계단 오르기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 계단 개수
		int[] stair = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
//		System.out.println(Arrays.toString(stair));
		
		int[] d = new int[N+1];
		d[1] = stair[1];
		if(N >= 2) 
			d[2] = d[1] + stair[2];
		
		for (int i = 3; i <= N; i++) {
			d[i] = Math.max(d[i-2] + stair[i], d[i-3] + stair[i-1] + stair[i]);
		}
		
		System.out.println(d[N]);
	}
}
