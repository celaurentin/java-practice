import java.util.Arrays;

/**
 * An anagram is a word or phrase that is formed by rearranging the letters of another word or phrase. For example,
 * the word "listen" can be rearranged to form the word "silent".
 */
public class Anagram {

    public static boolean isAnagram(String w1, String w2){
        if (w1.length()!=w2.length()) return false;
        char[] charsW1 = w1.toCharArray();
        char[] charsW2 = w2.toCharArray();

        Arrays.sort(charsW1);
        Arrays.sort(charsW2);

        return Arrays.equals(charsW1, charsW2);
    }
}
