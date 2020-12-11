/*
 * BOJ 5622 다이얼
 * Bronze 2
 * https://www.acmicpc.net/problem/5622
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ('A' <= ch && ch <= 'C') {
				cnt += 3;
			} else if ('D' <= ch && ch <= 'F') {
				cnt += 4;
			} else if ('G' <= ch && ch <= 'I') {
				cnt += 5;
			} else if ('J' <= ch && ch <= 'L') {
				cnt += 6;
			} else if ('M' <= ch && ch <= 'O') {
				cnt += 7;
			} else if ('P' <= ch && ch <= 'S') {
				cnt += 8;
			} else if ('T' <= ch && ch <= 'V') {
				cnt += 9;
			} else if ('W' <= ch && ch <= 'Z') {
				cnt += 10;
			}
		}
		System.out.println(cnt);
	}
}
