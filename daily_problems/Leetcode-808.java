class Solution {
    Double[][] memo;
    private double solve(int a,int b){
        if((a<=0 && b<=0))
        return 0.5;

        if(a<=0)
        return 1.0;

        if(b<=0)
        return 0.0;

        if(memo[a][b] != null){
            return memo[a][b];
        }

        memo[a][b]=0.25*(solve(a-4,b) +
                        solve(a-3,b-1)+
                        solve(a-2,b-2)+
                        solve(a-1,b-3));
        return memo[a][b];
    }
    public double soupServings(int n) {
        if(n>5000)
        return 1.0;
        int m=(int)Math.ceil(n/25.0);
        memo = new Double[m+1][m+1];
        return solve(m,m);
    }
}
