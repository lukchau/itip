package lab5;

import java.util.regex.*;

public class IP {
    public static void main(String[] args) {
        String ipAddress = "0.168.0.1";
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher matcher = pattern.matcher(ipAddress);

        if (matcher.matches()) {
            System.out.println("IP адрес корректен");
        } else {
            System.out.println("Некорректный IP адрес");
        }
    }
}
