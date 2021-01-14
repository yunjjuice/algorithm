/*
 * BOJ 4358 생태학
 * Gold 4
 * https://www.acmicpc.net/problem/4358
 */

import java.util.*;
import java.io.*;

public class BOJ4358 {
	static TreeMap<String, Integer> map = new TreeMap<>();
	static int totalCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while (true) {
			totalCnt++;
			map.put(str, map.getOrDefault(str, 0) + 1);
			str = br.readLine();
			if (str == null || str.length() == 0) break;
		}

		StringBuilder sb = new StringBuilder();
		for (String key : map.keySet()) {
			float res = (float)map.get(key)/(float)totalCnt * 100;
			String s = String.format("%.4f", res);
			sb.append(key).append(' ').append(s).append('\n');
		}
		
		System.out.println(sb);
	}
}
