/*
 * BOJ 2075 N번째 큰 수
 * Gold 5
 * https://www.acmicpc.net/problem/2075
 */

import java.io.*;
import java.util.*;

public class BOJ2075 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < N-1; i++) {
			q.poll();
		}
		
		System.out.println(q.poll());
	}
}
