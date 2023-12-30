package lab7;

import java.util.concurrent.*;

public class Loader {
    static int currentWeight;
    public static void main(String[] args) {
        int[] weight = new int[]{45, 52, 53, 50, 50, 51};
        ExecutorService service = Executors.newFixedThreadPool(3);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(service);
        for (int i = 0; i < weight.length - 2; i += 3) {
            if (currentWeight >= 150) {
                try {
                    System.out.println("Идет разгрузка");
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                currentWeight = 0;
            }
            completionService.submit(new LoaderCallable(weight[i]));
            completionService.submit(new LoaderCallable(weight[i + 1]));
            completionService.submit(new LoaderCallable(weight[i + 2]));
            try {
                Future<Integer> res1 = completionService.take();
                System.out.println("Товар весом: " + res1.get() + " добавлен");
                Future<Integer> res2 = completionService.take();
                System.out.println("Товар весом: " + res2.get() + " добавлен");
                Future<Integer> res3 = completionService.take();
                System.out.println("Товар весом: " + res3.get() + " добавлен");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
        System.out.println("Весь товар разгружен");
    }
}

