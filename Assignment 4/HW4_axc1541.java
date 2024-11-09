public class HW4_axc1541 {
    public static void main(String[] args) {
        HW4_axc1541 linear = new HW4_axc1541(10);
        HW4_axc1541 doubleHashing = new HW4_axc1541(10);
        
        int[] linearArray = {10, 3, 17, 14, 18, 3, 8, 1, 18, 11};
        int[] doubleArray = {7, 17, 27, 37, 47, 57, 67, 77, 87, 97};
        
        for (int i = 0; i < linearArray.length; i++) {
            linear.linearProbingInsert(linearArray[i]);
        }
        
        for (int i = 0; i < doubleArray.length; i++) {
            doubleHashing.doubleHashingInsert(doubleArray[i], 7);
        }
        
        System.out.println("Linear Probing: ");
        linear.printTable();
        System.out.println("Double Hashing: ");
        doubleHashing.printTable();
    }
    
    private int[] table;

    public HW4_axc1541(int size) {
        table = new int[size];
    }

    public void linearProbingInsert(int key) {
        int index = key % table.length;
        while (table[index] != 0) {
            index = (index + 1) % table.length;
        }
        table[index] = key;
    }

    public void doubleHashingInsert(int key, int prime) {
        int index = key % table.length;
        int i = 1;
        while (table[index] != 0) {
            index = (key + i * (prime - (key % prime))) % table.length;
            i++;
        }
        table[index] = key;
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": " + table[i]);
        }
    }

}
