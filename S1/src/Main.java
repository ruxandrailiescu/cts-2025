import java.util.*; // import all collections
import java.util.stream.*; // import streams

public class Main {

    // class exercises
    public static boolean isPrime(int number) {
        if (number <= 1) // early exit condition check
            return false;

        for (int i = 2; i < Math.sqrt(number); i++) // regular for
            // for (variable declaration; termination condition; increment step)
            if (number % i == 0) // check for divisors up until sqrt(number)
                return false; // if at least one divisor is found, the number is not prime, thus we exit and return false

        return true; // if we reach here, no divisor was found, hence the number is prime
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
        // if we had a constructor in the Parent class, we would call it in this constructor using super(arg1, arg2, ..., argN); - arguments for the parent class constructor
        public void p_1() {
            System.out.println("p_1 from Child");
        }

        @Override
        public void p_2() {
            System.out.println("Overriden p_2 from Child");
        }
    }

    public static void doArray() {
        // ArrayList<int> array = new ArrayList<int>(); - remember that primitive types cannot be used for collections, we need to use their associated wrappers
        // int - Integer, boolean - Boolean, double - Double and so on
        ArrayList<Integer> array = IntStream.range(1, 11) // declare an int stream for the range [1-11); we can also use .rangeClosed(1, 10), this will make the range be treated as [1-10]
                .boxed() // convert it to wrapper class => Integer
                .collect(Collectors.toCollection(ArrayList::new)); // store result into an ArrayList
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

        for (Integer value: array) // for with an iterator (can be like this or you can manually get the iterator and use it to traverse the collection) - it traverses the collection element by element, and puts the value of the elements in our defined variable
            // for (CollectionInternalDatatype variable: Collection)
            // if we were to use iterators for this array, we would have
            // Iterator<CollectionInternalDatatype> it = collection.iterator();
            // it.next() gets the value of the current element and advances the iterator to the next position - it also has .nextIndex(), which returns the index of the element
            // it.remove() removes the current element and advances to the next
            // it.hasNext() is a boolean function (predicate) that returns true if the collection has elements left, and false otherwise
            // it is to be used in traversing the collection using iterators
            // you can either use the iterator in a while loop as such:
            // while(it.hasNext())
            //     CollectionInternalDatatype i = it.next();
            //     ....
            // or in a for loop, as such:
            // for (Iterator<CollectionInternalDatatype> it = collection.iterator(); it.hasNext();)
            //     CollectionInternalDatatype object = it.next();
            //     ....
            System.out.print(value + " ");

        System.out.println(); // print an empty line
        // to check if an array is empty, we can use array.isEmpty();
        // to get a value from the ArrayList variable, use array.get(index), we can't use operator[] as with primitive arrays
        // to set/update a value, use array.set(index, newValue);
        // or we can use .replaceAll() with a lambda function to modify all elements according to our rules

        array.forEach((number) -> { // for each traverses the collection applying the action we provide it on every element
            // our parameter for the function will be the current element in the array
            if (array.indexOf(number) % 2 == 0) // if the index of the element is even, print it
                System.out.print(number + " ");
        });

        // lambda function syntax
        // (argument1, argument2, ..., argumentN) -> { lambda function body }
    }

    public static void doStack() {
        // the stack can be initialized in the same way we used for an ArrayList, or just do it by hand
        Stack<Integer> stack = new Stack<>();
        // the stack is a data structure which stores elements in a LIFO manner (Last-In-First-Out)
        // think of it as stacking books on top of each other
        // you add books on top of the existing ones, and you remove books from the top, one by one
        stack.push(1); // this pushes (adds) an element to the stack
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Size of stack is: " + stack.size());
        // to check if a stack is empty, we use stack.isEmpty()
        // same removal mechanism is also available for stacks, though the standard approach is using .pop()

        // print all elements of the stack using .forEach()
        stack.forEach(System.out::println); // traversal is done from bottom to top
        // same .set()/.replaceAll() mechanism is available fo stacks, though it is not specific
        // it is present since Stack derives from Vector

        // do some prints related to stacks
        System.out.println("Top element: " + stack.peek()); // get the top element without popping it
        stack.pop(); // pops (removes) the element from the top of the stack and returns it
        System.out.println("New top element after popping: " + stack.peek());
        System.out.println("New stack size is: " + stack.size());
    }

    public static void doQueue() {
        // we can initialize a queue using the same way as an Array (either via streams or with .add())
        Queue<Integer> queue = IntStream.range(1, 11)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new)); // since Queue is an interface, we have to use some specific types - we can either use the variable type as LinkedList, but for this example I used queue
        // common ones for using queues are LinkedList and PriorityQueue
        // a queue is a FIFO data structure (First-In-First-Out)
        // think of it as real-life waiting queues, the first person in the queue is the one getting served
        // when you join a queue you go the end of it, and when you reach the front you are served, after which you leave, and thus are removed from the queue

        System.out.println("Size of queue is: " + queue.size());
        // for removing, we can use .remove(index), .remove(value) or .remove() - removes the front element
        // for checking if the queue is empty, we can use "queue.isEmpty()"
        // if we want to use .set(), we have to cast it to LinkedList for example, as Queue doesn't implement that

        // print queue
        queue.forEach((number) -> System.out.print(number + " "));

        // some displays
        System.out.println("\nFront element is: " + queue.peek()); // or queue.element() can be used
        queue.remove(); // returns the front element and returns it, queue.poll() does the same
        System.out.println("New front element after removal is: " + queue.element());
        System.out.println("New queue size is: " + queue.size());

        // queue.element() throws an exception if the queue is empty (NoSuchElementException), whereas queue.peek() doesn't, and just returns null
        // similarly, queue.remove() throws an exception if the queue is empty (NoSuchElementException), whereas queue.poll() doesn't, and just returns null
    }

    public static void doHashtable() {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        // we could also do "Map<String, Integer> map = new Hashtable<>();", since Hashtable is the specific implementation of the Map interface
        // the hashtable is a special data structure, taking in 2 data types
        // it is able to save a value for a specific key, basically allowing us to map certain "keys" to "values"
        // the identifiable element is called a key, and its value is called value

        hashtable.put("key1", 1); // adds the key "key1" and puts its value to be 1
        hashtable.put("key2", 2);

        hashtable.putIfAbsent("key3", 3); // only adds the key-value pair if it isn't present already
        // if we have another map/hashtable and want to add it, we can use .putAll()

        System.out.println("The size of the hashtable is: " + hashtable.size());

        System.out.println("The value for the key \"key3\" is: " + hashtable.get("key3"));
        // if the key doesn't exist, .get() returns null
        // additionally, we can use .getOrDefault(key, defaultValue), and will return the defaultValue if the key doesn't exist, instead of returning null

        // a collection of the values can be retrieved by "hashtable.values();"
        // a set of the keys can be retrieved by "hashtable.keysSet();"

        // to check if a key exists, we can use hashtable.containsKey(key)
        // to check if a value exists, we can use hashtable.containsValue(value)

        // to update a value we can use .replace(key, newValue), or .replace(key, currentValue, newValue) - the latter will replace the value in the key only if its value matches currentValue
        // we can also use .compute(key, lambda) to do some calculations on the current value to update it; you also have .computeIfAbsent() and .computeIfPresent(), with self explanatory usage and the same parameter list

        // to remove an element, we use .remove(key), or .remove(key, value) - the latter has the same functionality as .replace(key, currValue, newValue), in the sense that it will remove the key only if its current value matches "value"

        // there are multiple ways of traversing a hashtable
        Enumeration<String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(key + ": " + hashtable.get(key));
        }

        // for (Map.Entry<String, Integer> entry : hashtable.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }

        // scores.forEach((name, score) -> System.out.println(name + ": " + score));
    }

    public static void main(String[] args) {
        // test prime checking function
        System.out.println("Testing primality function.");

        if (isPrime(2))
            System.out.println("Number 2 is prime.");
        else
            System.out.println("Number 2 is not prime.");

        if (isPrime(27))
            System.out.println("Number 27 is prime.");
        else
            System.out.println("Number 27 is not prime.");

        if (isPrime(113))
            System.out.println("Number 113 is prime.");
        else
            System.out.println("Number 113 is not prime.");

        // test override
        System.out.println("\nTesting override.");

        Parent parent = new Parent();
        Parent child = new Child(); // create an element of the Parent type, but give it the child

        parent.p_1(); // will print "p_1 from Parent"
        parent.p_2(); // will print "p_2 from Parent"
        child.p_1(); // will print "p_1 from Parent" - since we didn't override the method in the child, even though we redefined it, it still takes it from the parent, as the datatype of the variable is Parent
        // thus, in trying to define method for inheritance, each children needs to override the methods to use their variant
        child.p_2(); // will print "Overriden p_2 from Child" // the overriden method is executed instead of the parent one

        Child child1 = new Child();
        child1.p_1(); // will print "p_1 from Child" - beware of the type of the variable
        // since for this one we made it to be Child, it will use the methods from there

        // test ArrayList usage
        System.out.println("\nTesting usage of ArrayList.");

        doArray();

        // test Stack usage
        System.out.println("\n\nTesting usage of Stack.");

        doStack();

        // test Stack usage
        System.out.println("\nTesting usage of Queue.");

        doQueue();

        // test Stack usage
        System.out.println("\nTesting usage of Hashtable.");

        doHashtable();
    }
}

// additional recap examples - abstract classes, interfaces and generics
abstract class Animal {
    // abstract classes are defined by the "abstract" keyword
    // they cannot be instantiated directly (e.g. Animal animal = new Animal("joe");)
    // they can have constructors, variables, static concrete methods (with implementation)
    // contains at least one method defined as abstract - MANDATORY
    // for inheritance, all classes that inherit it must override the abstract methods
    // a class can only inherit one abstract class
    // inheritance is done via "extends" keyword, as normal
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void speak(); // overriding with @Override annotation mandatory

    public void eat() { // overriding not mandatory
        System.out.println("Animal eating...");
    }
}


interface Shape {
    // cannot be instantiated directly
    // all methods are implicitly public and abstract unless stated otherwise
    // java8 >= we can have "default" and "static" methods with implementation
    // java9 >= we can have private methods
    // allows for constants
    // a class can inherit multiple interfaces
    // for inheritance, the "implements" keyword is used
    // in inheritance, all methods not marked as default must be overriden (the default ones are optional, but the rest are mandatory)

    // java8>=
    // there's also the concept of functional interfaces - interfaces with a single abstract method (can still have default methods)
    // they are typically annotated with @FunctionalInterface, though that is not required, only recommended
    // they are instantiated with lambda functions

    // for e.g., if this was a functional interface, we'd have Shape shape = (int x) -> x * 2;
    // and then, when we run the only abstract function with the arguments required by the lambda function, it executes it

    double PI = 3.1415;

    double perimeter(); // overriding with @Override annotation mandatory
    double area(); // overriding with @Override annotation mandatory

    default void show() { // overriding not necessary, though it can be
        System.out.println("Shape printed!");
    }
}

class Pair<K, V> {
    // generics are similar to templates in C++, though they don't use the word template in their definition
    // they just retain the definition way, using angular brackets, i.e. "<" and ">"
    // it allows you to work in a generic way with some dummy datatypes (defined in brackets), allowing you to create a general implementation of either a class or a method
    // in this example, we have created a small example for a pair (tuple)
    // when you instantiate it, you provide the datatypes explicitly, as follows: Pair<Integer, String> pair = new Pair<>(1, "hello");
    final private K first;
    final private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return this.first;
    }

    public V getSecond() {
        return this.second;
    }

    @Override // override default toString in Object
    public String toString() {
        return ("(" + this.first + ", " + this.second + ")");
    }
}