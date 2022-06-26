# Up & Running With Java

### Java Garbage Collection

> NOTE : in java there is no need to remove an Object you don't use , because java has a feature called Garbag Collection . so There is no need to remove unreferenced objects because there is Automatic Garbage Collection in java.

----

### How To Create A Java Class

- > the name of your file must be exactly the name of your Top class , begins with Uppercase letter

- > every java program must only have one main method

- > create your file in a folder (the name of the project) and this way the folders in it would be mentions in package name , like bellow , also name the folder in a correct manner , best example , the name of the project , or main class , and rememeber Package must be all lowerCase

```java
package arash.samandar; // we are in the project folder (HelloWorld) in the folder samandar which is the sub directory of arash
```

-------------

### working with numbers

> Remember that if you want to get an exact number . when you devide two integer number . like 4/3 the value would be wrong and an integer .

> to get it currectly use 4/3.0 , meaning , let the program know that you want the exact number

----

### Working With Random Class

```java
package main; // program is in a folder named main
import java.util.Random;
public class My {
   public static void main(String[] args) {
      int diceOne,diceTwo;
      Random rand = new Random();
      for(int i=0;i<100;i++) {
         diceOne = rand.nextInt(6) + 1; // cause it start from 0
         diceTwo = rand.nextInt(6) + 1;
      }
   }
}
```

----

### Pass By Reference & By Value

> **NOTE : in java** **Arrays** **always are a pass by** **reference** **like bellow :**

```java
public double manipulateTheArray(double[] value) {
    value[0] = 12.11; // the value[0] would be changed even outside of this function
}
```

> **NOTE : General rule of thumb : primitive data types are call by value , and variable such as arrays and objects are call by reference . ( this is in java ofcource )**

----

### Using Scanner Class

> Scanner in java is used to read and write from the console , like bellow :

```java
Scanner in = new Scanner(System.in);
System.out.println("type your number : ");
int value = in.nextInt();
System.out.println("your number was : " + String.valueOf(value));
```

----

### Array & ArrayList

> **NOTE :** Arrays can only store primitive data types , thats why we use ArrayList for storing Objects . because we can't use Array for them , another benefit of the ArrayList is that the size can be increased and decreased . we can also add different types of objects or primitives to an arraylist .

```java
import java.util.ArrayList;
public ArrayList<String> myStrings = new ArrayList<String>();
```

> some of ArrayList Functions ( methods )

- `.add` for adding new element to ArrayList .

- `.remove` for removing an element .

- `.set` for changing an element .

- `.get` for getting an element .

- > you will use `index` number for any of these , like `arrlist.remove(1)`;

----

## Working With File

> Best Practice is to Create the File in your build folder , and just write the name of the file , or write the whole Address Of the File

```java
File file = new File("myText.txt");
```

> you need File and Scanner to read from it , a Veryyy Goood example is bellow :

```java
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        File myfile = new File("D:\\mytext.txt");
        ArrayList<String> answers = new ArrayList<String>();
        try {
            Scanner in = new Scanner(myfile);
            String line;
            while(in.hasNextLine()) {
                line = in.nextLine();
                answers.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        Random random = new Random();
        System.out.println(answers.get(random.nextInt(5))); // look how beautiful it is
    }
}
```

### Always Use Try Catch

> **NOTE** : Always use try catch to avoid unwanted terminate of application with some unknown errors . both in java and android . instead you can catch the Exception e and show its message , so you can fix it this way

```java
try {
   int n = 0;
   double answer = (4 + 5) / n;
   System.out.println(answer);
} catch(Exception e) {
   System.out.println(e.toString()); // would print a very nice error , can not devide by zero
}
```

----

### Write To A File

> Remember : you should close When your Operation is Done . otherwise outPut file Would be Empty ,

> For creating an output file you need first as `route` ( meaning defining the file ) . Second you need a `PrintWrite` 

```java
package main;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File menuItems = new File("D:\\menuItems.txt");
        File menuPrices = new File("D:\\menuPrices.txt"); // this file doesn't exist but it would be created as it is an output file for us .
        String menuItem;
        double price;
        try {
            Scanner input = new Scanner(menuItems);
            PrintWriter output = new PrintWriter(menuPrices); // create the write to write that file
            Scanner in = new Scanner(System.in); // to read from command line
            while(input.hasNextLine()) {
                menuItem = input.nextLine(); // read line by line from the menuItems.txt
                System.out.println("what is the price of this : " + menuItem);
                price = in.nextDouble(); 
                in.nextLine(); // just added to put the cursor to the next line
                output.print(menuItem); // write one line that is red by input.nextLine()
                output.print("\t"); // write a tab
                output.println(price); // print and go to the next line
            }
            output.close(); // create and close the file
        } catch (FileNotFoundException e) {
            System.out.println(e.toString()); // show if any error exists
        }
    }
}
```

----

### JAR File

*Watch this and you don't need to read this chapter :*[D:\Education\Lynda\Java & More With It\Lynda-Java.Essential.Training.for.Students.2015[www.fileniko.com]\024 Creating and importing JAR files.mp4]()

> **NOTE :** J.A.R is refered to as a jar file , and a jar and jar file stands for java Archive , it is commonly used to combine several classes into a Compressed zip file, jar files are preneeded, eather using  the utility , jar.exe , thats provided in the java JDK , or you can create your jar file in the IDE , we will see creating the jar file in the command line and in the IDE

#### Command Line Version

> before creating the jar file we need to get all are classes and manifest into one directory

> To make the jar file runable , you need a manifest file that specifies wich class contains the main method .

> here is how you create a manifest file and tell it wich class has the main file , for example :

```mariadb
// NOTE : it should be exactly the same . and must have a empty line 2
// so in this manifest.txt file we have for example :
Main-Class: Geometry
```

> The Command in cmd to create a jar file ( for you folder with a lot of .class files and a manifes.txt)

```mariadb
after pointing to the right folder ( where you .class file and manifest are in , write: )
C:\myJava\Geometry>jar cvfm MyGeometry.jar manifest.txt *.class
```

----

## Make a Java UI , or GUI App

*Watch This*[D:\Education\Lynda\Java & More With It\Java-tutorials_Up-Running-Java_18445\048 Frames, events, and event handling.mp4]()

*Watch This if you want to be able to run your file anywhere by simply a click :*[https://www.youtube.com/watch?v=LFP0hG0U9tE]()

## Date & FormatDate

```java
Date date = new Date();
DateFormat dateformat = new SimpleDateFormat("mm/dd/yyyy");
System.out.println(dateformat.format(date));
// or
Date dateOne = new Date();
DateFormat dateformate2 = DateFormat.getInstance(DateFormat.LONG,Local.France);
System.out.println(dateformate2.format(dateOne);
```

## interface

- Contract between a class and the outside world
- a class **implements** an interface
- the class provides the behavior included in the interface
- **interface can also store constants**

## Comparing Objects With Comparable Interface

> for this porpuse you have to @override the compareTo method . like for example think that we have two Objects of type Address

> **NOTE :** Inside The Address Class we Override the CompareTo() method Just like bellow , so we can compare this Address class **to** Another Address Class , by its Zipcode

```java
// inside object Address we override the CompareTo() , as mention above .
@override
pubic int compareTo(Object a) {
   Address addr = (Address)a;
   // now compare this object zip with the object passed as Object a in the Argument of this class method
   int zip1 = Integer.parseInt(this.zipcode); // zip code of this class itself
   int zip2 = Integer.parseInte(addr.zipcode); // zip code of the passed Object to this class's Compare method
   if(zip1 < zip2)
      return -1; // they are different
   else if(zip1 > zip2)
      return 1; // they are different
   else
      return 0 ; // they are the same ( as of there zip ofcource )
}
```

> **NOTE : so Remember if you want to Compare your Object , you have to impelement the CompareTo .**

## abstract class

- include the keyword abstract in the class header , like public abstract class Example
- May or may not include abstract methods
- cannot be instantiated
- Abstract methods only contain the method header , without implementation

*subclasses ( or inherits from an abstract class )*

- > Must provide method implementation , unless the suclass is also declared as abstract

*abstract class is very similar to interface*

- > cannot be instantiated

**an example of abstract class**

```java
public abstract class Shape {
   private String shapeName;
   private double area;
   
   public Shape() {
      shapeName = "generic shape";
   }
   public Shape(String shapeName) {
      this.shapeName = shapeName;
      area = 0;
   }
   public Shape(String name,double area) {
      this.shapeName = name;
      this.area = area;
   }
   public String getShapeName() {
      return shapeName;
   }
   public abstract double calculateArea();
}
```

> Once Again Remember You can Not Instantiate An Abstract Class , you can only Extend it .

> any subclass that extends this class Must Impelment the calculateArea()



### Use an abstract class if you ...

- Want to share Code
- Expect to have Common methods of fields
- Require access modifier other than public
- want to declare non-static or non-final fields

### Use an interface if you ...

- Expect unrelated classes to use your interface
- Want to specify the behavior of a data type
- Want to take advantage of multiple inheritance

## Polymorphism

> polymorphism is simply when a class overwrites the funtion of its supper class , for example a supperClass of Animal , when you define three types of animal , you overwrite the speak method of Animal , because each animal has specific sound




