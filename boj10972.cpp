//
//  boj10972.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 27..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
	cin >> n;
	
	vector<int> a(n);
	
	for(int i = 0 ; i < n ; i++){
		cin >> a[i];
	}
	
	if(next_permutation(a.begin(), a.end())){
		for(int i = 0 ; i < n ; i++){
			cout << a[i] << " ";
		}
	} else
		cout << "-1";

	return 0;
}
