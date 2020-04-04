/*
 * programmers lv2 타겟 넘버
 */

public class Programmers_lv2_타겟넘버 {
	public static void main(String[] args) {
		solution(new int[] {1, 1, 1, 1, 1}, 3);
	}
	
	static int answer = 0;
    public static int solution(int[] numbers, int target) {
        
        go(numbers, 0, 0, target);
//        System.out.println(answer);
        return answer;
    }
    
    public static void go(int[] numbers, int idx, int res, int tar) {
    	if(idx == numbers.length) {
    		if(res == tar) {
    			answer++;
//    			System.out.println(answer);
    		}
    		return;
    	}
//    	System.out.println(idx + " " + res);
    	go(numbers, idx+1, res+numbers[idx], tar);
//    	System.out.println(idx + " " + res);
    	go(numbers, idx+1, res-numbers[idx], tar);
    }
}
