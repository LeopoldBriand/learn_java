public class FactorialCalculation {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for(int i=n-1; i > 0; i--) {
            n = n * i;
        }
        System.out.println(n);
    }
  
}