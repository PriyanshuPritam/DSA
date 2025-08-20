class Solution {
    public int numberOfWays(int n, int x) {
        long[] t=new long[n+1];
        t[0]=1;

        for(int i=1;Math.pow(i,x)<=n;i++){
            int num=(int)Math.pow(i,x);
            for(int s=n;s>=num;s--){
                t[s] += t[s-num];
            }
        }
        return (int) (t[n]%1_000_000_007);
    }
}
