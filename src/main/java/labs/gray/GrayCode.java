package labs.gray;

import labs.MinimalOrderChangeElement;

import java.util.Objects;

public class GrayCode implements MinimalOrderChangeElement<GrayCode> {

    private int value;
    private final int binaryLength;

    public GrayCode(int index, int binaryLength) {
        this.value = index ^ (index >> 1);
        this.binaryLength = binaryLength;

        this.value = this.value & mask();
    }

    @Override
    public int rank() {
        int temp = value;
        int mask = temp >> 1;
        while (mask != 0)
        {
            temp = temp ^ mask;
            mask = mask >> 1;
        }
        return temp;
    }

    @Override
    public String toString() {
        return "GrayCode{" +
                "value=" + value +
                '}';
    }

    private int mask() {
        int result = 0;
        for (int i =0 ; i< binaryLength ; i++) {
            result = result | 1 << i;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrayCode grayCode = (GrayCode) o;
        return value == grayCode.value &&
                binaryLength == grayCode.binaryLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, binaryLength);
    }
}
