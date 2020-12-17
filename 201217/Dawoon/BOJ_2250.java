package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2250 {

	static int[] low;
	static int[] high;
	static int nodeIdx;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Leaf[] tree = new Leaf[N+1];
		low = new int[N+1];
		Arrays.fill(low, Integer.MAX_VALUE);
		high = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			if(tree[v] == null) {
				tree[v] = new Leaf(-1, 1, v, left, right);
			}
			tree[v].left = left;
			tree[v].right = right;
			if(left != -1) {
				if(tree[left]  == null) {
					tree[left] = new Leaf(v, tree[v].level+1, left, 0, 0);
				}else {
					tree[left].parent = v;
					tree[left].level = tree[v].level+1;
				}
			}
			if(right != -1) {
				if(tree[right] == null)
					tree[right] = new Leaf(v, tree[v].level+1, right, 0, 0);
				else {
					tree[right].parent = v;
					tree[right].level = tree[v].level+1;
				}
			}
		}
		int root = 0;
		for (int i = 1; i <= N; i++) {
			if(tree[i].parent == -1)
				root = i;
		}
		
		nodeIdx = 1;
		dfs(root, 1, tree);
		
		int result = high[1] - low[1] + 1;
		int level = 1;
		for (int i = 2; i <= N; i++) {
			int temp = high[i] - low[i] + 1;
			if(temp > result) {
				result = temp;
				level = i;
			}
		}
		
		System.out.println(level + " " + result);
	}
	
	private static void dfs(int nodeNum, int cnt, Leaf[] tree) {
		if(tree[nodeNum].left > 0)
			dfs(tree[nodeNum].left, cnt+1, tree);
		
		low[cnt] = Math.min(low[cnt], nodeIdx);
		high[cnt] = Math.max(high[cnt], nodeIdx++);
		
		if(tree[nodeNum].right > 0)
			dfs(tree[nodeNum].right, cnt+1, tree);
		
	}

	static class Leaf{
		int parent;
		int level;
		int v;
		int left;
		int right;
		
		public Leaf(int parent, int level, int v, int left, int right) {
			this.parent = parent;
			this.level = level;
			this.v =v;
			this.left = left;
			this.right = right;
		}
	}
}
