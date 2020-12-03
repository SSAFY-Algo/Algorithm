package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1946_���Ի�� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[][] score = new int[N][2]; // paper, interview score
			boolean[] notStaff = new boolean[N];
			int staffNum = N;
			// N���� ���� �� setting
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				score[i][0] = Integer.parseInt(st.nextToken()); // paper score
				score[i][1] = Integer.parseInt(st.nextToken()); // interview score
			}

			Arrays.sort(score, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			}); // ���������� �������� ����

//			for (int i = 0; i < N; i++) {
//				System.out.print(score[i][0] + " " + score[i][1]);
//				System.out.println();
//			}

			for (int i = 1; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if (score[i][1] > score[j][1])
						notStaff[i] = true;
					continue; // ���Ի�� �Ұ���
				}
			}
//			for(int i=0; i<N-1; i++) {
//				if(score[i][1]<=score[i+1][1]) {
//					
//				}
//			}

//			for (int i = 0; i < N; i++) {
//				if (notStaff[i] == true)
//					continue;
//				for (int j = 0; j < N; j++) {
//					if (j == i)
//						continue;
//					if (paperScore[i] > paperScore[j]) {
//						if (interviewScore[i] > interviewScore[j] && notStaff[i] == false) {
//							// ���Ի�� Ż���ϴ� ���
//							staffNum -= 1;
//							notStaff[i] = true;
//							System.out.println(paperScore[i] + " " + interviewScore[i]);
//						} else
//							continue;
//					}
//				}
//			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (notStaff[i] == false)
					count += 1;
			}
			
			System.out.println(count);

		} // end of testCase

	} // end of main
}
