
class PROG_43162_네트워크 {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]){
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int i,int[][] computers){
        visited[i] = true;
        
        for(int j=0; j<visited.length; j++){
            if(computers[i][j] == 1 && !visited[j]){
                dfs(j, computers);
            }
            
        }
            
    }
}