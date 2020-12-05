package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963_소수경로 {
	//4자리 소수의 개수 : 1061개
	static int A,B,res=1000,cnt=0;
	static boolean eratos[],visited[];
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		StringTokenizer st;
		eratos=new boolean[10001];
		Arrays.fill(eratos, true);
		makeEratostenes();
		for(int t=0;t<tc;t++) {
			visited=new boolean[10001];
			cnt=0;
			q=new LinkedList<>();
			st=new StringTokenizer(bf.readLine());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
//			System.out.println(A/1000+" "+(A/100)%10+" "+(A/10)%10+" "+(A%10));
			q.add(A);
			visited[A]=true;
			if(bfs())
				System.out.println(cnt);
			else
				System.out.println("Impossible");
		}
	}
	
	private static boolean bfs() {
		while(!q.isEmpty()) {
			int size=q.size();
			for(int t=0;t<size;t++) {
				int tmp=q.poll();
				if(tmp==B) {
					return true;
				}
				int nums[]= {tmp/1000,(tmp/100)%10,(tmp/10)%10,(tmp%10)};
				for(int i=0;i<4;i++) {
					for(int j=0;j<10;j++) {
						int num=nums[i];
						nums[i]=j;
						int tmpNum=nums[0]*1000+nums[1]*100+nums[2]*10+nums[3];	
						if(eratos[tmpNum]&&tmpNum>1000&&!visited[tmpNum]) {
							visited[tmpNum]=true;
							q.add(tmpNum);
						}
						nums[i]=num;
					}
				}	
			}
			cnt++;
		}
		return false;
	}


	private static void makeEratostenes() {
		// TODO Auto-generated method stub
		for(int i=2;i*i<=10000;i++) {
			for(int j=i*i;j<=10000;j+=i) {
				eratos[j]=false;
			}
		}
	}
}
