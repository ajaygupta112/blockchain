import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int count = 1;
        char ch = str.charAt(0);
        String ans = "";
        for( int i = 1 ; i < str.length() ; i++)
        {
            if(str.charAt(i) == ch)
            {
                count++;
            }
            else
            {
                ans = ans+ch+count;
                ch = str.charAt(i);
                count = 1;
            }
        }
        ans = ans+ch+count;
        System.out.println(ans);
    }
}