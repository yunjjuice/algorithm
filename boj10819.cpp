//
//  boj10819.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 9..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>
#include <vector>
#include <cstdlib>
#include <algorithm>

using namespace std;



int main() {
    int n;
	cin >> n;
	
	vector<int> a(n);
	
	for(int i = 0 ; i < n ; i++){
		
		cin >> a[i];
	}
	
	int ans = 0;
	
	sort(a.begin(), a.end());
	
	do{
		int tmp = 0;

		for(int i = 0 ; i < n-1 ; i++){
			tmp += abs(a[i]-a[i+1]);
		}
		if(tmp > ans)
			ans = tmp;
	}while(next_permutation(a.begin(), a.end()));
	
	cout << ans << '\n';
	
    return 0;
}
