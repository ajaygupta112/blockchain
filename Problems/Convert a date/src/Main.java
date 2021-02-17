import java.util.*;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String str = s.next();
        String arr[] = str.split("-");
        String ans = arr[1] + "/" + arr[2] + "/"+arr[0];
        System.out.println(ans);
    }
}