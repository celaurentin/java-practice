
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionArrays {

    public int[] getIntersection1(int[] array1, int[] array2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (Integer n: array1){
            set1.add(n);
        }
        for (Integer n: array2){
            if (set1.contains(n)){
                resultSet.add(n);
            }
        }

        return resultSet.stream().mapToInt(x->x).toArray();
    }

    public int[] getIntersection2(int[] array1, int[] array2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (Integer n: array1){
            set1.add(n);
        }
        for (Integer n: array2){
            set2.add(n);
        }

        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int i = 0;
        for (Integer n: set1){
            result[i] = n;
            i++;
        }
        Arrays.sort(result);
        return result;
    }
}
