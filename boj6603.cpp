//
//  boj6603.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 30..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>
#include <vector>

using namespace std;

vector<int> lotto;

void solution(vector<int> a, int index, int count) {

	if(count == 6){
		for(int num : lotto){
			cout << num << ' ';
		}
		cout << '\n';
		return;
	}
	
	unsigned long n = a.size();
	if(n == index)
		return;
	
	lotto.push_back(a[index]);
	solution(a, index+1, count+1);
	lotto.pop_back();
	
	solution(a, index+1, count);
}

int main() {
	
	while(true){
		int k;
		cin >> k;
		
		if(k==0) break;
		
		vector<int> a(k);
		
		for(int i = 0 ; i < k ; i++){
			cin >> a[i];
		}
		solution(a, 0, 0);
		cout << '\n';
	}
	
    return 0;
}
