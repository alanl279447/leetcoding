package com.example.uber;

public class genericsTest {
    /**
     * Create a Linked List (not double linked list)
     * <p>
     * methods add(item), remove(index), get(index), size()
     **/

    public static void main(String[] args) {

        Linkedist<String> list = new Linkedist();

        list.add("1");

        list.add("2");

        list.add("3");

        list.add("4");

        System.out.println("size: " + list.size());

        System.out.println("got 2: " + list.get(2));

        System.out.println("removed 3: " + list.remove(3));

        System.out.println("size: " + list.size());


    }


//get, remove, size, add

//generic data type

//LinkedList

// class Node

// value, nextPtr

// headPtr - start of the list

// curr - final element

//remove - 0(n)

//get - 0(n)

//size - 0(1) time


    static class Linkedist<E> {

        Node<E> head = null;

        Node<E> currPtr = null;

        int size = 0;


        public void Linkedist() {

            // currPtr = head;

            size = 0;

        }


        public void add(E value) {

            if (head == null) {

                head = new Node(value);

                currPtr = head;

            } else {

                currPtr.nextPtr = new Node(value);

                currPtr = currPtr.nextPtr;

            }

            size++;

        }


        public E get(int index) {

            // E returnValue;

            if (index > size) return null;

            else {

                Node<E> temp = head;

                for (int i = 0; i < index; i++) {

                    temp = temp.nextPtr;

                }

                return temp.value;

            }

        }


        public E remove(int index) {

            E returnVaue = null;

            if (index >= size) return null;

            else {

                size--;

                Node<E> temp = head;

                for (int i = 0; i < index - 1; i++) {

                    temp = temp.nextPtr;

                }

                if (temp.nextPtr != null) {

                    returnVaue = temp.nextPtr.value;

                    temp.nextPtr = temp.nextPtr.nextPtr;

                }

            }

            return returnVaue;

        }


        public int size() {

            return size;

        }


    }


    static class Node<E> {

        E value;

        Node<E> nextPtr = null;


        public Node(E val) {

            value = val;

        }

    }

//Stack LIFO mode
    static class Stack<E> {

        private Linkedist<E> backingList = new Linkedist<E>();


        public void push(E value) {

            backingList.add(value);

        }


        public E pop() {

            if (backingList.size == 0) return null;

            return backingList.remove(backingList.size - 1);

        }


        public E peek() {

            if (backingList.size == 0) return null;

            return backingList.get(backingList.size - 1);

        }

    }
}
