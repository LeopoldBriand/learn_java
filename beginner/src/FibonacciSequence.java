import java.util.ArrayList;
import java.util.Arrays;

public class FibonacciSequence {

    public static void main(String[] args) throws Exception {
        Integer n = Integer.parseInt(args[0]);
        if (n < 2) {
            throw new Exception("n must be greater than 1");
        }
        Integer[] base = { 1, 1 };
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(base));
        for (int i = 2; i < n; i++) {
            result.add(i, result.get(i - 1) + result.get(i - 2));
        }
        System.out.println(result);
    }

}
