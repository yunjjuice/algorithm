//
//  boj15685.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 20..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

/*
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int dir[4] = {0, 1, 2, 3};
int x_dir[4] = {1, 0, -1, 0};
int y_dir[4] = {0, -1, 0, 1};

int rotate(int d) {
	stack<int> s;
	stack<int> tmp;
	
	s.push(d);
	
	if(!s.empty()){
		int t = s.top();
		s.pop();
		tmp.push(dir[t+1]);
	}
	
	return 0;
}

int main() {
    int n;
    scanf("%d", &n);
    
    // d는 방향 : 0 우->, 1 아래, 2 좌<-, 3 위
    int x, y, d, g;
    
    for(int i = 0 ; i < n ; i++){
        scanf("%d %d %d %d ", &x, &y, &d, &g);
		rotate(d);
    }
    return 0;
}
*/
