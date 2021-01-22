import java.util.Scanner;

public class BOJ1543_문서검색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();
        int answer = 0;

        for (int i = 0; i <= doc.length() - word.length(); i++) {
            int count = 0;
            for (int j = i; j <= doc.length() - word.length(); j++) {
                boolean flag = true;
                for (int k = 0; k < word.length(); k++) {
                    if(doc.charAt(j+k) != word.charAt(k)) {
                        flag = false;
                        break;
                    }
                }

                // word를 찾았다!
                if (flag) {
                    count++;
                    j += word.length()-1;
                }
            }

            // answer 값 갱신
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
