import java.util.HashMap;
import java.util.Map;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII,
which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle
applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.
 */
public class RomanToInt {


    public int toInteger(String roman){
        char[] romanChars = roman.toCharArray();
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        int i = 0;
        int result = 0;
        while (i<romanChars.length){
            char current = romanChars[i];
            if (i+1<romanChars.length && (current=='I' && (romanChars[i+1]=='V' || romanChars[i+1]=='X'))
                    || (current=='X' && (romanChars[i+1]=='L' || romanChars[i+1]=='C'))
                    || (current=='C' && (romanChars[i+1]=='D' || romanChars[i+1]=='M'))
                ){
                result += romanValues.get(romanChars[i+1]) - romanValues.get(current);
                i++;
            } else {
                result += romanValues.get(current);
            }
            i++;
        }
        return result;
    }
}
