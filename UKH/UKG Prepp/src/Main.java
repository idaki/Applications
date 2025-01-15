import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(sc.nextLine());
            arr[i] = currentNum;
        }
Integer

        int result = Arrays
                .stream(arr)
                .min().stream().
                findFirst()
                .orElseThrow(NoSuchElementException::new);

        print(result);


    }

    public static void print(int n) {
        System.out.println(n);
    }
}