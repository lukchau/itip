package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> wordCounts = new HashMap<>();

        try {
            // Указываем путь к текстовому файлу
            File file = new File("src/chupa.txt");

            // Создание объекта Scanner для чтения файла
            Scanner scanner = new Scanner(file);

            // Перебор слов в файле
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();

                // Если слово уже встречалось, увеличиваем его счетчик
                if (wordCounts.containsKey(word)) {
                    int count = wordCounts.get(word);
                    wordCounts.put(word, count + 1);
                } else {
                    // Если слово встречается впервые, добавляем его в Map
                    wordCounts.put(word, 1);
                }
            }

            // Закрываем Scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }

        // Создание списка из элементов Map
        List<Map.Entry<String, Integer>> sortedWordCounts = new ArrayList<>(wordCounts.entrySet());

        // Сортировка списка по значению по убыванию
        sortedWordCounts.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedWordCounts) {
            if (count >= 10) {
                break;
            }

            System.out.println(entry.getKey() + ": " + entry.getValue());
            count++;
        }
    }
}