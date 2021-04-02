import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N, M;
		int[] arr, arr2;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = N - 1;
			search(left, right, arr, num);
		}
	}

	private static void search(int left, int right, int[] arr, int num) {
		// 기저조건
		if (left > right) {
			System.out.println(0);
			return;
		}

		// 유도조건
		int middle = (left + right) / 2;
		if (arr[middle] == num) {
			System.out.println(1);
			return;
		}

		if (arr[middle] < num) {
			search(middle + 1, right, arr, num);
		} else {
			search(left, middle - 1, arr, num);
		}

	}
}

