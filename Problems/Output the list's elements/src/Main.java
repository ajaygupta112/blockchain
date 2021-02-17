import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        // write your code here
        for (int i = 0; i < nameList.size(); i++)
            System.out.println(nameList.get(i));
    }
}