import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimeNumbers implements Iterable<Integer> {
    private List<Integer> primes = new ArrayList<Integer>();

    public void computePrimes(int n) {
        int count = 1;
        int number = 2;
        boolean isPrime;
        while (count <= n) {
            isPrime = true;
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime && (number % 10 != 9)) {
                primes.add(number);
                count++;
            }
            number++;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return primes.iterator();
    }

    @Override
    public String toString() {
        return primes.toString();
    }

    public static void main(String[] args) {
//        PrimeNumbers primeNumbers = new PrimeNumbers();
//        primeNumbers.computePrimes(10); // Compute the first 10 prime numbers
//        System.out.println("Prime Numbers: " + primeNumbers);

        PrimeNumbers primeNumbers = new PrimeNumbers();

        primeNumbers.computePrimes(10);
        System.out.println("Prime Numbers: " + primeNumbers);

        // Iterate through the prime numbers
//        Iterator<Integer> iterator = primeNumbers.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
}
