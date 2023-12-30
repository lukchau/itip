import java.util.*;

public class tasks3 {
    public static void main(String[] args) {
        System.out.println(replaceVowels("apple"));
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code."));

        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));

        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));

        System.out.println(numCheck(243));
        System.out.println(numCheck(52));

        System.out.println(countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{2, 5, 2}));
        System.out.println(countRoots(new int[]{1, -6, 9}));

        System.out.println(salesData(new String[][]{
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        }));
        System.out.println(salesData(new String[][]{
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        }));

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));

        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));

        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words."));
    }

    public static String replaceVowels(String a) {
        return a.replaceAll("[aeiouAEIOU]", "*");
    }

    public static String stringTransform(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                word = word.replace(word.substring(i, i + 2), "Double" + String.valueOf(word.charAt(i)).toUpperCase());
            }
        }
        return word;
    }

    public static boolean doesBlockFit(int height, int weight, int depth, int holeHeight, int holeWeight) {
        return Math.min(Math.min(height * weight, height * depth), weight * depth) <= holeWeight * holeHeight;
    }

    public static boolean numCheck(int num) {
        int sum = 0;
        int check = num % 2;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum % 2 == check;
    }

    public static int countRoots(int[] coefficients) {
        int d = coefficients[1] * coefficients[1] - 4 * coefficients[0] * coefficients[2];

        if (d > 0) {
            return 2;
        } else if (d == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static String salesData(String[][] data) {
        LinkedList<String> res = new LinkedList<>();
        HashSet<String> allShops = new HashSet<>();
        for (int line = 0; line < data.length; line++) {
            for (int shopIndex = 1; shopIndex < data[line].length; shopIndex++) {
                allShops.add(data[line][shopIndex]);
            }
        }
        for (int i = 0; i < data.length; i++) {
            HashSet<String> currentShops = new HashSet<>();
            for (int j = 1; j < data[i].length; j++) {
                currentShops.add(data[i][j]);
            }
            if (allShops.equals(currentShops)) {
                res.add(data[i][0]);
            }
        }
        return res.toString();
    }

    public static boolean validSplit(String sentence) {
        String[] word = sentence.split(" ");

        for (int i = 1; i < word.length; i++) {
            String firstWord = word[i - 1];
            String secondWord = word[i];

            if (firstWord.charAt(firstWord.length() - 1) != secondWord.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static boolean waveForm(int[] mas) {
        boolean increasing = mas[1] > mas[0];

        for (int i = 2; i < mas.length; i++) {
            if ((mas[i] < mas[i - 1] && !increasing) || (mas[i] > mas[i - 1] && increasing)) {
                return false;
            }
            increasing = !increasing;
        }

        return true;
    }

    public static char commonVowel(String sentence) {
        sentence = sentence.toLowerCase();
        HashMap<Character, Integer> Vowels = new HashMap<>();
        Vowels.put('a', 0);
        Vowels.put('e', 0);
        Vowels.put('o', 0);
        Vowels.put('i', 0);
        Vowels.put('u', 0);

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (Vowels.containsKey(c)) {
                int count = Vowels.get(c);
                Vowels.put(c, count + 1);
            }
        }

        char mostVowel = ' ';
        int max = 0;

        for (char vowel : Vowels.keySet()) {
            int count = Vowels.get(vowel);
            if (count > max) {
                mostVowel = vowel;
                max = count;
            }
        }
        return mostVowel;
    }
}