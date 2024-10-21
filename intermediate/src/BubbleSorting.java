import java.util.Arrays;
import java.util.stream.Stream;

public class BubbleSorting {
    public static void main(String[] args) {
        Integer[] numbers = Stream.of(args).map(Integer::valueOf).toArray(Integer[]::new);
        Integer[] sorted = sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(sorted));
    }

    public static Integer[] sort(Integer[] data) {
        Integer[] numbers = data.clone();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j + 1] < numbers[j]) {
                    Integer temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }
}
