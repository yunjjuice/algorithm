//
//  boj14891.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 9..
//  Copyright © 2019년 YUNJU. All rights reserved.
//

#include <iostream>
#include <math.h>

int wheel[4][8];
int k; // 회전 횟수
bool isRotate[4]; // 회전했는지 아닌지
bool check[3]; // 마주닿은 면이 다른지 같은지. 다르면 0 같으면 1
int direction[4]; // 돌아가는 방향 저장
int a, dir;

int init(int, int);
int rotate(int, int);
int restRotate(int, int);


// n극은 0, s극은 1
int main() {
	
	for(int i = 0 ; i < 4 ; i++){
		for(int j = 0 ; j < 8 ; j++){
			scanf("%1d", &wheel[i][j]);
		}
	}
	
	scanf("%d", &k);
	
	for (int i = 0 ; i < k ; i++){
		//int a, dir;
		scanf("%d %d", &a, &dir);
		init(a, dir);
		rotate(a, dir);
		
		/*
		// 출력 검사
		for(int k = 0 ; k<4 ; k++){
			for(int j = 0 ; j<8 ; j++){
				printf("%d ", wheel[k][j]);
			}
			printf("\n");
		}
		 */
	}
	
	int sum = 0;
	for (int i = 0 ; i < 4 ; i++){
		if(wheel[i][0] == 1)
			sum += pow(2, i);
	}
	
	printf("%d", sum);
	
	return 0;
}

int init(int a, int dir) {
	for (int i = 0 ; i < 3 ; i++){
		if(wheel[i][2] == wheel[i+1][6])
			check[i] = true;
		else
			check[i] = false;
	}
	
	for(int i = 0 ; i < 4 ; i++){
		//direction[i] = 1;
		isRotate[i] = false;
	}
	
	return 0;
}

int rotate(int a, int dir) { // a는 몇 번째 톱니바퀴, dir은 방향
	
    if(dir == 1){ // 시계방향
		int temp[8];
		for(int i = 0 ; i < 8 ; i++){
			temp[(i+1)%8] = wheel[a-1][i]; // a-1인 이유 : 4번째 톱니바퀴라는 배열에서는 [3]이므로
		}
		for(int i = 0 ; i < 8 ; i++){
			wheel[a-1][i] = temp[i];
		}
    }
    else if(dir == -1){ // 반시계방향
		int temp[8];
		for(int i = 0 ; i < 8 ; i++){
			temp[i] = wheel[a-1][(i+1)%8];
		}
		for (int i = 0 ; i < 8 ; i++){
			wheel[a-1][i] = temp[i];
		}
    }
	
	isRotate[a-1] = true;
	
	restRotate(a, dir);
	
    return 0;
}

int restRotate(int a, int dir) {
	// 1번이면 2번이 돌았는지 확인
	// 2번이면 1,3번이 돌았는지 확인
	// 3번이면 2,4번이 돌았는지 확인
	// 4번이면 3번이 돌았는지 확인
	
	if(a == 1){
		if(check[0] == false && isRotate[1] == false){
			rotate(2, -dir);
		}//else return 0;
	}
	else if(a == 2){
		if(check[0] == false && isRotate[0] == false){
			rotate(1, -dir);
		}
		if(check[1] == false && isRotate[2] == false){
			rotate(3, -dir);
		}
		//else return 0;
	}
	else if(a == 3){
		if(check[1] == false && isRotate[1] == false){
			rotate(2, -dir);
		}
		if(check[2] == false && isRotate[3] == false){
			rotate(4, -dir);
		}
		//else return 0;
	}
	else if(a == 4){
		if(check[2] == false && isRotate[2] == false){
			rotate(3, -dir);
		}
		//else return 0;
	}
	
	return 0;
}
