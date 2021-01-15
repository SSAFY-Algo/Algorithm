import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2503_숫자야구 {
	
	static class question{
		String answer;
		int strike;
		int ball;
		
		public question(String answer, int strike, int ball) {
			this.answer = answer;
			this.strike = strike;
			this.ball = ball;
		}

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<question> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			list.add(new question(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int answer = 0;
		
		for (int i = 123; i <= 987; i++) {
			String num = Integer.toString(i);
			if(num.charAt(0) == '0' || num.charAt(1) == '0' || num.charAt(2) == '0') continue;
			if(num.charAt(0) == num.charAt(1) || num.charAt(0) == num.charAt(2) || num.charAt(1) == num.charAt(2)) continue;
			
			int cnt = 0;
			
			for (int j = 0; j < list.size(); j++) {
				int s_cnt = 0;
				int b_cnt = 0;
				
				for (int k = 0; k < 3; k++) {
					if(num.charAt(k) == list.get(j).answer.charAt(k))
						s_cnt++;
					
				}
				
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if(k != l && num.charAt(k) == list.get(j).answer.charAt(l))
							b_cnt++;
					}
				}
				
				if(s_cnt != list.get(j).strike || b_cnt != list.get(j).ball) continue;
				
				cnt++;
				
			}
			if(cnt == list.size()) 
				answer++;
		}
		
		
		System.out.println(answer);
	}

}
