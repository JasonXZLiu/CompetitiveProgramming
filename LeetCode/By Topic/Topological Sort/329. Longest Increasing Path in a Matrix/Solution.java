class Solution {
    int N, M;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        N = matrix.length;
        M = matrix[0].length;
        
        int[][] cache = new int[N][M];
        int count = 0;
        
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                count = Math.max(count, dfs(matrix, i, j, cache));
                
        return count;
    }
    
    public int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        
        for (int k = 0; k < 4; k++) {
            int nX = i + dx[k], nY = j + dy[k];
            
            if (nX >= 0 && nX < N && nY >= 0 && nY < M && matrix[nX][nY] < matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, nX, nY, cache));
        }
        
        return ++cache[i][j];
    }
}