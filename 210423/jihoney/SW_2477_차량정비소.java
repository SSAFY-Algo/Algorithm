package sc_210420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_2477_차량정비소 {

	static int T,N,M,K,A,B,reception[],repair[];
	static ArrayList<customer> list=new ArrayList<>();
	static Queue<customer> input;
	static PriorityQueue<customer> waiting;
	static customer receptions[],repairs[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;t++) {
			int idx=0,time=0,ans=0;
			input=new LinkedList<>();
			waiting=new PriorityQueue<>();
			
			st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			
			//창구에서 걸리는 시간
			reception=new int[N+1];
			repair=new int[M+1];
			
			//창구
			receptions=new customer[N+1];
			repairs=new customer[M+1];
			
			//접수
			st=new StringTokenizer(bf.readLine());
			for(int i=1;i<=N;i++) {
				reception[i]=Integer.parseInt(st.nextToken());
			}
			//정비
			st=new StringTokenizer(bf.readLine());
			for(int i=1;i<=M;i++) {
				repair[i]=Integer.parseInt(st.nextToken());
			}
			//고객
			st=new StringTokenizer(bf.readLine());
			for(int i=1;i<=K;i++) {
				input.add(new customer(i,Integer.parseInt(st.nextToken())));
			}
			
			
			while(true) {
				if(idx==K) {
					break;
				}
				//접수 창구에서 장비창구로 넣어주기
				for(int i=1;i<=N;i++) {
					if(receptions[i]!=null) {
						if(receptions[i].t+reception[i]<=time) {
							receptions[i].t=time;
							waiting.add(receptions[i]);
							receptions[i]=null;
						}
					}
				}
				
				// 접수 창구 검사하고 넣어주기
				for(int i=1;i<=N;i++) {
					//접수창구비어있지 않으면
					if(receptions[i]==null) {
						if(!input.isEmpty()){
							if(input.peek().arrive<=time) {
								customer c=input.poll();
								//창구 번호 넣어주고
								c.a=i;
								// 접수끝나기까지 걸리는 시간 넣어주기
								c.t=time;
								receptions[i]=c;
							}
						}
					}
				}
			
				//장비창구에서 끝난거 빼기
				for(int i=1;i<=M;i++) {
					if(repairs[i]!=null) {
						if(repairs[i].t+repair[i]<=time) {
							if(repairs[i].a==A&&repairs[i].b==B) {
								ans+=repairs[i].id;		
							}
							repairs[i]=null;
							idx++;
						}
					}
				}
				
				//장비 창구 검사하고 넣어주기
				 for(int i=1;i<=M;i++) {
					 if(repairs[i]==null) {
						 if(!waiting.isEmpty()){
							 customer c=waiting.poll();
							 c.b=i;
							 c.t=time;
							 repairs[i]=c;
						 }
					 }
				 }
				
				time++;
			}
			if(ans==0)
				System.out.println("#"+t+" "+"-1");
			System.out.println("#"+t+" "+ans);
		}
	}
}

class customer implements Comparable<customer>{
	int id;
	int arrive;
	int t;
	int a;
	int b;
	
	public customer(int id,int arrive) {
		this.id=id;
		this.arrive=arrive;
	}

	@Override
	public int compareTo(customer o) {
		// TODO Auto-generated method stub
		if(this.t==o.t) {
			return this.id-o.id;
		}
		return this.t-o.t;
	}
	
	
}