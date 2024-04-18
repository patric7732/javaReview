package review.genericTest;

public interface Container<T> {
    void set(T value);

    T get();
}
