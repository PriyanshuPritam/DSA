class Solution {
    private boolean querysegmenttree(int i,int l, int r, int[] segmenttree, int val){
        if(segmenttree[i]<val)
        return false;

        if(l==r){
            segmenttree[i]=-1;
            return true;
        }
        int mid=(l+r)/2;
        boolean placed =false;

        if(segmenttree[2*i+1]>=val){
            placed=querysegmenttree(2*i+1,l,mid,segmenttree,val);
        }
        else{
            placed=querysegmenttree(2*i+2,mid+1,r,segmenttree,val);
        }
        segmenttree[i]=Math.max(segmenttree[2*i+1],segmenttree[2*i+2]);

        return placed;

    }
    private void build(int i,int l,int r, int[] baskets,int[] segmenttree){
        if(l==r){
            segmenttree[i]=baskets[l];
            return;
        }
        int m=(l+r)/2;
        build(2*i+1,l,m,baskets,segmenttree);
        build(2*i+2,m+1,r,baskets,segmenttree);

        segmenttree[i]=Math.max(segmenttree[2*i+1],segmenttree[2*i+2]);
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int[] segmenttree=new int[4*n];

        build(0,0,n-1,baskets,segmenttree);

        int unplaced=0;
        for(int fruit: fruits){
            if(!querysegmenttree(0,0,n-1,segmenttree,fruit)){
                unplaced++;
            }
        }
        return unplaced;
        
    }
}
