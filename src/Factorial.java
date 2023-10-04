import java.util.*;

class Factorial {
    private static HashMap<Long, Long> cache;
    private static Integer calculationsPerformed;

    static {
        cache = new HashMap<>();
        calculationsPerformed = 0;
    }

    public long[][] solution(long[] numbersToCalculate) {
        long[][] results = new long[numbersToCalculate.length][2];
        for (int i = 0; i < numbersToCalculate.length; i++) {
            Long result = factorial(numbersToCalculate[i]);
            results[i][0] = result;
            results[i][1] = calculationsPerformed.longValue();
            System.out.println("n! of "+ numbersToCalculate[i]+ "="+results[i][0]+ " (Calculations: "+ results[i][1]+")");
            calculationsPerformed = 0;
        }

        cache = new HashMap<>();
        return results;
    }

    private static Long factorial(Long value) {
        if (value == 0 || value == 1) {
            return 1L;
        }

        Long cached = cache.get(value);
        if (cached != null) {
            return cached;
        }

        calculationsPerformed++;
        Long result = value * factorial(value-1);
        cache.put(value, result);
        return result;
    }
}
