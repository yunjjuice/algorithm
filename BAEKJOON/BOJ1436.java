/*
 * BOJ 1436 영화감독 숌
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 666; i < Integer.MAX_VALUE; i++) {
			String tmp = i+"";
			if(tmp.contains("666"))
				list.add(i);
			if(list.size() > N)
				break;
		}
		System.out.println(list.get(N-1));
	}
}
