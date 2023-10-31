/**
 * Find the most common character in the given word, return ' ' if word is empty
 */
import java.util.*;
import java.util.stream.Collectors;

public class CommonChar {

    public Character mostCommonChar(String word) {
        char[] chars = word.toCharArray();
        Map<Character, Integer> dict = new HashMap<>();
        int maxOccur = 0;
        Character mostCommon = ' ';
        for (Character c: chars) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);

            if (dict.get(c) > maxOccur){
                maxOccur = dict.get(c);
                mostCommon = c;
            }
        }

        return mostCommon;
    }

    public List<Character> top3CommonChars(String s) {
        List<Character> top3Chars = new ArrayList<>();
        Map<Character, Integer> dict = new HashMap<>();

        for (Character c: s.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) +1 );
        }

        List<Map.Entry<Character, Integer>> orderedEntryList = dict.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList());

        for (Map.Entry<Character, Integer> entry: orderedEntryList) {
            top3Chars.add(entry.getKey());
        }

        return top3Chars;
    }
}
