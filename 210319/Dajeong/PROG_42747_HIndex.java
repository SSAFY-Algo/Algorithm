import java.util.*;
class PROG_42747_HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
		int answer = 0;
		int h = citations[citations.length-1];
		
		while(h>0) {
			int up = 0;
			int down = 0;
			for(int i=0; i<citations.length; i++) {
				if(h <= citations[i])
					up++;
				else
					down++;
			}
			if(up >= h && down <= h) {
				answer = h;
				break;
			}
			h--;
		}
        return answer;
    }
}