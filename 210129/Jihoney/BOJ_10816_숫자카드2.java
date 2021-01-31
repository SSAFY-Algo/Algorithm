package sc_210129;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {

	static int N,M,res[],num,value;
	static HashMap<Integer,Integer> map=new HashMap<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(bf.readLine());
		StringTokenizer st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			num=Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				int value=map.get(num);
				map.put(num, value+1);
			}else
				map.put(num, 1);
		}
		
		M=Integer.parseInt(bf.readLine());
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<M;i++) {
			num=Integer.parseInt(st.nextToken());
			if(map.containsKey(num))
				value=map.get(num);
			else
				value=0;
			bw.append(value+" ");
		}
		bw.flush();
		bf.close();
		bw.close();
		
	}

}
