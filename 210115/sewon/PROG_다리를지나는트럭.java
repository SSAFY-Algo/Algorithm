import java.util.*;

public class PROG_다리를지나는트럭 {

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        int weight_sum = 0;
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();

        for(int t: truck_weights) {
            while (true) {
                if(q.isEmpty()) {
                    answer++;
                    q.add(t);
                    weight_sum += t;
                    break;
                }

                if (q.size() == bridge_length) {
                    weight_sum -= q.poll();
                }
                else {
                    if (weight_sum + t <= weight) {
                        q.add(t);
                        weight_sum += t;
                        answer++;
                        break;
                    }

                    q.add(0);
                    answer++;
                }
            }
        }
        System.out.println(answer + bridge_length);
    }
}
