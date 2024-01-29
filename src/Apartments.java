import java.util.Arrays;

/**
There are n applicants and m apartments

 desired = [60, 45, 80, 75]    // people looking for unit with desired space size
 apartments = [70, 60, 30]   // apartment size
 k = 5                      // size threshold tolerated by people

 determine the total matches
 ...

 applicant  desired min max would accept (k=5)
 0          60      55  65      1
 1          45      40  50      0
 2          80      75  85      0
 3          75      70  75      1

output: 2
 */

public class Apartments {

        public int getMatches(int[] apartments, int[] desired, int k) {
            int count = 0;
            Arrays.sort(apartments);
            for (Integer desiredSize: desired){
                if (binarySearch(apartments, desiredSize, k))
                    count++;
            }
            return count;
        }

        private boolean binarySearch(int[] apartments, int size, int k) {
            int left = 0;
            int right = apartments.length-1;
            while (left <= right) {
                int mid = (left + right)/2;
                // stop condition
                if (size >= apartments[mid]-k && size <= apartments[mid]+k) return true;
                else if (size > apartments[mid]-k) left = mid + 1;
                else right = mid - 1;
            }
            return false;
        }
}
