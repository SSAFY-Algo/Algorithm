package DP;

import java.util.Scanner;

public class BOJ_1003_피보나치 {

	static int fibo[],n,tc,res[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		tc=sc.nextInt();
		res=new int[tc][2];
		fibo=new int[41];
		
		for(int t=0;t<tc;t++) {
			n=sc.nextInt();
			
			if(n==0) {
				System.out.println(1+" "+0);
			}else if(n==1) {
				System.out.println(0+" "+1);
			}else {
				fibo(n);
				System.out.println(fibo[n-1]+" "+fibo[n]);	
			}
		}
		
	}
	static int fibo(int n) {
		if(n==0) {
			fibo[0]=0;
			return 0;
		}else if(n==1) {
			fibo[1]=1;
			return 1;
		}else if(fibo[n]!=0)
			return fibo[n];
		else
			return fibo[n]=fibo(n-1)+fibo(n-2);
	}

}
