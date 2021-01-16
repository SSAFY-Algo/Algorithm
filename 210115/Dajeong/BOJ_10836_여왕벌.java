import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10836_¿©¿Õ¹ú2 {
    static int[][] map;
    static int[] dx = {0, -1, -1};
    static int[] dy = {-1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new int[M][M];
        
        for(int i=0; i<M; i++) {
           Arrays.fill(map[i], 1);
        }
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			for(int j=M-1; j>=0; j--) {
	            if(zero>0)
	                zero--;

	            else if(one>0) {
	                map[j][0] += 1;
	                one--;
	            }

	            else if(two>0) {
	            	map[j][0] += 2;
	                two--;
	            }
	        }

	        for(int j=1; j<M; j++) {
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

        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<M; i++) {
            for(int j=1; j<M; j++) {
                for(int k=0; k<3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    map[i][j] = Math.max(map[i][j], map[nx][ny]);
                }
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
               	sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }

  
}