class Solution {
    private int utility(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int result = Integer.MAX_VALUE;

        for(int rowsplit=1;rowsplit<m;rowsplit++){
            for(int colsplit=1;colsplit<n;colsplit++){
                int top=minimumArea(0,rowsplit,0,n,grid);
                int bottomleft=minimumArea(rowsplit,m,0,colsplit,grid);
                int bottomright=minimumArea(rowsplit,m,colsplit,n,grid);

                result=Math.min(result,top+bottomleft+bottomright);
            }
        }
        for(int rowsplit=1;rowsplit<m;rowsplit++){
            for(int colsplit=1;colsplit<n;colsplit++){
                int topleft=minimumArea(0,rowsplit,0,colsplit,grid);
                int topright=minimumArea(0,rowsplit,colsplit,n,grid);
                int bottom=minimumArea(rowsplit,m,0,n,grid);

                result=Math.min(result,topleft+bottom+topright);
            }
        }

        for(int split1=1;split1<m;split1++){
            for(int split2=1;split2<m;split2++){
                int top=minimumArea(0,split1,0,n,grid);
                int middle=minimumArea(split1,split2,0,n,grid);
                int bottom=minimumArea(split2,m,0,n,grid);

                result=Math.min(result,top+middle+bottom);
            }
        }
        return result;
    }
    private int[][] rotateclockwise(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] rotatedgrid=new int[n][m];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rotatedgrid[j][m-i-1]=grid[i][j];
            }
        }
        return rotatedgrid;
    }
    private int minimumArea(int startrow,int endrow,int startcol,int endcol, int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int minrow=m, maxrow=-1, mincol=n, maxcol=-1;
        for(int i=startrow;i<endrow;i++){
            for(int j=startcol;j<endcol;j++){
                if(grid[i][j]==1){
                    minrow=Math.min(minrow,i);
                    maxrow=Math.max(maxrow,i);
                    mincol=Math.min(mincol,j);
                    maxcol=Math.max(maxcol,j);
                }
            }
        }
        if(maxrow < startrow) return 0;
        return (maxrow-minrow+1)*(maxcol-mincol+1);
     }
    public int minimumSum(int[][] grid) {
        int result=utility(grid);
        int[][] rotatedgrid=rotateclockwise(grid);
        result=Math.min(result,utility(rotatedgrid));
        return result;
        }
}
