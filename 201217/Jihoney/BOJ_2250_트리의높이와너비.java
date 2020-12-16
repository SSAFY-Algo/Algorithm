package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2250_트리의높이와너비 {

	static int N,root,index=1,totalMaxLevel=1,
			maxLevel=1,maxWidth=1,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	static ArrayList<Integer> width=new ArrayList<>();
	static Node nodes[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(bf.readLine());
		nodes=new Node[N+1];
		
		for(int i=1;i<=N;i++) {	// N개의 노드 초기화 (값, 위치, 부모, 왼쪽 , 오른쪽 자식)
			nodes[i]=new Node(i,-1,-1,-1,new int[] {-1,-1});
		}
		
		int num,left,right;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			num=Integer.parseInt(st.nextToken());
			left=Integer.parseInt(st.nextToken());
			right=Integer.parseInt(st.nextToken());
			
			nodes[num].childs[0]=left;
			nodes[num].childs[1]=right;
			
			if(left!=-1)	//자식들 부모 저장
				nodes[left].parent=num;
			if(right!=-1)
				nodes[right].parent=num;
		}
		
		for(int i=1;i<=N;i++) {				// root 노드 찾기
			if(nodes[i].parent==-1) {		//부모가 없으면 루트
				root=i;
				break;
			}
		}
		nodes[root].level=1;	// 루트 노드의 레벨 = 1
		
		setLevel(root,1); 		//각 노드의 레벨 설정
		setPos(root);			//각 노드의 위치 값 설정
		calcWidth(); 			// 각 레벨별 최대 너비 계산
		System.out.println(maxLevel+" "+maxWidth);
	}
	
	private static void calcWidth() {
		// TODO Auto-generated method stub
		for(int i=1;i<=totalMaxLevel;i++) {
			width.clear();
			for(int j=1;j<=N;j++) {	// 레벨 별 제일 왼쪽 pos와 가장 오른쪽 pos 연산
				if(nodes[j].level==i) {
					width.add(nodes[j].pos);
				}
			}
			calc(i);
		}
		
	}
	private static void calc(int level) {
		// TODO Auto-generated method stub
		Collections.sort(width);
		int res=Math.abs(width.get(0)-width.get(width.size()-1))+1;
		if(maxWidth<res) {
			maxWidth=res;
			maxLevel=level;
		}
	}
	
	private static void setPos(int root) {	//중위순회로 pos 설정
		// TODO Auto-generated method stub
		if(nodes[root].childs[0]!=-1) {
			setPos(nodes[root].childs[0]);
		}
		nodes[root].pos=index++;
//		System.out.println(nodes[root].data+" "+nodes[root].pos);
		if(nodes[root].childs[1]!=-1) {
			setPos(nodes[root].childs[1]);
		}
		
	}
	
	private static void setLevel(int root,int depth) {
		// TODO Auto-generated method stub
		if(nodes[root].childs[0]==-1&&nodes[root].childs[1]==-1) {	// leaf node일 경우 종료
			totalMaxLevel=Math.max(totalMaxLevel,depth);	//최대 깊이=level 저장
			return;
		}
		int leftChild=nodes[root].childs[0] ;
		int rightChild=nodes[root].childs[1];
		if(leftChild!=-1) {// 자식이 존재한다면
			nodes[leftChild].level=depth+1;
			setLevel(leftChild,depth+1);
		}
		if(rightChild!=-1) {
			nodes[rightChild].level=depth+1;
			setLevel(rightChild,depth+1);
		}
	}

}
class Node{
	int data;	// 값 
	int pos;	// x행 위치 값
	int level;	// 레벨
	int parent;	// 부모
	int childs[]; //자식  0:왼쪽 자식 1:오른쪽 자식

	public Node(int data, int pos,int level, int parent, int childs[]) {
		super();
		this.data = data;
		this.pos = pos;
		this.level=level;
		this.parent = parent;
		this.childs=childs;
	}
	
	
	
}
