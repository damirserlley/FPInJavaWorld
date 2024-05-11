package fp.model;

@FunctionalInterface
public  //only one function can be added in the interface with this annotation
interface Evaluate<T> { //T entry parameter type
    boolean isNegative(T t);
}
