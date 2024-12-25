import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {
    /*
     * Complete the 'findMaximumGreatness' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMaximumGreatness(List<Integer> arr) {
        // Convert List to Array for sorting
        int[] array = arr.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array); // Sort the array

        int n = array.length;
        int greatness = 0;

        // Two pointers: one for original array, one for rearranged array
        int i = 0; // Pointer for original array
        int j = 0; // Pointer for rearranged array

        while (j < n) {
            if (array[j] > array[i]) {
                // Increment greatness and move both pointers
                greatness++;
                i++;
            }
            // Move pointer for rearranged array
            j++;
        }

        return greatness;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // Set up BufferedReader for input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Set up BufferedWriter for output
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // Read the size of the array
        System.out.println("Enter the size of the array:");
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        // Read the array elements
        System.out.println("Enter the array elements, one per line:");
        List<Integer> arr = IntStream.range(0, arrCount)
                .mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().trim();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Compute the result
        int result = Result.findMaximumGreatness(arr);

        // Output the result
        System.out.println("Maximum Greatness: " + result);

        // Close readers and writers
        bufferedReader.close();
        bufferedWriter.close();
    }
}
