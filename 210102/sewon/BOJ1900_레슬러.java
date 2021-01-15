import java.io.*;
import java.util.*;

public class BOJ1900_레슬러 {

    public static class Person {
        int num, power, magicPower, winCount;

        public Person(int num, int power, int magicPower) {
            this.num = num;
            this.power = power;
            this.magicPower = magicPower;
        }
    }

    static Person[] people;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        people = new Person[N];

        // input
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            people[i] = new Person(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N-1; i++) {
           for (int j = i+1; j < N; j++) {
               fight(people[i], people[j]);
           }
        }

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.winCount-o1.winCount;
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(people[i].num);
        }
    }

    private static void fight(Person A, Person B) {
        int powerA = A.power + B.power * A.magicPower;
        int powerB = B.power + A.power * B.magicPower;

        if(powerA > powerB) {
            A.winCount++;
        }
        else {
            B.winCount++;
        }
    }
}
