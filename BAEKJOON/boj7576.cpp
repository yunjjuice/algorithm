//
//  boj7576.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 9..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <stdio.h>
#include <queue>
#include <vector>

using namespace std;

int box[1000][1000];
int day[1000][1000]; // 걸린 일수 저장용

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, -1, 0, 1};

int main() {
	int n, m;
	scanf("%d %d", &m, &n);
	
	queue<pair<int, int>> q;
	
	for(int i = 0 ; i < n ; i++){
		for(int j = 0 ; j < m ; j++){
			scanf("%d", &box[i][j]);
			day[i][j] = -1;
			if(box[i][j] == 1){
				q.push(make_pair(i, j));
				day[i][j] = 0; // 익어있다!
			}
		}
	}
	
	while(!q.empty()){
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		
		for(int i = 0 ; i < 4 ; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < m){
				if(box[nx][ny] == 0 && day[nx][ny] == -1){ // 아직 안 익었으면
					day[nx][ny] = day[x][y] + 1;
					q.push(make_pair(nx, ny));
				}
			}
		}
	}
	
	int ans = 0;
	
	for(int i = 0 ; i < n ; i++){
		for(int j = 0 ; j < m ; j++){
			if(ans < day[i][j]){
				ans = day[i][j];
			}
		}
	}
	
	for(int i = 0 ; i < n ; i++){
		for(int j = 0 ; j < m ; j++){
			if(box[i][j] == 0 && day[i][j] == -1){
				ans = -1;
			}
		}
	}
	
	printf("%d\n", ans);
	
	return 0;
}
*/
