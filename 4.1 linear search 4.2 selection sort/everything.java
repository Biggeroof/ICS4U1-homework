import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] values = {3, -3, 7, 12, 9, 10, 14};
        Random random = new Random();
        int N = 10;
        int[] big = new int[N];
        for (int i = 0; i < N; i++) {
            big[i] = random.nextInt(N);
        }
        //System.out.println(Arrays.toString(big));
//        System.out.println(linearSearch(values, 14));
//        System.out.println(smallest(values));
//        System.out.println(indexOfTheSmallest(values));
//        System.out.println(indexOfTheSmallestStartingFrom(values, 3));
//        swap(values, 1,4);
        //selectionSort(big);
        //System.out.println(Arrays.toString(big));
        //sort(big, 0, big.length - 1);
        insertionSort(big);
        System.out.println(Arrays.toString(big));
    }

    public static boolean linearSearch(int[] array, int searched) {
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searched) {
                found = true;
            }
        }
        return found;
    }

    public static boolean linearSearchV2(int[] array, int searched) {
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > searched)
            {
                return false;
            }
            if (array[i] == searched) {
                return true;
            }
        }
        return false;
    }

    public static int smallest(int[] array) {
        // Assume it's the first item.
        int smallest = array[0];
        // Start at index 1.
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    public static int indexOfTheSmallest(int[] array) {
        int index = -1;
        int smallest = smallest(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == smallest) {
                index = i;
            }
        }
        return index;
    }

    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        int smallest = array[index];
        int idx = index;
        for (int i = index+1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void selectionSort(int[] array) {
        // Selection sort:
        for (int i = 0; i < array.length; i++) {
            swap(array, i, indexOfTheSmallestStartingFrom(array, i));
        }
    }

    public static int binarySearch(int[] arr, int x)
    {
        int l = 0;
        int r = arr.length;
        while (l < r)
        {
            int mid = ((l + r) / 2);

            if(arr[mid] == x)
            {
                return mid;
            }

            if(arr[mid] > x)
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return  -1;
    }

    public static void bubbleSort(int[] arr)
    {
        int temp;
        boolean swap;
        for(int i = 0; i < arr.length; i++)
        {
            swap = false;
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    swap(arr, arr[j], arr[j + 1]);
                    swap = true;
                }
            }
            if(!swap)
            {
                break;
            }
        }
    }

    public static void insertionSort(int[] arr)
    {
      for(int i = 1; i < arr.length; i++)
        {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && key < arr[j])
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void sort(int[] arr, int l, int r)
    {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            mergeSort(l, r, m, arr);
        }
    }

    public static void mergeSort(int l, int r, int m, int[] arr)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
        {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; ++j)
        {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
