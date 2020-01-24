//
//  boj2206.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 13..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <iostream>
#include <queue>
#include <tuple>
#include <algorithm>

using namespace std;

int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};

int map[1001][1001];
int d[1001][1001][2]; // 0이면 벽 부순적 없다 1이면 있다

int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	
	for(int i=0 ; i<n ; i++){
		for(int j=0 ; j<m ; j++){
			scanf("%1d", &map[i][j]);
		}
	}
	
	queue<tuple<int, int, int>> q;
	q.push(make_tuple(0, 0, 0));
	d[0][0][0] = 1;
	
	while(!q.empty()){
		int x, y, z;
		tie(x, y, z) = q.front();
		q.pop();
		
		for(int i=0 ; i<4 ; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=m)
				continue;
			// 벽을 부실 수 있는 경우
			if(z==0 && map[nx][ny]==1 && d[nx][ny][z+1]==0){
				q.push({nx, ny, z+1});
				d[nx][ny][z+1] = d[x][y][z] + 1;
			}
			// 벽을 부시지 않아도 될 경우
			if(map[nx][ny]==0 && d[nx][ny][z]==0){
				q.push({nx, ny, z});
				d[nx][ny][z] = d[x][y][z] + 1;
			}
		}
	}
	
	if(d[n-1][m-1][0] != 0 && d[n-1][m-1][1])
		printf("%d\n", min(d[n-1][m-1][0], d[n-1][m-1][1]));
	else if(d[n-1][m-1][0] != 0)
		printf("%d\n", d[n-1][m-1][0]);
	else if(d[n-1][m-1][1] != 0)
		printf("%d\n", d[n-1][m-1][1]);
	else
		printf("-1\n");
	
	return 0;
}
*/
