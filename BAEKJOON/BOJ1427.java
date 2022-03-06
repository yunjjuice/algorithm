/*
 * BOJ 1427 소트인사이드
 * Silver 5
 * https://www.acmicpc.net/problem/1427
 */

import java.io.*;
import java.util.*;

public class BOJ1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		char[] strArr = str.toCharArray();
		Arrays.sort(strArr);
		
		StringBuilder sb = new StringBuilder();
		for (int i = strArr.length - 1; i >= 0; i--) {
			sb.append(strArr[i]);
		}
		System.out.println(sb);
	}
}
