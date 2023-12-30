package lab7;

import java.util.concurrent.Callable;

public class MatrixMaxElementCallable implements Callable<Integer> {
    private final int startIndex;
    private final int endIndex;

    private final int[][] matrix;

    MatrixMaxElementCallable(int startIndex, int endIndex, int[][] matrix) {
        this.matrix = matrix;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    @Override
    public Integer call() {
        int maxValue = Integer.MIN_VALUE;
        for (int i = startIndex; i < endIndex; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxValue = Math.max(maxValue, matrix[i][j]);
            }
        }
        return maxValue;
    }
}

