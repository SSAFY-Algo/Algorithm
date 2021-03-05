package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {
    static int N;
    static int[] parent;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>>list;

    public static void main(String[] args) throws NumberFormatException, IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st;

         N = Integer.parseInt(br.readLine());
         parent = new int[N+1];
         visit = new boolean[N+1];
         list = new ArrayList<>();

         for(int i = 0; i <= N; i++) {
             list.add(new ArrayList<Integer>());
         }

         for(int i = 1; i < N; i++) {
             st = new StringTokenizer(br.readLine());

             int idx1 = Integer.parseInt(st.nextToken());
             int idx2 = Integer.parseInt(st.nextToken());

             list.get(idx1).add(idx2);
             list.get(idx2).add(idx1);
         }

         dfs(1);

         for(int i = 2; i < N+1; i++) {
             bw.write(parent[i] + "\n");
         }

         bw.flush();
         bw.close();
         br.close();

    }

    static void dfs(int node) {

        if(!visit[node]) {
            visit[node] = true;

            for(int n : list.get(node)) {
                if(visit[n]) parent[node] = n;
                dfs(n);
            }
        }
    }
}
