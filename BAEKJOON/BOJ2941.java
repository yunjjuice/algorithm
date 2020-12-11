/*
 * BOJ 2941 크로아티아 알파벳
 * Silver 5
 * https://www.acmicpc.net/problem/2941
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (tmp == 'c') {
				if (i + 1 < str.length()) {
					if ((str.charAt(i+1) == '=' || str.charAt(i+1) == '-')) {
						i++;
					}
				}
			} else if (tmp == 'd') {
				if (i + 1 < str.length()) {
					if (str.charAt(i+1) == 'z') {
						if (i+2 < str.length() && str.charAt(i+2) == '=') {
							i += 2;
						}
					} else if (str.charAt(i+1) == '-') {
						i++;
					}
				}
			} else if (tmp == 'l' || tmp == 'n') {
				if (i + 1 < str.length() && str.charAt(i+1) == 'j')
					i++;
			} else if (tmp == 's' || tmp == 'z') {
				if (i + 1 < str.length()) {
					if (str.charAt(i+1) == '=') {
						i++;
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
