/*
 * BOJ 1620 나는야 포켓몬 마스터 이다솜
 * Silver 4
 * https://www.acmicpc.net/problem/1620
 */

import java.io.*;
import java.util.*;

public class BOJ1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, String> dogam1 = new HashMap<>();
		Map<String, String> dogam2 = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String pokemon = br.readLine();
			dogam1.put(String.valueOf(i), pokemon);
			dogam2.put(pokemon, String.valueOf(i));
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (dogam1.containsKey(str)) {
				sb.append(dogam1.get(str)).append('\n');
			} else if (dogam2.containsKey(str)) {
				sb.append(dogam2.get(str)).append('\n');
			}
		}
		
		System.out.print(sb);
	}
}
