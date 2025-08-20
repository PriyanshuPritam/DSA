class Solution {
    private int lowerbound(int[] arr,int target){
        int low=0;
        int high=arr.length;
        while(low<high){
            int mid=(low+high)/2;
            if(arr[mid]<target)
            low=mid+1;
            else
            high=mid;
        }
        return low;
    }
    private int upperbound(int[] arr,int target){
        int low=0;int high=arr.length;
        while(low<high){
            int mid=(low+high)/2;
            if(arr[mid]<=target)
            low=mid+1;
            else
            high=mid;
        }
        return low;
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n=fruits.length;
        int[] sums=new int[n];
        int[] indices=new int[n];

        for(int i=0;i<n;i++){
            indices[i]=fruits[i][0];
            sums[i]=fruits[i][1] + (i>0?sums[i-1]:0);
        }

        int maxfruits=0;

        for(int d=0;d<=k;d++){
            int remain=k-2*d;
            int i=startPos-d;
            int j=startPos+remain;

            int left=lowerbound(indices,i);
            int right=upperbound(indices,j)-1;

            if(left<=right){
                int total=sums[right]-(left>0? sums[left-1]:0);
                maxfruits=Math.max(maxfruits,total);
            }
            remain=k-2*d;
            i=startPos-remain;
            j=startPos+d;

            left=lowerbound(indices,i);
            right=upperbound(indices,j)-1;

            if(left<=right){
                int total=sums[right]-(left>0?sums[left-1]:0);
                maxfruits=Math.max(maxfruits,total);
            }
        }
        return maxfruits;
    }
}
