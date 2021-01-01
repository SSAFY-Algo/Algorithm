package CLASS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1026_보물 {

	static int n,res=0;
	static Integer a[],b[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(bf.readLine());
		a=new Integer[n];
		b=new Integer[n];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(b,Collections.reverseOrder());	//Collections 정렬 사용시 Wrapper 클래스로 객체정의
		
		for(int i=0;i<n;i++) {
			res+=a[i]*b[i];
		}
		System.out.println(res);
	}

}
