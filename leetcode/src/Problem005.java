import java.util.*;

public class Problem005 {
    public static void main(String[] args) {
//        int[] states = {0, 1, 1, 0, 1, 1, 0, 1, 1, 1};
//        int[] numbers = {3, 8, 6};

        int[] states = {1, 1, 0, 0, 1, 1, 0, 1, 1, 1};
        int[] numbers = {3, 4, 15};

        Map<Integer, Integer> freq = new HashMap<>();
        for (int number : numbers) {
            List<Integer> primeFactors = getPrimeFactors(number);
            for (Integer primeFactor : primeFactors) {
                freq.put(primeFactor, freq.getOrDefault(primeFactor, 0) + 1);
            }

            freq.replaceAll((n, v) -> freq.get(n) % 2);
        }

        System.out.println(freq);
        for (int index : freq.keySet()) {
            if (freq.get(index) == 1) {
                for (int i = index - 1; i < states.length; i += index) {
                    states[i] = (states[i] == 0) ? 1 : 0;
                }
            }
        }

        System.out.println(Arrays.toString(states));
    }

    private static List<Integer> getPrimeFactors(int number) {
        List<Integer> ans = new ArrayList<>();
        boolean[] primes = new boolean[number + 1];

        // initializing all arrays to true as all are considered prime numbers initially
        Arrays.fill(primes, true);

        // code for sieve of eratosthenes - to calculate all primes of a given number
        for (int i = 2; i * i <= number; i++) {
            if (primes[i]) {
                for (int j = 2 * i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }

        // return all prime factors of a given number
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                if (number % i == 0)
                    ans.add(i);
            }
        }
        return ans;
    }
}
