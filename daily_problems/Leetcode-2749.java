class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        int k=1;
        while(true){
            long diff=(long)num1-(long)k*num2;

            if(diff<k)
            return -1;

            if(k>=Long.bitCount(diff))
            return k;

            k++;
        }
    }
}
