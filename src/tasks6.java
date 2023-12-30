import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tasks6 {
    public static void main(String[] args) {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.",
                "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));

        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));

        System.out.println(Arrays.toString(twoProducts(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProducts(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProducts(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProducts(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProducts(new int[]{100, 12, 4, 1, 2}, 15)));

        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));

        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println(pilishString("33314444"));
        System.out.println(pilishString("TOP"));
        System.out.println(pilishString("X"));
        System.out.println(pilishString(""));
        System.out.println(pilishString("CANIMAKEAGUESSNOW"));

        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));

        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));

    }

    public static String hiddenAnagram(String sentence, String anagram) {
        Pattern specialSymbolsHandler = Pattern.compile("[ .,?!\\-<>~@#$%^&*()1234567890]");
        Matcher senetnceMatcher = specialSymbolsHandler.matcher(sentence);
        Matcher anagramMatcher = specialSymbolsHandler.matcher(anagram);
        sentence = senetnceMatcher.replaceAll("").toLowerCase();
        anagram = anagramMatcher.replaceAll("").toLowerCase();
        char[] anagramSymbols = anagram.toCharArray();
        Arrays.sort(anagramSymbols);
        for (int i = 0; i <= sentence.length() - anagram.length(); i++) {
            String substring = sentence.substring(i, i + anagram.length());
            char[] currentSymbols = substring.toCharArray();
            Arrays.sort(currentSymbols);
            if (Arrays.equals(currentSymbols, anagramSymbols)) {
                return substring;
            }
        }
        return "not found";
    }

    public static String[] collect(String str, int n) {
        if (str.length() < n) {
            return new String[]{};
        }
        String[] results = Arrays.copyOf(collect(str.substring(n), n), collect(str.substring(n), n).length + 1);
        results[results.length - 1] = str.substring(0, n);
        Arrays.sort(results);
        return results;
    }

    public static StringBuilder nicoCipher(String message, String key) {
        char[] keyLetters = key.toCharArray();
        Map<Character, LinkedList<Character>> cipher = new HashMap<>();
        StringBuilder res = new StringBuilder();
        StringBuilder messageBuilder = new StringBuilder(message);
        while (messageBuilder.length() % keyLetters.length != 0) {
            messageBuilder.append(" ");
        }
        message = messageBuilder.toString();
        for (int i = 0; i < keyLetters.length; i++) {
            char keyLetter = keyLetters[i];
            LinkedList<Character> letters = new LinkedList<>();
            int j = i;
            do {
                letters.add(message.charAt(j));
                j += keyLetters.length;
            } while (j < message.length());
            cipher.put(keyLetter, letters);
        }
        int rowsCount = cipher.get(keyLetters[0]).size();
        Arrays.sort(keyLetters);
        int index = 0;
        while (index < rowsCount) {
            for (char letter : keyLetters) {
                res.append(cipher.get(letter).get(index));
            }
            index++;
        }
        return res;
    }

    public static int[] twoProducts(int[] arr, int n) {
        int[] res = new int[2];
        int minDiff = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] * arr[j] == n && j - i < minDiff) {
                    minDiff = j - i;
                    res[0] = arr[i];
                    res[1] = arr[j];
                }
            }
        }
        return res;
    }

    public static int[] isExact(int n) {
        int[] res = isExact(1, 1, n);
        return res[0] == n? new int[]{n, res[1]}: new int[]{};
    }

    public static int[] isExact(int factorial, int addition, int border) {
        if (factorial >= border) {
            return new int[] {factorial, addition};
        }
        return isExact(factorial * (addition + 1), addition + 1, border);
    }

    public static String fractions(String num) {
        int startPow = num.indexOf("(") - num.indexOf(".") - 1;
        int endPow = num.substring(num.indexOf("."), num.length() - 1).length() - 2;
        int partBeforePeriod = Integer.parseInt(num.substring(0, num.indexOf("(")).replace(".", ""));
        int newNum = Integer.parseInt(num.replace(".", "").replace("(", "").replace(")", ""));
        int difference = newNum - partBeforePeriod;
        int denominator = (int)(Math.pow(10, endPow) - Math.pow(10, startPow));

        for (int i = Math.min(denominator, difference); i >= 2; i--) {
            if (denominator % i == 0 && difference % i == 0) {
                denominator /= i;
                difference /= i;
                break;
            }
        }
        return difference + "/" + denominator;
    }

    public static StringBuilder pilishString(String str) {
        String PI = String.valueOf(Math.PI).replace(".", "");
        StringBuilder res = new StringBuilder();
        int pIndex = 0;
        int strIndex = 0;
        while (strIndex < str.length()) {
            int addition = PI.charAt(pIndex) - '0';
            if (strIndex + addition <= str.length()) {
                res.append(str, strIndex, strIndex + addition).append(" ");
            } else {
                StringBuilder lastPart = new StringBuilder(str.substring(strIndex));
                while (lastPart.length() < addition) {
                    lastPart.append(str.charAt(str.length() - 1));
                }
                res.append(lastPart);
            }
            strIndex += addition;
            pIndex++;
        }
        return res;
    }

    public static String generateNonconsecutive(String str) {
        Pattern bracketsFinder = Pattern.compile("\\(.*\\)");
        Matcher bracketsMatcher = bracketsFinder.matcher(str);
        while (bracketsMatcher.find()) {
            String chander = bracketsMatcher.group();
            str = bracketsMatcher.replaceFirst(generateNonconsecutive(chander.substring(1, chander.length() - 1)));
        }
        Pattern multiplication = Pattern.compile("-?\\d* (\\*||/) -?\\d*");
        while (str.contains("/") || str.contains("*")) {
            Matcher multiplicationMatcher = multiplication.matcher(str);
            if (multiplicationMatcher.find()) {
                String[] expression = multiplicationMatcher.group().split(" ");
                if (expression[1].equals("*")) {
                    str = multiplicationMatcher.replaceFirst(String.valueOf(Integer.parseInt(expression[0]) * Integer.parseInt(expression[2])));
                } else {
                    if (expression[2].equals("0")) {
                        return "division by zero";
                    }
                    str = multiplicationMatcher.replaceFirst(String.valueOf(Integer.parseInt(expression[0]) / Integer.parseInt(expression[2])));
                }
            } else {
                break;
            }
        }
        Pattern sumOrSubtraction = Pattern.compile("-?\\d* (\\+||-) -?\\d*");

        while (str.contains("+") || str.contains("-")) {
            Matcher sumOrSubtrationMatcher = sumOrSubtraction.matcher(str);
            if (sumOrSubtrationMatcher.find()) {
                String[] expression = sumOrSubtrationMatcher.group().split(" ");
                if (expression[1].equals("+")) {
                    str = sumOrSubtrationMatcher.replaceFirst(String.valueOf(Integer.parseInt(expression[0]) + Integer.parseInt(expression[2])));
                } else {
                    str = sumOrSubtrationMatcher.replaceFirst(String.valueOf(Integer.parseInt(expression[0]) - Integer.parseInt(expression[2])));
                }
            } else {
                break;
            }

        }
        return str;
    }

    public static String isValid(String str) {
        HashMap<Character, Integer> counts = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (counts.containsKey(currentChar)) {
                counts.put(currentChar, counts.get(currentChar) + 1);
                minCount = Math.min(minCount, counts.get(currentChar));
            } else {
                counts.put(currentChar, 1);
            }
            maxCount = Math.max(maxCount, counts.get(currentChar));
        }
        int diff = 0;
        for (Map.Entry<Character, Integer> letter: counts.entrySet()) {
            if (letter.getValue() != minCount) {
                diff++;
            }
        }
        return ((minCount == maxCount || maxCount - minCount == 1) && diff <= 1)? "YES": "NO";
    }

    public static StringBuilder findLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        StringBuilder lcs = new StringBuilder();

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = s1.length(), j = s2.length();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--; // влево
            }
        }

        return lcs.reverse();
    }

}
