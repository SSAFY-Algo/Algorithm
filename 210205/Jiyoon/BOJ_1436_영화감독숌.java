package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_¿µÈ­°¨µ¶¼ò {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 666;
        
        while(N>0) {
            
            if(Integer.toString(answer).contains("666")) {
                N--;
            }
            answer++;
        }
        System.out.println(answer-1);
	}
}
