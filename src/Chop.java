/**
 * Write a binary chop method that takes an integer search target and a sorted array of integers.
 * It should return the integer index of the target in the array, or -1 if the target is not in the array
 */
public class Chop {

    public int chop(int target, int[] data) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (data[m] == target) return m;
            if (data[m] > target) right = m - 1;
            else left = m + 1;
        }

        return -1;
    }
}
