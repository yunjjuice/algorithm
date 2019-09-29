//
//  boj9095.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 27..
//  Copyright © 2019년 YUNJU. All rights reserved.
//


#include <iostream>

using namespace std;

int solution(int sum, int goal){
	
	if(sum > goal)
		return 0;
	if(sum == goal)
		return 1;
	
	int tmp = 0;
	for(int i = 1 ; i <= 3 ; i++){
		tmp += solution(sum+i, goal);
	}
	
	return tmp;
}

int main() {
    
    int t;
	cin >> t;
	
	int a[t];
	
	int sum = 0;
	int count;
	
	for(int i = 0 ; i < t ; i++){
		count = 0;
		cin >> a[i];
		count = solution(sum, a[i]);
		cout << count << "\n";
	}
}
