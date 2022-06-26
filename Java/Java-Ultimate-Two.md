## Programming Paradigms

![image-20210109153408331](D:\Programming Notes\Java\Java-Ultimate-Two.assets\image-20210109153408331.png)

## OOP Benefits

![image-20210110021455572](D:\Programming Notes\Java\Java-Ultimate-Two.assets\image-20210110021455572.png)

# Clean Code

## What Does Refactoring Means ?

> `Refactoring` Means Changing the structure of our code , without changing it's behaviour .

#### A Note :memo:

> Ideally `a method should be` between `5` to `10` lines of code . if your method (Function) has more than this , it is not standard , use refactoring if possible .

--------------------------

## Encapsulation

> thus `encapsulation` means -> extracting the __Values__ and The __Methods__ that *Operate on that values* , in a Single Class .

## Abstraction

> `Abstraction` means __Reduce complexity by hiding unnecessary details__

## Static Members

> we use `static members` , when a value is for the class itself , it is not neccessarily relevent to the Object of that class , for example in an employee class , *theNumberOfEmployees* could be a
>
> ```java
> public class Employee {
>     public static int numberOfEmployees;
>     public int salary;
>     public int extraHour;
>     public int calculateSalary() {
>         return salary + (folan * extraHour);
>     }
> }
> // and in the Main class we have for example
> public class Main {
>     public static void main(String[] args) {
>         Employee.numberOfEmployees = 10;
>         // and so on ....
>     }
> }
> ```
>
> 

> a `class` can have `two` types of `members` .
>
> - Instance Members (Belong to the Instance (Object) of The Class)
>
> - Static Members (The Fields or Methods that belongs to the Class itself)
>
> __we use them to represent a concept that should only be in a single place__
>
> __we use them when the value is independent of the objects__

## Refactoring Object-Oriented

> NOTE :memo: *In The Cases Where You Wanted To Refactor A Function From A Class To Another New Class* , just move on it , then from the `Refactor` menu -> Refactor This -> Move Members , and then type you will see that the source is filled with the name of your package and the class name , in the target write the same (With The Desired Class You Want) . and then hit OK .