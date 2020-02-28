/*
 * BOJ 11053 가장 긴 증가하는 부분 수열
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
	static int n, max;
	static int[] a;
	static int[] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if(a[i] > a[j] && d[i] < d[j]+1) {
					d[i] = d[j] + 1;
				}
			}
		}
		
		max = d[0];
		for (int i = 0; i < n; i++) {
			if(max < d[i])
				max = d[i];
		}
		
		System.out.println(max);
	}
}
