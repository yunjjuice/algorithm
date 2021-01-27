/*
 * BOJ 10816 숫자 카드 2
 * Silver 4
 * https://www.acmicpc.net/problem/10816
 */

import java.util.*;
import java.io.*;

public class BOJ10816 {
	static int N, M;
	static int[] cards;
	static HashMap<Integer, Integer> map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cards = new int[N];
		map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			map.put(cards[i], map.getOrDefault(cards[i], 0) + 1);
		}
		Arrays.sort(cards);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int l = 0, r = N - 1, m = 0;
			boolean flag = false;
			while (l <= r) {
				m = (l + r) / 2;
				if (cards[m] == num) {
					sb.append(map.get(num) + " ");
					flag = true;
					break;
				} else if (cards[m] > num) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
			if (!flag) sb.append("0 ");
		}
		
		System.out.println(sb);
	}
}
