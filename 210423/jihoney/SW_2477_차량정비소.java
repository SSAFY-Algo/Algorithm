package sc_210420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_2477_��������� {

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
			
			//â������ �ɸ��� �ð�
			reception=new int[N+1];
			repair=new int[M+1];
			
			//â��
			receptions=new customer[N+1];
			repairs=new customer[M+1];
			
			//����
			st=new StringTokenizer(bf.readLine());
			for(int i=1;i<=N;i++) {
				reception[i]=Integer.parseInt(st.nextToken());
			}
			//����
			st=new StringTokenizer(bf.readLine());
			for(int i=1;i<=M;i++) {
				repair[i]=Integer.parseInt(st.nextToken());
			}
			//��
			st=new StringTokenizer(bf.readLine());
			for(int i=1;i<=K;i++) {
				input.add(new customer(i,Integer.parseInt(st.nextToken())));
			}
			
			
			while(true) {
				if(idx==K) {
					break;
				}
				//���� â������ ���â���� �־��ֱ�
				for(int i=1;i<=N;i++) {
					if(receptions[i]!=null) {
						if(receptions[i].t+reception[i]<=time) {
							receptions[i].t=time;
							waiting.add(receptions[i]);
							receptions[i]=null;
						}
					}
				}
				
				// ���� â�� �˻��ϰ� �־��ֱ�
				for(int i=1;i<=N;i++) {
					//����â��������� ������
					if(receptions[i]==null) {
						if(!input.isEmpty()){
							if(input.peek().arrive<=time) {
								customer c=input.poll();
								//â�� ��ȣ �־��ְ�
								c.a=i;
								// ������������� �ɸ��� �ð� �־��ֱ�
								c.t=time;
								receptions[i]=c;
							}
						}
					}
				}
			
				//���â������ ������ ����
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
				
				//��� â�� �˻��ϰ� �־��ֱ�
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