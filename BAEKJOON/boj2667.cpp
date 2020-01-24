//
//  boj2667.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 10. 4..
//  Copyright © 2019년 YUNJU. All rights reserved.
//
/*
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int n;
int a[26][26];
int check[26][26] = {0};
int dx[4] = {0, 1, 0, -1};
int dy[4] = {-1, 0, 1, 0};

void bfs(int x, int y, int count) {
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
    check[x][y] = count;
    
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0 ; i < 4 ; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<n && 0<=ny && ny<n){
                if(a[nx][ny] == 1 && check[nx][ny] == 0){
                    q.push(make_pair(nx, ny));
                    check[nx][ny] = count;
                }
            }
        }
    }
}

int main() {
    scanf("%d ", &n);
    
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j ++){
            scanf("%1d", &a[i][j]);
        }
    }
    
    int count = 0;
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            if(a[i][j] == 1 && check[i][j] == 0)
                bfs(i, j, ++count);
        }
    }
    
    printf("%d\n", count);
    
    // 같은 수를 가지고 있는 단지들끼리의 합을 구한다.
    int ans[25*25];
    
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            ans[check[i][j]] += 1;
        }
    }
    
    sort(ans+1, ans+count+1);
    
    for(int i = 1 ; i <= count ; i++){
        printf("%d\n", ans[i]);
    }
    return 0;
}
*/
