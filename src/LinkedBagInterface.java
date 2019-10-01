package Project1;

//interface to hold methods from LinkedBag
public interface LinkedBagInterface <T> {
    //Gets current number of objects in the bag
    public int getCurrentSize();

    //Tests whether the bag is empty
    public boolean isEmpty();

    //Adds a new item t in the bag
    public boolean add(T entry);

    // Removes the certain item from the bag
    public boolean remove(T entry);

    //Removes an unspecified item from the bag
    public T remove();

    //Removes all items from the bag
    public void clear();

    //Tests whether a certain item is in the bag
    public boolean contains(T entry);

    //Counts the number of times a given item occurs in the bag
    public int getFrequencyOf(T entry);

    //retrieves all entries that are in the bag
    public T[] toArray();

    //retrieves all entries that are in the bag
    public T[] toArray(T[] a);
}
