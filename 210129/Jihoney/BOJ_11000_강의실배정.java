package sc_210129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실배정 {

	static int N;
	static PriorityQueue<lecture> pq=new PriorityQueue<>();
	static PriorityQueue<Integer> res=new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(bf.readLine());
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			pq.add(new lecture(start,end));
		}
		
		lecture l=pq.poll();	
		res.add(l.end);
		
		for(int i=1;i<N;i++) {
			lecture tmp=pq.poll();
			if(res.peek()>tmp.start)	//주석 안달아줄거지롱~~
				res.add(tmp.end);
			else if(res.peek()<=tmp.start) {
				res.poll();
				res.add(tmp.end);
			}	
		}
		System.out.println(res.size());
	}

}

class lecture implements Comparable<lecture>{
	int start;
	int end;
	
	public lecture(int start,int end) {
		this.start=start;
		this.end=end;
	}

	@Override
	public int compareTo(lecture o) {
		// TODO Auto-generated method stub
		if(this.start>o.start) {
			return 1;
		}
		else if(this.start==o.start) {
			if(this.end>o.end) {
				return 1;
			}else {
				return -1;
			}
		}else
			return -1;
	}
	
	
}