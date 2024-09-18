## Stream

A Stream in Java can be defined as a sequence of elements from a source, such as arrays, List, Set or any other collection.

Streams are lazily operated, opposite to collections that must store all the values before it starts processing. Stream is conceptually a pipeline, in which elements are computed on demand.


## Stream Collectors

<table><thead><tr><th>Method</th><th>List Attributes</th><th>Java Version</th></tr></thead><tbody><tr><td>List&lt;T&gt; list = stream.toList();</td><td>Unmodifiable List</td><td>Java 16+</td></tr><tr><td>List&lt;T&gt; list = stream.collect(Collectors.toUnmodifiableList());</td><td>Unmodifiable List<br>Stream cannot have <em>null</em> values</td><td>Java 10+</td></tr><tr><td>List&lt;T&gt; list = stream.collect(Collectors.toList());</td><td>Modifiable List</td><td>Java 8+</td></tr><tr><td>LinkedList&lt;T&gt; list = stream.collect(Collectors.toCollection(LinkedList::new));</td><td>Mutable <em>LinkedList</em></td><td>Java 8+</td></tr><tr><td>ArrayList&lt;T&gt; list = stream.collect(Collectors.toCollection(ArrayList::new));</td><td>Mutable <em>ArrayList</em></td><td>Java 8+</td></tr></tbody></table>


## Differences between Stream map() and flatMap()

<table><thead><tr><th>Aspect</th><th><em>map()</em></th><th><em>flatMap()</em></th></tr></thead><tbody><tr><td><strong>Transformation</strong></td><td>One-to-one transformation</td><td>One-to-many transformation</td></tr><tr><td><strong>Input to Output</strong></td><td>1 input -&gt; 1 output</td><td>1 input -&gt; n outputs (flattened)</td></tr><tr><td><strong>Output Sequence</strong></td><td>Preserves input sequence</td><td>Flattens output</td></tr><tr><td><strong>When to Use</strong></td><td>Modify values, Extract properties</td><td>Splitting string, Combining nested collections</td></tr><tr><td><strong>Common Usage</strong></td><td>Normal data transformations</td><td>Handling nested structures</td></tr></tbody></table>

## Stream findAny()

The Stream.findAny() returns an Optional describing any element of the specified stream if Stream is non-empty. It returns an empty Optional if the stream is empty.

In non-parallel streams, findAny() will return the first element in most cases, but this behavior is not guaranteed. The Stream.findAny() method has been introduced for performance gain in the case of parallel streams, only.



## Links

Lambda Expression:
1. https://javaconceptoftheday.com/java-8-lambda-expressions/

Functional Interface:
1. https://javaconceptoftheday.com/java-8-functional-interfaces/

Method references:
1. https://javaconceptoftheday.com/java-8-method-references/

Java 8 default and static methods:
1. https://javaconceptoftheday.com/java-8-interface-changes-default-methods-and-static-methods/

Interface vs abstract classes:
1. https://javaconceptoftheday.com/interface-vs-abstract-class-after-java-8/

Stream:
1. https://javaconceptoftheday.com/java-8-streams-beginners-guide/
2. https://stackabuse.com/search/?q=Java+8

Collection vs Stream:
1. https://javaconceptoftheday.com/collections-and-streams-in-java/

Collectors class:
1. https://javaconceptoftheday.com/java-8-collectors-tutorial/

Stream questions:
1. https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/


Interview questions:
1. https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/
2. https://javaconceptoftheday.com/java-8-interview-questions-and-answers/

