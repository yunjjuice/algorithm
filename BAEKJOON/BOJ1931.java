/*
 * BOJ 1931 회의실배정
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MeetingRoom {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] t = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			t[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			t[i][1] = Integer.parseInt(st.nextToken()); // 끝 시간
		}
		
		// 종료시간을 기준으로 정렬한다
//		for (int i = 0; i < t.length-1; i++) {
//			for (int j = i+1; j < t.length; j++) {
//				if(t[i][1] > t[j][1]) {
//					int tmp = t[i][0];
//					t[i][0] = t[j][0];
//					t[j][0] = tmp;
//					
//					tmp = t[i][1];
//					t[i][1] = t[j][1];
//					t[j][1] = tmp;
//				}
//			}
//		}
		Arrays.sort(t, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
		});
		
//		for (int i = 0; i < t.length; i++) {
//			System.out.println(Arrays.toString(t[i]));
//		}
		
		int count = 0;
		int time = -1;
		for (int i = 0; i < n; i++) {
			if(t[i][0] >= time) {
				count++;
				time = t[i][1]; // 종료시간으로 저장
//				System.out.println(time);
			}
		}
		System.out.println(count);
	}
}
