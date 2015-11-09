package checkpoint.andela.temp;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Creates a temporary buffer that behaves like an blocking queue that stores the elements internally in an array.
 * That it is bounded means that it cannot store unlimited amounts of elements.
 * There is an upper bound on the number of elements it can store at the same time.
 * You set the upper bound at instantiation time, and after that it cannot be changed.
 * @param <E> The type definition
 */
public class TempBuffer <E> {
    /**
     * An ArrayBlockingQueue
     */
    private ArrayBlockingQueue<E> buffer;
    /**
     * The limit if the buffer
     */
    public static final int UPPER_BOUND = 1;

    /**
     * Creates a new tempBuffer wich can take 1 object
     */
    public TempBuffer() {
        this(UPPER_BOUND);
    }

    /**
     * cretes a new TempBuffer
     * @param size the capacity of the buffer
     */
    public TempBuffer(int size) {
        buffer = new ArrayBlockingQueue<E>(size);
    }
    /**
     * Inserts a new item into the buffer
     * @param item the object to be inserted
     * @throws InterruptedException
     */
    public void insert(E item) throws InterruptedException {
        buffer.put(item);
    }

    /**
     * Removes an Object from the Buffer
     * @return the object at the top of the queue
     * @throws InterruptedException
     */
    public E Remove() throws InterruptedException {
        return buffer.take();
    }

    /**
     * the size of the buffer
     * @return the size of the buffer
     */
    public int capacity() {
        return buffer.size();
    }

    public boolean contains(E ob) {
        return buffer.contains(ob);
    }

    public boolean isEmpt() {
        return buffer.isEmpty();
    }

}
