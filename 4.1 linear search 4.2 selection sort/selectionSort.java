import java.util.Arrays;
import java.util.Random;

public class selectionSort 
{
    public static void main(String[] args) 
    {
        int length = 10;
        int[] arr = new int[length];
        Random rand = new Random();
        for(int i = 0; i < length; i++)
        {
            arr[i] = rand.nextInt(1000);
        }
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // public static void selectionSort(int[] arr) 
    // {
    //     int smallestIdx;
    //     int temp;
    //     for(int i = 0; i < arr.length; i++)
    //     {
    //         smallestIdx = i;
    //         for(int j = i; j < arr.length; j++)
    //         {
    //             if(arr[j] < arr[smallestIdx])
    //             {
    //                 smallestIdx = j;
    //             }
    //         }
    //         temp = arr[i];
    //         arr[i] = arr[smallestIdx];
    //         arr[smallestIdx] = temp;
    //     }
    // }

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
}
