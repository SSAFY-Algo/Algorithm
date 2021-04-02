/*

키의 일부분이 자물쇠 배열에 포함되어야 함
배열을 늘려서(arr배열 생성) 키가 위치할 수 있는 경우를 확인 -> 키 길이 * 3 - 2 만큼
네 방향 모두 탐색
자물쇠 배열은 arr배열의 중앙에 위치 (key길이-1부터 시작한다)
회전하면서 arr배열에 key의 값을 더해준다 
arr배열에서 자물쇠 배열이 있는 위치들을 탐색해서 1이 나온다면 자물쇠는 풀림


*/
public class PROG_60059_자물쇠와열쇠 {

	public boolean solution(int[][] key, int[][] lock) {
        int offset = key.length - 1; // 열쇠를 기준으로 가장 마지막
        
        // r -> offset에다가 자물쇠를 더한 크기만큼 쓴다 (key의 첫번째 행 기준)
        // c -> offset + lock.length만큼 배열 사용 (key의 첫번째 열 기준)
        for(int r=0; r<offset + lock.length; r++){
            for(int c=0; c<offset + lock.length; c++){
                for(int rot=0; rot<4; rot++){ // 4번 방향으로 돌릴 수 있음
                    int[][] arr = new int[58][58]; // 최대 크기 20 + 20 + 20 - 2
                    
                    // lock이 가운데 위치할 수 있도록 자물쇠 복사
                    for(int i=0; i<lock.length; i++){
                        for(int j=0; j<lock.length; j++){
                            arr[offset+i][offset+j] = lock[i][j];
                        }
                    }
                    
                    // 회전하면서 arr 배열에 key와 lock을 더해준다
                    // 복사한 자물쇠 배열, 키 배열, 회전 횟수, row, col 
                    match(arr, key, rot, r, c);
                    
                    // 더한 값이 모두 1인지 확인 -> 통과
                    if(check(arr, offset, lock.length)){
                        return true;
                    }
                    
                }
            }
        }
        
        // true가 반환이 안된다면 자물쇠 풀지 못함
        return false;
    }
    
    public boolean check(int[][] arr, int offset, int n) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // arr 배열에서 자물쇠가 있는 범위를 탐색하면서 1이 아닌 값이 나온다면 풀리지 않음 
                if(arr[offset+i][offset+j] != 1){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void match(int[][] arr, int[][] key, int rot, int r, int c){
        int n = key.length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                // 회전 안한 경우
                if(rot == 0) {
                    arr[r+i][c+j] += key[i][j];
                } else if(rot == 1){ // 90도 회전한 경우
                    arr[r+i][c+j] += key[j][n-1-i];
                } else if(rot == 2) { // 180도 회전한 경우
                    arr[r+i][c+j] += key[n-1-i][n-1-j];
                } else { // 270도 회전
                    arr[r+i][c+j] += key[n-1-j][i];
                }
                
            }
        }
        
    }


}
