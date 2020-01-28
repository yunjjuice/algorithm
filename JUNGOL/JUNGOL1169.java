import java.util.Scanner;

/**
 * 1169 주사위 던지기1
 */

public class JUNGOL1169 {
	static int[] dice = { 1, 2, 3, 4, 5, 6 };
	static int N, M;
	static int[] tmp = new int[5]; // 주사위 던진 횟수 최대 5번

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		if (M == 1) {
			m1(0);
		}
		else if (M == 2) {
			m2(0, 0);
		}
		else if (M == 3) {
			m3(0, 0);
		}
	}

	// M = 1 : 주사위를 N번 던져서 나올 수 있는 모든 경우
	// M = 2 : 주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우
	// M = 3 : 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우

	static void m1(int cnt) { // 뽑은 개수
		if (cnt == N) {
			for (int i = 0; i < cnt; i++) {
				System.out.print(tmp[i] + " ");
			}
			System.out.println();
			return;
		}
		else {
			for (int i = 0; i < dice.length; i++) {
				tmp[cnt] = dice[i];
				m1(cnt + 1);
			}
		}
	}

	static void m2(int cnt, int index) { // 뽑은 개수, 시작 index
		if (cnt == N) {
			for (int i = 0; i < cnt; i++) {
				System.out.print(tmp[i] + " ");
			}
			System.out.println();
			return;
		}
		else {
			for (int i = index; i < dice.length; i++) {
				tmp[cnt] = dice[i];
				if (tmp[cnt] <= dice[i])
					m2(cnt + 1, i);
			}
		}
	}

	static boolean[] check = new boolean[6]; // 숫자 1~6까지
	static void m3(int cnt, int index) { // 뽑은 개수, 시작 index
		if(cnt == N){
			for (int i = 0; i < cnt; i++) {
				System.out.print(tmp[i] + " ");
			}
			System.out.println();
			return;
		}
		else {
			for (int i = 0; i < dice.length; i++) {
				if(check[i] == true)
					continue;
				tmp[cnt] = dice[i];
				check[i] = true;
				m3(cnt+1, i);
				check[i] = false;
			}
		}
	}
}