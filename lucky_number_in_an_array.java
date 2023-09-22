class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<>();

         
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int temp_j = 0;
                Boolean isRowMin = true;
                while(temp_j < col){
                    if(matrix[i][temp_j] < matrix[i][j]) isRowMin = false;
                    temp_j++;
                } 

                int temp_i = 0;
                Boolean isColMax = true;
                while(temp_i < row){
                    if(matrix[temp_i][j] > matrix[i][j]) isColMax = false;
                    temp_i++;
                }

                if(isRowMin && isColMax) ans.add(matrix[i][j]);
            }
        }
        

        // Optimised Approach | TC = O(m*(m+n))
        for(int i = 0; i < row; i++){
            int minColIndex = minColIndexInRow(matrix, i, col);
            int luckyNum = matrix[i][minColIndex];

            if(checkIfMaxInCol(matrix, minColIndex, luckyNum, row)){
                ans.add(luckyNum);
            }
        }

        return ans;
    }

    private int minColIndexInRow (int [][] matrix, int i, int col){
        int j =  0, min = matrix[i][j];
        int minColIndex = 0;

        for(j = 1; j < col; j++){
            if(matrix[i][j] < min){
                min = matrix[i][j];
                minColIndex = j;
            }
        }

        return minColIndex;
    }

    private Boolean checkIfMaxInCol(int [][] matrix, int j, int num, int row){
        for(int i = 0; i < row; i++){
            if(matrix[i][j] > num) return false;
        }

        return true;
    }
}
