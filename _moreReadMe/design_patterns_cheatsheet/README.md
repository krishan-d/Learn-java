# Design Patterns CheatSheet

![design-pattern-cheatsheet](https://user-images.githubusercontent.com/2780145/59164687-16df4c00-8b2e-11e9-90cc-5b49cdcdafca.png)

The Singleton Pattern:

This ensures a class has only one instance and provides a global point of access to that instance.
Some examples are logger classes, configuration managers or any scenario where only a single instance of a class 
should be responsible for coordinating actions in a system.
The pros of this approach ensures that only one instance of a class exists. This can reduce memory usages but does 
provide global access.
Some cons includes that global state might introduce hidden dependencies between classes and may hinder unit testing 
and it's not always thread safe unless implemented properly.