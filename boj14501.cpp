//
//  boj14501.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 30..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>

using namespace std;

int n;
int t[15];
int p[15]; // 걸리는 기간 t, 비용 p
int ans = 0;

void solution(int day, int sum){
	
	if(day == n) { // 퇴사 날짜가 되면
		if(sum > ans) {
			ans = sum;
		}
		return;
	}
	
	if(day > n) {// 퇴사 날짜를 넘긴다면
		return;
	}
	
	solution(day+t[day], sum+p[day]);
	solution(day+1, sum);
	
	return;
}

int main() {

	cin >> n;
	
	for(int i = 0 ; i < n ; i++){
		cin >> t[i] >> p[i];
	}
	
	solution(0, 0);
	
	cout << ans << '\n';
	
    return 0;
}
