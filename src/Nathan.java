import java.util.HashMap;
import java.util.Map;

/*
-Problem: Nathan has completed his very first programming test and now is wondering about his score. He received an
email containing the final report about the task he solved in the test, but it omitted the score. Nathan never gives
up, so he decided to compute his result from the report. He found out that:
 o His program was tested on several test cases
 o Every test case has a given one of the following results: "OK", "Wrong answer", "Time limit exceeded" or "Runtime
 error"
 o Test cases were organized into groups numbered by consecutive natural numbers
 o His program scored points for a group only when the result of every test case in the group was "OK"

In the report, test cases are named according to the following rule: if the test case is the only test case in the
group, its name is [task name] + [group number]. If there is more than one test in the group, its name is extended by
a lowercase English letter which is different for each test case. Example test case names are: test1, test2a, test2b.
In this example, test2a and test2b form one group ans test1 forms another.

Nathan's score is the number of groups his program passed multiplied by 100 and divided by the total number of groups.
 If the result is fractional, the number of points is rounded to the highest integer not greater than the result.
For example, if the program passed two groups out of three, the result is 2*100 / 3 = 66.(6), so Nathan would gain 66
points.

Write a function
  class Solution { public int solution(String[] T, String[] R); }

That, given the names and results of all the test cases, returns the number of points Nathan scored. T and R are
arrays (containing strings) of length N. T[i] is a string corresponding to the i-th test case name; R[i] is the
result of this test case, containing one of four possible values ("OK", "Wrong answer", "Time limit exceeded" or "Runtime
 error").

For example, for data:
T[0] = "test1a"     R[0] =  "Wrong answer"
T[1] = "test2"      R[1] =  "OK"
T[2] = "test1b"     R[2] =  "Runtime error"
T[3] = "test1c"     R[3] =  "OK"
T[4] = "test3"      R[4] =  "Time limit exceeded"

the function should return 33. Nathan's program passed only the second group.

For another set of data:
T[0] = "codility1"      R[0] =  "Wrong answer"
T[1] = "codility3"      R[1] =  "OK"
T[2] = "codility2"      R[2] =  "OK"
T[3] = "codility4b"     R[3] =  "Runtime error"
T[4] = "codility4a"     R[4] =  "OK"

the function should return 50. Nathan's program passed the second and third groups.

Assume that:
- N is an integer withing the range [1..300]
- arrays T and R have the same length
- every test case appears in table T exactly once
- tests groups are numbered by consecutive natural numbers from 1
- test cases in groups containing at least two tests are distinguished by a lowercase letter suffix in alphabetical
order from a
- every element in T is a valid test name
- the task name is identical for every test case, contains only English lowercase letters and is of a length not
greater than 30 letters
- each string in array R has one of the following values "OK", "Wrong answer", "Time limit exceeded" or "Runtime
 error"

In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

----
Date: 02/03/2019
----
 */
public class Nathan {
    public int nathanSolution(String[] T, String[] R) {
        // write your code in Java SE 8
        Map<String, String> nathanMap = new HashMap<>();
        int totalGroups;
        int totalGroupsPassed=0;
        double score;

        // Step 1: read T and parse the test name, populate a Map (Nathan's Map)
        // Step 2: read R and convert the result to int where 1 is OK otherwise 0, update Nathan's Map
        String group;
        for (int i=0; i<T.length; i++) {
            group = parseTestName(T[i]);
            if (nathanMap.containsKey(group)) {
                // build a sequence of results e.g "10110"
                String newResult = nathanMap.get(group).concat(convertResult(R[i]));
                nathanMap.put(group, newResult);
            } else {
                nathanMap.put(group, convertResult(R[i]));
            }
        }

        // Step 3: Set TG (total groups) value and TGP (total groups passed) value
        totalGroups = nathanMap.size();
        for (String groupResult: nathanMap.values()) {
            if (!groupResult.contains("0")) {
                totalGroupsPassed++;
            }
        }

        // Step 4: Calculate Nathan's score and print the result
        score = totalGroupsPassed*100 / (double) totalGroups;

        return (int) score;
    }

    private String parseTestName(String fullTestName) {
        // "[task name] + [group number]" => task name or group name

        String groupName;
        char[] word = fullTestName.trim().toCharArray();
        int suffixIndex = word.length - 1;
        // check if suffix exists
        if (!Character.isDigit(word[suffixIndex])) {
            // chop suffix
            groupName = fullTestName.substring(0, fullTestName.length()-1);
        } else {
            groupName = fullTestName;
        }
        //System.out.println(fullTestName + "->" + groupName);
        return groupName;
    }

    // Maps all possible results in terms of 1 (OK) 0 (Not OK)
    private String convertResult(String resultName) {
        // {"OK", Wrong answer", etc} => 1 for ok other cases will be 0

        String result;
        if ("OK".equalsIgnoreCase(resultName)) {
            result = "1";
        } else {
            result = "0";
        }
        return result;
    }
}
