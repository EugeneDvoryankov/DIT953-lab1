import java.util.Stack;

public class FixedSizeStack<T> {
    private Stack<T> stack;
    private int maxSize;
    private int currentSize;

    public FixedSizeStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public T push(T item){
        if(currentSize < maxSize){
            stack.push(item);
            currentSize++;
        }
        return item;
    }

    public T pop(T item){
        stack.pop();
        return item;
    }

    public T peek(T item){
        stack.peek();
        return item;
    }

}
