import java.util.LinkedList;
import java.util.List;

/*
-Problem: You are in charge of preparing a recently purchased lot for one of Amazon's new building. The lot is covered
 with trenches and has a single obstacle that needs to be taken down before the foundation can be prepared for the
 building. The demolition robot must remove the obstacle before progress can be made on the building.

Write an algorithm to determine the minimum distance required for the demolition robot to remove the obstacle.

Assumptions:
- The lot is flat, except for trenches, and can be represented as a two-dimensional grid.
- The demolition robot must start from the top-left corner of the lot, which is always flat, and can move one block
up, down, left, or right at a time
- The demolition robot cannot enter trenches and cannot leave the lot.
- The flat areas are represented as 1, areas with trenches are represented  by 0 and the obstacle is represented by 9.

-Input:
The input to the function/method consists of three arguments: numRows, an integer representing the number of rows;
numColumns, an integer representing the number of columns; lot, representing the two-dimensional grid of integers.
-Output:
Return an integer representing the minimum distance traversed to remove the obstacle else return -1

Constrains:
1 <= numRows, numColumns <= 1000

-Test case:
Input:
numRows= 3
numColumns= 3
lot=
[[1, 0, 0],
[1, 0, 0],
[1, 9, 1]]

Expected return value: 3

Explanation: Starting from the top-left corner, the demolition robot traversed the cells (0,0) -> (1,0) -> (2,0) ->
(2,1). The robot traversed the total distance 3 to remove the obstacle. So, the output is 3.

----
Date: 04/13/2019
----
 */
public class DemolitionRobot {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        // WRITE YOUR CODE HERE

        // Step 0: Normalize data set
        Integer[][] rawLot = lot.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);

        // Marking blocked cells as visited.
        boolean[][] visited = new boolean[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++)
            {
                if (rawLot[i][j] == 0) {
                    // A trench can not be visited
                    visited[i][j] = true;
                } else {
                    visited[i][j] = false;
                }
            }
        }

        // Step 1: BFS
        // applying BFS on the matrix, starting from top-left corner
        PointLot start = new PointLot(0,0,0);

        LinkedList<PointLot> q = new LinkedList<>();
        q.add(start);
        visited[start.row][start.col] = true;
        while (!q.isEmpty()) {
            PointLot p = q.pop();

            //Checks for obstacle found
            if (rawLot[p.row][p.col] == 9)
                return p.getDistance();

            // moving right
            if (p.col + 1 < numColumns && !visited[p.row][p.col + 1]) {
                q.push(new PointLot(p.getRow(), p.getCol() + 1, p.getDistance() + 1));
                visited[p.getRow()][p.getCol() + 1] = true;
            }

            // ? moving down
            if (p.row + 1 < numRows && !visited[p.row + 1][p.col]) {
                q.push(new PointLot(p.getRow()+1, p.getCol(), p.getDistance() + 1));
                visited[p.getRow() + 1][p.getCol()] = true;
            }

            // moving left
            if (p.col - 1 >= 0 && !visited[p.getRow()][p.getCol() - 1]) {
                q.push(new PointLot(p.getRow(), p.getCol() - 1, p.getDistance() + 1));
                visited[p.row][p.getCol() - 1] = true;
            }

            // moving up
            if (p.getRow() - 1 >= 0 && !visited[p.getRow() - 1][p.getCol()]) {
                q.push(new PointLot(p.getRow()-1, p.getCol(), p.getDistance() + 1));
                visited[p.getRow()-1][p.getCol()] = true;
            }

        }
        return -1;
    }
    // METHOD SIGNATURE ENDS

    // MODEL FOR TRACKING ROBOT'S MOVEMENTS AND DISTANCE TRAVERSED
    public static class PointLot {
        private int row;
        private int col;
        private int distance;

        public PointLot(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
