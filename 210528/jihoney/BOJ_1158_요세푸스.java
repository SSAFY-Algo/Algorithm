package sc_210528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_¿ä¼¼Çª½º {

	static int N,K,cnt,index=0;
	static Queue<Integer> q=new LinkedList<>();
	static ArrayList<Integer> nums=new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		sb.append("<");
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		
		while(!q.isEmpty()) {
			for(int i=0;i<K;i++) {
				if(i==K-1) {
					sb.append(q.poll()+", ");
				}
				else {
					q.add(q.poll());
				}
			}
		}
		sb.append(">");
		System.out.println((sb.substring(0, sb.length()-3) + ">").toString());
	}

}
