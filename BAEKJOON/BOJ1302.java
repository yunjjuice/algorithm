/*
 * BOJ 1302 베스트셀러
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ1302 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			String s = br.readLine().trim();
			if(map.containsKey(s)) {
				map.replace(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		
		int max = 0;
        for(String s : map.keySet()){
            max = Math.max(max, map.get(s));
        }
        
        ArrayList<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list);
        for(String s : list) {
            if(map.get(s) == max){
                System.out.println(s);
                break;
            }
        }
	}
}


