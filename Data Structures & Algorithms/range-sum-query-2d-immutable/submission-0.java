class NumMatrix {
    private int[][] prefixSums;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefixSums = new int[rows + 1][cols + 1];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                prefixSums[r + 1][c + 1] = matrix[r][c] 
                                         + prefixSums[r][c + 1] 
                                         + prefixSums[r + 1][c] 
                                         - prefixSums[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSums[row2 + 1][col2 + 1] 
             - prefixSums[row1][col2 + 1] 
             - prefixSums[row2 + 1][col1] 
             + prefixSums[row1][col1];
    }
}