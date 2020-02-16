/*
 * JUNGOL 1863 Á¾±³
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1863 {
	static int n, m;
	public static int[] p;
	public static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		rank = new int[n+1];
		
		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		int count = 0;
//		System.out.println(Arrays.toString(p));
//		System.out.println(Arrays.toString(rank));
		for (int i = 1; i < rank.length; i++) {
			if(i == p[i])
				count++;
		}
		System.out.println(count);
	}
	
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px != py) {
			link(px, py);
		}
	}
	
	public static void link(int px, int py) {
		if(rank[px] > rank[py]) {
			p[py] = px;
		} else {
			p[px] = py;
			if(rank[px] == rank[py])
				rank[py]++;
		}
	}

	public static int findSet(int x) {
		if(p[x] == x) {
			return x;
		} else {
			p[x] = findSet(p[x]);
			return p[x];
		}
	}
}