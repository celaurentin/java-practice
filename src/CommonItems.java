import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonItems {

    public Set<Integer> getCommonItems(Integer[] A, Integer[] B) {

        Set<Integer> setA = new HashSet<>(Arrays.asList(A));
        Set<Integer> setB = new HashSet<>(Arrays.asList(B));
        setA.retainAll(setB);

        return setA;

    }


    public Set<Integer> getNonCommonItems(Integer[] A, Integer[] B) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(A));
        Set<Integer> setB = new HashSet<>(Arrays.asList(B));

        Set<Integer> aNotB = new HashSet<>(setA);
        Set<Integer> bNotA = new HashSet<>(setB);

        aNotB.removeAll(setB);
        bNotA.removeAll(setA);

        aNotB.addAll(bNotA);

        return aNotB;

    }


}
