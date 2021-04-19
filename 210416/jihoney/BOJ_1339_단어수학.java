package sc_210416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1339_단어수학 {
	// 자리수가 높은 순  > 알파벳 중복이 많은 순
	static String[] input;
	static int[] alphabet;
	static int N,sum=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		
		input=new String[N];
		alphabet=new int[26];
		
		for(int i=0;i<N;i++) {
			input[i]=bf.readLine();
			int len=input[i].length();
			//pow 출력값은 double
			int tmp=(int) Math.pow(10,len-1);
			for(int j=0;j<len;j++) {
				alphabet[input[i].charAt(j)-65]+=tmp;
				tmp/=10;
			}
		}
		Arrays.sort(alphabet);
//		System.out.println(Arrays.toString(alphabet));
		int idx=9;
		for(int i=alphabet.length-1;i>=0;i--) {
			sum+=alphabet[i]*idx;
			idx--;
		}
		System.out.println(sum);	
	}
}
