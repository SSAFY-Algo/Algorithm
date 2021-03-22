import java.util.*;

class Solution {
    public int solution(int N, int number) {
        HashSet<Integer>[] DP = new HashSet[9]; // DP[i] : i자리로 만들 수 있는 모든 경우의 수

        for(int index = 1; index <= 8; index++) {   // 최솟값을 구하므로 1자리부터 시작
            int num = 0;
            for(int i=0; i<index; i++) {
                num += N*Math.pow(10, i);   // index자릿수의 숫자를 만드는 과정
            }
            
            DP[index] = new HashSet<Integer>();
            DP[index].add(num);
            
            for(int i=1; i<index; i++) {
                for(int x1 : DP[index-i]) {
                    for(int x2 : DP[i]) {
                        // 사칙연산
                        DP[index].add(x1 + x2);
                        DP[index].add(x1 - x2);
                        DP[index].add(x1 * x2);
                        if(x1 != 0 && x2 != 0) {
                            DP[index].add(x1 / x2); // 0으로 나눌 수 없기에 if문으로 감쌈
                        }
                    }
                }
            }
            
            // number가 있는지 확인
            if(DP[index].contains(number))  return index;
        }
        return -1;  // 답이 8보다 크면 -1 return
    }
}
