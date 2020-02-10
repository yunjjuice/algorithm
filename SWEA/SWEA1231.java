/*
 * SWEA 1231 중위순회 D4
 */

import java.util.Scanner;

public class SWEA1231 {
	public static String[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
			sc.nextLine();
			tree = new String[N+1];
			for (int i = 1; i <= N; i++) {
				String str = sc.nextLine();
				String[] strArr = str.split(" ");
//				System.out.println(Arrays.toString(strArr));
				int node = Integer.parseInt(strArr[0]);
				tree[node] = strArr[1];
			}
//			System.out.println(Arrays.toString(tree));
			System.out.print("#" + testCase + " ");
			inorder(1);
			System.out.println();
		}
	}
	
	public static void inorder(int index) {
		if(index >= tree.length || tree[index].equals(null)) {
			return;
		}
		inorder(index*2);
		System.out.print(tree[index]);
		inorder(index*2+1);
	}
}
