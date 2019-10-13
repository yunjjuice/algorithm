//
//  boj1012.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 13..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <stdio.h>
#include <cstring>

using namespace std;

int t, n, m, k;
int map[50][50];
int visit[50][50];

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

void dfs(int x, int y) {
	for(int i=0 ; i<4 ; i++){
		int nx = x + dx[i];
		int ny = y + dy[i];
		if(0<=nx && nx<n && 0<=ny && ny<m){
			if(visit[nx][ny]==0 && map[nx][ny]==1){
				visit[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}

int main() {
	scanf("%d", &t);
	
	while(t--) {
		int worm = 0;
		
		scanf("%d %d %d", &m, &n, &k);
		
		memset(map, 0, sizeof(map));
		memset(visit, 0, sizeof(visit));
		
		while(k--){
			int x, y;
			scanf("%d %d", &x, &y);
			map[y][x] = 1;
		}
		
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<m ; j++){
				if(visit[i][j]==0 && map[i][j]==1){
					visit[i][j] = true;
					dfs(i, j);
					worm++;
				}
			}
		}
		
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<m ; j++){
				printf("%d ",visit[i][j]);
			}
			printf("\n");
		}
		
		printf("%d\n", worm);
		
	}
	return 0;
}
