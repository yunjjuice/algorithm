//
//  boj15649.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 17..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>

using namespace std;

int a[10]; // 정답을 넣는 배열
int check[10];
int n, m;

void solution(int index){
	if(index == m){
		for(int i=0 ; i<m ; i++){
			cout << a[i];
			if(i != m-1) // 맨 마지막 숫자 아니면 띄어쓰기
				cout << ' ';
		}
		cout << '\n';
		return;
	}
	
	for(int i=1 ; i<=n ; i++){
		if(check[i])
			continue;
		check[i] = true;
		a[index] = i;
		solution(index+1);
		check[i] = false;
	}
}

int main() {
	cin >> n >> m;
	solution(0);
	
	return 0;
}
