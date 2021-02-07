import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		while(N>0) {
			answer++;
			
			if(Integer.toString(answer).contains("666"))
				N--;
			
		}
		
		System.out.println(answer);
	}

}
