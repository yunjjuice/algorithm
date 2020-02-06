/*
 * SWEA 1217 °Åµì Á¦°ö D3
 */

import java.util.Scanner;

public class SWEA1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int tc = sc.nextInt();
			int num = sc.nextInt();
			int count = sc.nextInt();
			
			int ans = multi(num, count);
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
	
	static int multi(int n, int c) {
		if(c == 1) {
			return n; 
		}
		
		return n * multi(n, c-1);
	}
}
