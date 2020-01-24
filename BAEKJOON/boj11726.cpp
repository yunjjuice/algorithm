//
//  boj11726.cpp
//  Algorithm
//
//  Created by 최윤주 on 29/10/2019.
//  Copyright © 2019 YUNJU. All rights reserved.
//
/*
#include <iostream>

using namespace std;

int d[1001];

int main() {
	int n;
	cin >> n;
	
	d[0] = 1;
	d[1] = 1;
	for(int i=2 ; i<=n; i++){
		d[i] = d[i-1] + d[i-2];
		d[i] %= 10007;
	}
	
	cout << d[n] << '\n';
	return 0;
}
*/
