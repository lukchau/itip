package lab5;

import java.util.regex.*;

public class Password {
    public static void main(String[] args) {
        String text = "aA1d@mail.ru";

        Pattern pattern = Pattern.compile("^(?=.[A-Z])(?=.*\\d)[A-Za-z0-9@.]{8,16}$");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("Пароль подходит всем условиям");
        } else {
            System.out.println("Пароль не соответствует требованиям");
        }

        if (text.length() < 8) {
            System.out.println("Длина пароля меньше 8 символов");
        } else if (text.length() > 16) {
            System.out.println("Длина пароля больше 16 символов");
        }
    }
}
