import java.util.Scanner;

public class JUNGOL1175 {
	static int N, M;
	static int[] dice = {1, 2, 3, 4, 5, 6};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 주사위 던진 횟수
		M = sc.nextInt(); // 만들고자 하는 눈의 합
		sum(0, 0);
	}

	static int[] tmp = new int[7]; // 주사위던진 횟수 2<=N<=7

	static void sum(int cnt, int amount) { // 주사위 던진 횟수, 합
		if (cnt == N) {
			if (amount == M) {
				for (int i = 0; i < N; i++) {
					System.out.print(tmp[i] + " ");
				}
				System.out.println();
				return;
			} else {
				return;
			}
		} else {
			for (int i = 0; i < dice.length; i++) {
				tmp[cnt] = dice[i];
				sum(cnt+1, amount+dice[i]);
			}
		}
	}
}
