package com.learning._8.functional_interfaces;

public class Details {

    /*
     * Link: https://www.geeksforgeeks.org/functional-interfaces-java/?ref=lbp
     * Since Java SE 1.8 onwards, there are many interfaces that are converted into functional interfaces.
     * All these interfaces are annotated with @FunctionalInterface. These interfaces are as follows –
     * Runnable –> This interface only contains the run() method.
     * Comparable –> This interface only contains the compareTo() method.
     * ActionListener –> This interface only contains the actionPerformed() method.
     * Callable –> This interface only contains the call() method.
     *
     * Java SE 8 included four main kinds of functional interfaces which can be applied in multiple situations as mentioned below:
     * Consumer
     * Predicate
     * Function
     * Supplier
     *
     * Amidst the previous four interfaces, the first three interfaces,i.e., Consumer, Predicate, and Function, likewise have additions that are provided beneath –
     * Consumer -> Bi-Consumer
     * Predicate -> Bi-Predicate
     * Function -> BiFunction, UnaryOperator, BinaryOperator
     */

    /* 1. Consumer
    The consumer interface of the functional interface is the one that accepts only one argument or a gentrified argument.
    The consumer interface has no return value. It returns nothing.
    There are also functional variants of the Consumer — DoubleConsumer, IntConsumer, and LongConsumer.
    These variants accept primitive values as arguments.

    Other than these variants, there is also one more variant of the Consumer interface known as Bi-Consumer.
    Bi-Consumer – Bi-Consumer is the most exciting variant of the Consumer interface.
    The consumer interface takes only one argument, but on the other side, the Bi-Consumer interface takes two arguments.
    Both, Consumer and Bi-Consumer have no return value. It also returns nothing just like the Consumer interface.
    It is used in iterating through the entries of the map.*/


    /* 2. Predicate
    In scientific logic, a function that accepts an argument and, in return, generates a boolean value as an answer is known as a predicate.
    Similarly, in the Java programming language, a predicate functional interface of Java is a type of function that accepts
    a single value or argument and does some sort of processing on it, and returns a boolean (True/ False) answer.
    The implementation of the Predicate functional interface also encapsulates the logic of filtering
    (a process that is used to filter stream components on the base of a provided predicate) in Java.

    Extensions/variants : These are IntPredicate, DoublePredicate, and LongPredicate.
    These types of predicate functional interfaces accept only primitive data types or values as arguments.

    Bi-Predicate – Bi-Predicate is also an extension of the Predicate functional interface, which, instead of one, takes two arguments,
    does some processing, and returns the boolean value.*/

    /* 3. Function
    A function is a type of functional interface in Java that receives only a single argument and returns a value after the required processing.
    There are many versions of Function interfaces because a primitive type can’t imply a general type argument,
    so we need these versions of function interfaces.
    Many different versions of the function interfaces are instrumental and are commonly used in primitive types like double, int, long.
    The different sequences of these primitive types are also used in the argument.

    These versions are:

    Bi-Function :

    The Bi-Function is substantially related to a Function. Besides, it takes two arguments, whereas Function accepts one argument.

    The prototype and syntax of Bi-Function is given below –

    @FunctionalInterface
    public interface BiFunction<T, U, R>
    {

        R apply(T t, U u);
    .......

    }
    In the above code of interface, T and U are the inputs, and there is only one output which is R.

    Unary Operator and Binary Operator :
    There are also two other functional interfaces which are named Unary Operator and Binary Operator.
    They both extend the Function and Bi-Function, respectively.
    In simple words, Unary Operator extends Function, and Binary Operator extends Bi-Function.

    The prototype of the Unary Operator and Binary Operator is mentioned below :

    i. Unary Operator

    @FunctionalInterface
    public interface UnaryOperator<T> extends Function<T, U>
    {
    ……...
    }
    ii. Binary Operator

    @FunctionalInterface
    public interface BinaryOperator<T> extends BiFunction<T, U, R>
    {
    ……...
    }
    We can understand from the above example that the Unary Operator accepts only one argument and returns a single argument only.
    Still, in Unary Operator both the input and output values must be identical and of the same type.

    On the other way, Binary Operator takes two values and returns one value comparable to Bi- Function but similar to a Unary Operator,
    the input and output value types must be identical and of the same type.*/


    /* 4. Supplier
    The Supplier functional interface is also a type of functional interface that does not take any input or argument and yet returns a single output.
    This type of functional interface is generally used in the lazy generation of values.
    Supplier functional interfaces are also used for defining the logic for the generation of any sequence.
    For example – The logic behind the Fibonacci Series can be generated with the help of the Stream. generate method,
    which is implemented by the Supplier functional Interface.

    The different extensions of the Supplier functional interface hold many other suppliers functions like
    BooleanSupplier, DoubleSupplier, LongSupplier, and IntSupplier.
    The return type of all these further specializations is their corresponding primitives only.*/



}
