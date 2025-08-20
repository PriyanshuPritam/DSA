import java.util.*;
class Solution {
    public int longestSubarray(int[] nums) {
        int max=nums[0];
        for(int num:nums){
            max= Math.max(max,num);
        }

        int curr=0, maxlen=0;
        for(int num:nums){
            if(num==max){
                curr++;
                maxlen=Math.max(maxlen,curr);
            }
            else
            curr=0;
        }
        return maxlen;

    }
}
