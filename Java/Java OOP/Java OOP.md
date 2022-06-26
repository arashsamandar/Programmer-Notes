# Java OOP

### Abstract method
1) A method that is declared but not defined. Only method signature no body.
2) Declared using the abstract keyword

```java
abstract public myFunction(String havij);
```

### But Why Do We Use An Abstract Method In a Class
we use it so we force the extended class to implement this method :) , because every class that inherits this class MUST implement the abstract class

### these can not be abstract class
Constructors
Static methods
Private methods
Methods that are declared “final”


---

## Interface

> An interface is a blueprint of a class, which can be declared by using interface keyword. Interfaces can contain only constants and abstract methods

> **NOTE :** you must initialize all variable , if you have any in your interface , they must have a value .


![Image](D:\Programming Notes/medley/resources/Sye9eQILTV_BkgjDUUTN.png)
> using interface i can insert a bunch of `variable` to my class , just as easy as that .

```java
public interface MyInterface {
   String havij = "samandar";
   String number = 123;
   final String className = "THIS IS";
   
   public void arashSamandar();
   public String returnMeBaby(String value,int grade);
}

// now in the class we can use interface variables verryyy easy

public class Main extends AppCompat implements MyInterface {

   int classNumber;
   public void Main() {
      this.classNumber = number;
      // or anything else
   }
   
   @Override
   public void arashSamandar() {
   }
   
   @override
   public String returnMeBaby(String value,int grade) {
   }
}
```

---

## Java Copy Constructor Concept

> A copy constructor is used for copying the values of one object to another object.

```java
class JavaExample{  
   String web; 
   JavaExample(String w){  
	web = w;
   }  
   
   JavaExample(JavaExample je){  
	web = je.web; 
   }  
   
   void disp(){
	System.out.println("Website: "+web);
   }  

   public static void main(String args[]){  
	JavaExample obj1 = new JavaExample("BeginnersBook");  
	JavaExample obj2 = new JavaExample(obj1);  
	obj1.disp();  
	obj2.disp();  
   }  
}
```


## Association
> **NOTE :** Association establishes relationship between two separate classes through their objects. The relationship can be one to one, One to many, many to one and many to many.

> we already know the use of `super` and the Inheritence , so in here we skip that , however there is a nice functionality we haven't seen so often and that is Association and works like bellow : when we use parent constructor in child constructor :
```java
public class Car {
   String carName;
   int carId;
   Car(String name,int id) {
      this.carName = name;
      this.carId = id;
   }
}
public class Driver extends Car {
   String driverName;
   Driver(String name,String cName,int cID) {
      super(cName,cID);
      this.driverName = name;
   }
}
```


## Aggregation

> **NOTE :** basically the same , but we use the first class in second class Arguments

> For example consider two classes Student class and Address class. Every student has an address so the relationship between student and address is a Has-A relationship. But if you consider its vice versa then it would not make any sense as an Address doesn’t need to have a Student necessarily. Lets write this example in a java program.
> Student Has-A Address
```java
class Address
{
   int streetNum;
   String city;
   String state;
   String country;
   Address(int street, String c, String st, String coun)
   {
       this.streetNum=street;
       this.city =c;
       this.state = st;
       this.country = coun;
   }
}
class StudentClass
{
   int rollNum;
   String studentName;
   //Creating HAS-A relationship with Address class
   Address studentAddr; 
   StudentClass(int roll, String name, Address addr){
       this.rollNum=roll;
       this.studentName=name;
       this.studentAddr = addr;
   }
```

## Delegation
> Delegation is simply passing a duty off to someone/something else

Suppose that you need to create a class named EmployeeCollection that represents a group of employees. One way to create this class would be to extend one of the collection classes supplied by the Java API, such as the ArrayList class. Then your EmployeeCollection class would be a specialized version of the ArrayList class and would have all the methods that are available to the ArrayList class.

A simpler alternative, however, would be to declare a class field of type ArrayList within your EmployeeCollection class. Then you could provide methods that use this ArrayList object to add or retrieve employees from the collection.

Why is this technique called the delegation? Rather than write code that implements the functions of the collection, you delegate that task to an ArrayList object, because ArrayList objects already know how to perform these functions.

Example
```java
class RealPrinter { 
    // the "delegate" 
    void print() 
    { 
        System.out.println("The Delegate"); 
    } 
} 
  
class Printer { 
    // the "delegator" 
    RealPrinter p = new RealPrinter(); 
  
    // create the delegate 
    void print() 
    { 
        p.print(); // delegation 
    } 
} 
  
public class Tester { 
  
    // To the outside world it looks like Printer actually prints. 
public static void main(String[] args) 
    { 
        Printer printer = new Printer(); 
        printer.print(); 
    } 
} 
```

> When you delegate, you are simply calling up some class which knows what must be done. You do not really care how it does it, all you care about is that the class you are calling knows what needs doing.


---


## Singleton Design Pattern

### Definition:
**The singleton pattern is a design pattern that restricts the instantiation of a class to one object.**

Implementation
```java
class Singleton 
{ 
    private static Singleton obj; 
  
    // private constructor to force use of 
    // getInstance() to create Singleton object 
    private Singleton() {} 
  
    public static Singleton getInstance() 
    { 
        if (obj==null) 
            obj = new Singleton(); 
        return obj; 
    } 
} 
```

> Here we have declared `getInstance()` `static` so that we can call it without instantiating the class. The first time `getInstance()` is called it creates a new singleton object and after that it just returns the same object. Note that Singleton obj is not created until we need it and call getInstance() method. This is called lazy instantiation.


> The Only Problem With Above Code , is when multithreading is at work . then it is possible that at the same time it gives two different object , while it shoudn't , for this reason we use `Synchronized`

```java
class Singleton 
{ 
    private static Singleton obj; 
  
    private Singleton() {} 
  
    // Only one thread can execute this at a time 
    public static synchronized Singleton getInstance() 
    { 
        if (obj==null) 
            obj = new Singleton(); 
        return obj; 
    } 
} 
```

---

## An Example Of Method OverLoading In Java
```java
class ABC{
   public void myMethod()
   {
	System.out.println("Overridden method");
   }	   
}
class Demo extends ABC{
   public void myMethod(){
	//This will call the myMethod() of parent class
	super.myMethod();
	System.out.println("Overriding method");
   }
   public static void main( String args[]) {
	Demo obj = new Demo();
	obj.myMethod();
   }
}
```



















