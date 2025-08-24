class Solution {
    public int longestSubarray(int[] nums) {
        int left=0;
        int right=0;
        boolean isdeleted=false;
        int ans=0;

        while(right<nums.length){
            int num=nums[right];
            if(num==1){
                ans=isdeleted? Math.max(ans,right-left):Math.max(ans,right-left+1);
            }
            else{
                if(isdeleted){
                    while(nums[left]==1){
                    left +=1;
                }
                left +=1;
                }
                else{
                isdeleted=true;
                }
            }
            right += 1;
        }
        return isdeleted ? ans : ans - 1;
    }
}
