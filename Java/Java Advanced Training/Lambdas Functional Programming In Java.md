# Functional Programming In Java

## Lambda & Functional Interface In Java

#### Labdas

> In Java8 a new feature was introduced called `Lambdas` , Labdas represent the implementation of a functional interface . 

#### Functional Interface

> A functional interface is an interface `that has only one abstract method`, like the example bellow .

```java
public interface HelloMessage {
    public abstract void hello(String name);
}
```

> now we can implement the functional interface in another class ,  inside the main method when we declare it , IntelliJ Idea and other IDEs automatically adds an override version of the HelloMessage class .

#### anonymous in a class

> because HelloMessage is an abstract method with no implementation . we have to write our own every time we create a new instance of the HelloMessage  . This is also known as an `anonymous in a class `

```java
public class Main {
    public static void main(String[] args) {
        HelloMessage message = new HelloMessage() {
            @Override
            public void hello(String name) {
                System.out.println("Hello : " + name);
            }
        };
        message.hello("Arash");
    }
}
```

#### meaning of functional interface & Lamdas

> that is all a functional interface is , `it allow java programmers to pass code around as data` .

> but at the moment the codes to implement our interface is long and messy , considering all it does : is a one line of functionality , `so lambdas was intruduced to improve this` .

-------

## Implementing Labdas

> labdas provide a short & simple way to implement functional interfaces ( Functional Interface are Interfaces that has Only One method ) in java , They are now a commonly used feature in the Java language , so it is useful to be able to read and understand them, as well as to use them in your own code.

> now lets implement our functional interface this time with lambdas . shorter and simpler

```java
public class Main {
    public static void main(String[] args) {
        HelloMessage message = (String name) -> {
            System.out.println("Hello : " + name);
        };
        message.hello("Arash");
    }
}
```

> Lets see another example

```java
@FunctionalInterface
public interface MessagePrinter {
    public abstract void printMessage();
}
```

```java
public class Main {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = () {
            System.out.println("This Is A Message");
        };
        messagePrinter.printMessage();
    }
}
```

> So lambdas are a quick and simple way of implementing Functional Interface , they look quite different to anonymous inner classes , but the logic is the same .

------

## Using Method Referene In Java

#### Definition

> Method references are a *shorthand way of writing a certain type of `Labda` expression*, if you have a labda expression that passes in a variable and then calls a method on that variable , you can replace it with a method reference .

**Example**

*We Normal Class Called `Square`*

```java
public class Square {

    private int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    public int calculateArea() {
        return (sideLength*sideLength);
    }

}
```

*And A FunctionalInterface Called `Shapes` which gets a `Square` in it's abstract method*

```java
@FunctionalInterface
public interface Shapes {
    public abstract int getArea(Square person);
}
```

*And in the `Main` class We have*

```java
public class Main {
    public static void main(String[] args) {
        Square s = new Square(4);
        Shapes shape = (Square square) -> {
            return square.calculateArea();
        };
        System.out.println("Area : " + shape.getArea(s));
    }
}
```

:bulb:**Now We Change It with `Method Reference`**

```java
public class Main {
    public static void main(String[] args) {
        Square s = new Square(4);
        Shapes shape = (Square square) -> {
            return square.calculateArea();
        };
        System.out.println("Area : " + shape.getArea(s));
    }
}
```