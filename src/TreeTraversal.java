/**
 * Suppose you're given a binary tree represented as an array. For example,
 * [3, 6, 2, 9, -1, 10] represents the following binary tree (where -1 is a
 * non-existent node)
 *                                   [3]
 *                            [6]           [2]
 *                        [9]     -1   [10]     \\
 *
 * Write a function that determines weather the left or right branch of the tree is
 * larger. The size of each branch s the sum of the node values. The function should
 * return the string "Right" if the right side is larger and "Left" if the left side
 * is larger. If the tree has 0 nodes or if the size of hte branches are equal, then
 * return empty string.
 *
 */
class TreeTraversal {

    public String solution(long[] btree) {
        // Type your solution here
        if (btree==null || btree.length ==0){
            return "";
        } else {
            long leftSize = treeTraversal(btree,1);
            long rightSize = treeTraversal(btree, 2);

            if (leftSize > rightSize) return "Left";
            else if (leftSize < rightSize) return "Right";
            else return "";
        }
    }

    private long treeTraversal(long[] btree, int index) {
        if (index >= btree.length || btree[index] == -1) {
            return 0;
        } else {
            return btree[index] + treeTraversal(btree, index*2 + 1) +
                    btree[index] + treeTraversal(btree, index*2 + 2);
        }
    }
}
