class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxD=-1;
        int maxA=-1;

        for(int[] rect:dimensions){
            int l=rect[0];
            int w=rect[1];
            int diag= l*l + w*w;
            int area=l*w;

            if(diag>maxD){
                maxD=diag;
                maxA=area;
            }
            else if(diag==maxD)
            maxA= Math.max(area,maxA);
        }
        return maxA;
    }
}
