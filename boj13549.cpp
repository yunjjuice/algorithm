//
//  boj13549.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 13..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <stdio.h>
#include <deque>

using namespace std;

int main() {
	bool visit[100001];
	int second[100001];
	
	int n, k; // n수빈이 k동생
	scanf("%d %d", &n, &k);
	
	visit[n] = true;
	second[n] = 0;
	
	deque<int> dq;
	dq.push_back(n);
	
	while(!dq.empty()){
		int x = dq.front();
		dq.pop_front();
		if(x*2 < 100001 && !visit[x*2]){
			int nx = x*2;
			visit[nx] = true;
			dq.push_front(nx);
			second[nx] = second[x];
		}
		if(x-1 >=0 && x-1<100001 && !visit[x-1]){
			int nx = x-1;
			visit[nx] = true;
			dq.push_back(nx);
			second[nx] = second[x] + 1;
		}
		if(x+1<100001 && !visit[x+1]){
			int nx = x+1;
			visit[nx] = true;
			dq.push_back(nx);
			second[nx] = second[x] + 1;
		}
	}
	
	printf("%d\n", second[k]);
	
	return 0;
}
