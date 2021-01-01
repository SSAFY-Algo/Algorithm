package CLASS2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_14235_크리스마스선물 {

	static int n,num;	
	static PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());//오름차순 정렬
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(int i=0;i<n;i++) {
			num=sc.nextInt();
			if(num==0) {
				if(pq.isEmpty()) {
					System.out.println("-1");
				}
				else {
					System.out.println(pq.poll());
				}
			}
			else {
				for(int j=0;j<num;j++) {
					pq.add(sc.nextInt());
				}
			}
		}
	}

}
