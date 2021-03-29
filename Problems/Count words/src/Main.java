import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String line = reader.readLine().trim();
        String[] arr = line.split("\\s+");
        int count = arr.length;
        if(line.isEmpty())
            count = 0;
        System.out.print(count);
        reader.close();
    }
}