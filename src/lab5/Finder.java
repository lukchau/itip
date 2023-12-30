package lab5;

import java.util.regex.*;

public class Finder {
    public static void main(String[] args) {
        String text = "The quick brownj fox jumps jover the ljazy dog";
        String letter = "j";
        Pattern pattern = Pattern.compile("\\b" + letter + "\\w*\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
