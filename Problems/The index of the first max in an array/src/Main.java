import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        if(size == 1)
        {
            String ans = s.next();
            System.out.println(0);
        }
        else
            {
            int num[] = new int[size];
            for(int i = 0 ; i < size ; i++)
            {
                num[i] = s.nextInt();
            }
            int temp = num[0];
            int index = 0;
            int i = 1;
            while (i < size) {
                if (num[i] > temp) {
                    temp = num[i];
                    index = i;
                }
                i++;
            }
            System.out.println(index);
        }
    }
}