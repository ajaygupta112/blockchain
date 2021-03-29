import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        // implement the method
        int size = 0;
        for(int i  = 0 ; i < words.length ; i++)
        {
            size += words[i].length();
        }
        char[] chars = new char[size];
        int count = 0;
        for(int i = 0 ; i < words.length ; i++)
        {
            for(int j = 0 ; j < words[i].length() ; j++)
            {
                chars[count] = words[i].charAt(j);
                count++;
            }
        }
        return chars;
    }
}