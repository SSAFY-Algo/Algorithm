package sc_210107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2503_숫자야구 {

	static int N,arr[],one,ten,hundred,res=0;
	static BaseBall baseBall[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(bf.readLine());
		baseBall=new BaseBall[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			arr=new int[3];
			
			int num=Integer.parseInt(st.nextToken());
			arr[0]=num%10;
			arr[1]=num/10%10;
			arr[2]=num/100;		
			
			int s=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			baseBall[i]=new BaseBall(arr,s,b);
		}
		
		for(int i=123;i<=987;i++) { // 123~987
			one=i%10;		//1의 자리
			ten=i/10%10;	//10의 자리
			hundred=i/100;		//100의 자리
			
			if(one==ten||one==hundred||ten==hundred||one==0||ten==0||hundred==0)	// 중복, 0일경우 제외
				continue;
			
			if(check(new int[]{one,ten,hundred}))
				res++;
		}
		System.out.println(res);
	}

	private static boolean check(int digits[]) {
		for(int i=0;i<N;i++) {
			int s=0,b=0;
			
			for(int j=0;j<3;j++) {
				int digit=digits[j];	//자리수 배열
				
				for(int k=0;k<3;k++) {
					if(digit==baseBall[i].num[k]) {
						if(k==j)
							s++;
						else
							b++;
					}
				}
			}
			if(baseBall[i].strike!=s||baseBall[i].ball!=b)
				return false;
		}
		return true;
	}
}

class BaseBall{
	int num[];
	int strike;
	int ball;
	
	public BaseBall(int num[], int strike, int ball) {
		super();
		this.num = num;
		this.strike = strike;
		this.ball = ball;
	}
}
