package labs;

public interface MinimalOrderChangeSet<T> {

    T next();
    T previous();
    T current();
    /**
     * Evaluate element which is located on specified index in minimal order change set
     */
    T unRank(int index);
}
