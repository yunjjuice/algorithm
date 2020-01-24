//
//  boj10971.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 9..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int w[10][10]; // 비용

int main() {
	
	int n;
	cin >> n;
	
	for(int i = 0 ; i < n ; i++){
		for(int j = 0 ; j < n ; j++){
			cin >> w[i][j];
		}
	}
	
	vector<int> d(n); // 경로
	
	for(int i = 0 ; i < n ; i++)
		d[i] = i;
	
	int cost = 2147483647;
	
	do{
		bool isZero = false;
		int sum = 0;
		for(int i = 0 ; i < n-1 ; i++){
			if(w[d[i]][d[i+1]] == 0)
				isZero = true;
			else
				sum += w[d[i]][d[i+1]];
		}
		if(!isZero && w[d[n-1]][d[0]] != 0){
			sum += w[d[n-1]][d[0]];
			if(sum < cost)
				cost = sum;
		}
	} while(next_permutation(d.begin(), d.end()));
	
	cout << cost << '\n';
	
	return 0;
}
*/
