//
//  boj2178.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 9..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <stdio.h>
#include <queue>

using namespace std;

int n, m;
int a[100][100];
bool check[100][100]; // 방문 확인
int dist[100][100]; // 거리값

int dx[] = {0, 1, 0, -1};
int dy[] = {-1, 0, 1, 0};

void bfs(int row, int col) {
	queue<pair<int, int>> q;
	q.push(make_pair(row, col));
	check[row][col] = true;
	dist[row][col] = 1;
	
	while(!q.empty()){
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		
		for(int i = 0 ; i < 4 ; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < m){
				if(check[nx][ny] == false && a[nx][ny] == 1){
					q.push(make_pair(nx, ny));
					dist[nx][ny] = dist[x][y] + 1;
					check[nx][ny] = true;
				}
			}
		}
	}
}

int main() {

	scanf("%d %d ", &n, &m);
	
	for(int i = 0 ; i < n ; i++){
		for(int j = 0 ; j < m ; j++){
			scanf("%1d", &a[i][j]);
		}
	}
	
	bfs(0,0);
	
	printf("%d\n", dist[n-1][m-1]);
	
	return 0;
}
*/
