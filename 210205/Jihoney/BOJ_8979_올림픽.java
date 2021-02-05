package sc_210205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_8979_¿Ã¸²ÇÈ {

	static int N,K;
	static ArrayList<country> olimpic=new ArrayList<>(); 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			int no=Integer.parseInt(st.nextToken());
			int g=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			olimpic.add(new country(no,g,s,b,1));
		}
		
		Collections.sort(olimpic);
		
		int res=0;
		for(int i=1;i<N;i++) {
			if(olimpic.get(i).no==K)
				res=i;
			if(olimpic.get(i-1).gold==olimpic.get(i).gold
					&&olimpic.get(i-1).silver==olimpic.get(i).silver
						&&olimpic.get(i-1).bronze==olimpic.get(i).bronze) {
				olimpic.get(i).rank=olimpic.get(i-1).rank;
			}else {
				olimpic.get(i).rank=i+1;				
			}
		}
		System.out.println(olimpic.get(res).rank);
	}

}

class country implements Comparable<country>{
	int no;
	int gold;
	int silver;
	int bronze;
	int rank;
	
	public country(int no, int gold, int silver, int bronze,int rank) {
		super();
		this.no = no;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
		this.rank=rank;
	}

	@Override
	public int compareTo(country o) {
		// TODO Auto-generated method stub
		if(this.gold>o.gold) {
			return -1;
		}else if(this.gold==o.gold) {
			if(this.silver>o.silver) {
				return -1;
			}else if(this.silver==o.silver) {
				if(this.bronze>o.bronze) {
					return -1;
				}else if(this.bronze==o.bronze) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	
}