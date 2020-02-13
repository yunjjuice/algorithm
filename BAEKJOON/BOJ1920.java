/*
 * BOJ 1920 ¼ö Ã£±â
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}
}
