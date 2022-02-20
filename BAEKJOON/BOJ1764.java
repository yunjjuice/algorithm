/*
 * BOJ 1764 듣보잡
 * Silver 4
 * https://www.acmicpc.net/problem/1764
 */

import java.io.*;
import java.util.*;

public class BOJ1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> listen = new HashSet<>();
		for (int i = 0; i < N; i++) {
			listen.add(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		List<String> who = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String look = br.readLine();
			if (listen.contains(look)) {
				who.add(look);
			}
		}
		
		Collections.sort(who);
		
		sb.append(who.size()).append('\n');
		for (int i = 0; i < who.size(); i++) {
			sb.append(who.get(i)).append('\n');
		}
		System.out.print(sb.toString());
	}
}
