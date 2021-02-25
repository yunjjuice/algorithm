/*
 * BOJ 5639 이진 검색 트리
 * Silver 1
 * https://www.acmicpc.net/problem/5639
 */

import java.io.*;

public class BOJ5639 {
	static Node root;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		root = new Node(Integer.parseInt(br.readLine()));
		sb = new StringBuilder();
		String str;
		while (true) {
			str = br.readLine();
			if (str == null || str == "") break;
			root.insert(Integer.parseInt(str));
		}
		
		postOrder(root);
		
		System.out.println(sb);
	}
	
	public static void postOrder(Node node) {
		if (node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.num).append('\n');
	}

	static class Node {
		int num;
		Node left, right;
		
		public Node(int num) {
			this.num = num;
		}
		
		public void insert(int n) {
			if (n < this.num) {
				if (this.left == null) {
					this.left = new Node(n);
				} else {
					this.left.insert(n);
				}
			} else {
				if (this.right == null) {
					this.right = new Node(n);
				} else {
					this.right.insert(n);
				}
			}
		}
	}
}
