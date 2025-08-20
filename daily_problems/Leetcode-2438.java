class Solution {
    final int MOD = (int)(1e9 + 7);

    public int[] productQueries(int n, int[][] queries) {
        List <Integer> powers=new ArrayList<>();
        List <Integer> ans=new ArrayList<>();

        for(int i=0;i<32;i++){
            if(( n & (1<<i)) != 0)
            powers.add(1<<i);
        }
        for(int[] query: queries){
            int start=query[0];
            int end=query[1];
            long res=1;
            for(int i=start;i<=end;i++){
                res = (res*powers.get(i)) % MOD;
            }
            ans.add((int)res);
        }

        return ans.stream().mapToInt(i->i).toArray();
    }
}
