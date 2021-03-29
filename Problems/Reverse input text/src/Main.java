import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        int i = reader.read();
        String s = "";
        while(i != -1)
        {
            s = (char)i + "" + s;
            i = reader.read();
        }
        System.out.print(s);
        reader.close();
    }
}