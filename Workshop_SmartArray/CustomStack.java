package Workshop_SmartArray;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int capacity;
    private int size;
    private int[] items;

    public CustomStack() {

        this.capacity = INITIAL_CAPACITY;
        this.items = new int[this.capacity];
    }

    public int getSize() {

        return this.size;
    }

    private void resize() {

        this.capacity *= 2;
        int[] copy = new int[this.capacity];
        for (int i = 0; i < items.length; i++) {
            copy[i] = this.items[i];
        }
        this.items = copy;
    }

    public void push(int element) {

        if (this.size == this.capacity) {
            resize();
        }
        this.items[this.size++] = element;
    }

    private void checkEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("CustomStack is empty");
        }
    }

    private void shrink() {
        if (this.size <= this.capacity / 4) {
            this.capacity /= 2;
            int[] copy = new int[this.capacity];
            for (int i = 0; i < this.size; i++) {
                copy[i] = this.items[i];
            }
            this.items = copy;

        }
    }

    public int pop() {
        checkEmpty();

        int element = this.items[this.size - 1];
        this.items[this.size - 1] = 0;
        this.size--;
        shrink();
        return element;
    }

    public int peek() {
        checkEmpty();

        int element = this.items[this.size - 1];
        return element;

    }

    public void forEach(Consumer<Integer> consumer) {

        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.items[i]);
        }
    }


}
