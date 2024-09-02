package iterator;

public interface Iterator<T> {
    boolean hasNext();
    T next() throws Exception;
}
