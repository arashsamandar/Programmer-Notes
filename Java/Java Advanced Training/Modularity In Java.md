# Modularity In Java

## Definition

### Watch bellow movie :

[D:\Education\Lynda\Java & More With It\Lynda.com - Advanced Java Programming\06 Modular Programming in Java\001 Understanding modules in Java.mp4](You Must Watch This Video First : )

-----

:memo:**`So What Is A module :`**

> A module is a group of related code So it contains some code.
>
> Module is used to break large applications into several sections , or Get rid off unwanted JDK parts ( or old parts ) .
>
> Achieving Better Encapsulation .
>
> So everything inside a module is hidden from the outside world .
>
>  the module name must be uniqe like a package name .
>
> Every Module has a Module Descriptor : so we can say if any part of the module is accessible from the outside world , the descriptor can also be used to state if code from any other modules is going to be used .

------

## Creating A Module In Java

All we need to do is add something called `Module Info File` to our programme .

> in IntelliJ IDEA first we create an empty project for ourselfs , then in the project structure we can add new modules to our project . :memo:`Note :`we have to change the sdk version to version **9**, so it supports the module in our program .
>
> then right click on the `src` and click add `module-inja.java` .

> in Netbeans : right click on your project -> new -> java Module Info... -> then in the PopUp window click on finish .  a file named `module-info.java` would be created . just having this file makes your application a modular application .

*in the `module-info.java`File .*

```java
module HelloWorld { // The name has to be the name of the directory it is in
}
```

- > **General Rule is :** Module Names Are The Same as The Folder They Are IN .

:pushpin:**`Now in the module-info.java` File we have :**

```java
// the same name of there folder
module ArashModule {
    requires java.Desktop; // if we want to use different module , for example
    exports MyClass; // to let other modules to use MyClass which i have created .
    exports MyPackage; // this would share any class inside MyPackage package (folder)
}
```

------

## Compiling & Running Modular Applications From The Command Line

