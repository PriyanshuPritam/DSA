class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set=new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch=board[i][j];

                if(ch=='.')continue;

                String row="r_"+i+"_"+ch;
                String col="c_"+j+"_"+ch;
                String grid="g_"+i/3+"_"+j/3+"_"+ch;

                if(set.contains(row) || set.contains(col) || set.contains(grid))
                return false;

                set.add(row);
                set.add(col);
                set.add(grid);
            }
        }
        return true;
    }
}
