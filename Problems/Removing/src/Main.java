import java.util.*;

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
            // put your code here
            int index = findKey(key);

            if(index == -1)
            {
                rehash();
                index = findKey(key);
            }

            table[index] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            // put your code here
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            // put your code here
            int idx = findKey(key);
            //System.out.println(table[idx]);
            if (idx != -1 && table[idx] != null) {
                table[idx].remove();
            }

        }

        private int findKey(int key) {
            // put your code here
            int hash = key%size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        private void rehash() {
            TableEntry temp[] = new TableEntry[size];
            for( int i = 0 ; i < table.length; i++)
            {
                temp[i] = table[i];
            }
            size = size*2;
            table = new TableEntry[size];
            for( int i = 0 ; i < temp.length; i++)
            {
                int index = findKey(temp[i].getKey());
                table[index] = new TableEntry(temp[i].getKey(),temp[i].getValue());
                if(temp[i].isRemoved() == true)
                    table[index].remove();
            }
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                                                + ", value=" + table[i].getValue()
                                                + ", removed=" + table[i].isRemoved());
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
        int size = s.nextInt();
        HashTable hs = new HashTable(5);
        int removeEntry = s.nextInt();
        for( int i = 1; i <=size ; i++)
        {
            int key = s.nextInt();
            String value = s.next();
            hs.put(key, value);
        }
        for( int i = 1 ; i <= removeEntry ; i++)
        {
            int key = s.nextInt();
            hs.remove(key);
        }
        System.out.println(hs);
    }
}