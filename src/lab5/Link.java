package lab5;

import java.util.regex.*;

public class Link{
    public static void main(String[] args) {
        String text = "Visit my website at www.example.com or www.lukchau.com or http://vk.com";

        Pattern pattern = Pattern.compile("(www\\.[\\S]+)");
        Matcher matcher = pattern.matcher(text);

        boolean foundMatch = false;

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            foundMatch = true;
            String url = matcher.group();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }
            matcher.appendReplacement(sb, url);

        }
        matcher.appendTail(sb);

        if (foundMatch) {
            String modifiedText = sb.toString();
            System.out.println(modifiedText);
        } else {
            System.out.println("Ссылки в тексте не найдены");
        }
    }
}
