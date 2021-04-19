import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 순서가 정해져있는 작업을 차례대로 수행해야 할 때 -> 위상정렬
 * 입력을 받으면서 그 정점에 선행 작업의 개수를 세어준다
 * 선행작업이 0인 정점을 큐에 넣어준다
 * 큐에서 정점을 꺼내고 그 정점과 연결된 정점을 탐색하면서 연결된 정점의 선행작업 개수를 1개 빼준다(현재 정점은 이미 완료되었으므로)
 * 만약 연결된 정점의 선행작업 개수가 0이라면 큐에 넣어준다
 * 위 과정을 반복한다
 */
public class BOJ_2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int[] check = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			check[B]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < N+1; i++) {
			if(check[i] == 0)
				q.add(i);
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			int a = q.poll();
			result.add(a);
			
			for (int b : list[a]) {
				check[b]--;
				
				if(check[b] == 0)
					q.add(b);
			}
			
		}
		
		System.out.println(result);
	}

}
