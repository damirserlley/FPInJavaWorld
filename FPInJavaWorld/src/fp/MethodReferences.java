package fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {
        /*
    MAIN CONCEPTS
    Definition -> They're often used to create simple lambda expressions by referencing existing methods
    -Types
        -Bound  -> no argument passed
        -Unbound -> passed arguments...
        -Static -> Collections::sort
        -Constructor -> ArrayList::new
     */

    public void run(){
        System.out.println();
        System.out.println("---------------- Method reference -  Bound type");
        String lastName = "UZUMAKI";
        Supplier<String> lambdaWay = () -> lastName.toLowerCase();
        Supplier<String> referenceWay = lastName::toLowerCase;
        System.out.println(lambdaWay.get());
        System.out.println(referenceWay.get());

        System.out.println("---------------- Method reference -  UnBound type");
        String onePiece = "Coco Island";
        Function<String, String> wheIsIsland =  String::toUpperCase;
        BiFunction<String, String, String> wheIsIslandBi = String::concat;
        System.out.println(wheIsIsland.apply(onePiece));
        System.out.println(wheIsIslandBi.apply(onePiece, " COCOLA Black beard secret map"));

        System.out.println("---------------- Method reference -  Static type");
        Consumer<List<Integer>> sortList = Collections::sort;
        var list = Arrays.asList(9, 5, 2, 9, 1);
        sortList.accept(list);
        System.out.println(list);

        System.out.println("---------------- Method reference -  Constructor type");
        Supplier<StringBuilder> newStringBuilder = StringBuilder::new;
        var testStringBuilder = newStringBuilder.get() + "Adding new word -> Lorem";
        System.out.println(testStringBuilder);

        Function<Integer, List<String>> functionList = ArrayList::new;
        List<String> resultList = functionList.apply(5);
        resultList.add("new value");
        System.out.println(resultList.size()); //FIXME: this size is wrong
    }
}
