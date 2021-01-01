import java.util.*;

public class BOJ5904_moo {

    static int N;
    static ArrayList<Integer> len;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        len = new ArrayList<Integer>();
        int index = 0;

        while(true) {
            if(len.size() == 0) {
                len.add(3);
            }

            // 정답 출력
            if(len.get(index) >= N)	{
                play(index);
                break;
            }

            int pos = len.get(index);
            index++;	// 현재 인덱스

            int strlen = (pos*2) + (index+3);
            len.add(strlen);
        }
        sc.close();
    }

    private static void play(int index) {
        if(index == 0) {
            if(N == 1)  System.out.println("m");
            else        System.out.println("o");
            return;
        }

        if(N <= len.get(index-1)){
            play(index-1);
        }
        else if(N <= len.get(index-1) + index +3){
            if(N == len.get(index-1)+1) System.out.println("m");
            else                        System.out.println("o");
        }
        else {
            N -= len.get(index-1) + index + 3;
            play(index-1);
        }

    }
}
