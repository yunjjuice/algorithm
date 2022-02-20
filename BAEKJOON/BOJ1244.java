/*
 * BOJ 1244 스위치 켜고 끄기
 * Silver 3
 * https://www.acmicpc.net/problem/1244
 */

import java.io.*;
import java.util.*;

public class BOJ1244 {
	static int N, M;
	static int[] switches;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		switches = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			if (gender == 1) {
				for (int j = 0; j < N; j++) {
					if ((j+1) % pos == 0) switches[j] = switches[j] == 0 ? 1 : 0;
				}
			} else if (gender == 2) {
				switches[pos - 1] = switches[pos - 1] == 0 ? 1 : 0;
				for (int j = 1; j < N/2; j++) {
					if (pos - 1 + j >= N || pos - 1 - j < 0) break;
					if (switches[pos - 1 - j] == switches[pos - 1 + j]) {
						switches[pos - 1 - j] = switches[pos - 1 - j] == 0 ? 1 : 0;
						switches[pos - 1 + j] = switches[pos - 1 + j] == 0 ? 1 : 0;
					} else {
						break;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(switches[i]).append(' ');
			if ((i+1) % 20 == 0) sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}
