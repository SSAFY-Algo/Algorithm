package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541_잃어버린괄호 {

	static String[] minus,sum;
	static int res[],sumRes;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();

		if (str.contains("-")) {	// '-' 끊어주기 없으면 다 더하기
			minus=new String[str.split("\\-").length];
			res=new int[str.split("\\-").length];
			
			minus = str.split("\\-");
			
			for(int i=0;i<minus.length;i++) {
				if(minus[i].contains("+"))
					res[i]=sum(minus[i]);
				else
					res[i]=Integer.parseInt(minus[i]);
			}
		} else {
			sumRes = sum(str);
			System.out.println(sumRes);
			System.exit(0);
		}
		sumRes=res[0];
		for(int j=1;j<res.length;j++) {
			sumRes-=res[j];
		}
		System.out.println(sumRes);
	}

	static int sum(String str) {
		int tmp = 0;
		if (str.contains("+")) {//'+' 끊어서 다 더하기
			sum=new String[str.split("\\+").length];
			
			sum = str.split("\\+");
			for (int i = 0; i < sum.length; i++) {
				tmp += Integer.parseInt(sum[i]);
			}
		}
		else
			tmp = Integer.parseInt(str);
		return tmp;
	}

}
