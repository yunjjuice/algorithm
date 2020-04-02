/*
 * SWEA 9760 Poker Game
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA9760 {
	static int[] suitCnt;
	static int[] rankCnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC ; tc++) {
			sb.append('#').append(tc).append(' ');
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String[] card = new String[5];
			for (int i = 0; i < 5; i++) {
				card[i] = st.nextToken();
			}
//			System.out.println(Arrays.toString(card));
			
			suitCnt = new int[4];
			rankCnt = new int[13];
			// 수트 검사
			// 랭크 검사
			for (int i = 0; i < 5; i++) {
				char tmp = card[i].charAt(0);
				switch (tmp) {
					case 'S': suitCnt[0]++; break;
					case 'D': suitCnt[1]++; break;
					case 'H': suitCnt[2]++; break;
					case 'C': suitCnt[3]++; break;
				}
				char tmp2 = card[i].charAt(1);
				switch (tmp2) {
					case 'A': rankCnt[0]++; break;
					case '2': rankCnt[1]++; break;
					case '3': rankCnt[2]++; break;
					case '4': rankCnt[3]++; break;
					case '5': rankCnt[4]++; break;
					case '6': rankCnt[5]++; break;
					case '7': rankCnt[6]++; break;
					case '8': rankCnt[7]++; break;
					case '9': rankCnt[8]++; break;
					case 'T': rankCnt[9]++; break;
					case 'J': rankCnt[10]++; break;
					case 'Q': rankCnt[11]++; break;
					case 'K': rankCnt[12]++; break;
				}
			}
//			System.out.println(Arrays.toString(suitCnt));
//			System.out.println(Arrays.toString(rankCnt));
			
			check();
		}
		
		System.out.println(sb);
	}
	
	public static void check() {
//		1. Straight Flush : 모두 동일한 슈트에 랭크(값)가 모두 연속적이다(여기서는 로얄 플러쉬를 포함한다. 로얄 플러쉬는 모두 동일한 슈트에 T, J, Q, K, A를 갖는다).
//		4. Flush : 5장이 모두 동일한 슈트다.
		for (int i : suitCnt) {
			if (i == 5) {
				if(checkRank()) {
					sb.append("Straight Flush").append('\n');
					return;
				} else {
					sb.append("Flush").append('\n');
					return;
				}
			}
		}
		
//		2. Four of a Kind : 5장 중 4개의 랭크(값)가 모두 같다.
		for (int i : rankCnt) {
			if(i == 4){
				sb.append("Four of a Kind").append('\n');
				return;
			}
		}
		
//		3. Full House : 3장의 동일한 랭크(값)와 다른 랭크(값)의 동일한 2장으로 구성된다.
//		6. Three of a kind : 동일한 랭크(값)가 3장이다(1,2,3,3,3).
//		7. Two pair : 동일한 랭크(값) 2장씩 두개의 랭크다(2,6,6,3,3).
//		8. One pair : 동일한 랭크가 2장이다(2,4,5,5,7).
		int cnt2 = 0;
		int cnt3 = 0;
		for (int i : rankCnt) {
			if(i == 2)
				cnt2++;
			if(i == 3)
				cnt3++;
		}
		if(cnt2 == 1 && cnt3==1) {
			sb.append("Full House").append('\n');
			return;
		} else if(cnt3 == 1) {
			sb.append("Three of a kind").append('\n');
			return;
		} else if(cnt2 == 2) {
			sb.append("Two pair").append('\n');
			return;
		} else if(cnt2 == 1) {
			sb.append("One pair").append('\n');
			return;
		}
		
//		5. Straight : 다른 슈트가 섞여있으며 랭크(값)가 모두 연속적이다.
		if(checkRank()) {
			sb.append("Straight").append('\n');
			return;
		}
		
//		9. High card : 1~8번에 해당하지 않는다.  
		sb.append("High card").append('\n');
	}
	
	public static boolean checkRank() {
		int[] d = new int[13];
		for (int i = 1; i <= rankCnt.length; i++) {
			if(rankCnt[i%13] != 0) {
				if(rankCnt[i-1] != 0)
					d[i%13] = d[i-1] + 1;
			}
		}
		
//		System.out.println(Arrays.toString(d));
		
		for (int i : d) {
			if(i == 4) return true;
		}
		
		return false;
	}
}
