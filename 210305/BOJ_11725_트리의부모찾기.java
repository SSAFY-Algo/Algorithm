package sc_210305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

	static int N;
	static ArrayList<Node> isNode[];
	static boolean check[];
	static int parent[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(bf.readLine());
		isNode=new ArrayList[N+1];
		check=new boolean[N+1];
		parent=new int[N+1];
		
		for(int i=0;i<=N;i++) {
			isNode[i]=new ArrayList<>();
		}
		
		Node root=new Node(1);
		
		int rootData=root.data;
		int n1,n2;
		
		
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(bf.readLine());
			n1=Integer.parseInt(st.nextToken());
			n2=Integer.parseInt(st.nextToken());
			
			isNode[n1].add(new Node(n2));
			isNode[n2].add(new Node(n1));	
		}
		
		for(int i=1;i<=N;i++) {
			if(!check[i]) {
				find(i);
			}
		}
		
		for(int i=2;i<=N;i++) {
			System.out.println(parent[i]);
		}
					
	}
	private static void find(int num) {
		// TODO Auto-generated method stub
		if(check[num])
			return;
		check[num]=true;
		for(Node next:isNode[num]) {
			int n=next.data;
			if(!check[n]) {
				parent[n]=num;
				find(n);
			}
		}
	}

}

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
}
