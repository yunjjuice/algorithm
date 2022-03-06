/*
 * BOJ 1120 문자열
 * Silver 4
 * https://www.acmicpc.net/problem/1120
 */

import java.io.*;
import java.util.*;

public class BOJ1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int cnt = 0;
		
		if (A.length() == B.length()) {
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) != B.charAt(i)) cnt++;
			}
		} else {
			cnt = Integer.MAX_VALUE;
			for (int i = 0; i <= B.length() - A.length(); i++) {
				int tmpCnt = 0;
				for (int j = 0; j < A.length(); j++) {
					if (A.charAt(j) != B.charAt(i+j)) tmpCnt++;
				}
				cnt = Math.min(tmpCnt, cnt);
			}
		}
		
		System.out.println(cnt);
	}
}
