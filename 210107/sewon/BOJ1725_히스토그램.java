import java.io.*;
import java.util.*;

public class BOJ1725_히스토그램 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long answer = 0;
            int N = Integer.parseInt(st.nextToken());
            if(N == 0)  return;

            int[] numbers = new int[N];
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i <N ; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i <= N; i++) {

                if(i == N) {
                    while(!stack.isEmpty()) {
                        int top = stack.peek();
                        long height = numbers[stack.peek()];
                        long width = N - top;
                        stack.pop();

                        if(!stack.isEmpty())    width += top - stack.peek() - 1;
                        answer = Math.max(answer, height*width);
                    }
                    break;
                }

                while(!stack.isEmpty() && numbers[stack.peek()] > numbers[i]) {
                    // 낮은 기둥 발견
                    int top = stack.peek();
                    long height = numbers[stack.peek()];
                    long width = i - top;
                    stack.pop();

                    if(!stack.isEmpty())    width += top - stack.peek() - 1;
                    answer = Math.max(answer, height*width);
                }
                stack.push(i);
            }

            System.out.println(answer);
        }
    }
}
