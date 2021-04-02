import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		// 1. String 배열에 단어 저장
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = sc.nextLine();
		}

		// 2. 단어 정렬
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2); // 사전 순으로
				}
				return o1.length() - o2.length(); // 길이가 짧은 순으로
			}
		});

		// 3. 중복제거하여 출력
		String str = words[0];
		System.out.println(str);
		for (int i = 1; i < N; i++) {
			if (words[i].equals(str)) {
				continue;
			}
			System.out.println(words[i]);
			str = words[i];
		}
	}

}
