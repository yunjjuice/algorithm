/*
 * BOJ 1991 트리 순회
 * Silver 1
 * https://www.acmicpc.net/problem/1991
 */

import java.util.*;
import java.io.*;

public class BOJ1991 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, List<String>> map = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			List<String> list = new ArrayList<>();
			list.add(left);
			list.add(right);
			map.put(root, list);
		}
		
		preorder("A");
		sb.append('\n');
		inorder("A");
		sb.append('\n');
		postorder("A");
		
		System.out.println(sb);
	}
	public static void preorder(String v) {
		if (v.equals(".")) return;
		
		sb.append(v);
		preorder(map.get(v).get(0));
		preorder(map.get(v).get(1));
	}
	
	public static void inorder(String v) {
		if (v.equals(".")) return;
		
		inorder(map.get(v).get(0));
		sb.append(v);
		inorder(map.get(v).get(1));
	}
	
	public static void postorder(String v) {
		if (v.equals(".")) return;
		
		postorder(map.get(v).get(0));
		postorder(map.get(v).get(1));
		sb.append(v);
	}
}
