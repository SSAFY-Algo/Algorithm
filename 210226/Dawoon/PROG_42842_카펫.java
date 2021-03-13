package com.ssafy;

public class PROG_42842_카펫 {

	public static void main(String[] args) {
		int brown = 0;
		int yellow = 0;
		new PROG_42842_카펫().solution(brown, yellow);

	}

	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 0; i < brown/2; i++){
            int j = (brown - (2 * i) + 4) / 2;
            if(i*j == brown + yellow){
                answer[0] = i;
                answer[1] = j;
            }
        }
        return answer;
    }
}
