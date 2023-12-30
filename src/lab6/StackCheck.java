package lab6;

public class StackCheck {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Верхний элемент стека: " + stack.peek());

        System.out.println("Удаленный элемент из стека: " + stack.pop());

        System.out.println("Верхний элемент стека: " + stack.peek());

        stack.push(6);

        System.out.println("Верхний элемент стека: " + stack.peek());
    }
}

