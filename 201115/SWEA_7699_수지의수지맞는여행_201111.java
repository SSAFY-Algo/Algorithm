package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7699_수지의수지맞는여행_201111 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++) {
            max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] mmap = new int[R][C];
            visited = new boolean[R][C];
            abc = new boolean[26];
             
            for(int j=0; j<R; j++) {
                String s = br.readLine();
                for(int k=0; k<C; k++) {
                    mmap[j][k] = s.charAt(k) - 'A';
                }
            }
             
            dfs(mmap,0,0,1);
            System.out.printf("#%d %d\n",i,max);
        }
    }
     
    static int max;
    static boolean[] abc;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    private static void dfs(int[][] mmap, int y, int x, int cnt) {
        if(max<cnt) max = cnt;
        abc[mmap[y][x]] = true;
        for(int i=0; i<4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx>=0 && tx<mmap[0].length && ty>=0 && ty<mmap.length && !abc[mmap[ty][tx]]) {
                dfs(mmap, ty, tx, cnt+1);
                abc[mmap[ty][tx]] = false;
            }
        }
    }

}
