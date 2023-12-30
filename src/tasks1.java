public class tasks1 {
    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0,  2));
        System.out.println(containers(4, 1, 4));

        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4,  5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println(howManyItems(22, 1.8, 2));
        System.out.println(howManyItems(45, 1.8,  1.9));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }

    public static double convert(int a) {
        return a * 3.785;
    }

    public static int fitCalc(int a, int b) {
        return a * b;
    }

    public static int containers(int a, int b, int c) {
        return a * 20 + b * 50 + c * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x < y + z && y < x + z && z < x + y) {
            if (x == y && y == z) {
                return "isosceles";
            } else if (x == y || x == z || y == z) {
                return "equilateral";
            } else {
                return "different-sided";
            }
        } else {
            return "not a triangle";
        }
    }

    public static int ternaryEvaluation(int a, int b) {
        return a > b ? a : b;
    }

    public static int howManyItems(double n, double w, double h) {
        return (int) ((n / 2) / (w * h));
    }
    public static int factorial(int a) {
        int b = 1;
        for (int i = 1; i <= a; i++) {
            b *= i;
        }
        return b;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }

    public static int ticketSaler(int a, int b) {
        return (int) (a * b * 0.72);
    }

    public static int tables(int a, int b) {
        if ((a + 1) / 2 - b < 0) {
            return 0;
        } else {
            return (a + 1) / 2 - b;
        }
    }
}