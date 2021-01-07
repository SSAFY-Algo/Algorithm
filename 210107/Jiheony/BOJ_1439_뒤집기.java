package sc_210107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439_µÚÁý±â {

	static int zero=0,one=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String str=bf.readLine();
		if(str.charAt(0)=='0')
			zero++;
		else
			one++;
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i-1)!=str.charAt(i)) {
				if(str.charAt(i)=='0')
					zero++;
				else
					one++;
			}
		}
		System.out.println(Math.min(zero, one));
	}

}
