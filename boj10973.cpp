//
//  boj10973.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 9..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    
    int n;
    cin >> n;
    
    vector<int> v(n);
    
    for(int i = 0 ; i < n ; i++){
        cin >> v[i];
    }
    
    if(prev_permutation(v.begin(), v.end())){
        for(int i = 0 ; i < n ; i++){
            cout << v[i] << ' ';
        }
        cout << '\n';
    }
    else
        cout << -1 << '\n';
    
    return 0;
}
