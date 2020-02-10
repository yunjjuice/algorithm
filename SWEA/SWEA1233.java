/*
 * SWEA 1233 사칙연산 유효성 검사 D4
 */

import java.util.Scanner;

public class SWEA1233 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 10; testCase++) {
			int ans = 1; // 유효하다면 1, 아니면 0
			int N = sc.nextInt(); // 노드 개수
			sc.nextLine();
			String[] tree = new String[N+1];
			for (int i = 1; i < N+1; i++) {
				String str = sc.nextLine();
				String[] strArr = str.split(" ");
				int node = Integer.parseInt(strArr[0]);
				tree[node] = strArr[1];
			}
			// 종단노드에 연산자가 있으면 유효하지 않다
//			System.out.println(tree[1].equals("-"));
			for (int i = (N/2)+1; i < N+1; i++) {
//				System.out.println("i : " + i);
				if(tree[i].equals("+") || tree[i].equals("-") || tree[i].equals("*") || tree[i].equals("/")) {
//					System.out.println("if");
					ans = 0;
					break;
				}
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
