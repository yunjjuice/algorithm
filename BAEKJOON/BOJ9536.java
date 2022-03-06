/*
 * BOJ 9536 여우는 어떻게 울지?
 * Silver 4
 * https://www.acmicpc.net/problem/9536
 */

import java.io.*;
import java.util.*;

public class BOJ9536 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			List<String> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
			
			String str = br.readLine();
			while (!str.contains("what does the fox say?")) {
				String[] animal = str.split(" ");
				String sound = animal[2];
				while (list.contains(sound)) {
					list.remove(sound);
				}
				
				str = br.readLine();
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i)).append(' ');
			}
			System.out.println(sb);
		}
	}
}
