/*
 * BOJ 7785 회사에 있는 사람
 * Silver 5
 * https://www.acmicpc.net/problem/7785
 */

import java.util.*;
import java.io.*;

public class BOJ7785 {
	static int n;
	static HashSet<String> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		set = new HashSet<>();
		String name, status;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			status = st.nextToken();
			if (status.equals("enter")) {
				set.add(name);
			} else if (status.equals("leave")) {
				set.remove(name);
			}
		}
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (int i = list.size()-1; i >= 0; i--) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.println(sb);
	}
}
