import java.util.*;

public class tasks4 {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));

        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));

        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("ababab"));
        System.out.println(alphabeticRow("klmabzyxw"));

        System.out.println(letterCounter("aaabbcdd"));
        System.out.println(letterCounter("vvvvaajaaaaa"));

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("77897898"));

        System.out.println(shortestWay(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
        System.out.println(shortestWay(new int[][]{
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}}));

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));


    }

    public static String nonRepeatable(String str) {
        if (str.length() == 0) {
            return "";
        }
        ;
        String symbol = String.valueOf(str.charAt(str.length() - 1)); //  последний символ
        if (str.indexOf(symbol) != str.lastIndexOf(symbol)) {
            symbol = "";
        }
        return nonRepeatable(str.substring(0, str.length() - 1)) + symbol; //  строка на 1 элемент короче
    }

    public static List<String> generateBrackets(int n) {
        List<String> brackets = new ArrayList<>();
        generateBracketsHelper(n, n, "", brackets);
        return brackets;
    }

    public static void generateBracketsHelper(int open, int close, String current, List<String> brackets) {
        if (open == 0 && close == 0) {
            brackets.add(current);
            return;
        }

        if (open > 0) {
            generateBracketsHelper(open - 1, close, current + "(", brackets);
        }

        if (close > open) {
            generateBracketsHelper(open, close - 1, current + ")", brackets);
        }
    }

    public static List<String> binarySystem(int n) {
        List<String> combinations = new ArrayList<>();
        generateCombinations("", n, combinations);
        return combinations;
    }

    public static void generateCombinations(String current, int n, List<String> combinations) {
        if (current.length() == n) {
            combinations.add(current);
            return;
        }

        if (current.endsWith("0")) {
            generateCombinations(current + "1", n, combinations);
        } else {
            generateCombinations(current + "0", n, combinations);
            generateCombinations(current + "1", n, combinations);
        }
    }

    public static String alphabeticRow(String str) {
        String longestRow = "";
        String currentRow = "";
        String result = "";

        for (int i = 0; i < str.length() - 1; i++) {
            currentRow += str.charAt(i);

            if (str.charAt(i + 1) - str.charAt(i) == 1) {
                continue;
            }

            if (currentRow.length() > longestRow.length()) {
                longestRow = currentRow;
            }

            currentRow = "";
        }
        currentRow += str.charAt(str.length() - 1);

        if (currentRow.length() > longestRow.length()) {
            result = currentRow;
        }
        else result = longestRow;
        currentRow = "";
        longestRow = "";

        for (int i = str.length()-1; i > 0; i--) {
            currentRow += str.charAt(i);

            if (str.charAt(i-1) - str.charAt(i) == 1) {
                continue;
            }

            if (currentRow.length() > longestRow.length()) {
                longestRow = currentRow;
            }

            currentRow = "";
        }

        currentRow += str.charAt(0);

        if (currentRow.length() > result.length())
            result = currentRow;
        else if (longestRow.length() > result.length())
            result = longestRow;

        return result;
    }

    public static String letterCounter(String input) {
        Map<Character, Integer> charCount = new HashMap<>(); //для подсчёта повторений кол-ва символов
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1); //метод для получения значения Map по указанному уключу, счётчик увеличивается на 1
        }

        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(charCount.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Character, Integer> entry : sortedEntries) {
            result.append(entry.getKey());
            result.append(entry.getValue());
        }

        return result.toString();
    }

    public static int convertToNum(String numExpression) {
        Map<String, Integer> wordsToNumbers = new HashMap<>();
        wordsToNumbers.put("one", 1);
        wordsToNumbers.put("two", 2);
        wordsToNumbers.put("three", 3);
        wordsToNumbers.put("four", 4);
        wordsToNumbers.put("five", 5);
        wordsToNumbers.put("six", 6);
        wordsToNumbers.put("seven", 7);
        wordsToNumbers.put("eight", 8);
        wordsToNumbers.put("nine", 9);
        wordsToNumbers.put("ten", 10);
        wordsToNumbers.put("eleven", 11);
        wordsToNumbers.put("twelve", 12);
        wordsToNumbers.put("thirteen", 13);
        wordsToNumbers.put("fifteen", 15);
        wordsToNumbers.put("twenty", 20);
        wordsToNumbers.put("thirty", 30);
        wordsToNumbers.put("fifty", 50);

        String[] words = numExpression.split(" ");
        int res = 0;
        for (String word: words) {
            if (word.endsWith("teen")) {
                res += wordsToNumbers.get(word.substring(0, word.length() - 4)) + 10;
                continue;
            }
            if (word.endsWith("ty") && !wordsToNumbers.containsKey(word)) {
                res += wordsToNumbers.get(word.substring(0, word.length() - 2)) * 10;
                continue;
            }

            if (word.equals("hundred")) {
                res *= 100;
                continue;
            }
            if (word.equals("thousand")) {
                res *= 1000;
                continue;
            }
            res += wordsToNumbers.get(word);
        }
        return res;
    }

    public static StringBuilder uniqueSubstring(String str) {
        StringBuilder maxLenSubstring = new StringBuilder("");
        for (int i = 0; i < str.length() - 1; i++) {
            StringBuilder currentLength = new StringBuilder(String.valueOf(str.charAt(i)));
            ArrayList<Character> symbolsInSubstring = new ArrayList<>();
            symbolsInSubstring.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (symbolsInSubstring.contains(str.charAt(j))) { // проверка на повторение
                    if (maxLenSubstring.length() < currentLength.length()) {
                        maxLenSubstring = currentLength;
                    }
                    break;
                }
                currentLength.append(str.charAt(j));
                symbolsInSubstring.add(str.charAt(j));
            }

        }
        return  maxLenSubstring;
    }

    public static int shortestWay(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        dp[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }

        return dp[n-1][n-1];
    }

    public static String numericOrder(String input) {
        String[] words = input.split(" ");
        String[] rearrangedWords = new String[words.length];

        for (String word : words) {
            int index = Integer.parseInt(word.replaceAll("\\D+", "")) - 1; //получение нецифровой части и преобразование в целое число
            rearrangedWords[index] = word.replaceAll("\\d+", ""); //удаление цифровой части
        }

        return String.join(" ", rearrangedWords);
    }

    public static int switchNums(int a, int b) {
        List<Integer> numsA = new ArrayList<>();
        List<Integer> numsB = new ArrayList<>();

        while (a > 0) {
            numsA.add(a % 10);
            a = a / 10;
        }
        while (b > 0) {
            numsB.add(b % 10);
            b = b / 10;
        }

        int fin = 0;

        for (int i = numsB.size() - 1; i >= 0; i--) {
            int B = numsB.get(i);
            int ind = 0;
            if (!numsA.isEmpty()) {
                for (int j = 0; j < numsA.size(); j++) {
                    if (numsA.get(j) > B) {
                        B = numsA.get(j);
                        ind = j;
                    }
                }
                numsA.remove(ind);
            }
            fin = fin * 10 + B;
        }
        return fin;
    }

}