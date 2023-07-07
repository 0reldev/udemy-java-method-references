package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld {

    private static int last_id = 1;

    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object");
    }
}

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("Anna", "Bob", "Chuck", "Dave"));
        list.forEach(System.out::println);
//        Anna
//        Bob
//        Chuck
//        Dave

        calculator(Integer::sum, 10, 25);
//        Result of the operation: 35

        calculator(Double::sum, 2.5, 7.5);
//        Result of the operation: 10.0

        Supplier<PlainOld> reference1 = PlainOld::new;
        PlainOld newPojo = reference1.get();
//        Creating a PlainOld Object

        System.out.println("Getting array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);
//        Creating a PlainOld Object
//        Creating a PlainOld Object
//        Creating a PlainOld Object
//        Creating a PlainOld Object
//        Creating a PlainOld Object
//        Creating a PlainOld Object
//        Creating a PlainOld Object
//        Creating a PlainOld Object
//        Creating a PlainOld Object
//        Creating a PlainOld Object

        calculator((s1, s2) -> s1 + s2, "Hello", "World");
//        Result of the operation: HelloWorld

        calculator((s1, s2) -> s1.concat(s2), "Hello", "World");
//        Result of the operation: HelloWorld

        calculator(String::concat, "Hello", "World");
//        Result of the operation: HelloWorld

        BinaryOperator<String> b1 = String::concat;
        System.out.println(b1.apply("Hello", "World"));
//        HelloWorld

        BiFunction<String, String, String> b2  = String::concat;
        System.out.println(b2.apply("Hello", "World"));
//        HelloWorld

        UnaryOperator<String> u1 = String::toUpperCase;
        System.out.println(u1.apply("Hello"));
//        HELLO

        String result = "Hello".transform(u1);
        System.out.println("Result = " +  result);
//        Result = HELLO

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);
//        Result = hello

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println("Result = " + resultBoolean);
//        Result = false
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {

        T result = function.apply(value1, value2);
        System.out.println("Result of the operation: " +  result) ;
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {

        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}