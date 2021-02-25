/*
 * BOJ 1068 트리
 * Silver 1
 * https://www.acmicpc.net/problem/1068
 */

import java.io.*;
import java.util.*;

public class BOJ1068 {
	static int N, root, del, ans;
	static List<Integer> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = i;
				continue;
			}
			list[parent].add(i);
		}
		del = Integer.parseInt(br.readLine());
		
		dfs(root);
		System.out.println(ans);
	}
	
	public static void dfs(int s) {
		if (s == del) return;
		if (list[s].size() == 0) {
			ans++;
			return;
		}
		for (int i = 0; i < list[s].size(); i++) {
			int next = list[s].get(i);
			if (list[s].size() == 1 && next == del) {
				ans++;
				return;
			}
			dfs(next);
		}
		
	}
}
