import java.util.HashMap;
import java.util.Map;

/**
 * Find the first non-repeating character in a string of letters,
 * otherwise return ' '
 */
public class FirstNonRepeatingChar {

    public char findFirstNonRepeating(String word){
        char[] chars = word.toCharArray();
        Map<Character, Integer> dict = new HashMap<>();
        for (Character c: chars){
            dict.put(c, dict.getOrDefault(c, 0)+1);
        }
        for (Map.Entry<Character, Integer> entry : dict.entrySet()){
            if (entry.getValue()==1) return entry.getKey();
        }
        return ' ';
    }

}
