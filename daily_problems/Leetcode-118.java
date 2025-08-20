class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle=new ArrayList<>();

        for(int rownum=0;rownum<numRows;rownum++){
            List<Integer> row =new ArrayList<>();
            row.add(1);
            for(int j=1;j<rownum;j++){
                int left=triangle.get(rownum-1).get(j-1);
                int right=triangle.get(rownum-1).get(j);
                row.add(left+right);
            }

            if(rownum>0){
                row.add(1);
            }
            triangle.add(row);
        }
        return triangle;
    }
}
