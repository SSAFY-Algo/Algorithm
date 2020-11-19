package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_�Կ��̿��ο�����ī�����_201119 {

	static int wcount, lcount; // �Կ����� ��� Ƚ��, �� Ƚ��
	private static int[] in;
	private static int[] gyu;
	private static int[] number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			gyu = new int[9]; // �Կ����� �迭
			in = new int[9]; // �ο����� �迭
			StringTokenizer st = new StringTokenizer(br.readLine());
			number = new int[19];// �ο��̰� ������ �ִ� ���� �迭

			for (int i = 0; i < 9; i++) {
				// �Կ��̰� ���� ī�� ���
				int n = Integer.parseInt(st.nextToken());
				gyu[i] = n;
				number[gyu[i]] = 1; // ���߿� 0 �� �ֵ鸸 �ο��� ���� �迭�� �־��ֱ�
			}

			wcount = 0; // �Կ����� ���Ƚ�� �ʱ�ȭ
			lcount = 0; // �Կ����� �� Ƚ�� �ʱ�ȭ
			Permutation(0);
			System.out.println("#" + tc + " " + wcount + " " + lcount);
		} // end of test case
	}

	private static void Permutation(int cnt) {

		if (cnt == 9) {
			// �̶� �Կ��� �迭�̶� ���ؼ� ����ϸ� count ++
			int kSum = 0, iSum = 0;
			for (int i = 0; i < 9; i++) {
				if (gyu[i] > in[i]) {
					kSum += (gyu[i] + in[i]);
				} else
					iSum += (gyu[i] + in[i]);
			}
			if (kSum > iSum)
				wcount++;
			else if (kSum < iSum)// �Կ��� ����
				lcount++;
			return;
		}

		for (int i = 1; i < 19; i++) {
			if (number[i] == 0) {
				number[i] = 1;
				in[cnt] = i;
				Permutation(cnt + 1);
				number[i] = 0;
			}
		}
	}
}
