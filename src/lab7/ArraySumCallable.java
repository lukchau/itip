package lab7;

import java.util.concurrent.Callable;

public class ArraySumCallable implements Callable<Integer> {
    private final int startIndex;
    private final int endIndex;
    private final int[] array;
    ArraySumCallable(int startIndex, int endIndex, int[] array){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.array = array;
    }

    @Override
    public Integer call() {
        int currentSum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            currentSum += array[i];
        }
        return currentSum;
    }
}

