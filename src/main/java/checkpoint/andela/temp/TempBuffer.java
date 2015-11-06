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
    private ArrayBlockingQueue<E> buffer;

    public static final int UPPER_BOUND = 1;

    public TempBuffer() {
        this(UPPER_BOUND);
    }

    public TempBuffer(int size) {
        buffer = new ArrayBlockingQueue<E>(size);
    }

    public void insert(E item) throws InterruptedException {
        buffer.put(item);
    }

    public void Remove() throws InterruptedException {
        buffer.take();
    }

    public int capacity() {
        return buffer.size();
    }

}
