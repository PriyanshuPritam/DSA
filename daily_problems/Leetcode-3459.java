class Solution {
    private int n;
    private int m;
    private int[][] dir={
        {1,1},{1,-1},{-1,-1},{-1,1}
    };
    public int lenOfVDiagonal(int[][] grid) {
       n=grid.length;
       m=grid[0].length;
       
       Integer[][][][] dp= new Integer[n][m][4][2];

       int maxlength=0;

       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==1){
                for(int d=0;d<4;d++){
                    maxlength=Math.max(maxlength,1+dfs(grid,i,j,2,d,true,dp));
                }
            }
        }
    }
        return maxlength;
    }

    private boolean isValid(int[][] grid,int i, int j, int expected){
        return i>=0 && i<n && j>=0 && j<m && grid[i][j]==expected;
    }
    private int dfs(int[][] grid,int i, int j, int expected,int d, boolean canTurn, Integer[][][][] dp){
        int newi=i+dir[d][0];
        int newj=j+dir[d][1];

        if(!isValid(grid,newi,newj,expected))
        return 0;

        int cindex=canTurn?1:0;
        
        if(dp[newi][newj][d][cindex] != null){
            return dp[newi][newj][d][cindex];
        }

        int nextExpected=expected == 2? 0:2;

        int maxlength=dfs(grid,newi,newj,nextExpected,d,canTurn,dp);

        if(canTurn){
            int newDir=(d+1)%4;
            maxlength=Math.max(maxlength,dfs(grid,newi,newj,nextExpected,newDir, false, dp));
        }

        dp[newi][newj][d][cindex]=1+maxlength;
        
        return dp[newi][newj][d][cindex];
    }
}
