import java.util.*;

public class BOJ1436_숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int num = 665;
        while(count < N) {
            num++;
            int temp = num;

            while(temp != 0) {
                if(temp % 1000 == 666) {
                    count++;
                    break;
                }
                else temp /= 10;
            }
        }
        System.out.println(num);
        sc.close();
    }
}
