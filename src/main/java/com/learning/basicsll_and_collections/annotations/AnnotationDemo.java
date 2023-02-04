package com.learning.basicsll_and_collections.annotations;

class DeprecatedDemo {
    /**
     * @deprecated
     * This method is deprecated and has been replaced by newMethod()
     */
    @Deprecated
    public static void deprecatedMethod(){
        System.out.println("Deprecated method!)");
    }
}
public class AnnotationDemo {

    //@SuppressWarnings({"checked", "deprecation"})
    public static void main(String[] args) {
        DeprecatedDemo.deprecatedMethod();
    }
}

