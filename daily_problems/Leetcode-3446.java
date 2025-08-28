class Solution {
    private int n;
    private void sortdiagonal(int r,int c, int[][] grid, boolean asc){
        List<Integer> vec=new ArrayList<>();

        int i =r, j=c;
        while(i<n && j<n){
            vec.add(grid[i][j]);
            i++;
            j++;
        }
        if(asc){
            Collections.sort(vec);
        }
        else
        vec.sort(Collections.reverseOrder());

        i=r;
        j=c;
        for(int val:vec){
            grid[i][j]=val;
            i++;
            j++;
        }
    }
    public int[][] sortMatrix(int[][] grid) {
        n=grid.length;
        for(int row=0;row<n;row++){
            sortdiagonal(row,0,grid,false);
        }
        for(int col=1;col<n;col++){
            sortdiagonal(0,col,grid,true);
        }
        return grid;
    }
}
