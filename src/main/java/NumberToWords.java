public class NumberToWords {
    public static String numberToWordsPl(int n) {
        String[] zero = {"zero"};
        String[] jednosci = {"", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
        String[] nascie = {"dziesięć", "jedynaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};
        String[] dziesci = {"", "", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąc", "dziewięćdziesiąt"};
        String[] set = {"", "sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset", "siedemset", "osiemset", "dzewięćset"};
        String[][] rzedy = {
                {"tysiąc", "tysiące", "tysięcy"},
                {"milion", "miliony", "milionów"},
                {"miliard", "miliardy", "miliardów"},
                {"bilion", "biliony", "bilionów"}
        };


        if (n == 0) return zero[0];
        if (n < 10) return jednosci[n];
        if (n < 20) return nascie[n - 10];
        if (n < 100) {
            String jednosc = jednosci[n % 10];
            String dziesiat = dziesci[(n - n % 10) / 10];
            return dziesiat + " " + jednosc;
        }
        if (n < 1000) {
            int rest = n % 100;
            n -= rest;
            if (rest == 0) return zero[0];
            if (rest < 10) return jednosci[n];
            if (rest < 20) return nascie[n - 10];
            if (rest < 100) {
                String jednosc = jednosci[n % 10];
                String dziesiat = dziesci[(n - n % 10) / 10];
            }
        }
        return "error";
    }
}
