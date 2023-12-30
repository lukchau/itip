package lab8;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataManager {
    private List<String> data;
    public List<Method> methods = new ArrayList<>();

    public Object processor;

    public void registerDataProcessor(Object processor) {
        this.processor = processor;
        for (Method method: processor.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(DataProcessor.class)) {
                methods.add(method);
            }
        }
    }

    public void loadData(String source) throws IOException {
        data = Files.readAllLines(Paths.get(source));
    }

    public void processData() {
        ExecutorService service = Executors.newFixedThreadPool(methods.size());
        List<Future<String>> newData = methods.stream()
                .map(method -> service.submit(() -> {
                    try {
                        Object result = method.invoke(processor, data);
                        if (result instanceof List<?> resultList) {
                            if (resultList.stream().allMatch(item -> item instanceof String)) {
                                List<String> processedData = resultList.stream()
                                        .map(String::valueOf)
                                        .toList();
                                String comment = method.getAnnotation(DataProcessor.class).comment();
                                synchronized (DataManager.class) {
                                    data = processedData;
                                }
                                return comment + "\n" + processedData.toString() + "\n";
                            } else {
                                return "Error: Список содержит элементы, которые не являются строковыми.\n";
                            }
                        } else {
                            return "Error: Метод не вернул List<String>.\n";
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        return "";
                    }
                }))
                .toList();
        data = newData.stream().flatMap(future -> {
            try {
                return Stream.of(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return Stream.empty();
        }).collect(Collectors.toList());
        service.shutdown();
    }

    public void saveData(String destination) throws IOException {
        Files.write(Paths.get(destination), data);
    }
}

