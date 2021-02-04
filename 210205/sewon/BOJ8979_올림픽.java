import java.io.*;
import java.util.*;

public class BOJ8979_올림픽 {
    public static class Country {
        int num, gold, silver, bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Country[] countries = new Country[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries[i] = new Country(num, gold, silver, bronze);
        }

        Arrays.sort(countries, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if(o1.gold == o2.gold) {
                    if(o1.silver == o2.silver) {
                        return o2.bronze - o1.bronze;
                    }
                    return o2.silver - o1.silver;
                }
                return o2.gold - o1.gold;
            }
        });

        int rank = 0;
        int count = 0;
        int score = -1;
        for (int i = 0; i < N; i++) {
            count++;

            int tmp = (countries[i].gold * 3) + (countries[i].silver * 2) + (countries[i].bronze);
            if(score != tmp) {
                rank = count;
                score = tmp;
            }

            if(countries[i].num == K) {
                System.out.println(rank);
                break;
            }
        }
    }
}
