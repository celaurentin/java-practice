/*
-Problem: You are processing plane seat reservations. The plane has N rows of seats, numbered from 1 to N. There are
 ten seats in each row (labeled from A to K, with letter I omitted), as shown in the figure below:
         A   B   C         D   E   F   G         H   J   K
 1     |   |   |   |     |   |   |   |   |     |   |   |   |
 2     |   |   |   |     |   |   |   |   |     |   |   |   |
 3     |   |   |   |     |   |   |   |   |     |   |   |   |
 ...
 N     |   |   |   |     |   |   |   |   |     |   |   |   |

 Some of the seats are already reserved. The list of reserved seats is given as a string S (of length M) containing
 seat numbers separated by single spaces: for example, "1A 3C 2B 40G 5A". The reserved seat can be listed in S in
 any order.
 Your task is to allocate seats for as many three-person families as possible. A three-person family occupies three
 seats that are next to each other in the same row. Seats across aisle (such as 2C and 2D) are not considered to be
 next to each other. Obviously, each available seat cannot be taken by more than one family.

 Write a function:

    class Solution { public int solution(int N, String S); }

 that, given the number of rows N and a list of reserved seats as string S, returns the maximum number of
 three-person families that can be seated in the remaining unreserved seats.

 For instance, given N = 2 and S = "1A 2F 1C", your function should return 4. The following figure shows one possible
  way of seating four families in the remaining seats:
         A   B   C         D   E   F   G         H   J   K
 1     | X |   | X |     |   | - | - | - |     | - | - | - |
 2     | - | - | - |     |   |   | X |   |     | - | - | - |

 Given N = 1 and S = "" (empty string), your function should return 3, because we can seat at most three families in
 a single row of seats, as shown in the figure below:
         A   B   C         D   E   F   G         H   J   K
 1     | - | - | - |     | - | - | - |   |     | - | - | - |

 Assume that:
    - N is an integer within the range[1..50]
    - M is an integer within the range [0..1909]
    - string S consists of valid seat names separated with spaces
    - every seat number appears in string S at most once

 In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

----
Date: 02/03/2019
----
 */

import java.util.StringTokenizer;

public class Booking {

    public int solution(int N, String S) {
        // total of possible consecutive spots for a 3-person family
        int totalConsecutiveSpots = 3*N;
        // columns: ABC DEFG HJK;  total columns= 10
        int[][] booking = new int[N+1][10];

        StringTokenizer st = new StringTokenizer(S," ");
        int row;
        String column;
        String token;
        while (st.hasMoreElements()){
            token = st.nextToken();
            column = token.substring(token.length()-1);
            row = Integer.parseInt(token.substring(0,token.length()-1));
            booking[row][mapper(column)]=1;
        }
        // counting consecutive spots taken and subtract from totalConsecutiveSpots
        int takenCounter =0;
        for (int i=1; i<N+1; i++) {
            if (booking[i][0]==1 || booking[i][1]==1 || booking[i][2]==1) {
                takenCounter++;
            }
            if (booking[i][7]==1 || booking[i][8]==1 || booking[i][9]==1) {
                takenCounter++;
            }
            if ((booking[i][4]==1 || booking[i][5]==1) || (booking[i][3]==1 && booking[i][6]==1)) {
                takenCounter++;
            }
        }
        return (totalConsecutiveSpots - takenCounter);
    }

    private static int mapper(String columnName) {
        int column = 0;
        switch (columnName) {
            case "A": column = 0; break;
            case "B": column = 1; break;
            case "C": column = 2; break;
            case "D": column = 3; break;
            case "E": column = 4; break;
            case "F": column = 5; break;
            case "G": column = 6; break;
            case "H": column = 7; break;
            case "J": column = 8; break;
            case "K": column = 9; break;
        }
        return column;
    }
}
