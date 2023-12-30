package lab3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Contact> contact = new HashTable<>(3);
        System.out.println(contact.isEmpty());

        contact.put("3", new Contact("Олег", "oleg@mail.ru", "Pushink's St."));
        System.out.println(contact.size());

        System.out.println(contact.get("3").name);

        contact.put("88005553535", new Contact("Евгений", "sutulaya@mail.ru", "Kolotushkin's St."));
        contact.put("895833833", new Contact("Кирилл", "s@mail.ru", "Kolotushkin's St."));
        System.out.println(contact.size());

        contact.remove("895833833");
        System.out.println(contact.get("895833833"));
        System.out.println(contact.size());
        System.out.println(contact.get("88005553535").address);

        contact.put("E", new Contact("Вова", "vovan4ik@gmail.com", "Chill St."));

        System.out.println(Arrays.toString(contact.view()));

    }
}
