//
//  boj17140.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 5..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

int a[101][101];
int temp[101];

int main() {
	
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
	
	int r, c, k;
	cin >> r >> c >> k;
	
	int n = 3, m = 3; // 행, 열
	
	for(int i = 1 ; i <= n ; i ++){
		for(int j = 1 ; j <= m ; j++){
			cin >> a[i][j];
		}
	}
	
	int second = 0;
	
	while(second <= 100) {
		
		if(a[r][c] == k){
			cout << second << '\n';
			return 0;
		}

		if(n >= m){ // R 연산
			int maxSize = 0;
			
			for(int i = 1 ; i <= n ; i++){
				memset(temp, 0, sizeof(temp));
				vector<pair<int, int>> vp;

				for(int j = 1 ; j <= m ; j++){
					temp[a[i][j]]++;
				}
				for(int j = 1 ; j <= 100 ; j ++){
					if(temp[j] > 0){ // 0의 개수는 세지 않는다
						vp.push_back(make_pair(temp[j], j)); // 수의 개수, 수
					}
				}
				sort(vp.begin(), vp.end()); // 수의 개수를 준으로 정렬한다
					
				vector<int> v;
				for(auto x:vp){
					v.push_back(x.second); // 수를 먼저 넣고
					v.push_back(x.first); // 그 수의 개수를 넣어야 함
				}
				
				// 벡터에 있는 거 배열에 옮기기
				if(v.size() > maxSize){
					if(v.size() >= 100) // 100보다 크면 100이 최대
						maxSize = 100;
					else
						maxSize = v.size();
					
					int len = maxSize;
					for(int j = 1 ; j <= len ; j++){
						a[i][j] = v[j-1];
					}
					for(int j = len+1 ; j <= 100 ; j ++){
						a[i][j] = 0;
					}
				}
				else {
					int len = v.size();
					for(int j = 1 ; j <= len ; j++){
						a[i][j] = v[j-1];
					}
					for(int j = len+1 ; j <= 100 ; j ++){
						a[i][j] = 0;
					}
				}
			}
			m = maxSize;
		}
		else { // C 연산
			int maxSize = 0;
			
			for(int i = 1 ; i <= m ; i++){
				memset(temp, 0, sizeof(temp));
				vector<pair<int, int>> vp;

				for(int j = 1 ; j <= n ; j++){
					temp[a[j][i]]++;
				}
				for(int j = 1 ; j <= 100 ; j ++){
					if(temp[j] > 0){ // 0의 개수는 세지 않는다
						vp.push_back(make_pair(temp[j], j));
					}
				}
				sort(vp.begin(), vp.end());
				
				vector<int> v;
				for(auto x:vp){
					v.push_back(x.second);
					v.push_back(x.first);
				}
				
				// 벡터에 있는 거 배열에 옮기기
				if(v.size() > maxSize){
					if(v.size() >= 100) // 100보다 크면 100이 최대
						maxSize = 100;
					else
						maxSize = v.size();
					
					int len = maxSize;
					for(int j = 1 ; j <= len ; j++){
						a[j][i] = v[j-1];
					}
					for(int j = len+1 ; j <= 100 ; j ++){
						a[j][i] = 0;
					}
				}
				else {
					int len = v.size();
					for(int j = 1 ; j <= len ; j++){
						a[j][i] = v[j-1];
					}
					for(int j = len+1 ; j <= 100 ; j ++){
						a[j][i] = 0;
					}
				}
			}
			n = maxSize;
		}
		second++;
	}
	
	cout << -1 << '\n';
	return 0;
}
*/
