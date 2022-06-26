# Generics In Java

> Generics are a way to tell the compiler what type of Objects a Collection can Contain .

***An Example***

```java
List names = new ArrayList(); // without Generics
List<String> namesTwo = new ArrayList(); // with Generics
names.add("Arash");
namesTwo.add("Arash");
```

<!--You Should Use The Generic Type , as It Claryfies The Type-->

> Generic Types in java are methods that allow you to create a new Type parameter just for that method , this is usefull if you are writing a method but want to be Flexible about the type of objects you can pass in , an Example is Bellow :

```java
public class GenericMethods {
    static Charachter[] charArray = {'h','e','l','l','0'};
    static Integer[] intArray = {1,2,3,4,5};
    static Boolean[] boolArray = {true,false,true,true};
    
    public static <T> List<T> arrayToList(T[] array,List<T> list) {
        for(T object : array) {
            list.add(object);
        }
        return list;
    }
    
    public static void main(String[] args) {
        List<Charachter> charList = arrayToList(charArray,new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray,new ArrayList<>());
        List<Integer> intList = arrayToList(intArray,new ArrayList<>());
    }
}
```

> So the key Here is Using `T` , then we define a Genericly Typed function like :

```java
public <T> List<T> myFunction(List<T> list,T[] array)
```

-----

## Using Varargs in Java

> somethimes we might want to right a method that takes a variable number of argumets , in java there is a feature called `Variable-length arguments` or `Varargs`for short . wich allows to do this

- > *We can Create a Methods that Takes an `Array` , or We Can use `Varargs` to take a numbers of arguments , using three dot (...) is the key for this*

```java
private static void printShoppingList(String... items) {
    for(int i=0;i<items.length;i++) {
        System.out.println(items.get(i));
    }
}
//we can use it with one,two,three ... or more , or we can use it even without argumens
printShoppingList("arash","samandar","aghashahee","sheerdel","khalajee")
```

------

## The Substitution Principle in Java

> is an important concept in object oriented programming , because it allows you to make maintanable and reusable codes , it is actually very simple .
>
> it just means : that if you have a variable of a given type , you can assign it to the value that is sub-type of that type .

*In bellow example we have Two Classes wich one is a subtype of the other*

```java
class Building {
    @override
    public String toString() {
        return("building");
    }
}
//---------------------------------------------------
class Office extends Building {
    @override
    public String toString() {
        return("office");
    }
}

// in the main method we have-----------------------------------

public static void main(String[] args) {
    Building building = new Building();
    Office office = new Office();
    build(building); // works
    build(office); // works
    
    List<Office> offices = new ArrayList();
    offinces.add(new Office());offices.add(new Office());
    printBuildings(offices); // it would not work . the varargs dosn't work for Lists
}
static void build(Building building) {
    System.out.println("Constructing a new : " + building.toString());
}
static void printBuildings(List<Building> buildings) {
    for(int i=0;i<buildings.length;i++) {
        System.out.println(i + 1 + " " + buildings.get(i).toString());
    }
}
```

> so the note is `Varargs`doesn't work for List items , **BUT** : we can change it with `Wildcards`

-----

## Using WildCards In Generic Programming

> wildcard in java can be usefull in different situations , a `wildcard is` essentially an `Unkown type`and can give you more flexibility when writing methods .

*Lets Take a Look at This Example*

**Building Class**

```java
class Building {
    public int numberOfRooms = 7;
    @override
    public String toString() {
        return ("building");
    }
    
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
```

**Office Class**

```java
class Office extends Building {
    @override
    public String toString() {
        return ("office");
    }
}
```

**House Class**

```java
public class House extends Building {
    public int numberOfRooms = 10;
    @override
    public String toString() {
        return ("house");
    }
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
```

> And Here We Go with the Main Class

```java
public static void main(String[] args) {
    List<Building> buildings = new ArrayList();
    buildings.add(new Building());buildings.add(new Building());
    printBuildings(buildings);
    
    // List of Office
    List<Office> offices = new ArrayList();
    offices.add(new Office());offices.add(new Office());
    printBuildings(offices); // works with magic List<? extends Building>
    
    // List of House
    List<House> houses = new ArrayList();
    houses.add(new House());houses.add(new House());
    printBuildings(houses); // works with magic List<? extends Building>
    
    addHouseToList(houses);
    addHouseToList(buildings); // works with magic List<? super Building>
}
public static void printBuildings(List<? extends Building> buildings) {
    for(int i=0;i<buildings.length;i++) {
        System.out.println(buildings.get(i).toString() + " " + (i + 1));
    }
    System.out.println();
}
public static void addHouseToList(List<? super House> buildings) {
    buildings.add(new House());
    System.out.println();
}
```

- *A Note On `WildCards`, Actually it works very simply , for Arguments we have :*

```java
public void myFunc(List<? super House> buildings) // meaning every class that House is its subClass class can be used
public void myFunc(List<? extends Building> buildigs) // meaning every class that extends the Building class can be used
```

