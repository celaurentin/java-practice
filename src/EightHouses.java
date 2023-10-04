import java.util.Arrays;
import java.util.List;

/*
-Problem: Eight houses, represented as cells, are arranged in a straight line. Each day every cell competes with its
adjacent cells (neighbors). An integer value of 1 represents an active cell and a value of 0 represents an inactive
cell. If the neighbors on both the sides of a cell are either active or inactive, the cell becomes inactive on the
next day, otherwise the cell become active. The two cells on each end have a single adjacent cell, so assume that
the unoccupied space on the opposite side is an inactive cell. Even after updating the cell state, consider its
previous state when updating the state of other cells. The state information of all cells should be updated
simultaneously.

Write an algorithm to output the state of the cells after given number of days.

-Input:
The input to the function/method consists of two arguments "states", a list of integers representing the current
state of cells; "days", an integer representing the number of days.

-Output:
Return a list of integers representing the state of the cells after the given number of days.

Note: The elements of the list "states" contains 0s and 1s only.

-Test case 1:
Input: [1,0,0,0,0,1,0,0], 1
Expected return value: 0 1 0 0 1 0 1 0

-Test case 2:
Input: [1,1,1,0,1,1,1,1], 2
                       1 0 1 0 1 0 0 1   Day 1
Expected return value: 0 0 0 0 0 1 1 0   Day 2

----
Date: 04/13/2019
----
 */
public class EightHouses {

    public int[] cellCompete(int[] currentStates, int days)
    {
        // WRITE YOUR CODE HERE
        int[] nextDayStates = new int[8];

        while (days > 0) {

            for (int i = 0; i < 8; i++) {
                // first house
                if (i == 0 ) {
                    if (currentStates[i+1]==1) {
                        nextDayStates[0]=1;
                    }else{
                        nextDayStates[0]=0;
                    }
                    // last house
                } else if (i==7) {
                    if (currentStates[i-1]==1) {
                        nextDayStates[7]=1;
                    }else{
                        nextDayStates[7]=0;
                    }
                    // house(s) in the middle
                } else {
                    if ((currentStates[i-1]==1 && currentStates[i+1]==0) || (currentStates[i-1]==0 && currentStates[i+1]==1)) {
                        nextDayStates[i]=1;
                    }else{
                        nextDayStates[i]=0;
                    }
                }
            }
            currentStates = Arrays.copyOf(nextDayStates,8);
            days--;
        }
        return currentStates;
    }
}
