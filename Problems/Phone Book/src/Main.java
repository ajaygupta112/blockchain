import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void remove() {
             removed = true;   
        }

        public boolean isRemoved() {
             return removed;   
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int idx = findKey(key);

            if (idx == -1) {
                return false;
            }

            table[idx] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            // put your code here
            int idx = findKey(key);
            if (idx != -1) {
                table[idx] = null;
            }
        }

        private int findKey(int key) {
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                            + ", value=" + table[i].getValue());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        // put your code here

        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        HashTable<String> table = new HashTable(x);
        String ans = "";
        while(x >= 0)
        {
            if(s.hasNextLine())
            {
                String arr[] = s.nextLine().split(" ");
                switch (arr[0]) {
                    case "put":
                        table.put(Integer.parseInt(arr[1]), arr[2]);
                        break;
                    case "get":
                        String res = table.get(Integer.parseInt(arr[1]));
                        if (res == null)
                            ans = ans + "-1" + "\n";
                        else
                            ans = ans + res + "\n";
                        break;
                    case "remove":
                        table.remove(Integer.parseInt(arr[1]));
                }
            }
            x--;
        }
        System.out.println(ans);
    }
}