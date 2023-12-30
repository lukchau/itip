package lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4"};
        int sum = 0;
        try {
            for (int i = 0; i < arr.length + 1; i++) {
                sum += Integer.parseInt(String.valueOf(arr[i]));;
            }
            double average = (double) sum / arr.length;
            System.out.println("Average: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid array element");
        }
    }
}