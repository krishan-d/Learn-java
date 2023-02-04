package com.learning.basics_and_collections.annotations.annotation;

import java.lang.annotation.*;

public class CustomAnnotation {

    /*
     * Custom Annotation:
     * Syntax:
     * [Access Specifier] @interface<AnnotationName> {
     *     DataType <MethodName>() [default value];
     * }
     *
     * Return Type can be primitive, enum, string, class name or array of these types.
     * */

    @interface NewCustomAnnotation {
        String value() default "default value";
    }

    @NewCustomAnnotation(value = "www")
    public void method() {
        System.out.println("Test method");
    }

    /*
     * Meta Annotations:
     * 1.@Retention:
     * Specifies the level up to which the annotation will be available.
     * Syntax:
     * @Retention(RetentionPolicy)
     *
     * Types:
     * RetentionPolicy.SOURCE: To source, ignored by compiler
     * RetentionPolicy.CLASS: To compiler at compile-time, but ignored by JVM
     * RetentionPolicy.RUNTIME: To JVM
     * */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyCustomAnnotation1 {
    }

    /*
     * 2.@Documented:
     * To include our annotation in the Javadoc documentation.
     * */
    @Documented
    public @interface MyCustomAnnotation2 {
    }

    /*
     * 3.@Target:
     * restrict an annotation to be applied to specific targets.
     * Syntax:
     * @Target(ElementType)
     *
     * ElementType.ANNOTATION_TYPE
     * ElementType.CONSTRUCTOR
     * ElementType.FIELD
     * ElementType.LOCAL_VARIABLE
     * ElementType.METHOD
     * ElementType.PACKAGE
     * ElementType.PARAMETER
     * ElementType.TYPE
     *
     * NOTE:
     * If the target type is not defined, the annotation can be used for any element.
     * */
    @Target(ElementType.METHOD)
    public @interface MyCustomAnnotation3 {
    }

    /*
     * 4.@Inherited:
     * By default, an annotation type cannot be inherited from a superclass.
     * However, if we need to inherit an annotation from a superclass to a subclass, we use the @Inherited annotation.
     *
     * Syntax:
     * @Inherited
     * */
    @Inherited
    public @interface MyCustomAnnotation4 {
    }

    @MyCustomAnnotation4
    public class ParentClass {
    }

    public class SubClass extends ParentClass {
    }

    /*
     * 5.@Repeatable:
     * */
    @Repeatable(Universities.class)
    public @interface University {
        String name();
    }

    /*
     * The value defined in the @Repeatable annotation is the container annotation.
     * The container annotation has a variable value of array type of the above repeatable annotation.
     * Here, Universities are the containing annotation type.
     * */
    public @interface Universities {
        University[] value();
    }

    /*
     * Now, the @University annotation can be used multiple times on the same declaration.
     *
     * To retrieve annotation values, we use getAnnotationsByType() or getAnnotations() method defined in the Reflection API.
     * */
    @University(name = "TU")
    @University(name = "KU")
    private String uniName;


    public static void main(String[] args) throws Exception {
        CustomAnnotation a = new CustomAnnotation();

        a.method();

        System.out.println(a.uniName);
    }
}
