import java.util.Arrays;
import java.util.Random;

public class tasks2 {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));

        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 5}));
        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 6}));

        System.out.println((indexMult(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(indexMult(new int[]{3, 3, -2, 408, 3, 31})));

        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));

        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        System.out.println(botHelper("Hello, I'm under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }
    public static boolean duplicateChars(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getInitials(String name) {
        StringBuilder initials = new StringBuilder();
        String[] nameSurname = name.split(" ");

        for (String part : nameSurname) {
            initials.append(part.charAt(0));
        }
        return initials.toString();
    }

    public static int differenceEvenOdd(int[] mas){
        int sumEven = 0;
        int sumOdd = 0;
        for (int i : mas) {
            if (i % 2 == 0) {
                sumEven += i;
            } else {
                sumOdd += i;
            }
        }
        return sumEven > sumOdd? sumEven - sumOdd : sumOdd - sumEven;
    }

    public static boolean equalToAvg(int[] mas) {
        int sum = 0;
        for (int i : mas) {
            sum += i;
        }
        double avg = (double) sum / mas.length;
        for (int i : mas) {
            if (i == avg) {
                return true;
            }
        }
        return false;
    }

    public static int[] indexMult(int[] mas) {
        int[] res = new int[mas.length];
        for (int i = 0; i < mas.length; i++) {
            res[i] = mas[i] * i;
        }
        return res;
    }

    public static String reverse(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static int Tribonacci(int num) {
        if (num < 3) {
            return 0;
        } else if (num == 3) {
            return 1;
        } else {
            return Tribonacci(num - 1) + Tribonacci(num - 2) + Tribonacci(num - 3);
        }
    }

    public static String pseudoHash(int length) {
        StringBuilder hash = new StringBuilder();
        Random rand = new Random();

        String characters = "0123456789abcdef";
        int charactersLength = characters.length();

        for (int i = 0; i < length; i++) {
            int randIndex = rand.nextInt(charactersLength);
            char randChar = characters.charAt(randIndex);
            hash.append(randChar);
        }
        return hash.toString();
    }

    public static String botHelper(String sentence) {
        if (sentence.toLowerCase().contains("help")) {
            return "Calling for a staff member";
        } else {
            return "Keep waiting";
        }
    }

    public static boolean isAnagram(String word1, String word2) {
        word1 = word1.replaceAll("\\s", "");
        word2 = word2.replaceAll("\\s", "");
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            alphabet[word1.charAt(i) - 'a']++;
            alphabet[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }
}