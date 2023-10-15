package _07_Exercises_Generics._07_CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> data;

    CustomList() {
        this.data = new ArrayList<>();
    }

    public int size() {
        return this.data.size();
    }

    public T get(int index) {
        return this.data.get(index);
    }

    public void add(T element) {
        this.data.add(element);
    }

    public void remove(int index) {
        checkIndex(index);
        this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.data.size()) {
            throw new IndexOutOfBoundsException(
                    String.format("Index %d is out of bounds for size %d", index, this.data.size())
            );
        }
    }

    public void swap(int firstIndex,int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);
        T firstElement = this.data.get(firstIndex);
        T secondElement = this.data.get(secondIndex);

        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    public int greaterThanElement(T element) {
        int counter = 0;
        for (T e : this.data) {
            int result = e.compareTo(element);
            if (result > 0) {
                counter++;
            }
        }
        return counter;
    }

    public T getMax() {
        T max = this.data.get(0);
        for (T e : this.data) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }

    public T getMin() {
        T min = this.data.get(0);
        for (T e : this.data) {
            if (e.compareTo(min) < 0) {
                min = e;
            }
        }
        return min;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }
            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
