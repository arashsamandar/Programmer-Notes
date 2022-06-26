## Desing Patterns Used In Laravel

> the `Art` of designing Object Oriented Sofware .
>
> irrelevent note : we use `package` for java ( like com.arash.samandar ) , and it's a container for Classes . equevalent of this in php is `namespace`

## In Laravel 4 it says

According to the book [Laravel Design Patterns and Best Practices](https://www.packtpub.com/web-development/laravel-design-patterns-and-best-practices):

Chapter 5: Design Patterns in Laravel

- The Builder (Manager) pattern
- The need for the Builder (Manager) pattern
- The Factory pattern
- The need for the Factory pattern
- The Repository pattern
- The need for the Repository pattern
- The Strategy pattern -The need for the Strategy pattern
- The Provider pattern
- The Facade pattern

And let's not forget the Architectural Model-View-Controller Pattern.

-------------------

#### Repository desing pattern

>The **repository design pattern** allows you to use **objects** without having to know how these **objects** are persisted. Essentially it is an abstraction of the data layer. This means that your business logic doesn't need to know how data is retrieved or what the source of the data is

-----------

## Coupling & Decoupling

> `Coupling Problem` accures when one class is dependent on another class
>
> Simply put one class is using another class ! very simple ha ?
>
> yea , this way , if that class changes , it means compiler needs to decompile it . and also the first one that uses this class also has to be recompiled .
>
> __this is called as coupling problem__ . like bellow

```java
package com.arash.desingPatterns;

public class Main {

    public static void main(String[] args) {
	    User user = new User("Arash",31);
	    user.sayHello();
    }
}
//-----------------------------
package com.arash.desingPatterns;

public class User {
    public String name;
    public User(String name,int age) {
        this.name = name;
    }
    public void sayHello() {
        System.out.println("Hi, My Name Is " + name);
    }
}
```

--------------

## Building Loosly Coupled Applications

> imagine your car , if your tire is flat , you just need to replace that part ( the tire ) . the Application should be like this . not coupled everywhere ,
>
> how we do it ? __Using `Interfaces`__