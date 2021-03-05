package sc_210305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어 {

	static int N,K,cnt=0,con[];
	static boolean robot[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		con=new int[2*N];
		// 해당위치에 로봇이 있는지 없는지
		robot=new boolean[N];
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<2*N;i++) {
			con[i]=Integer.parseInt(st.nextToken());
		}
		
		while(check()) {
			cnt++;
			rotate();
			moveRobot();
			load();
		}
		System.out.println(cnt);
	}
	private static boolean check() {
		// TODO Auto-generated method stub
		int kCnt=0;
		for(int i=0;i<2*N;i++) {
			if(con[i]==0)
				kCnt++;
		}
		if(kCnt>=K)
			return false;
		return true;
	}
	
	//	3. 로봇 올리기
	private static void load() {
		// TODO Auto-generated method stub
		if(!robot[0]&&con[0]>0) {
			robot[0]=true;
			con[0]--;
		}
	}
	// 2. 로봇 한칸 이동 
	private static void moveRobot() {
		for(int i=N-2;i>=0;i--) {
			if(robot[i]) {
				if(i==N-2&&con[i+1]>0) {// 로봇 내려주기
					con[i+1]--;
					robot[i]=false;
					continue;
				}
				if(!robot[i+1]&&con[i+1]>0) {// 로봇 이동하기
					con[i+1]--;
					robot[i+1]=true;
					robot[i]=false;
				}
			}
		}
	}
	// 1.벨트가 한 칸 회전한다
	private static void rotate() {
		// 컨베이어벨트 마지막위치에 있는건 첨위치로 이동
		int tmp=con[2*N-1];
		for(int i=2*N-1;i>0;i--) {
			con[i]=con[i-1];
		}
		con[0]=tmp;
		
		for(int i=N-1;i>0;i--) {
			robot[i]=robot[i-1];			
		}
		robot[0]=false;
	}

}
