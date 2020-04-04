/*
 * Programmers lv2 영어 끝말잇기
 */

import java.util.Arrays;
import java.util.HashSet;

public class Programmers_lv2_영어끝말잇기 {
	public static void main(String[] args) {
		String[] arr = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		solution(3, arr);
		String[] arr2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		solution(5, arr2);
		String[] arr3 = {"hello", "one", "even", "never", "now", "world", "draw"};
		solution(2, arr3);
		String[] arr4 = {"qwe", "eqwe", "eqwe"};
		solution(2, arr4);
	}
	
    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        HashSet<String> set = new HashSet<>();
        
        int fail = 0;
        String end, front = ""; // 이전 글자의 끝글자와 내 글자의 첫 글자를 비교한다
        // 첫 번째에 탈락할 일은 없으니 먼저 넣어준다.
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
        	end = words[i-1].charAt(words[i-1].length()-1) + "";
        	front = words[i].charAt(0) + "";
//        	System.out.println(end + " " + front);
        	if(!front.equals(end)) { // 뒷글자와 앞글자가 다르면 탈락
        		fail = i;
        		break;
        	}
        	if(set.contains(words[i])) { // 같은 단어 말하면 탈락
        		fail = i;
        		break;
        	}
			set.add(words[i]);
		}
        
//        System.out.println(fail);
        
        if(fail != 0) {
        	answer[0] = fail%n + 1; // 몇 번째 사람이
        	answer[1] = fail/n + 1; // 몇 번 차례에 틀렸다
        }
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
