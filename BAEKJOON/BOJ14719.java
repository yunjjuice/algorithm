/*
 * BOJ 14719 빗물
 * Gold 5
 * https://www.acmicpc.net/problem/14719
 */

import java.io.*;
import java.util.*;

public class BOJ14719 {
	static int H, W, left, right, sum;
	static int[] blocks;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		blocks = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < blocks.length; i++) {
			left = right = 0;
			
			for (int j = i; j >= 0; j--) {
				left = Math.max(blocks[j], left);
			}
			for (int j = i; j < blocks.length; j++) {
				right = Math.max(blocks[j], right);
			}
			
			sum += Math.abs(Math.min(left, right) - blocks[i]);
		}
		
		System.out.println(sum);
	}
}
