package sc_210115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10836_¿©¿Õ¹ú {

	static int n, m, map[][],dir[][]= {{0,-1},{-1,-1},{-1,0}};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[m][m];

		for (int i = 0; i < m; i++) {
			Arrays.fill(map[i], 1);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int z = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			feed(z,o,t);
		}
		
		for(int r=1;r<m;r++) {
			for(int c=1;c<m;c++) {
				int max=Integer.MIN_VALUE;
				for(int d=0;d<dir.length;d++) {
					int nr=r+dir[d][0];
					int nc=c+dir[d][1];
					
					max=Math.max(max, map[nr][nc]);
				}
				map[r][c]=max;
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				bw.write(map[i][j]+" ");
			}
				bw.write("\n");
		}
		bw.flush();

	}

	private static void feed(int zero, int one, int two) {
		// TODO Auto-generated method stub
		for(int i=m-1; i>=0; i--) {
            if(zero>0)
                zero--;

            else if(one>0) {
                map[i][0] += 1;
                one--;
            }

            else if(two>0) {
                map[i][0] += 2;
                two--;
            }
        }

        for(int j=1; j<m; j++) {
            if(zero>0)
                zero--;

            else if(one>0) {
                map[0][j] += 1;
                one--;
            }

            else if(two>0) {
                map[0][j] += 2;
                two--;
            }
        }
		
	}


}
