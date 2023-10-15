package Workshop_SmartArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        SmartArray smartArray = new SmartArray();
//
//        List<Integer> list = new ArrayList<>();
//
//        smartArray.add(1);
//        smartArray.add(22);
//        smartArray.add(3);
//        smartArray.add(78);
//        smartArray.add(15);
//        smartArray.add(115);
//
//        System.out.println(smartArray.contains(300));
//
//        System.out.println();

//        CustomStack customStack = new CustomStack();
//
//        customStack.push(50);
//        customStack.push(14);
//        customStack.push(78);
//        customStack.push(3);
//        customStack.push(18);
//        customStack.push(81);
//        customStack.push(81);
//        customStack.push(81);
//        customStack.push(81);
//        customStack.push(81);
//        customStack.push(81);
//        customStack.push(81);
//        customStack.push(81);
//
//
//        System.out.println(customStack.pop());
//
//        customStack.forEach(System.out::println);

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addFirst(5);
        doublyLinkedList.addFirst(37);
        doublyLinkedList.addFirst(19);
        doublyLinkedList.addFirst(22);
        doublyLinkedList.addLast(97);
        doublyLinkedList.addLast(17);
        doublyLinkedList.addLast(1);

        doublyLinkedList.toArray();

        System.out.println();


    }

}
