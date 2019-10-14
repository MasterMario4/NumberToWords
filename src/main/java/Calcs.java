import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Calcs {
    static long greatestCommonDivisor(long a, long b) {
        long gcd = 1L;
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 && b == 0) {
            System.out.println("Nieprawidłowe dane. Obie podane liczby to 0.");
            return 0;
        }

        for (long c = 1; c <= Math.max(a, b); c++) {
            if (a % c == 0 && b % c == 0) {
                gcd = c;
            }
        }

        return gcd;
    }

    public static long NWD1(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    static long NWD2(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return NWD2(b, a % b);
        }
    }

    static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        }
        for (int i = 2; i < n / 2 + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] getPrimeNumbers(List<Integer> list) {
        return list.stream()
                .filter(Calcs::isPrime)
                .distinct()
                .mapToInt(x -> x)
                .toArray();
    }

    static List<Long> getPrimeDividers(long n) {
        List<Long> divs = new ArrayList<>();
        for (long i = 2; i < n + 1; i++) {
            if (n % i == 0) {
                divs.add(i);
            }
        }
        return divs.stream()
                .filter(Calcs::isPrime)
                .distinct()
                .collect(Collectors.toList());
    }

//    public static int NWW(int a, int b) {
//
//        //Źle
//        List<Integer> primesA = getPrimeDividers(a);
//        List<Integer> primesB = getPrimeDividers(b);
//        int nww = 1;
//
//        primesA.addAll(primesB);
//        int[] primes = primesA.stream()
//                .distinct()
//                .mapToInt(x -> x)
//                .toArray();
//        for (int i : primes) {
//            nww = nww * i;
//        }
//        return nww;
//    }

//    public static int[] getPrimesSieve(List<Integer> list){
//
//    }

    public static int[] getNPrimeNumbers(int n) {
        int[] primes = new int[n];
        int counter = -1;
        int number = 1;
        do {
            number++;
            if (isPrime(number)) {
                counter++;
                primes[counter] = number;
            }
        } while (counter < n - 1);
        return primes;
    }

    public static int getNthPrimeNumber(int n) {
        int counter = -1;
        int number = 1;
        do {
            number++;
            if (isPrime(number)) {
                counter++;
            }
        } while (counter < n - 1);
        return number;
    }

    public static void UniqueFactorization(long n) {
        //Check if prime, 0 or 1
        if (isPrime(n)) {
            System.out.println("1");
            System.out.println(n);
            return;
        } else if (n <= 1) {
            System.out.println("Podana liczba: " + "'" + n + "' jest liczbą 0 albo 1.");
            return;
        }

        List<Long> primeDividers = getPrimeDividers(n);
        int index = 0;

        do {
            if (n % primeDividers.get(index) == 0) {
                System.out.println(n + "|" + primeDividers.get(index));
                n = n / primeDividers.get(index);
            } else {
                index++;
            }
        } while (n > 1);
        System.out.println("1|*");
    }


}
