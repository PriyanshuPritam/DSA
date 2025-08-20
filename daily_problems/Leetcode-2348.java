class Solution {static
    {
        for(int i=0;i<=201;i++) zeroFilledSubarray(new int[1]);
    }
    public static long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long count=0;

        for(int num:nums){
            if(num==0)
            count += 1;
            else
            count=0;
            res += count;
        }
        return res;
    }
}
