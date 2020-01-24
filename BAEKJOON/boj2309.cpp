//
//  boj2309.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 23..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

/*
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    
    int h[9];
    int sum = 0;
    
    for (int i = 0 ; i < 9 ; i++){
        cin >> h[i];
        sum += h[i];
    }
    
    sort(h, h+9);
    
    for(int i = 0 ; i < 9 ; i++){
        for(int j = 0 ; j < 9 ; j++){
            if((sum-h[i]-h[j]) == 100){
                for(int k = 0 ; k < 9 ; k++){
                    if(k==i || k==j)
                        continue;
                    cout << h[k] << endl;
                }
                return 0;
            }
        }
    }
    return 0;
}
*/
