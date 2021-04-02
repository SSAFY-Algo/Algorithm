import java.util.*;
public class PROG_42895_N으로표현 {

	static int answer = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        
        dfs(N, number, 0, 0);
       
        // 8이하일때 값이 안나오면 -1 출력
        return (answer==Integer.MAX_VALUE)?-1:answer;
    }
    static void dfs(int N, int number, int cnt, int calc){
        // N 사용횟수가 8이 넘으면 return
        if(cnt > 8) {
            answer = -1;
            return;
        }
        
        // 계산결과가 number이면 answer 판별(최솟값)
        if(calc == number){
            answer = Math.min(answer, cnt);
            return;
        }
        
        // N이 연속으로 몇번 나올 수 있는지?
        // N, NN, NNN, NNNN, ... (1 ~ 8-cnt개까지 가능)
        for(int i=1; i<=8-cnt; i++){
            // cnt + i -> cnt에 N개를 쓴 횟수만큼 더한다
            // calc와 연속된 수를 계산해줌
            dfs(N, number, cnt + i, calc + number(i, N));
            dfs(N, number, cnt + i, calc - number(i, N));
            dfs(N, number, cnt + i, calc * number(i, N));
            dfs(N, number, cnt + i, calc / number(i, N));
        }
        
    }
    
    // N...N (i개)
    static int number(int i, int N){
        int calc = 0;
        for(int j=0; j<i; j++){
            calc += Math.pow(10,j)*N;
        }
        return calc;
    }
	    
	
}
