import java.util.Scanner;

public class BOJ1439_뒤집기 {
    static String S;
    static boolean[] visit;
    static int[] num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();
        visit = new boolean[S.length()];
        num = new int[2];

        for (int i = 0; i < S.length(); i++) {
            if(!visit[i]) {
                i += go(i, S.charAt(i), 0) - 1;
                num[S.charAt(i) - '0']++;
            }
        }

        System.out.println(Math.min(num[0], num[1]));
    }

    public static int go(int pos, char ch, int count) {
        if(pos == S.length() || S.charAt(pos) != ch) {
            return count;
        }

        visit[pos] = true;
        return go(pos+1, ch, count+1);
    }
}
