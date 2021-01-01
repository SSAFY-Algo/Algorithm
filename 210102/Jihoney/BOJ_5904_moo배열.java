package DP;

import java.util.Scanner;

public class BOJ_5904_moo배열 {

	static int len=4;// N<=1,000,000,000, len=m+o*(k+2)
	static long mooLen=3;// S() length
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		//S(k)=S(k-1)+(m+o*k+2)+S(k-1)
		while(true) {
			if(N<=mooLen)
				break;
			mooLen=mooLen+len+mooLen;
			len++;
		}
		len--;
		find(N);
	}

	//S(0)=moo, S(1)=moo mooo moo
	private static void find(int n) {
		if(mooLen==3) {
			if(n==1)
				System.out.println('m');
			else
				System.out.println('o');
			return;
		}
		long pre=(mooLen-len)/2;	//이전 문자열 길이
		if(n<=pre) {
			len--;
			mooLen=pre;
			find(n);
		}else if(n>pre&&n<=pre+len) {
			n-=pre;
			if(n==1)
				System.out.println('m');
			else
				System.out.println('o');
			return;
		}else {
			n-=(pre+len);
			len--;
			mooLen=pre;
			find(n);
		}
	}
}
