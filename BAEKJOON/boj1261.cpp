//
//  boj1261.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 13..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <stdio.h>
#include <deque>

using namespace std;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int main() {
	int m, n;
	scanf("%d %d", &m, &n);
	
	int map[101][101];
	bool visit[101][101];
	int second[101][101];
	
	for(int i=0 ; i<n ; i++){
		for(int j=0 ; j<m ; j++){
			scanf("%1d",&map[i][j]);
		}
	}
	
	deque<pair<int, int>> dq;
	dq.push_back(make_pair(0, 0));
	second[0][0] = 0;
	visit[0][0] = true;
	
	while(!dq.empty()){
		int x = dq.front().first;
		int y = dq.front().second;
		dq.pop_front();
		
		for(int i=0 ; i<4 ; i++){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(0<=nx && nx<n && 0<=ny && ny<m){
				if(!visit[nx][ny]){
					if(map[nx][ny]==0){
						visit[nx][ny] = true;
						dq.push_front(make_pair(nx, ny));
						second[nx][ny] = second[x][y];
					}
					if(map[nx][ny]==1){
						visit[nx][ny] = true;
						dq.push_back(make_pair(nx, ny));
						second[nx][ny] = second[x][y] + 1;
					}
				}
			}
		}
	}
	
	printf("%d\n", second[n-1][m-1]);
	
	return 0;
}
*/
