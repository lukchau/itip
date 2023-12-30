package lab7;

import java.util.concurrent.Callable;

public class LoaderCallable implements Callable<Integer> {
    public int currentWeight;
    LoaderCallable(int weight) {
        currentWeight = weight;
    }
    @Override
    public Integer call() throws InterruptedException {
        synchronized (Loader.class) {
            Loader.currentWeight += currentWeight;
            if (Loader.currentWeight > 150) {
                System.out.println("Лимит по весы превышен");
                Thread.sleep(3000);
            }
        }
        return currentWeight;
    }
}

