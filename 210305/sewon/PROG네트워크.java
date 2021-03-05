class Solution {
    static boolean[][] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1 && !visited[i][j]) {
                    answer++;
                    visited[i][j] = true;
                    DFS(i, j, n, computers);
                }
            }
        }
        return answer;
    }
    
    public void DFS(int s, int e, int n, int[][] computers) {
        for(int i=0; i<n; i++) {
            if(computers[e][i] == 1 &&!visited[e][i]) {
                visited[e][i] = true;
                DFS(e, i, n, computers);
            }
        }
    }
}
