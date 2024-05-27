### Annotations in Java

Annotations in Java provide additional information to the compiler and JVM. An annotation is a tag representing metadata
about classes, interfaces, variables, methods, or fields. Annotations do not impact the execution of the code that they
annotate. Some characteristics of annotations are:

- Begin with ‘@’
- Do not alter the execution of the program
- Provide supplemental information and help to link metadata with elements of a program such as classes, variables, constructs, methods, etc.
- Are different from comments since they can affect how the program is treated by the compiler


### Hierarchy of Annotations in Java

![Annotation Hierarchy](https://www.simplilearn.com/ice9/free_resources_article_thumb/Annotatins_in_Java_1.PNG)

### Categories of Annotation

![Annotation Categories](https://www.simplilearn.com/ice9/free_resources_article_thumb/Annotatins_in_Java_2.PNG)

### 1: Marker Annotations

Marker annotations do not contain members/elements. It is only used for marking a declaration.

Example:
@Override
@TestAnnotation()

### 2: Single value Annotations

A single element annotation contains only one element.

Syntax:
@AnnotationName(elementName = "elementValue")
@AnnotationName(value = "elementValue")
@AnnotationName("elementValue")

### 3: Full Annotations

Full Annotations include multiple data members, values, names, and pairs.

Syntax:
@AnnotationName(element1 = "value1", element2 = "value2")

### 4: Type Annotations

Type Annotations are applied at any place where a type is being used. Type Annotations are declared with @Target Annotation.

Type annotations enable Java code to be analyzed better and provide even stronger type checks.

Example:

**Constructor invocation**:

new @Readonly ArrayList<>()

**Type definitions**:

@NotNull String str;

This declaration specifies non-null variable str of type String to avoid NullPointerException.

@NotNull List<String> newList;

This declaration specifies a non-null list of type String.

List<@NotNull String> newList;

This declaration specifies a list of non-null values of type String.

**Type casts**:

newString = (@NotNull String) string;

**extends and implements clause**:

class Warning extends @Localized Message

**throws clause**:

public String readMethod() throws @Localized IOException

### Types of Annotations

### Predefined/ Standard Annotations

### Annotation 1: @Deprecated
- It is a marker annotation. It indicates that a declaration is obsolete and has been replaced by a newer form.
- The Javadoc @deprecated tag should be used when an element has been deprecated.
- @deprecated tag is for documentation and @Deprecated annotation is for runtime reflection.
- @deprecated tag has higher priority than @Deprecated annotation when both are together used.

Example:

```java
public class DeprecatedTest
{
     /**
     * @deprecated
     * This method is deprecated and has been replaced by newMethod()
     */
     @Deprecated
     public static void deprecatedMethod(){
         System.out.println("Deprecated method!)");
     }
 
     public static void main(String args[]){
         deprecatedMethod();
     }
}
```

### Annotation 2: @Override

The @Override annotation specifies that a method of a subclass overrides the method of the superclass with the same 
method name, return type, and parameter list.

It is used to ensure that a superclass method is actually overridden, and not simply overloaded.

Example:

```java
class Base {
     public void Display() {
         System.out.println("Base display()");
     }
}

class Derived extends Base {
     @Override
     public void Display(){
         System.out.println("Derived display()");
     }
     public static void main(String args[]) {
         Base base = new Derived();
         base.Display();
     }
}
```

### Annotation 3: @SuppressWarning

The @SuppressWarnings annotation instructs the compiler to suppress warnings that are generated while the program executes.
This type of annotation can be applied to any type of declaration.

The warnings that can be suppressed are compiler-specific but there are two categories of warnings: **deprecated** and **unchecked**.

- **deprecated** instructs the compiler to suppress warnings when we use a deprecated element.
- **unchecked** instructs the compiler to suppress warnings when we use raw types.

Example:

```java
class DeprecatedDemo {
    @Deprecated
    public static void deprecatedMethod() {
        System.out.println("Deprecated display()");
    }
}

public class Main {
    @SuppressWarnings({"checked", "deprecation"})
    public static void main(String[] args) {
        deprecatedMethod();
    }
}
```

### Meta Annotations

Meta-annotations are annotations that are applied to other annotations.

### Annotation 1: @Retention
The @Retention annotation specifies the level up to which the annotation will be available.

Syntax: @Retention(RetentionPolicy)

Retention annotation policies:
- **RetentionPolicy.SOURCE**: Annotations is available only at the source level and is ignored by the compiler.
- **RetentionPolicy.CLASS**: The annotation is available to the compiler at compile-time, but is ignored by JVM.
- **RetentionPolicy.RUNTIME**: The annotation is available to the JVM.

Example:

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {
    //...
}
```

### Annotation 2: @Documented

By default, custom annotations are not included in the official Java documentation. To include our annotation in the 
Javadoc documentation, we use the @Documented annotation.

Example:

```java
import java.lang.annotation.Documented;

@Documented
public @interface MyCustomAnnotation {
    //...
}
```

### Annotation 3: @Target

We can restrict an annotation to be applied to specific targets using the @Target annotation.

Syntax: @Target(ElementType)

<table class="alt">
<tbody>
<tr><th>ElementType</th><th>Target</th></tr>
<tr><td>ElementType.ANNOTATION_TYPE</td><td>Another annotation</td></tr>
<tr><td>ElementType.CONSTRUCTOR</td><td>Constructor</td></tr>
<tr><td>ElementType.FIELD</td><td>Field</td></tr>
<tr><td>ElementType.LOCAL_VARIABLE</td><td>Local variable</td></tr>
<tr><td>ElementType.METHOD</td><td>Method</td></tr>
<tr><td>ElementType.PACKAGE</td><td>Package</td></tr>
<tr><td>ElementType.PARAMETER</td><td>Parameter</td></tr>
<tr><td>ElementType.TYPE</td><td>Class, Interface, or enumeration</td></tr>
</tbody></table>

Example:

```java
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
public @interface MyCustomAnnotation{
    //...
}
```

### Annotation 3: @Inherited

By default, an annotation type cannot be inherited from a superclass. However, if we need to inherit an annotation from
a superclass to a subclass, we use the @Inherited annotation.

Syntax: @Inherited

Example:

```java
import java.lang.annotation.Inherited;

@Inherited
public @interface MyCustomAnnotation {}

@MyCustomAnnotation
public class ParentClass{}

public class ChildClass extends ParentClass {}
```

### Annotation 3: @Repeatable

An annotation that has been marked by @Repeatable can be applied multiple times to the same declaration.

```java


import java.lang.annotation.Repeatable;

@Repeatable(Universities.class)
public @interface University {
    String name();
}

public @interface Universities {
    University[] value();
}

public class Main() {
    @University(name = "IIT")
    @University(name = "MIT")
    private String uniName;
}

```

### Custom Annotations

To annotate program elements, i.e. variables, constructors, methods, etc. user-defined annotations can be used. The 
user-defined annotations can be applied to the elements Ii.e. variables, constructors, classes, methods) just before 
their declaration.

Annotations are created by using @interface and are followed by the annotation name. An annotation can also have 
elements. They appear as methods but the implementation should not be provided for these elements. All the annotations 
extend java.lang.annotation.Annotation interface. The annotations cannot include the extended clause.

Example:

```java
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// User-defined annotation
@Documented
@Retention(RetentionPolicy.RUNTIME)
@ interface AnnotationDemo {
    String Developer() default "None";
    String ExpiryDate();
}

public class Demo {
    @AnnotationDemo(Developer="Eve", ExpiryDate="26-03-2020")
    public void method1() {
        System.out.println("Demo method 1");
    } 

    @AnnotationDemo(ExpiryDate="26-03-2021")
    void method2() {
        System.out.println("Demo method 2");
    }     

    public static void main(String args[]) {
        Demo d = new Demo();
        d.method1();
        d.method2();
    }
}
```

### Annotations Use

- **Compiler instructions** - Annotations can be used for giving instructions to the compiler, detect errors or suppress
warnings. The built-in annotations @Deprecated, @Override,@SuppressWarnings are used for these purposes.

- **Compile-time instructions** - Compile-time instructions provided by these annotations help the software build tools 
to generate code, XML files and many more.

- **Runtime instructions** - Some annotations can be defined to give instructions to the program at runtime. These 
annotations are accessed using Java Reflection.