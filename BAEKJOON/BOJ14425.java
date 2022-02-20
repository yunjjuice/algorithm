/*
 * BOJ 14425 문자열 집합
 * Silver 3
 * https://www.acmicpc.net/problem/14425
 */

import java.io.*;
import java.util.*;

public class BOJ14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine().trim());
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine().trim();
			if (set.contains(str)) cnt++;
		}
		
		System.out.println(cnt);
	}
}
