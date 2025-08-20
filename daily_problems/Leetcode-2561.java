class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> count=new TreeMap<>();
        int n=basket1.length;
        int minval=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            count.put(basket1[i],count.getOrDefault(basket1[i],0)+1);
            count.put(basket2[i],count.getOrDefault(basket2[i],0)-1);
            minval=Math.min(minval,Math.min(basket1[i],basket2[i]));
        }
        List <Integer> toSwap=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e: count.entrySet()){
            int val=e.getKey();
            int bal=e.getValue();
            if(bal%2 != 0)
            return -1;
            for(int k=0;k<Math.abs(bal)/2;k++){
                toSwap.add(val);
            }
        }
        Collections.sort(toSwap);
        int m=toSwap.size();
        long cost=0;
        for(int i=0;i<m/2;i++){
            cost += Math.min(toSwap.get(i),2*minval);
        }
        return cost;
    }

}
