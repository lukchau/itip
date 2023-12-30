package lab8;

import java.util.List;
import java.util.stream.Collectors;

public class DataProcessors {
    @DataProcessor(comment = "Заполнение массива")
    public static List<String> addUserIntoData(List<String> data) {
        return data.stream().filter(line -> !line.isEmpty()).collect(Collectors.toList());
    }

    @DataProcessor(comment = "Перевод к заглавным буквам")
    public List<String> upper(List<String> data) {
        return data.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    @DataProcessor(comment = "Переворот слова")
    public List<String> reverse(List<String> data) {
        return data.stream().map(word ->
        {
            return new StringBuilder(word).reverse().toString();
        }).collect(Collectors.toList());
    }

    @DataProcessor(comment = "Сортировка")
    public List<String> sort(List<String> data) {
        return data.stream().sorted().collect(Collectors.toList());
    }
}

