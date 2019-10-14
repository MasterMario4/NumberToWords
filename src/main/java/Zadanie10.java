import java.util.*;

public class Zadanie10 {
    public static void PrimeFactors(long n) {
        List<Long> primes = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (long i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                values.add(n);
                primes.add(i);
                n = n / i;
            }
        }
        if (n > 1) {
            primes.add(n);
            values.add(n);
        }
        for (int i = 0; i < primes.size(); i++) {
            System.out.println(values.get(i) + "|" + primes.get(i));
        }
        System.out.println("1|*");
    }
}