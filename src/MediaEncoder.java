import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
-Problem: Amazon Media Encoder is a highly scalable, easy to use and cost-effective way for developers and businesses
 to convert media files from their source format into versions that will playback on devices like smartphones.
 Whenever a media file needs to be processed by the encoder, it partitions the media file into N sub files. Each
 sub file is processed independently. During this process each sub file gets compressed. These compressed sub files are
 then merged by the encoder.

 The enconder can marge only two files at a time. The time required to merge the two files is equal to the sum of
 their sizes. The size of this merged file is also equal to the sum of their sizes. This process is repeated until
 the N sub files are merged into a single output file.

Write an algorithm to output the minimum possible time to merge the given N sub files into a single file.

-Input:
The input to the function/method consists of two arguments "numOfSubFiles", an integer representing the number of sub
 files; "files", a list of integers representing the size of the compressed sub files.

-Output:
Return an integer representing the minimum time required to merge all the sub files.

Constrains:
2 <= numOfSubFiles <= 10**6
1 <= files[i] <= 10**6
0 <= i <= numOfSubFiles

-Test case 1:
Input:
numOfSubFiles= 4
files= [8, 4, 6, 12]

Expected return value: 58

Explanation: The optimal way to merge the sub files is as follows:
Step 1: Merge the files of size 4 and 6 (time required is 10), after merging: [8, 10, 12]
Step 2: Merge the files of size 8 and 10 (time required is 18), after merging: [18, 12]
Step 3: Merge the files of size 18 and 12 (time required is 30)
Total time required to merge the files is 10 + 18 + 30 = 58

----
Date: 04/13/2019
----
 */
public class MediaEncoder {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static int minimumTime(int numOfSubFiles, List<Integer> files)
    {
        // WRITE YOUR CODE HERE
        // Step 0: Normalize and sorting data set
        int[] inputFiles = files.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(inputFiles);

        int[] partialTimes = new int[numOfSubFiles];

        // Step 1: Traverse the sorted list and compute partial times in pairs
        int prev = inputFiles[0];
        for (int i=1; i<numOfSubFiles; i++) {
            partialTimes[i-1] = prev + inputFiles[i];
            prev = partialTimes[i-1];
        }

        // Step 3: Compute the total time consumed (minimum)
        IntStream partialTimeStream = Arrays.stream(partialTimes);
        return partialTimeStream.reduce(0, Integer::sum);

    }
    // METHOD SIGNATURE ENDS
}
