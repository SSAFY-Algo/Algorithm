package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1978_�Ҽ�ã�� {
	
	static int N = 1001;
	static boolean[] base = new boolean[N+1]; // 1���� 1000������ ���� �迭, false�� �ʱ�ȭ
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(bf.readLine());
		
		int range = Integer.parseInt(tk.nextToken());
		int[] array = new int[range];

		int count = 0;
		
		chk_prime();
		
		tk = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<range; i++) {
			array[i]=Integer.parseInt(tk.nextToken());
			
			if(base[array[i]]) continue;
			else count++;

		}
		
		System.out.println(count);
		
	}
	
	static boolean chk_prime() {
		// N���� �Ҽ��� ������ ������� base�迭�� true�� ����
		
		base[0]=base[1]=true;
		// 2 index����
		for(int i=2; i<N;i++) {
			for(int j=i; j<N; j++) {
				if(i*j>N) break;
				base[i*j]=true;
			}
		}
		return true;
	}
	
}
