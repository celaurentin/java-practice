/**
 * Given an n x n square matrix, rotate the matrix 90 degrees in clockwise direction,
 * without using n x n extra space.
 */
public class RotateMatrix {

    public int[][] rotateMatrix(int[][] matrix){
        int matrixLength = matrix[0].length;
        // Swapping values to convert into transpose matrix
        for (int row = 0; row<matrixLength; row++){
            for (int col=row; col<matrixLength; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // Reverse rows from transposed matrix to get the result
        int row = 0;
        while (row < matrixLength){
            int i = 0;
            int j = matrixLength - 1;
            while (i < j){
                int temp = matrix[row][j];
                matrix[row][j] = matrix[row][i];
                matrix[row][i] = temp;
                i++;
                j--;
            }
            row++;
        }

        return matrix;
    }


}
