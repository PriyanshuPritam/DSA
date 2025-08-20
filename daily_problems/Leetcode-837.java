class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] p=new double[n+1];
        p[0]=1.0;
        double currsum=(k>0?1.0:0.0);

        for(int i=1;i<=n;i++){
            p[i]=currsum/maxPts;

            if(i<k){
                currsum += p[i];
            }

            if(i-maxPts >= 0 && i-maxPts<k){
                currsum -= p[i-maxPts];
            }
        }

        double ans=0.0;
        for(int i=k;i<=n;i++){
            ans+=p[i];
        }
        return ans;
    }
}
