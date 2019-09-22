//
//  boj1476.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 23..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>

using namespace std;

int main() {
    int e, s, m;
    int ee(0), ss(0), mm(0);
    int year = 0;
    
    cin >> e >> s >> m;
    
    while(1) {
        
        if(ee==e && ss==s && mm==m){
            cout << year;
            return 0;
        }
        
        ee++;
        ss++;
        mm++;
        year++;
        if(ee==16)
            ee=1;
        if(ss==29)
            ss=1;
        if(mm==20)
            mm=1;
        
    }
    return 0;
}
