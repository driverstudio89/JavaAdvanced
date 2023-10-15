package _8_Exercises_IteratorsAndComparators._01_ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {

    private List<T> data;
    private int currentIndex;


    public ListyIterator(T... data) {
        this.data = List.of(data);
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return (currentIndex + 1 < this.data.size());
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.data.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(data.get(currentIndex));
        }
    }

    public void printAll() {
        if (data.isEmpty()) {
            System.out.println("Invalid Operation!");
        }
        data.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {

        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {

            return index < data.size();
        }

        @Override
        public T next() {

            return data.get(index++);
        }
    }


}
