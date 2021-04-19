package sc_210416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2529_∫ŒµÓ»£ {

	static ArrayList<String> res=new ArrayList<>();
	static int K;
	static char sign[];
	static boolean visited[]=new boolean[10];
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(bf.readLine());
		sign=new char[K];
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
//		System.out.println(st.countTokens());
		for(int i=0;i<K;i++) {
			sign[i]=st.nextToken().charAt(0);
		}
		dfs("",0);
		Collections.sort(res);
//		for(int i=0;i<res.size();i++) {
//			System.out.println(res.get(i));			
//		}
//		System.out.println('1'<'2'?true:false);
		System.out.println(res.get(res.size()-1));
		System.out.println(res.get(0));
		
	}
	private static void dfs(String str,int idx) {
		// TODO Auto-generated method stub
		if(idx==K+1) {
			if(check(str)) {
				res.add(str);				
			}
			return;
		}
		
		for(int i=0;i<=9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(str+i,idx+1);
				visited[i]=false;						
			}
		}
	}
	private static boolean check(String str) {
		// TODO Auto-generated method stub
		int len=str.length();
		for(int i=1;i<len;i++) {
			if(sign[i-1]=='<') {
				if(str.charAt(i-1)>str.charAt(i))
					return false;
			}else if(sign[i-1]=='>') {
				if(str.charAt(i-1)<str.charAt(i))
					return false;				
			}
		}
		return true;
	}

}
