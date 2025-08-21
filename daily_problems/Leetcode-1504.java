class Solution {
    public int numSubmat(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int[][] width=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0)
                width[i][j]=0;
                else
                width[i][j]=(i==0 ? 1: width[i-1][j]+1);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int min=width[i][j];
                for(int k=j;k>=0 && min>0;k--){
                    min = Math.min(min,width[i][k]);
                    ans += min;
                }
            }
        }
        return ans;
    }
}
