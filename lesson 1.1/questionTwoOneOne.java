import java.util.Arrays;

public class questionTwoOneOne 
{
    public static void main(String[] args)
    {
        int[] arr = {13, 60, 50, 46, 56, 83, 22, 71};
        int[] clone = new int[8];
        int index = 0;

        for(int i = arr.length - 1; i >= 0; i--)
        {
            clone[index] = arr[i];
            index++;
        }

        System.out.println(Arrays.toString(clone));
    }
}
