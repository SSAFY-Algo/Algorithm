import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        int cnt = 0;
        int answer = 0;
        
        for(int i = 0; i < citations.length ; i++) {  // 내림차순으로 생각
            
            if(i >= citations[citations.length - i - 1]) {
                return i;
            }
        }
        return citations.length;
    }
}
