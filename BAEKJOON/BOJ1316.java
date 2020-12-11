/*
 * BOJ 1316 그룹 단어 체커
 * Silver 5
 * https://www.acmicpc.net/problem/1316
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = "";
		int ans = 0;
		for (int n = 0; n < N; n++) {
			boolean[] alpha = new boolean[26];
			boolean flag = true;
			int cnt = 0;
			str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (i > 0 && str.charAt(i-1) != ch) {
					cnt = 0;
				}
				if (!alpha[ch - 'a'] && cnt == 0) {
					alpha[ch - 'a'] = true;
				} else if (alpha[ch - 'a'] && cnt == 0) {
					flag = false;
					break;
				}
				cnt++;
			}
			if (flag) ans++;
		}
		System.out.println(ans);
	}
}
