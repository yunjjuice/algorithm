//
//  boj14226.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 11..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <stdio.h>
#include <queue>
#include <cstring>

using namespace std;

int d[1001][1001]; // 이모티콘 개수, 클립보드 개수

int main() {
	
	int s;
	scanf("%d", &s);
	
	memset(d, -1, sizeof(d));
	
	queue<pair<int, int>> q;
	q.push(make_pair(1, 0)); // 처음에 1개가 입력되어 있고 클립보드는 비어있음
	d[1][0] = 0;
	
	while(!q.empty()){
		int e = q.front().first; // 이모티콘
		int c = q.front().second; // 클립보드
		q.pop();
		
		if(d[e][e] == -1){ // 클립보드에 저장
			d[e][e] = d[e][c] + 1;
			q.push(make_pair(e, e));
		}
		if(e+c <= s && d[e+c][c] == -1) { // 붙여넣기
			d[e+c][c] = d[e][c] + 1;
			q.push(make_pair(e+c, c));
		}
		if(e-1 >= 0 && d[e-1][c] == -1) { // 삭제
			d[e-1][c] = d[e][c] + 1;
			q.push(make_pair(e-1, c));
		}
	}
	
	int ans = -1;
	
	for(int i = 0 ; i <= s ; i++){
		if(d[s][i] != -1){
			if(ans == -1 || ans > d[s][i])
				ans = d[s][i];
		}
	}
	
	printf("%d\n", ans);
	
	return 0;
}
*/
