package com.learning._17;

public sealed class Shape permits Circle, Square{
}

final class Circle extends Shape {

}

final class Square extends Shape {

}

// NOTE:
// Shape is a sealed class, and only Circle and Square are allowed to extend it.
// final classes are required to prevent further inheritance.