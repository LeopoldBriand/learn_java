public class FactorialCalculation {

    public Integer factorial(Integer n) {
        for (Integer i = n - 1; i > 0; i--) {
            n = n * i;
        }
        return n;
    }

}