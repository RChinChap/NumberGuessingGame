package Project1;

import java.util.Arrays;

public class LinkedBag<T> implements LinkedBagInterface <T> {
    private Node<T> firstNode;
    //accessors and mutators for firstNode
    public Node<T> getFirstNode() {
        return firstNode;
    }
    public void setFirstNode(Node<T> firstNode) {
        this.firstNode = firstNode;
    }

    private int numberOfEntries;
    //accessors and mutators for numberOfEntries
    public int getNumberOfEntries() {
        return numberOfEntries;
    }
    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    private class Node<T> {
        private T data;
        //accessors and mutators for data
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
        //accessors and mutators for next
        private Node<T> next;
        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> next) {
            this.next = next;
        }

        private Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        if (firstNode == null) {
            assert (numberOfEntries == 0);
            return true;
        }
        return false;
    }

    public boolean add(T entry) {
        Node<T> aNode = new Node(entry);
        aNode.next = firstNode;
        firstNode = aNode;
        numberOfEntries++;
        return true;
    }

    public boolean remove(T entry) {
        for (Node<T> curr = firstNode; curr != null; curr = curr.next) {
            if (entry.equals(curr.data)) {
                curr.data = firstNode.data;
                firstNode = firstNode.next;
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    public T remove() {
        T result = null;
        if (firstNode != null) ;
        {
            result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }
        return result;
    }

    public void clear() {
        while (!isEmpty())
            remove();
    }

    public boolean contains(T entry) {
        boolean found = false;
        Node<T> currNode = firstNode;
        while (!found && (currNode != null)) {
            if (entry.equals(currNode.data))
                found = true;
            else
                currNode = currNode.next;
        }
        return found;
    }

    public int getFrequencyOf(T entry) {
        int counter = 0;
        int frequency = 0;
        Node<T> currNode = firstNode;
        while ((counter < numberOfEntries) && (currNode != null)) {
            if (entry.equals(currNode.data))
                frequency++;
            counter++;
            currNode = currNode.next;
        }
        return frequency;
    }

    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        int idx = 0;
        Node currNode = firstNode;
        while ((idx < numberOfEntries) && (currNode != null)){
            result[idx] = (T) currNode.data;
            idx++;
            currNode = currNode.next;
        }
        return result;
    }

    public T[] toArray(T[] a) {
        T[] result = Arrays.copyOf(a, numberOfEntries);
        for (Node<T> i = firstNode; i != null; i = i.next) {
            int idx = 0;
            result[idx] = (T) i.data;
            idx++;
        }
        return result;
    }

    public LinkedBag<T> copy() {
        LinkedBag<T> result = new LinkedBag<>();
        T[] bagArray = toArray();
        for (int i = 0; i < numberOfEntries; i++)
            result.add(bagArray[i]);
        return result;
    }

    public boolean equals(LinkedBag<T> other) {
        LinkedBag<T> copied = other.copy();
        if (numberOfEntries != other.getCurrentSize())
            return false;
        T[] firstArray = toArray();
        for (T item : firstArray)
            if (copied.contains(item)) {
                copied.remove(item);
            }
        if (copied.getCurrentSize() == 0)
            return true;
        else
            return false;
    }

    public LinkedBag<T> union(LinkedBag<T> b) {
        LinkedBag<T> unionBag = new LinkedBag<>();
        T[] bagArray = toArray();
        T[] bagArrayb = b.toArray();
        for (int i = 0; i < numberOfEntries; i++) {
            unionBag.add(bagArray[i]);
        }
        for (int i = 0; i < b.getCurrentSize(); i++) {
            unionBag.add(bagArrayb[i]);
        }
        return unionBag;
    }

    public LinkedBag<T> intersection(LinkedBag<T> other) {
        LinkedBag<T> newBag = new LinkedBag<T>();
        T[] array = toArray();
        LinkedBag<T> copied = other.copy();
        for (int i = 0; i < numberOfEntries; i++) {
            T item = array[i];
            if (copied.remove(item)) {
                newBag.add(item);
            }
        }
        return newBag;
    }
}


