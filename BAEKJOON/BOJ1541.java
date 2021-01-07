/*
 * BOJ 1541 잃어버린 괄호
 * Silver 2
 * https://www.acmicpc.net/problem/1541
 */

import java.io.*;

public class BOJ1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-");
		
		int sum = 0;
		for (int i = 0; i < str.length; i++) {
			int num = calc(str[i]);
			if (i == 0) num = -num;
			sum += num;
		}
		
		System.out.println(sum);
	}
	
	public static int calc (String str) {
		int sum = 0;
		
		String[] num = str.split("\\+");
		for (int i = 0; i < num.length; i++) {
			sum += Integer.parseInt(num[i]);
		}
		
		return -sum;
	}
}
