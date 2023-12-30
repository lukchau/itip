package lab5;

import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $-540 and €15,50 and $15.33";
        Pattern pattern = Pattern.compile("(-)?\\d+(([.,])\\d+)?");
        Matcher matcher = pattern.matcher(text);

        StringBuilder numbers = new StringBuilder();
        while (matcher.find()) {
            numbers.append(matcher.group()).append(" ");
        }

        String result = numbers.toString().trim();
        if (!result.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println("Числа не найдены");
        }
    }
}
