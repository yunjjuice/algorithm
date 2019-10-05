//
//  boj1592.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 5..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>

using namespace std;

int n, m, l;
//int count; // 공 던진 전체 횟수
int sik[1000]; // 공 받은 횟수 저장

void go(int index, int cnt) {
	//cnt++;
	
	if(sik[index] == m){
		cout << cnt <<'\n';
		return ;
	}
	else {
		cnt++;
		int ni;
		if(sik[index]%2 == 0) { // 짝수면 반시계방향으로 l번째 사람한테
			ni = (index+(n-l)) % n;
		}
		else { // 홀수면 시계방향으로 l번째 사람한테
			ni = (index+l) % n;
		}
		sik[ni] += 1;
		//cout << ni << " cnt: " << cnt << '\n';
		go(ni, cnt);
	}
}

int main() {
	cin >> n >> m >> l;
	int count = 0;
	sik[0] = 1;
	go(0, count);
	
	//cout << count <<'\n';
	
    return 0;
}
