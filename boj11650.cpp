//
//  boj11650.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 4..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    vector<pair<int, int>> v;
    
    cin >> n;
    
    for(int i = 0 ; i < n ; i++){
        int a, b;
        cin >> a >> b;
        v.push_back(make_pair(a, b));
    }
    
    sort(v.begin(), v.end());
    
    for(int i = 0 ; i < n ; i++){
        cout << v[i].first << " " << v[i].second << "\n";
    }
    
    return 0;
}
