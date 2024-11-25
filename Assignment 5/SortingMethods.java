import java.util.ArrayList;

public class SortingMethods {
    int comparison = 0;
    int swaps = 0;

    public static void main(String[] args) {
        int[] array1 = {26, 13, 72, 3, 17, 37, 0, 17, 73, 45};
        int[] array2 = {26, 13, 72, 3, 17, 37, 0, 17, 73, 45};
        int[] array3 = {26, 13, 72, 3, 17, 37, 0, 17, 73, 45};
        int[] array4 = {26, 13, 72, 3, 17, 37, 0, 17, 73, 45};

        SortingMethods sorting = new SortingMethods();
        System.out.println("Insertion Sort");
        sorting.insertionSort(array1);
        System.out.println();
        System.out.println("Merge Sort");
        sorting.mergeSort(array2);
        System.out.println();
        System.out.println("Quick Sort");
        sorting.quickSort(array3);
        System.out.println();
        System.out.println("Bucket Sort");
        sorting.bucketSort(array4);
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void insertionSort(int[] array) {
        comparison = 0;
        swaps = 0;

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < key) {
                comparison++;
                array[j + 1] = array[j];
                swaps++;
                j--;
            }
            array[j + 1] = key;
            swaps++;
        }
        printArray(array);
        System.out.println();
        System.out.println("Comparisons: " + comparison);
        System.out.println("Swaps: " + swaps);
    }

    public void mergeSort(int[] array) {
        comparison = 0;
        swaps = 0;

        mergeSort(array, 0, array.length - 1);
        printArray(array);
        System.out.println();
        System.out.println("Comparisons: " + comparison);
        System.out.println("Swaps: " + swaps);
    }

    private void merge(int[] array, int left, int middle, int right) {
        int leftHalf = middle - left + 1;
        int rightHalf = right - middle;

        int[] leftArray = new int[leftHalf];
        int[] rightArray = new int[rightHalf];

        for (int i = 0; i < leftHalf; i++) {
            leftArray[i] = array[left+i];
        }
        for (int j = 0; j < rightHalf; j++) {
            rightArray[j] = array[middle+1+j];
        }

        int i = 0, j = 0;

        int k = left;

        while (i < leftHalf && j < rightHalf) {
            if (leftArray[i] >= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
            comparison++;
            swaps++;
        }

        while (i < leftHalf) {
            array[k] = leftArray[i];
            i++;
            k++;
            swaps++;
        }

        while (j < rightHalf) {
            array[k] = rightArray[j];
            j++;
            k++;
            swaps++;
        }
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }  
    }

    public void quickSort(int[] array) {
        comparison = 0;
        swaps = 0;

        quickSort(array, 0, array.length - 1);
        printArray(array);
        System.out.println();
        System.out.println("Comparisons: " + comparison);
        System.out.println("Swaps: " + swaps);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = partition(array, low, high);

            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (array[j] >= pivot) {
                i++;
                comparison++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                swaps++;
            }
        }
        return i;
    }

    public void bucketSort(int[] array) {
        comparison = 0;
        swaps = 0;

        ArrayList<Integer>[] bucket = new ArrayList[array.length];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < array.length; i++) {
            int index = array[i] / 10;
            bucket[index].add(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            insertionSort(bucket[i]);
        }

        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < bucket[i].size(); j++) {
                array[index++] = bucket[i].get(j);
                swaps++;
            }
        }
        printArray(array);
        System.out.println();
        System.out.println("Comparisons: " + comparison);
        System.out.println("Swaps: " + swaps);
    }

    private void insertionSort(ArrayList<Integer> bucket) {
        for (int i = 1; i < bucket.size(); ++i) {
            int key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) < key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }
}
