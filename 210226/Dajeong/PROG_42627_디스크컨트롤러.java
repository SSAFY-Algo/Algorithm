import java.util.*;
class PROG_42627_디스크컨트롤러 {
    static class disk implements Comparable<disk>{
        int start;
        int time;
        
        public disk(int start, int time) {
            this.start = start;
            this.time = time;
        }
        
        @Override
        public int compareTo(disk o) {
            if(this.start != o.start)
                return this.start - o.start;
            else 
                return this.time - o.time;
        }
        
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        
        ArrayList<disk> list = new ArrayList<>();
        
        for(int i=0; i<jobs.length; i++){
            list.add(new disk(jobs[i][0], jobs[i][1]));
        }
        
        Collections.sort(list);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int cnt = 0;
        int time = 0;
        while(cnt < list.size() || !pq.isEmpty()) {
            for(int i=cnt; i<list.size(); i++){
                if(cnt < list.size() && list.get(i).start <= time) {
                    pq.add(new int[]{list.get(i).start, list.get(i).time});
                    cnt++;
                }
                else {
                    if(pq.isEmpty()) {
                        pq.add(new int[]{list.get(i).start, list.get(i).time});
                        cnt++;
                        time = list.get(i).start;
                    }
                    break;    
                    
                } 
            }
            
                
            if(!pq.isEmpty()){
                int[] a = pq.poll();
                answer += a[1] + time - a[0];
                if(a[0] > time)
                    time = a[0] + a[1];
                else 
                    time = time + a[1];
            }
        }
        
        return answer/list.size();
    }
}