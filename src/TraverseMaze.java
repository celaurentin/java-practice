import java.util.LinkedList;

/*
-Problem: Given a maze (an array of long of n x n), verify if a path exists from (0,0) to (n-1, n-1), cells marked with
1 are blocked.

-Test case:
Input:
n = 3
maze =
    [0, 0, 0],
    [0, 0, 1],
    [1, 0, 0]

Expected return value: true
*/
public class TraverseMaze {

    public boolean hasValidPath(int[][] maze, int n)
    {
        // Marking blocked cells as visited.
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
            {
                // A cell can not be visited
                visited[i][j] = maze[i][j] == 1;
            }
        }

        // Step 1: BFS
        // applying BFS on the matrix starting from top-left corner
        MazeCell start = new MazeCell(0,0);

        LinkedList<MazeCell> stack = new LinkedList<>();
        stack.push(start);
        visited[start.row][start.col] = true;
        while (!stack.isEmpty()) {
            MazeCell p = stack.pop();

            //Checks if target was reached
            if (p.row == n-1 && p.col == n-1)
                return true;

            // moving right
            if (p.col + 1 < n && !visited[p.row][p.col + 1]) {
                stack.push(new MazeCell(p.getRow(), p.getCol() + 1));
                visited[p.getRow()][p.getCol() + 1] = true;
            }

            // moving down
            if (p.row + 1 < n && !visited[p.row + 1][p.col]) {
                stack.push(new MazeCell(p.getRow()+1, p.getCol()));
                visited[p.getRow() + 1][p.getCol()] = true;
            }

            // moving left
            if (p.col - 1 >= 0 && !visited[p.getRow()][p.getCol() - 1]) {
                stack.push(new MazeCell(p.getRow(), p.getCol() - 1));
                visited[p.row][p.getCol() - 1] = true;
            }

            // moving up
            if (p.getRow() - 1 >= 0 && !visited[p.getRow() - 1][p.getCol()]) {
                stack.push(new MazeCell(p.getRow()-1, p.getCol()));
                visited[p.getRow()-1][p.getCol()] = true;
            }
        }
        return false;
    }

    public static class MazeCell {
        private int row;
        private int col;

        public MazeCell(int row, int col) {
            this.row = row;
            this.col = col;
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

    }
}
