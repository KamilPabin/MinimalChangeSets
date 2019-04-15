package labs.Gray;

import labs.MinimalOrderChangeSet;

public class GraySet implements MinimalOrderChangeSet<GrayCode> {

    private final int elementBinaryLength;
    private final int size;
    private GrayCode current;

    public GraySet(int elementBinaryLength) {
        this.elementBinaryLength = elementBinaryLength;
        current = unRank(0);
        size = (int) Math.pow(2, elementBinaryLength);
    }

    @Override
    public GrayCode next() {
        int rank = nextRank(current.rank());
        current = unRank(rank);
        return current;
    }

    @Override
    public GrayCode previous() {
        int rank = previousRank(current.rank());
        current = unRank(rank);
        return current;
    }

    @Override
    public GrayCode current() {
        return current;
    }

    @Override
    public GrayCode unRank(int index) {
        return new GrayCode(index, elementBinaryLength);
    }

    private int previousRank(int rank) {
        if (rank == 0) {
            return (int) Math.pow(2, elementBinaryLength) - 1;
        } else {
            return rank - 1;
        }
    }

    private int nextRank(int rank) {
        if (rank == size - 1) {
            return 0;
        }
        return rank + 1;
    }
}
