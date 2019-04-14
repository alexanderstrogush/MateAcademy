package mate.academy.hw09.AsciiCharSequence;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {

    private byte[] values;

    public AsciiCharSequence(byte[] byteArray) {
        values = Arrays.copyOf(byteArray, byteArray.length);
    }


    @Override
    public int length() {
        return values.length;
    }

    @Override
    public char charAt(int index) {
        return (char) values[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(values, start, end));
    }

    @Override
    public String toString() {
        return new String(values);
    }
}
