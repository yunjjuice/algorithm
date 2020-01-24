//
//  boj1759.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 29..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool check(string pw){
    int ja = 0;
    int mo = 0;
    
    for(char x : pw){
        if(x=='a' || x=='i' || x=='u' || x=='e' || x=='o')
            mo++;
        else
            ja++;
    }
    
    if(ja>=2 && mo>=1)
        return true;
    else
        return false;
}

void solution(int l, vector<char> alpha, string pw, int i){
    if(pw.length() == l){
        if(check(pw)){
            cout << pw << '\n';
        }
        return;
    }
    
    if(i >= alpha.size()) // 불가능한 경우
        return;

    solution(l, alpha, pw+alpha[i], i+1); // 다음에 문자를 붙일때
    solution(l, alpha, pw, i+1); // 안붙일때

}

int main() {
    int l, c;
    cin >> l >> c;
    
    vector<char> alpha;
    
    for(int i = 0 ; i < c ; i++){
        char tmp;
        cin >> tmp;
        alpha.push_back(tmp);
    }
    
    sort(alpha.begin(), alpha.end());
    
    solution(l, alpha, "", 0);
    
    return 0;
}
*/
