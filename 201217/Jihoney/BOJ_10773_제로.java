package IM;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_10773_제로 {

	static int K,sum=0,num;
	static Stack<Integer> stack=new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		K=sc.nextInt();
		
		for(int i=0;i<K;i++) {
			num=sc.nextInt();
			if(num!=0)
				stack.push(num);
			else if(num==0)
				stack.pop();
		}
		
		if(stack.size()!=0) {
			int size=stack.size();
			for(int i=0;i<size;i++) {
				sum+=stack.pop();
			}
		}
		
		System.out.println(sum);
			
		
	}

}
