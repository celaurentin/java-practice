/**
 * Given a positive integer n, return the digits of the integer as an array of characters.
 */
public class Digits {

    public char[] asArray(int n){
        String number = String.valueOf(n);
        return number.toCharArray();
    }
}
