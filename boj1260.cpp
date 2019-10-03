//
//  boj1260.cpp
//  Algorithm
//
//  Created by 최윤주 on 2019. 9. 9..
//  Copyright © 2019년 YUNJU. All rights reserved.
//



#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int n, m, v; // n : 정점의 개수, m : 간선 개수, v : 시작할 정점의 번호
bool check1[1001]; // 방문확인
bool check2[1001];
vector<int> a[1001];

void dfs(int x) {
    check1[x] = true;
    printf("%d ", x);
    for(int i = 0 ; i < a[x].size() ; i++){
        int y = a[x][i];
        if(check1[y] != true)
            dfs(y);
    }
}

void bfs(int start) {
    queue<int> q;
    q.push(start);
    check2[start] = true;
    
    while(!q.empty()){
        int x = q.front();
        q.pop();
        printf("%d ", x);
        for(int i = 0 ; i < a[x].size() ; i++){
            int y = a[x][i];
            if(!check2[y]){
                q.push(y);
                check2[y] = true;
            }
        }
    }
}

int main() {
    scanf("%d %d %d", &n, &m, &v);
    
    for(int i = 0 ; i < m ; i++){
        int x, y;
        scanf("%d %d", &x, &y);
        a[x].push_back(y);
        a[y].push_back(x);
    }
    
    for(int i = 1 ; i <= n ; i++){
        sort(a[i].begin(), a[i].end());
    }
    
    dfs(v);
    printf("\n");
    bfs(v);
    printf("\n");
    
    return 0;
}
 
