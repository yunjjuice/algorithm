
/*
 * 프로그래머스 가장 먼 노드 레벨3
 */

import java.util.*;

public class Programmers_Lv3_가장먼노드 {
	public static void main(String[] args) {
		int[][] arr = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6, arr));
	}

	public static int solution(int n, int[][] edge) { // n : 노드 개수
		int answer = 0;
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		boolean[] visited = new boolean[n];
		int[] count = new int[n];
		
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edge.length; i++) {
			int a = edge[i][0] - 1;
			int b = edge[i][1] - 1;
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
//		System.out.println(list);
		
		Queue<Integer> q = new LinkedList<Integer>();
		visited[0] = true;
		q.offer(0);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int v : list.get(cur)) {
				if(!visited[v]){
					count[v] = count[cur] + 1;
					visited[v] = true;
					q.offer(v);
				}
			}
		}
		
//		System.out.println(Arrays.toString(count));
		
		int max = count[0];
		for (int i = 0; i < count.length; i++) {
			if(max < count[i]) {
				max = count[i];
				answer = 1;
			} else if(max == count[i]){
				answer++;
			}
		}
		
		return answer;
	}
}
