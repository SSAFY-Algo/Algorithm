package TREE;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1927_최소_힙 {
	static int n,num;
	static PriorityQueue<Integer> pq=new PriorityQueue<>();// 오름차순 정렬
//	static PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); 내림차순 정렬
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			num=sc.nextInt();
			if(num==0) {
				if(pq.isEmpty())
					System.out.println("0");
				else
					System.out.println(pq.poll());
			}
			else {
				pq.add(num);
			}
		}		
	}

}
