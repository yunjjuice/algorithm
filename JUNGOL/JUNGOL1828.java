/*
 * JUNGOL 1828 냉장고
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1828 {
	static int N;
	static int[][] chemi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		chemi = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			chemi[i][0] = Integer.parseInt(st.nextToken()); // 최저점
			chemi[i][1] = Integer.parseInt(st.nextToken()); // 최고점
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(chemi[i]));
//		}
		
		for (int i = chemi.length-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if(chemi[j][1] > chemi[j+1][1]) { // 큰 걸 뒤로 보내준다
					int tmp = chemi[j][0];
					chemi[j][0] = chemi[j+1][0];
					chemi[j+1][0] = tmp;
					
					tmp = chemi[j][1];
					chemi[j][1] = chemi[j+1][1];
					chemi[j+1][1] = tmp;
				}
			}
		}
	
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(chemi[i]));
//		}
		
		int count = 1; // 냉장고 개수
		
		int max = chemi[0][1];
		for (int i = 1; i < chemi.length; i++) {
			if(chemi[i][0] > max){
				count++;
				max = chemi[i][1];
			}
		}
		
		System.out.println(count);
	}
}