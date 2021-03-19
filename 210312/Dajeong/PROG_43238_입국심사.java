import java.util.*;
class PROG_43238_입국심사 {
    public long solution(int n, int[] times) {
        long max = 0;
        for(int i=0; i<times.length; i++){
            max = Math.max(max, times[i]);
        }
        
        long r = max * n;
        long l = 0;
        while(l<r){
            long mid = (l+r)/2;
            long sum = 0;
            for(int i=0; i<times.length; i++){
                sum += mid / times[i];
            }
            if(sum >= n)
                r = mid;
            else
                l = mid + 1;
            
        }
        
        return r;
    }
}