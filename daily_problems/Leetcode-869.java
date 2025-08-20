class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] input= countdigits(n);

        for(int i=0;i<31;i++){
            int pow= 1<<i;
            int[] parr= countdigits(pow);
            if(matches(input,parr))
            return true;
        }

        return false;
    }
    private boolean matches(int[] a, int[] b){
        for(int i=0; i< a.length;i++){
            if(a[i]!=b[i])
            return false;
        }
        return true;
    }
    private int[] countdigits(int n){
        int[] res=new int[10];
        while(n>0){
            res[n%10] += 1;
            n /= 10;
        }
        return res;
    }
}
