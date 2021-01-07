import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1439_뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		char[] c = s.toCharArray();
		
		char ch = c[0];
		
		Queue<Character> q = new LinkedList<>();
		q.add(ch);
		
		for (int i = 0; i < c.length; i++) {
			if(c[i] != ch) {
				q.add(c[i]);
				ch = c[i];
			}
		}
		
		int cnt = 0;
		int size = q.size();
		while(!q.isEmpty()) {
			if(q.poll() != ch)
				cnt++;
		}
		
		System.out.println(Math.min(cnt, size-cnt));
	}

}
