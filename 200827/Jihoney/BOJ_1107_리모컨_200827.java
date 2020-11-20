package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1107_리모컨 {

	static boolean nums[] = new boolean[10];
	static int[] target;
	static int cnt = 0, tar, btn;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cur = 100; // 현재 채널
		tar = Integer.parseInt(sc.nextLine());
		btn = Integer.parseInt(sc.nextLine());

		for (int j = 0; j < btn; j++) {
			nums[sc.nextInt()] = true; // 고장
		}
		cnt=Math.abs(tar-cur);	//+,-로만 이동 횟수
		MoveChannel();
		System.out.println(cnt);
		sc.close();
	}

	static void MoveChannel() {
		for(int i=0;i<=999999;i++) {// 모든 채널 검색
			int ch=isClick(i);
			if(ch>0) {	
				int press=Math.abs(i-tar);
				if(cnt>press+ch)
					cnt=press+ch;	//최소값
			}
		}
		
	}

	static int isClick(int c) {	// 번호를 눌러서 이동
		if(c==0) {// 0이 고장났을경우 0
			if(nums[0])
				return 0;
			else {
				return 1;
			}
		}
		int n=0;
		while (c > 0) {
			if (nums[c % 10]) { //고장 여부 판단
				return 0;
			}
			n += 1;
			c /= 10;
		}
		return n;
		
		
	}
}
