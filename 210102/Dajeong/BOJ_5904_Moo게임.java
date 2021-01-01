package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5904_Moo게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int idx = 0;
		int s = 3;	// 초기값
		int k = 4;	// 가운데 1 + k+2 (mooo)
		
		while(s <= N) { // n을 ㅓㄴㅁ어가기 직전까지
			idx++;
			s = s + k + s; // 전체 문자열 길이 업데이트
			k += 1;
		}
		
		k--; // 하나를 빼줘야 인덱스를 맞출 수 있다
		
		
		
		while(idx >= 0) {
			
			int rest =  s - k / 2; // 가운데 mooo를 뺀 나머지 한쪽. s(k-1)의 길이  
			
			// 왼쪽, s(k-1)
			if(N <= rest) {	
				s = rest; // 탐색할 문자열의 길이를 rest로 바꿔줌
				k--; 
			}
			
			// 중간, moooo......
			else if(N > rest && N <= rest + k) {
				if(N == rest +1) { // 가운데의 첫번째 인덱스
					System.out.println("m");
					break;
				}
				else {
					System.out.println("o");
					break;
				}
			}
			
			// 오른쪽, s(k-1) 
			else {
				N = N - rest - k; // 왼쪽 S(k-1)과 가운데 mooo.. 를 빼준 상태
				s = rest; // 탐색할 문자열의 길이를 rest로 바꿔줌
				k--;
			}
			
			idx--;
		}
		
		

	}

}
