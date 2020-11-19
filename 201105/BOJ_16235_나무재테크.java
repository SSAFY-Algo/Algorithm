package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {

	static int map[][],feeds[][],N,M,K;
	static int dir[][]= {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static ArrayList<Integer> arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		feeds=new int[N+1][N+1];
		map=new int[N+1][N+1];
		arr=new ArrayList[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=new ArrayList<>();
			}
		}
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=1;j<=N;j++) {
				feeds[i][j]=Integer.parseInt(st.nextToken());
				map[i][j]=5;
			}
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int age=Integer.parseInt(st.nextToken());
			arr[r][c].add(age);
		}

		grow();
		
	}
	static void grow() {
		
		while(K>0) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][j].size()>0) { //나무 존재
						Collections.sort(arr[i][j]);
						int dead=0;
						ArrayList<Integer> tmp=new ArrayList<>();
						for(int t=0;t<arr[i][j].size();t++) {
							int age=arr[i][j].get(t);
							if(map[i][j]>=age) {
								map[i][j]-=age;
								tmp.add(age+1);
							}else {//양분못먹으면
								dead+=age/2;
							}
						}
						map[i][j]+=dead;
						arr[i][j].clear();
						for(int d:tmp)
							arr[i][j].add(d);
					}
				}
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][j].size()>0) {
						for(int t=0;t<arr[i][j].size();t++) {
							int age=arr[i][j].get(t);
							if(age%5==0) {
								for(int d=0;d<dir.length;d++) {
									int nr=i+dir[d][0];
									int nc=j+dir[d][1];
									if(nr>0&&nr<=N&&nc>0&&nc<=N)
										arr[nr][nc].add(1);
								}
							}
						}
						
					}
				}
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					map[i][j]+=feeds[i][j];
				}
			}
			
			
			K--;
		}
		
		int res=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				res+=arr[i][j].size();
			}
		}
		
		System.out.println(res);
	}

}
