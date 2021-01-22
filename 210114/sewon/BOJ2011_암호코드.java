import java.util.Scanner;

public class BOJ2011_암호코드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] password = sc.nextLine().toCharArray();
        int[] DP = new int[password.length+1];
        int mod = 1000000;

        if(password[0] == '0') {
            System.out.println(0);
            return;
        }

        DP[0] = DP[1] = 1;
        for (int i = 2; i <= password.length; i++) {
            int now = i-1;  // 실제 index를 맞추기 위해

            // 한 자리수
            if(password[now] != '0') {
                DP[i] += DP[i-1];
            }

            // 두자리수
            int num = (password[now-1] -'0')*10 + (password[now]-'0');  // 문자를 숫자로 변환
            if(num >= 10 && num <=26) {
                DP[i] = (DP[i] + DP[i-2])%mod;
            }
        }
        System.out.println(DP[password.length]);
    }
}
