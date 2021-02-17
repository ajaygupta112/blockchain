import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String input = s.next();
        int length = input.length();
        double count = 0;
        for(int i  = 0; i < length ; i++)
        {
            char ch = input.charAt(i);
            if(ch == 'g' || ch == 'G' || ch == 'c' || ch == 'C')
                count++;
        }
        double ans = count*100/length;
        System.out.println(Double.toString(ans));
    }
}