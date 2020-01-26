import java.util.Scanner;

public class SWEA2072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testCase = 1 ; testCase <= T ; testCase++){
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int tmp = sc.nextInt();
				if(tmp % 2 != 0){
					sum += tmp;
				}
			}
			System.out.println("#" + testCase + " " + sum);
		}
	}
}
