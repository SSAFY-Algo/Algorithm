import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				
				if(map.containsKey(s2)) {
					map.put(s2, map.get(s2)+1);
				}
				else
					map.put(s2, 1);
			}
			
			int answer = 1;
			for (String key : map.keySet()) {
				answer *= map.get(key) + 1;
			}
			
			System.out.println(answer-1);
		}
		

	}

}
