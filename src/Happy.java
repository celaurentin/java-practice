/**
 * Given: a range of numbers 1–100
 * When:
 * A number is a multiple of ‘3’ return “Happy”
 * A number is a multiple of ‘5’ return “Hour”
 * A number is a multiple of both ‘3’ and ‘5’ return “HappyHour”
 * A number is not divisible by ‘3’ or ‘5’ return the number itself
 * Then: print “Happy”, “Hour”, “HappyHour” or the number accordingly
 */

public class Happy {

    public static void main(String[] args){

        int n = 100;
        for (int number=1; number<=n; number++){
            if (number%3==0 && number%5==0) System.out.println("HappyHour");
            else if (number%3==0) System.out.println("Happy");
            else if (number%5==0) System.out.println("Hour");
            else System.out.println(number);

        }

    }

}
