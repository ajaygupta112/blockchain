import java.util.*;

class AsciiCharSequence implements CharSequence{
    // implementation

    private final byte[] bytes;

    AsciiCharSequence(byte[] bytes)
    {
        this.bytes = bytes;
    }

    @Override
    public char charAt(int index)
    {
        return (char)bytes[index];
    }

    @Override
    public int length()
    {
        return bytes.length;
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        if(start < 0)
            throw new IndexOutOfBoundsException(start);
        if(end > length())
            throw new IndexOutOfBoundsException(end);
        if(start == 0 && end == length())
            return this;
        int size = end - start;
        byte[] arr = new byte[size];
        for( int i = 0 ; i < size ; i++)
            arr[i] = bytes[i+start];
        return new AsciiCharSequence(arr);
    }

    @Override
    public String toString()
    {
        return new String(bytes);
    }
}