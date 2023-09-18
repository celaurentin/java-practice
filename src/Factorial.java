import java.util.*;

class Factorial {
    private static HashMap<Integer, Integer> cache;
    private static Integer calculationsPerformed;

    static {
        cache = new HashMap<>();
        calculationsPerformed = 0;
    }

    public static long[][] solution(long[] numbersToCalculate) {
        long[][] results = new long[numbersToCalculate.length][2];
        for (int i = 0; i < numbersToCalculate.length; i++) {
            Integer result = factorial((int)numbersToCalculate[i]);
            results[i][0] = result.longValue();
            results[i][1] = calculationsPerformed.longValue();
            System.out.println("n! of "+ numbersToCalculate[i]+ "="+results[i][0]+ " (Calculations: "+ results[i][1]+")");
            calculationsPerformed = 0;
        }

        cache = new HashMap<>();
        return results;
    }

    private static Integer factorial(Integer value) {
        if (value == 0 || value == 1) {
            return 1;
        }

        Integer cached = cache.get(value);
        if (cached != null) {
            return cached;
        }

        calculationsPerformed++;
        Integer result = value * factorial(value-1);
        cache.put(value, result);
        return result;
    }
}
