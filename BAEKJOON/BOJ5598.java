/*
 * BOJ 5598 카이사르 암호
 */

import java.util.Arrays;
import java.util.Scanner;

public class BOJ5598 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if((c[i]-3) < 'A')
				c[i] += 23;
			else
				c[i] -= 3;
		}
		
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
	}
}