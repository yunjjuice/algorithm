//
//  boj1182.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 30..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>

using namespace std;

int n, s;
int a[20];
int ans = 0;

void solution(int index, int sum) {

	if(index == n){
		if(sum == s){
			ans += 1;
		}
		return ;
	}
	
	solution(index+1, sum+a[index]);
	solution(index+1, sum);
}

int main() {
	cin >> n >> s;
	
	for(int i = 0 ; i < n ; i++){
		cin >> a[i];
	}
	
	solution(0, 0);
	
	if(s==0) // 공집합 제외
		ans -= 1;
	
	cout << ans << '\n';
}
