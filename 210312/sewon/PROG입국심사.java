import java.util.*;

class Solution {
    public long solution(long n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = times[times.length-1]*n;   // n명을 심사하는데 걸리는 최대시간
        long answer = right;
        
        while(left <= right) {
            long sum = 0;   // 심사를 통과한 사람 수
            long middle = (left + right)/2; // 중간 시간 탐색
            
            // middle 시간 안에 심사할 수 있는 사람 수 계산
            for(int i=0; i < times.length; i++){
                sum += middle/times[i];
            }
                
            if(sum < n) {   // 시간 부족
                left = middle+1;
            }
            else {  // 시간이 딱 맞거나, 남을 때
                if(middle < answer)    answer = middle;
                right = middle-1;
            }
        }
        
        return answer;
    }
}
