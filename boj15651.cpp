//
//  boj15651.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 18..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>

using namespace std;

int a[10];
int n, m;

void solution(int index){
	if(index == m){
		for(int i=0 ; i<m ; i++){
			cout << a[i];
			if(i != m-1)
				cout <<' ';
		}
		cout << '\n';
		return;
	}
	
	for(int i=1 ; i<=n ; i++){
		a[index] = i;
		solution(index+1);
	}
}

int main() {
	cin >> n >> m;
	solution(0);
	return 0;
}
