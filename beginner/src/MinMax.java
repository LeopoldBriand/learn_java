import java.util.stream.Stream;

public class MinMax {
    public static void main(String[] args) throws Exception {
        Integer[] numbers = Stream.of(args).map(Integer::valueOf).toArray(Integer[]::new);
        Integer max = numbers[0];
        Integer min = numbers[0];
        for (Integer n : numbers) {
            if (n > max)
                max = n;
            if (n < min)
                min = n;
        }
        System.out.println("Min: " + min.toString() + " Max: " + max.toString());
    }
}
