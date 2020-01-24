//
//  boj17142.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 11..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <stdio.h>
#include <queue>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

int a[50][50];
int check[50][50]; // 걸리는 시간 저장
int minSec = 987654321;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int main() {
	
	int n, m; // 연구소 크기 n, 활성시킬 바이러스 수 m
	scanf("%d %d", &n, &m);

	vector<pair<int, int>> v; // 조합을 위한 변수
	
	int empty = 0; // 빈칸의 개수
	for(int i = 0 ; i < n ; i++){
		for(int j = 0 ; j < n ; j++){
			scanf(" %d", &a[i][j]);
			if(a[i][j] == 2){ // 0빈칸 1벽 2바이러스
				v.push_back(make_pair(i, j));
			}
			if(a[i][j] == 0){
				empty++;
			}
		}
	}

	// 조합한 뒤 큐에 넣어주고 bfs 돌리기
	vector<int> index;
	for(int i = 0 ; i < m ; i++){
		index.push_back(1);
	}
	for(int i = 0 ; i < v.size()-m ; i++){
		index.push_back(0);
	}
	sort(index.begin(), index.end());

	vector<int> c; // 각 조합별로 걸린 시간들을 저장해놓는 벡터
	
	do{
		queue<pair<int, int>> q;
		memset(check, -1, sizeof(check));
		int tmp_e = empty;

		for(int i = 0 ; i < index.size() ; i++){
			if(index[i] == 1){
				int x = v[i].first;
				int y = v[i].second;
				check[x][y] = 0;
				q.push(make_pair(x, y));
			}
		}
		
		while(!q.empty()){
			int x = q.front().first;
			int y = q.front().second;
			q.pop();
			
			for(int i = 0 ; i < 4 ; i++){
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<n){
					if(a[nx][ny]==0 && check[nx][ny]==-1){
						check[nx][ny] = check[x][y] + 1;
						q.push(make_pair(nx, ny));
						tmp_e--;
					}
					if(a[nx][ny]==2 && check[nx][ny]==-1 && tmp_e>0){
						check[nx][ny] = check[x][y] + 1;
						q.push(make_pair(nx, ny));
					}
				}
			}
		}
		
		int tmp = 0;
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				//printf("%d ", check[i][j]);
				if(check[i][j]>tmp)
					tmp = check[i][j];
			}
			//printf("\n");
		}
		//printf("\n");
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(a[i][j]==0 && check[i][j]==-1)
					tmp = -1;
			}
		}
		
		c.push_back(tmp);
		//printf("%d ", tmp);

	} while(next_permutation(index.begin(), index.end()));
	
	sort(c.begin(), c.end());
	
	int count = 0;
	for(int i=0 ; i<c.size() ; i++){
		//printf("%d ", c[i]);
		if(c[i] == -1)
			count++;
	}
	//printf("\n%d\n", c.size());
	
	if(count==c.size())
		minSec = -1;
	else {
		for(int i=0 ; i<c.size() ; i++){
			if(c[i] != -1){
				minSec = c[i];
				break;
			}
		}
	}

	printf("%d\n", minSec);
	
	return 0;
}
*/
