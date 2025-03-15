import java.util.*;     // import all collections
import java.util.stream.*;      // import streams

public class Main {

    // class exercises
    public static boolean isPrime(int number) {

        // early exit condition check
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            // if at least one divisor is found, the number is not prime,
            // thus we exit and return false
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static class Parent {
        public void p_1() {
            System.out.println("p_1 from Parent");
        }

        public void p_2() {
            System.out.println("p_2 from Parent");
        }
    }

    public static class Child extends Parent {
        // if we had a constructor in the Parent class,
        // we would call it in the Child's class constructor
        // using super(arg1, arg2, ..., argN); - arguments for the parent class constructor
        public void p_1() {
            System.out.println("p_1 from Child");
        }

        @Override
        public void p_2() {
            System.out.println("Overridden p_2 from Child");
        }
    }

    public static void doArray() {
        ArrayList<Integer> array = IntStream.range(1, 11)   // declare an int stream for the range [1,11); can also use .rangeClosed(1,10)
                .boxed()    // convert it to wrapper class => Integer
                .collect(Collectors.toCollection(ArrayList::new));  // store result in an ArrayList

        // we have other streams for primitive data types, such as LongStream or DoubleStream
        // we can also convert primitive arrays (int[], double[]) via .stream(), and parse them accordingly (convert to collections, filter, apply transformations such as reduce and so on)
        // think of streams as c++ streams, it allows us to create sequences of objects such that Java internally can process them in a faster and more streamlined way

        // elements can be added manually by using "array.add(value);"
        // if we want to remove elements, we can use "array.remove(value);" or "array.remove(index);"
        // beware, the index to be removed is an int, thus passing int to remove would make it use the index version
        // if you want to remove an integer value, use "array.remove(Integer.valueOf(value));"
        // also, beware when using .remove(), as in some collections it throws errors, based on the collection types, so wrap it in a try-catch block
        // for try catch, you also the "finally" block, which is executed regardless of whether the code errored out or no

        System.out.println("Length of array is: " + array.size());
        // for arrays of primitive types, use .length for the length (not a function, beware)
    }
}
