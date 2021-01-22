package sc_210122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543_문서검색 {

	static char doc[],word[];
	static int cnt=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		doc=bf.readLine().toCharArray();
		word=bf.readLine().toCharArray();
		
		int length=word.length;
		for(int i=0;i<=doc.length-word.length;i++) {
			boolean flag=true;
			for(int j=0;j<word.length;j++) {
				if(doc[i+j]!=word[j]) {
					flag=false;
					break;
				}
			}
			if(flag) {
				cnt++;
				i+=word.length-1;
			}
		}
		System.out.println(cnt);
		
		
	}

}
