/*
 * BOJ 1107 리모컨
 * Gold 5
 * https://www.acmicpc.net/problem/1107
 */

import java.io.*;
import java.util.*;

public class BOJ1107 {
	static int N, M, cnt, length;
	static boolean[] broken;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		length = (N + "").length();
		
		// 사용할 수 있는 버튼으로 최대한 가까운 수를 만든다
		// 숫자가 아니라 +, -로 더 빨리가는 경우도 있을 수 있다!
		cnt = Math.abs(100 - N);
		
		for (int i = 0; i < 10; i++) {
			if (!broken[i]) {
				makeNumber(1, i, 0);
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void makeNumber(int pos, int i, int num) { // 몇번째 자리수, 값, 저장된값
		if (pos > length+1) {
			return;
		}
		
		int tmp = (int) (num + (Math.pow(10, pos-1) * i));
		cnt = Math.min(cnt, Math.abs(N - tmp) + pos);
		
		for (int j = 0; j < 10; j++) {
			if (!broken[j]) {
				makeNumber(pos+1, j, tmp);
			}
		}
	}
}
