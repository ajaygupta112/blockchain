import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte[] bytes = inputStream.readAllBytes();
        for(int i = bytes.length-1 ; i >= 0 ; i--)
            System.out.print((char)bytes[i]);
    }
}