package sc_210205;

import java.util.Scanner;

public class BOJ_1436_¿µÈ­°¨µ¶¼ò {

	static int arr[],N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		arr=new int[3000000];
		int cur=0,res=0;
		for(int i=666;i<arr.length;i++) {
			String str=Integer.toString(i);
			if(str.contains("666")) {
				cur++;
				if(cur==N)
					res=i;
			}
		}
		
		System.out.println(res);
	}

}
