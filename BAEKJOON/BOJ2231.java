package algorithmStudy;

import java.util.Scanner;

public class BOJ2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = 0;
		
		int tmp = 0;
		
		// i가 확인해볼 수가 되는 것
		for (int i = 0; i < N; i++) {
			tmp = i;
			int a = i; // while문을 돌면서 각 자리수에 있는 수를 뺄 것
			int length = (int)(Math.log10(i)+1);
			int jari = (int) Math.pow(10, length);
			
			while ((jari /= 10) >= 1) {
				//System.out.println("j : " + jari);
				tmp += (a/jari);
				a -= ((a/jari)*jari);
			}

			if (tmp == N) {
				M = i;
				break;
			}
		}
		
		System.out.println(M);
	}
}
