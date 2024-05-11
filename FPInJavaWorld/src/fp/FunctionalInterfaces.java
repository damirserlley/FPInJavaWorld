package fp;

import fp.model.Evaluate;

import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfaces {
    /*
    MAIN CONCEPTS
    -Lambdas
    -Functional Interfaces
        -Predicate and BiPredicate  -> return boolean like validation test()
        -Supplier                   -> no arguments, only return -> helpful for generate objects
        -Consumer and BiConsumer    -> pass arguments and returns nothing
        -Functions and biFunctions  -> receives and return another value
                                        (String, String) //last return type
                                        (String, String, String)  //last return type
        -UrinaryOperator and BinaryOperator -> receives and return the same value apply(String) only pass one argument
                                        (String) //receive one and return one
                                        (String) using Binary //receive two and return one
     */

    public void run() {
        System.out.println("---------------- Lambdas");
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println(1 + " - " + lambda.isNegative(1));
        System.out.println(0 + " - " + lambda.isNegative(0));
        System.out.println(-1 + " - " + lambda.isNegative(-1));

        System.out.println("---------------- Predicate");
        Predicate<String> pStr = s -> s.contains("tnt");
        System.out.println("damirtnt - " + pStr.test("damirtnt"));
        System.out.println("damir - " + pStr.test("damir"));

        System.out.println("---------------- BiPredicate");
        BiPredicate<String, Integer> twoStr = (str, len) -> str.length() == len;
        System.out.println("winter 6 - " + twoStr.test("winter", 6));
        System.out.println("winter 5 - " + twoStr.test("winter", 5));

        System.out.println("---------------- Supplier");
        Supplier<String> supplier = () -> Math.random() + "tnt";
        System.out.println("supplier random num plus tnt - " + supplier.get());

        System.out.println("---------------- Consumer");
        List<String> elements = List.of("val", "cin", "end", "dig");
        Consumer<String> consumer = el -> System.out.println(el);
        elements.forEach(consumer);

        System.out.println("---------------- BiConsumer"); //hashmap works good with this
        HashMap<String, String> hashMap = new HashMap<>();
        BiConsumer<String, String> biConsumer = (el, il) -> System.out.println(el + il);
        biConsumer.accept("2", "Goku");
        biConsumer.accept("3", "Naruto");
        biConsumer.accept("1", "Luffy");
        hashMap.forEach(biConsumer);

        System.out.println("---------------- Function");
        Function<String, Integer> funct = a -> a.length();  //first paremeter entry and second parameter return type
        BiFunction<String, String, Integer> biFunct = (a, b) -> a.length() + b.length(); //two first arguments are entry and return type Integer
        System.out.println("Function ->"+funct.apply("Costa Rica"));
        System.out.println("Function ->"+biFunct.apply("Costa Rica", "Costa Rica"));

        System.out.println("---------------- Function");
        UnaryOperator<String> unaryOperator = a -> a.concat(" saved!"); //entry and return type are the same
        BinaryOperator<String> binaryOperator = (a, b) -> a + b; //entry variables and return type are the same
        System.out.println(unaryOperator.apply("unary"));
        System.out.println(binaryOperator.apply("first", "second operator"));

        System.out.println("---------------- Final and Effectively Final");
        int x =12;
        Predicate<Integer> testEffectivelyFinal = i -> {
            //x =123; //final and effectively final -> variables outside of the scope are effectively final! so x does not need final key word
            return i == x;
        };
        System.out.println(testEffectivelyFinal.test(12));
        System.out.println(testEffectivelyFinal.test(122));
    }


}
