package com.ssafy;

import java.util.PriorityQueue;

public class PROG_42627_디스크컨트롤러 {

	public static void main(String[] args) {
		int[][] jobs = null;
		new PROG_42627_디스크컨트롤러().solution(jobs);
	}
	
	public int solution(int[][] jobs) {
        PriorityQueue<Task> pq = new PriorityQueue<Task>();
        for(int i = 0; i < jobs.length; i++){
            pq.add(new Task(jobs[i][0], jobs[i][0], jobs[i][1]));
        }
        int time = 0;
        int answer = 0;
        while(!pq.isEmpty()){
            Task now = pq.poll();
            if(now.start < time){
                pq.add(new Task(time, now.time, now.spend));
            }else if(now.start == time){
                answer += now.spend + time - now.time;
                time = now.spend + time;
            }else{
                answer += now.spend;
                time = now.spend + now.time;
            }
        }
        
        return answer/jobs.length;
    }
    
    static class Task implements Comparable<Task>{
        int time;
        int start;
        int spend;
        
        public Task(int start, int time, int spend){
            this.start = start;
            this.time = time;
            this.spend = spend;
        }
        
        @Override
        public int compareTo(Task o){
            if(this.start == o.start)
                return this.spend - o.spend;
            return this.start - o.start;
        }
    }

}
