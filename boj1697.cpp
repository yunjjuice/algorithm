//
//  boj1697.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 10..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <stdio.h>
#include <queue>

using namespace std;

int main() {
	
	int n, k;
	bool check[100001]; // 방문표시
	int second[100001]; // 걸린 시간
	
	scanf("%d %d", &n, &k);
	check[n] = true;
	second[n] = 0;
	
	queue<int> q;
	q.push(n);
	
	while(!q.empty()){
		int x = q.front();
		q.pop();
		
		if(x-1 >= 0){
			if(check[x-1] == false){
				check[x-1] = true;
				second[x-1] = second[x] + 1;
				q.push(x-1);
			}
		}
		if(x+1 < 100001){
			if(check[x+1] == false){
				check[x+1] = true;
				second[x+1] = second[x] + 1;
				q.push(x+1);
			}
		}
		if(x*2 < 100001){
			if(check[x*2] == false){
				check[x*2] = true;
				second[x*2] = second[x] + 1;
				q.push(x*2);
			}
		}
	}
	printf("%d\n", second[k]);
	
	return 0;
}
