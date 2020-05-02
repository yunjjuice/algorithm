/*
 * SWEA 4366 정식이의 은행업무
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA4366 {
	static String binary, tenary;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= TC; tc++) {
			binary = br.readLine().trim();
			tenary = br.readLine().trim();
			sb.append('#').append(tc).append(' ');
			endLoop:
			for (int i = 0; i < binary.length(); i++) { // 이진수의 한 자리씩 바꿔보면서 값을 비교해본다
				StringBuilder sb2 = new StringBuilder(binary);
				char changeBi = binary.charAt(i) == '0' ? '1' : '0';
				sb2.setCharAt(i, changeBi);
				int newBinary = Integer.parseInt(sb2.toString(), 2);
//				System.out.println("new : " + newBinary);
				
				for (int j = 0; j < tenary.length(); j++) {
					StringBuilder sb3 = new StringBuilder(tenary);
					char changeTe = tenary.charAt(j);
					if(changeTe == '0') {
						sb3.setCharAt(j, '1');
						int newTenary = Integer.parseInt(sb3.toString(), 3);
						if(newBinary == newTenary) {
							sb.append(newBinary).append('\n');
							break endLoop;
						}
						
						sb3.setCharAt(j, '2');
						newTenary = Integer.parseInt(sb3.toString(), 3);
						if(newBinary == newTenary) {
							sb.append(newBinary).append('\n');
							break endLoop;
						}
					} else if(changeTe == '1') {
						sb3.setCharAt(j, '0');
						int newTenary = Integer.parseInt(sb3.toString(), 3);
						if(newBinary == newTenary) {
							sb.append(newBinary).append('\n');
							break endLoop;
						}
						
						sb3.setCharAt(j, '2');
						newTenary = Integer.parseInt(sb3.toString(), 3);
						if(newBinary == newTenary) {
							sb.append(newBinary).append('\n');
							break endLoop;
						}
					} else if(changeTe == '2') {
						sb3.setCharAt(j, '0');
						int newTenary = Integer.parseInt(sb3.toString(), 3);
						if(newBinary == newTenary) {
							sb.append(newBinary).append('\n');
							break endLoop;
						}
						
						sb3.setCharAt(j, '1');
						newTenary = Integer.parseInt(sb3.toString(), 3);
						if(newBinary == newTenary) {
							sb.append(newBinary).append('\n');
							break endLoop;
						}
					}
				}
			}
		}
		System.out.print(sb);
	}
}
