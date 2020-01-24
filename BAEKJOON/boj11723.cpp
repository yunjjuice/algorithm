//
//  boj11723.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 2..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <iostream>

using namespace std;

int main() {
    int m; // 연산의 개수
    scanf("%d ", &m);
    
    int s = 0; // 집합
    
    while(m--) {
		char o[10];
        string opr;
        int tmp;
		
		scanf("%s", o);
		
		opr = o;
		
		scanf(" %d", &tmp);
		
        if(opr == "add") {
			s = s | (1 << (tmp-1));
        }
        else if(opr == "remove"){
			if((s & (1 << (tmp-1))) == 0){ // 이미 없다면 아무것도 안함
				
			}
			else {
				s = s & ~(1 << (tmp-1));
			}
				
        }
        else if(opr == "check"){
			if((s & (1 << (tmp-1))) == 0) { // 없으면
				cout << 0 << '\n';
			}
			else {
				cout << 1 << '\n';
			}
        }
        else if(opr == "toggle"){
			if((s & (1 << (tmp-1))) == 0){ // 없으면 추가
				s = s | (1 << (tmp-1));
			}
			else { // 있으면 제거
				s = s & ~(1 << (tmp-1));
			}
        }
        else if(opr == "all"){
			s = (1<<21) - 1;

        }
        else if(opr == "empty"){
			s = 0;
        }
    }
    
    return 0;
}
*/
