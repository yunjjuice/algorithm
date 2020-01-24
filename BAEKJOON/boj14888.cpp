//
//  boj14888.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 1..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


pair<int, int> calc(vector<int> &a, int index, int cur, int plus, int minus, int mul, int div) {
	
	unsigned long n = a.size();
	
	if(index == n)
		return(make_pair(cur, cur));
	
	vector<pair<int, int>> tmp;
	
	if(plus > 0)
		tmp.push_back(calc(a, index+1, cur+a[index], plus-1, minus, mul, div));
	
	if(minus > 0)
		tmp.push_back(calc(a, index+1, cur-a[index], plus, minus-1, mul, div));
	
	if(mul > 0)
		tmp.push_back(calc(a, index+1, cur*a[index], plus, minus, mul-1, div));
	
	if(div > 0)
		tmp.push_back(calc(a, index+1, cur/a[index], plus, minus, mul, div-1));
	
	auto ans = tmp[0];
	
	for(auto p : tmp){
		if(ans.first < p.first)
			ans.first = p.first;
		if(ans.second > p.second)
			ans.second = p.second;
	}
	
	return ans;
	
}

int main() {
	
	int n;
	cin >> n;
	
	vector<int> a(n);
	
	for(int i = 0 ; i < n ; i++){
		cin >> a[i];
	}
	
	int plus, minus, mul, div;
	cin >> plus >> minus >> mul >> div;
	
	auto ans = calc(a, 1, a[0], plus, minus, mul, div);
	
	cout << ans.first << '\n';
	cout << ans.second << '\n';
}
*/
