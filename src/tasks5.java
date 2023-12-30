import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class tasks5 {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));

        System.out.println(digitCount(4666));
        System.out.println(digitCount(544));
        System.out.println(digitCount(121317));
        System.out.println(digitCount(0));
        System.out.println(digitCount(12345));
        System.out.println(digitCount(1289396387328L));

        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant", "sat"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));


        System.out.println(sumUp(new int[]{1, 2, 3, 4, 5}));
        System.out.println(sumUp(new int[]{1, 2, 3, 7, 9}));
        System.out.println(sumUp(new int[]{10, 9, 7, 2, 8}));
        System.out.println(sumUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}));

        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));

        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));

        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(130));

    }

    public static boolean sameLetterPattern(String str1, String str2) {
        char[] str1Letters = str1.toCharArray();
        char[] str2Letters = str2.toCharArray();
        char changeLetter = 33;
        for (int i = 0; i < str1.length(); i++) {
            str1 = str1.replace(String.valueOf(str1Letters[i]), String.valueOf(changeLetter));
            str2 = str2.replace(String.valueOf(str2Letters[i]), String.valueOf(changeLetter));
            changeLetter++;
        }
        return str1.equals(str2);
    }

    public static String spiderVsFly(String spider, String fly) {
        String letters = "ABCDEFGH";
        StringBuilder path = new StringBuilder();
        int angle = Math.abs(letters.indexOf(spider.charAt(0)) - letters.indexOf(fly.charAt(0)));
        if(angle >= 5) {
            angle = 4 - angle % 4;
        }
        if (angle == 0) {
            if (spider.charAt(1) > fly.charAt(1)){
                for (int i = Integer.parseInt(spider.substring(1)); i >= Integer.parseInt(fly.substring(1)); i--) {
                    path.append(spider.charAt(0)).append(i).append("-");
                }
            }
            else {
                for (int i = Integer.parseInt(spider.substring(1)); i <= Integer.parseInt(fly.substring(1)); i++) {
                    path.append(spider.charAt(0)).append(i).append("-");
                }
            }
        }
        else if(angle == 1 || angle == 2) {
            if (Integer.parseInt(spider.substring(1)) > Integer.parseInt(fly.substring(1))) {
                for (int i = Integer.parseInt(spider.substring(1)); i >= Integer.parseInt(fly.substring(1)); i--) {
                    path.append(spider.charAt(0)).append(i).append("-");
                }
            } else {
                String[] reverse = spiderVsFly(fly, spider).split("-");
                path = new StringBuilder();
                for (int i = reverse.length-1; i >= 0; i--) {
                    path.append(reverse[i]).append("-");
                }
                path = new StringBuilder(path.substring(0, path.length() - 1));
                return path.toString();
            }
            int currNum = Integer.parseInt(fly.substring(1));
            String returnPath = "BAHGFEDC";
            if (Math.abs(letters.indexOf(spider.charAt(0)) - letters.indexOf(fly.charAt(0))) <
                    Math.abs(returnPath.indexOf(spider.charAt(0)) - returnPath.indexOf(fly.charAt(0)))) {
                for (int i = letters.indexOf(spider.charAt(0)) + 1; i <= letters.indexOf(fly.charAt(0)); i++) {
                    path.append(letters.charAt(i)).append(currNum).append("-");
                }
            } else {
                for (int i = returnPath.indexOf(spider.charAt(0)) + 1; i <= returnPath.indexOf(fly.charAt(0)); i++) {
                    path.append(returnPath.charAt(i)).append(currNum).append("-");
                }
            }
        }
        else {
            for (int i = Integer.parseInt(spider.substring(1)); i >= 0; i--) {
                path.append(spider.charAt(0)).append(i).append("-");
            }
            for (int i = 1; i <= Integer.parseInt(fly.substring(1)); i++) {
                path.append(fly.charAt(0)).append(i).append("-");
            }
        }
        path = new StringBuilder(path.substring(0, path.length() - 1));
        if (!path.toString().endsWith(fly)) {
            path.append("-").append(fly);
        }
        return path.toString();
    }

    public static int digitCount(long digit) {
        if (digit < 10) {
            return 1;
        }
        return 1 + digitCount(digit / 10);
    }

    public static int totalPoints(String[] guessedWords, String word) { // task 4
        int points = 0;
        boolean addPt = false;
        int additionallyPoints = 0;

        HashMap<Integer, Integer> addition = new HashMap<>();
        addition.put(3, 1);
        addition.put(4, 2);
        addition.put(5, 3);
        addition.put(6, 4);

        HashMap<Character, Integer> letters = new HashMap<>();
        for (char i: word.toCharArray()) {
            if (letters.containsKey(i)) {
                letters.put(i, letters.get(i) + 1);
            } else {
                letters.put(i, 1);
            }
        }

        for (String guessedWord: guessedWords) {
            HashMap<Character, Integer> currentLetters = new HashMap<>(Map.copyOf(letters));
            boolean check = true;

            if (guessedWord.length() == 6) {
                additionallyPoints++;
            }

            for (char i: guessedWord.toCharArray()) {
                if (guessedWord.equals(word)) {
                    addPt = true;
                }


                if (currentLetters.containsKey(i)) {
                    currentLetters.put(i, currentLetters.get(i) - 1);
                } else {
                    check = false;
                    break;
                }
            }

            if (currentLetters.containsValue(-1)) {
                check = false;
            }

            if (check) {
                points += addition.get(guessedWord.length());
            }
        }

        if (addPt) {
            points += (additionallyPoints * 50);
        }

        return points;
    }

    public static String sumUp(int[] nums) {
        ArrayList<Integer[]> pairsIndexes = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (num1 + num2 == 8 && i != j) {
                    pairsIndexes.add(new Integer[]{i, j});
                }
            }
        }
        for (int i = 0; i < pairsIndexes.size(); i++) {
            Integer[] min = pairsIndexes.get(i);
            int minId = i;
            for (int j = i; j < pairsIndexes.size(); j++) {
                if (pairsIndexes.get(j)[1] - pairsIndexes.get(j)[0] < min[1] - min[0]) {
                    min = pairsIndexes.get(j);
                    minId = j;
                }
            }
            Integer[] temp = pairsIndexes.get(i);
            pairsIndexes.set(i, min);
            pairsIndexes.set(minId, temp);
        }
        int[][] res = new int[pairsIndexes.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = nums[pairsIndexes.get(i)[0]];
            res[i][1] = nums[pairsIndexes.get(i)[1]];
        }
        return Arrays.deepToString(res);
    }

    public static int takeDownAverage(String[] results) {
        float resultsSum = 0;
        for (String result : results) {
            resultsSum += Integer.parseInt(result.substring(0, result.length() - 1));
        }
        float currentAverage = resultsSum / results.length;
        return (int) (((currentAverage - 5) * (results.length + 1)) - resultsSum);
    }

    public static StringBuilder caesarCipher(String mode, String str, int move) {
        String specialLetters = " !.,?0123456789";
        StringBuilder res = new StringBuilder();
        move = mode.equals("encode")? move: -1 * move;
        for (int i = 0; i < str.length(); i++) {
            if (specialLetters.contains(String.valueOf(str.charAt(i)))) {
                res.append(str.charAt(i));
                continue;
            }
            res.append(String.valueOf((char) (str.charAt(i) + move)).toUpperCase());
        }
        return res;
    }

    public static int setSetup(int n, int k) {
        if (k == 1) {
            return n;
        }
        return setSetup(n - 1, k - 1) * n;
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.US);
        LocalDateTime dateTimeA = LocalDateTime.parse(timestamp, formatter);

        Map<String, Integer> cities = new HashMap<>();
        cities.put("Los Angeles",-8);
        cities.put("New York",-5);
        cities.put("Caracas",-4);
        cities.put("Buenos Aires",-3);
        cities.put("London",0);
        cities.put("Rome",1);
        cities.put("Moscow",3);
        cities.put("Tehran", (int) 3.5);
        cities.put("New Delhi",(int) 5.5);
        cities.put("Beijing",8);
        cities.put("Canberra",10);

        int offsetA = cities.get(cityA);
        int offsetB = cities.get(cityB);
        int difference = offsetB - offsetA;

        LocalDateTime dateTimeB = dateTimeA.plusHours(difference);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
        return dateTimeB.format(outputFormatter);
    }

    public static boolean isNew(int num) {
        int[] nums = new int[String.valueOf(num).length()];
        int num2 = num;
        for (int i = 0; num2 >= 1 ; i++) {
            nums[i] = (num2 % 10);
            num2 /= 10;
        }
        Arrays.sort(nums);
        StringBuilder compareNum = new StringBuilder(); // минимальное число для сравнения с изначальным
        for (int i = 0; i < nums.length; i++) {
            compareNum.append(nums[i]);
        }
        if (compareNum.toString().startsWith("0")) {
            compareNum = new StringBuilder(compareNum.toString().replaceFirst("\\b\\d{2}",
                    String.valueOf(compareNum.charAt(1) + String.valueOf(compareNum.charAt(0)))));
        }
        return num <= Integer.parseInt(compareNum.toString());
    }
}
