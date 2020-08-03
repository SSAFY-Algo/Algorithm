package baekjoon;

import java.util.Scanner;

public class boj_1934 {
	public static void main(String[] args) {
		// 유클리드 호제법 사용
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int gcd = 0; // 최대공약수
			int lcm = 0; // 최소공배수
			gcd = gcd(Math.max(a, b), Math.min(a, b));
			lcm = lcm(gcd, a, b);
			System.out.println(lcm);
		}
	}
	
	static int gcd(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return gcd(b, a%b);
	}
	
	static int lcm(int gcd, int a, int b) {
		int aa = a/gcd;
		int bb = b/gcd;
		return gcd*aa*bb;
	}
}
