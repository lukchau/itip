package lab7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ArraySum {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        int sum = 0;
        ExecutorService service = Executors.newFixedThreadPool(2);
        ArraySumCallable a = new ArraySumCallable(0, array.length / 2, array);
        ArraySumCallable b = new ArraySumCallable( array.length / 2, array.length, array);
        Future<Integer> res1 = service.submit(a);
        Future<Integer> res2 = service.submit(b);
        sum += (res1.get() + res2.get());
        service.shutdown();
        System.out.println(sum);
    }
}
