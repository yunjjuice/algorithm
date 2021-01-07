/*
 * BOJ 1032 명령 프롬프트
 * Bronze 1
 * https://www.acmicpc.net/problem/1032
 */

import java.util.*;
import java.io.*;

public class BOJ1032 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
//		StringBuilder ans = new StringBuilder(str[0]);
//		for (int i = 1; i < str.length; i++) {
//			for (int j = 0; j < str[i].length(); j++) {
//				if (str[i-1].charAt(j) != str[i].charAt(j)) {
//					ans.setCharAt(j, '?');
//				}				
//			}
//		}
		
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < str[0].length(); i++) {
			boolean flag = true;
			for (int j = 1; j < str.length; j++) {
				if (str[j-1].charAt(i) != str[j].charAt(i)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				ans.append(str[0].charAt(i));
			} else {
				ans.append('?');
			}
		}
		
		System.out.println(ans);
	}
}
