//
//  boj4963.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 21..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>

using namespace std;

int map[51][51] = {0};
int check[51][51] = {0};

int dx[8] = {-1, 0, 1, -1, 1, -1, 0, 1}; // 자기 자신의 좌표는 제외
int dy[8] = {-1, -1, -1, 0, 0, 1, 1, 1};

void solution(int x, int y) {
	
	check[x][y] = 1;
	
	int nx, ny;

	for(int k = 0 ; k < 8 ; k++){
		nx = x+dx[k];
		ny = y+dy[k];
		
		if(map[nx][ny] == 1 && check[nx][ny] == 0){
			solution(nx, ny);
		}
	}
}

int main() {
	
	int w, h;
	
	int total;
	
    while(true){
		cin >> w >> h ;
		
        if(w==0 && h==0)
            return 0;
        
        // 입력
        for(int i = 1 ; i <= h ; i++){
            for(int j = 1 ; j <= w ; j++){
				check[i][j] = 0;
                cin >> map[i][j];
            }
        }
		
		total = 0;
		
        // 연결된 섬이 있는지 확인
        for(int i = 1 ; i <= h ; i++){
            for(int j = 1 ; j <= w ; j++){
				if(map[i][j] == 1 && check[i][j] == 0){
					// 주변 섬들 다 check = 1로 만들어준다.
					solution(i, j);
					total++;
				}
            }
        }
		
        cout << total << endl;
    }
    
    return 0;
}
