# Static code block & inner Classes , Reflection A

### java 7 Feature in working with numbers

> in java 7 and above , we can use (_) underScore , in a number , like 10_000_000 for any number , you can also use NumberFormater , to geet number with comma between them in console , like

```java
int myNumber = 10_000_000;
NumberFormater numberformater = NumberFormater.getInstance();
System.out.println(numberformater.formate(myNumber)); // the result is 10,000,000
```

> another java 7 new feature is you can use String in switch .

```java
switch(o.oliveName(0)) {
   case "Kalamata":System.out.println("Kalamata");break;
   //.....
}
```

-------

### using static block

> how to use static block to initialize variables when we instantiate the class

```java
public class Olives {
   private String name;
   private String sound;
   private long color;
   public Olives(String name,String sound,long color) {
      this.name = name;
      this.sound = sound;
      this.color = color
   }
}
// now to use static block and build a bunch of Olives when The OliveJar is Instantiated we have :
public class OliveJar {
   public static ArrayList<Olives> olives;
   static {
        olives = new ArrayList<Olives>();
        olives.add(new Olive("Kalamata",0x0000,"ouch"));
        olives.add(new Olive("Penagole",0xF0000,"ookh"));
        olives.add(new Olive("Picholine",0xF0000,"ooy"));
   }
}
// and now in the Main class , all we need to do to instantiate is
public static void main(String[] args) {
   ArrayList<Olives> olives = OliveJar.olives // thats all you need to do , so now we have instantiated all in static block
   for(Olives o:olives) {
      System.out.println(o.getName() + o.getSound() + o.getColor()); // and returns all in static block ;
   }
}
```

-------

### Using Instance Filed Initializer

> we use just a block {} for this porpuse , **note :** rememeber the code in the block would be initialized before the constructor

```java
public class OliveJar {
    public ArrayList<Olive> olives; // this is not static any more
     { // beginning of the block
        System.out.println("Initializing Static Block");
        olives = new ArrayList<Olive>();
        olives.add(new Olive("arash",2222,"ooch"));
        olives.add(new Olive("arash",2222,"ooch"));
        olives.add(new Olive("arash",2222,"ooch"));
    } // end of the block
    public OliveJar() {
        System.out.println("Constructor work in progress");
    }
}
// now in the main method we write :
public ArrayList<Olive> olives = new OliveJar().olives;
```

> **Question :** why don't we just put it in the constructor ??

> **Answer** is because we may have different constructors . but this code would run no matter wich constructor is called .

> so again an initializer code block for an instance field , is a way of executing code , before the constructor method is callled . and its especially handy when a class has more than one constuctor method , but we have a certain kind of code that we want to execute , no matter which constructor ir called .

-------

### Using Member Classes

> Member class is basically when you define a class within another class ( this is a form of encapsulation ) . for example if Olive class is inside OliveJar class , every class that wants to access Olive class , has to go through OliveJar class to access it , and in addition , the only way to add the Olive to OliveJar , is through a method of OliveJar class . in bellow example we decide that only OliveJar would use Olive class in entire program , so ofcource we define it as an inner class of OliveJar

```java
public class OliveJar {
    public ArrayList<Olive> olives;
     {
        System.out.println("Initializing Static Block");
        olives = new ArrayList<Olive>();
        olives.add(new Olive("arash",2222,"ooch"));
        olives.add(new Olive("arash",2222,"ooch"));
        olives.add(new Olive("arash",2222,"ooch"));
    }
    public OliveJar() {
        System.out.println("Constructor work in progress");
    }
    // as Olive is now an inner class of OliveJar , we have to Define Some Methods to access it
    public void addOlive(String oliveName,String Olivesound,long Olivecolor) {
       olives.add(new Olive(oliveName,Olivesound,Olivecolor);
    }
    // Olive is define as an inner class in here
    class Olive {
    private String name;
    private long color;
    private String sound;

    public Olive(String name,long color,String sound) {
        this.name = name;
        this.color = color;
        this.sound = sound;
    }
}
// an thus in the main method to add Olive we have
public static void(String[] args) {
  OliveJar jar = new OliveJar();
  jar.addOlive("Kalamata","Ouch",0xFDF00);
}
```

------

### Using Local Inner Classes

> Local Inner Class : is basically a class that is defined in a function , an example would be bellow ,it is way of defining complex functionality but keep it hidden from the rest of the application

```java
// in the olive jar class we create a function for reporting the Olives the class , but before reporting starts we want to open JarLid  :
// so inside the OliveJar the one that also has the Olive class as it's Member class we have a function named :
public void reportOlives() {
   class JarLid {
      public void open() {
         System.out.println("JarLid is Opened");
      }
   }
   new JarLid().open();
   for(Olive o : olives) {
      System.out.println(o.getName());
   }
} 
```

------

### Anonymous Inner Classes

> Anonymous inner Class is even better , we difine it with a constructor . and then we can attach its method , just like bellow 

```java
// we are in OliveJar class wich has a Member class named Olive , and we are going to define an anonymous inner class
public void reportOlives() {
   new Object() {
      public void open() {
         System.out.println("this is an anonymous class");
         System.out.println("something functions you want");
      }
   }.open()
   for(Olive o : olives) {
      System.out.println(o.getName());
   }
} 
```

------



# Using The Reflection API

### Using Class Class

> Class Class gives us information about our class and much more , and example of how to use it is bellow :

```java
Olive o = new Olive();
Class<?> c = o.getClass(); // we use ? in the <> diamond operator , when we don't know the name of the class
System.out.println(c); // returns the class with its whole package
System.out.println(c.getName()); // return the class name which is at the end of the package
System.out.println(c.getSimpleName()); // returns only the name of your class
```

-------

### Instantiating Classes Dynamically

> by using Constructor<> we have :

```java
Olive o = new Olive(); // wich has only one constructor
Constructor<?>[] constructors = o.getConstructors() // this class only has one constructor
System.out.println("Number of Constructors : " + constructors.length); // return 1 
// now making an Object out of this constructor with
Constructor<?> con = constructor[0];
Object obj = null;
try {
   obj = con.newInstance("oliveName","olivesound",0x000F);
} catch(Exception e) {
   System.out.println(e.getMessage);
}
```

------



### Walking in Inheritance Three with Reflection API

```java
Object obj = new Olive();
Class<?> c = obj.getClass();
System.out.println("Class Name Is : " + c.getSimpleName());
Class<?> sup = c.getSuperClass();
System.out.println("Super name : " + supe.getSimpleName());
Class<?> topName = sup.getSuperClass();
System.out.println("Super name : " + supe.getSimpleName());
// getting the class Packages
Package p = c.getPackage();
System.out.println("Package : " + p.getName());
```

------

### Peaking and Polling With Queue Interface

> every class that has the Queue interface , has some functions , for example pick() and pull() , pick() returns the obejcts but dosn't delete it , wearas pull() in addition to return the Object , deletes it too , example :

```java
// for example in above example after display() functions we can call
Olive o1 = list.pick();
display(); // first displays the first object , in this case Ligurio , and then displays all of the objects in list .
// now using pull();
Olive o2 = list.pull(); // returns the first object and also deletes it
display() // show all except the first Object that is pulled from the list
```






