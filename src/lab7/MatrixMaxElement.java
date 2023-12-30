package lab7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrixMaxElement {
    public static int maxElement = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 4, 7},
                {10, 2, 28},
                {52, 33, 9},
                {12, 14, 19}
        };
        ExecutorService service = Executors.newFixedThreadPool(2);
        MatrixMaxElementCallable a = new MatrixMaxElementCallable(0, matrix.length / 2, matrix);
        MatrixMaxElementCallable b = new MatrixMaxElementCallable(matrix.length / 2, matrix.length, matrix);
        Future<Integer> res1 = service.submit(a);
        Future<Integer> res2 = service.submit(b);
        try {
            maxElement = Math.max(res1.get(), res2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown();
        System.out.println(maxElement);
    }
}

