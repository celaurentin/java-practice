/**
 *  Given a 2D matrix of integers where each row is sorted ascending,
 *  find the maximum number of occurrences for a given target number
 *  using the fewest number of reads.
 *
 *  example:
 *  matrix
 *  {
 *      {1,2,3,4,5},
 *      {2,4,8,9,10},
 *      {3,5,9,10,18},
 *      {8,9,16,18,20}
 *  }
 *
 *  target: 9
 *  output: 3
 */

public class MatrixMaxOccurrence {

    public int getMaxOccurrence(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int counter = 0;
        for (int i=0; i<rows; i++ ){
            if (target>=matrix[i][0] && target<=matrix[i][cols-1]) {
                counter += getOccurrence(matrix, i, target);
            }
        }
        return counter;
    }

    // Binary search - target could be present just once per row
    private int getOccurrence(int[][] matrix, int i, int target){
        int[] row = matrix[i];
        int left = 0;
        int right = row.length;

        while (left <= right){
            int middle = (left + right)/2;
            if (target == row[middle]) return 1;
            else if (target > row[middle]) left = middle + 1;
            else right = middle - 1;
        }
        return 0;
    }

}
