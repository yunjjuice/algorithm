//
//  boj3055.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 14..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <stdio.h>
#include <queue>
#include <cstring>

using namespace std;

char map[50][50];
int water[50][50];
int dist[50][50];

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main() {

	int r, c;
	scanf("%d %d", &r, &c);
	
	memset(water, -1, sizeof(water));
	memset(dist, -1, sizeof(dist));
	queue<pair<int, int>> qw;
	queue<pair<int, int>> qs;
	pair<int, int> dest;
	
	for(int i=0 ; i<r ; i++){
		for(int j=0 ; j<c ; j++){
			scanf(" %c", &map[i][j]);
			if(map[i][j] == '*'){
				water[i][j] = 0;
				qw.push(make_pair(i, j));
			}
			if(map[i][j] == 'S'){
				dist[i][j] = 0;
				qs.push(make_pair(i, j));
			}
			if(map[i][j] == 'D')
				dest = make_pair(i, j);
		}
	}
	
	// 물이 차는 시간을 먼저 구한다
	while(!qw.empty()){
		int x = qw.front().first;
		int y = qw.front().second;
		qw.pop();
		for(int k=0 ; k<4 ; k++){
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx<0 || nx>=r || ny<0 || ny>=c)
				continue;
			if(map[nx][ny] == 'D' || map[nx][ny] == 'X' || water[nx][ny] != -1)
				continue;
			water[nx][ny] = water[x][y] + 1;
			qw.push(make_pair(nx, ny));
		}
	}

	// 고슴도치가 움직인다
	while(!qs.empty()){
		int x = qs.front().first;
		int y = qs.front().second;
		qs.pop();
		for(int k=0 ; k<4 ; k++){
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx<0 || nx>=r || ny<0 || ny>=c)
				continue;
			if(map[nx][ny] == 'X')
				continue;
			if(dist[nx][ny] != -1)
				continue;
			if(water[nx][ny] != -1 && dist[x][y]+1 >= water[nx][ny])
				continue;
			dist[nx][ny] = dist[x][y] + 1;
			qs.push(make_pair(nx, ny));
		}
	}

	if(dist[dest.first][dest.second] == -1){
		printf("KAKTUS\n");
	}
	else{
		printf("%d\n", dist[dest.first][dest.second]);
	}
	
	return 0;
}
*/
