## Collection Framework

### Mange Unordered Lists with HashSet

> we described how to use Classes Such as  ArrayList & HashMap which allow you to mange ordered and unordered sets of data , this classes are parts of something called Collections Framework , a collection of classes that do different things with collections of data in your java applications , you can find documents about this classes at : [this site.](http://docs.oracle.com/javase/7/docs/technotes/guides/collections/index.html)

> there is an overview there , API specifications Tutorials there , and other docs avalable , all of this packages are the member of java.util , and they are all avalable in java core adk

> here we would start with theHashSet class , and then we would go on to something called the TreeSet , a collection that is defined as a Set is explicitly a collection of data where each object can only apear in the set Once . we are going to start with HashSetbecause its the highest performance , and the simplest of the Set implementation , example bellow :

```java
public static void main(String[] args) {
   Olive lig = new Ligurio();
   Olive kal = new Kalamata();
   Olive pic = new Pcholine();
   HashSet<Olive> set = new HashSet<>();
   set.add(lig);set.add(kal);
   System.out.println("There Are " + set.size() + " olives in the set."); // resut 2
   set.add(pic);
   System.out.println("There Are " + set.size() + " olives in the set."); // result 3
   // One thing about the set is you can not add a duplicate , it won't show an error , but whould be ignored
   set.add(lig);
   System.out.println("There Are " + set.size() + " olives in the set."); // still we get result 3
   set.add(null);
   System.out.println("There Are " + set.size() + " olives in the set."); // result 4 , but the 4 elemnt is null
   
   // every set also supports the .remove() and the iterate through the set
   set.remove(lig);
   System.out.println("There Are " + set.size() + " olives in the set."); // result 3
```

> the advantage of using the Set is in comparison to , lets say the tree set . Set is faster . but if you want to add your objects and be sure that each object is added one , the HashSet is Greate way to do it .

------

### TreeSet

> TreeSet has everything that HashSet has , but it also keeps everything in order that ou can then controle by implementing the Interface called Comparable in the class that you are storing .

```java
Olive lig = new Ligurio();
Olive kal = new Kalamata();
Olive pic = new Pcholine();
TreeSet<Olive> set = new TreeSet<>();
try {
   set.add(lig);
   set.add(kal);
   set.add(lig);
} catch(Exception e) {
   System.out.println(e.getMessage) // result is :  Picholine cannot be cast to java.lang.Comparable
} // if we run now we would get an error , and thats because object you add to the TreeSet are exprected to implement an Interface called Comparable 
```

> now to solve this problem we can add Comparable interface to every subclass of Olive , but as they all extends the Olive , we Implement this Comparable interface in the Olive class

```java
public class Olive implements Comparable<Olive> { inside <> says what type with would be compared
   @override // the method that Comparable interface needs to be declared
   public int compareTo(Olive o) {
      String s1 = this.getClass().getSimpleName();
      String s2 = o.getClass.getSimpleName();
      return s1.compareTo(s2);
   }
}
// in the main above . now when we print the TreeSet , the result would be ASC alphabetical . meaningits sorted
```

> so the comparison between the Two , is that HashSet is Faster but TreeSet is Sorted

------

### Linked List

> the befenit of LinkedList Compare to ArrayList  , is some functions it has , like for example you can enter an element in any index ( for example between two objects that are already added to LinkedList . or you can use the method  list.addFirst(new Ligurio()) and it would place it at the beginning of the LinkedList

```java
LinkedList<Olive> list = new LinkedList<>();
list.add(new Picholine());
list.add(new Kalamata());
list.add(new Golden());
// now using of some good functions of LinkedList
list.add(1,new Golder); // put the Goldern between Picholine and Kalamata; or
list..addFirst(new Ligurio()); // put Ligurio at the beginning of LinkedList

display(list); // its duty is two output the result

static private void display(Collection<Olive> col) {
   System.out.println("List order : ");
   Iterator<Olive> iterator = col.iterator();
   while(iterator.hasNext()) {
      Olive olive = (Olive)iterator.next();
      System.out.println(olive.oliveName.toString());
   }
}
```

------

------

# Collection Framework Advanced

> there is a set of interfaces that define different types of collections . at the very top of the hierarchy is `iterable`, all types of collections implement iterable , and it declares the `forEach` method , then there is the `Collection` interface which extends iterable , this interface declares all of the methods that every collection must have . For example `add`,`remove`,`isEmpty`,`toArray`, and so on .

![](F:\Programming Notes\Java\Java Advanced Training\assets\CollectionIterfaces.png)

**There Are Different Types of Data Structure as you can see Bellow :**

> **Sets**

- *Do not allow Duplicates*
- *They are also Unordered*
- *as Sets are unordered , when you iterate through them , the items would show up in a random way*

> **Lists**

- *Allow duplicate entries*
- *Order is Significant , meaning when you iterate they would return as they have been entered* 

> **Ques**

- *Allow you to add Elements To the Head of The Collection*
- *They use First-in First-out Operation*
- *They are exactly like a real life Que , where the first person to arrive , is the first person to be served*

> **Maps**

- *Maps Actually do not extend the Collection interface , this is because they contain key-value pairs , which are not suted to being elements in a Collection , however they are still considered to be  a part of the Collection FrameWork in Java*

------

## Using Linked List to Structore data

### what is a Linked List

> a Linked List is a doubly linked collection of elements , Each entry in the list also holds a reference to the address  of the next and the previous item in the list ,
>
> **The Main Advantage of using a linked list is that they are very quick for inserting and removing elements in the middle of a list .**

#### working with LinkedList

***NOTE : if we want to add an element in the middle or in between to elements we use***

```java
LinkedList<String> mylist = new LinkedList<>();
mylist.add("A");
mylist.add("B");
mylist.add(1,"C"); // adds C after the A , in the 1 position
System.out.println(mylist); // outPut : [A, C, B]
// you can remove an element with its name , just like :
mylist.remove("B"); // removes B from the LinkedList
```

#### difference Between `LinkedList` & `ArrayList`

> they are very much like each other , the exception is when we want to add a lot of elements in the middle of our list , the `LinkedList`would be very faster .
>
> but if we want to get the elements from our list , then the `ArrayList` would be mush faster for getting elements .

> For most cases if you want to choose between LinkedList & ArrayList , you should choose The `ArrayList`

------

## Queue with a LinkedList , The implementation

#### Queue Use Case

> if you want controlling access to shared resources use Queue , like CPU Schaduling or doing something like simulating planes waiting for landing instructions .

> :warning:**NOTE**​ In Bellow Example We have Overwritten The `toString()`method of the Customer Class , So that when we use `System.out.print()` for our queue which contains elements of this class , it would print out the names , not anything elese .

*In Customer Class we Have*

```java
public class Customer {
    private boolean hasBeenServed;
    private String name;

    public Customer(String name) {
        hasBeenServed = false;
        this.name = name;
    }

    public void serve() {
        hasBeenServed = true;
        System.out.println(name + " has been served");
    }

    @Override
    public String toString() {
        return name;
    }
}
```

:bell:**Attention :** *They are several classes in the Java Api that implement the `Queue` interface, One of these classes is `LinkedList`, wich we have used for this example .*

```java
public class Main {
    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        queue.add(new Customer("Arash"));
        queue.add(new Customer("Cimin"));
        queue.add(new Customer("Nazanin"));
        queue.add(new Customer("Cima"));
        System.out.println(queue);
    }
}
```

> next we want to create a method in here (Main method) , to serve a customer at our store , so we create a new static void method called `serveCustomer`, we want this to behave like a real customer being served in a real store . like when a customer has been served it should be removed from the Queue , and it should always be the first person who joins the Queue , that gets served first . The Queue interface lets us do this with a method calld `poll`

> `poll()` : the poll method returns the first element in the Queue , and also removes it

*so the complete version of the Main class is :* 

```java
public class Main {
    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        queue.add(new Customer("Arash"));
        queue.add(new Customer("Cimin"));
        queue.add(new Customer("Nazanin"));
        queue.add(new Customer("Cima"));
        System.out.println(queue); // shows all the names in the queue
        serveCustomer(queue); // serves a customer , which also removes it
        System.out.println(queue); // shows all names except the first one that is served
    }
    public static void serveCustomer(LinkedList<Customer> queue) {
        Customer c = queue.poll();
        c.serve();
    }
}
```

------

## HashMap , Storing pairs with HashMaps

> HashMaps are a common data structure used in java Programming ,  they allow you to store pairs of values Toghether . an example could be a `PhoneBook`where the name of the person is the key and his/her number is the value

- `add()`adds an element in `Lists` , but in `HashMaps` we use `put()`

:bulb:*in bellow example calling System.out.print(myHashMap) would not print the names and values , as we inserted them . instead it decides for itself , in which order it will print out the elements to the console , thats why HashMap is Unordered*

```java
public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> phoneBook = new HashMap<>();
        phoneBook.put("Kevin",12345);
        phoneBook.put("Jill",98765);
        phoneBook.put("Brenda",123123);
        System.out.println(phoneBook);
        // for me in my first try the result was 
        // {Kevin=12345, Brenda=123123, Jill=98765}
        // as you see not in the way we expected, (thats why its unordered)
    }
}
```

:bulb:*Another Feature of HashMap is that it does not allow duplicate Keys , if you do try something like bellow , the value would be replaced*

```java
phoneBook.put("Arash",12345);
phoneBook.put("Arash",11222); // now if you print , The Arash is 11222
```

:bulb:*Another Feature is : HashMap Does Allow Null For Its Key , like :*

```java
phoneBook.put(null,00000);
```



- check if a key exists in a HashMap with `hashMap.contains("yourKeyName")`
- remove an element by using `hashmap.remove("yourKeyname")`
- Clear all HashMap elements with `clear()`like `hashMap.clear()`

-----

## LinkedHashMap , The Implementation

> We know in a HashMap there is no garante that would get the elements back in the same way we put them in , however with the use of Linked HashMap the order of the entries is retained . an Example is Bellow :arrow_double_down:

#### Iterate Through A HashMap with Map.Entry & mymap.entrySet

```java
public class Main {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> phoneBook = new LinkedHashMap<>();
        phoneBook.put("Arash",125487);
        phoneBook.put("Cimin",787777);
        phoneBook.put("Arman",11111);
        phoneBook.put("Nazanin",9125);
        for (Map.Entry<String,Integer> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    } // the order is as we expect and put them in , from Arash to Nazanin
}
```

> :warning:With Linked HashMap you can specify , if you want the elements to be retrieved , in the `order they where added` , or in the `order that they have been accessed` in . to choose between these Two options we have to alter its Constructor , in our example in the first line , where we hadn't add any element to our map yet .

:bulb:*The Different Type Of It's Constructors , pay attention that these are only for LinkedHashMap*

- *The First Argument is the capacity of the HashMap*

```java
LinkedHashMap<String,Integer> phoneBook = new LinkedHashMap<>(4)
```

- The Second Argument is Called the Load Factor , & Specifies How full the map can be before it is made bigger .

```java
LinkedHashMap<String,Integer> phoneBook = new LinkedHashMap<>(4,0.75f);
// we used 0.75f ( Which is the default value )
// it means when the map is 75% Full , it will increase its size.
// in this case , where the capacity is 4 , so when there are 3 elements in // the map i.e. it is 75% full , the map will get bigger .
```

- The Third one is a Boolean value , wich determines the ordering value . if it is false , or if it is not specified , it will use the insertion order

```java
LinkedHashMap<String,Integer> phoneBook = new LinkedHashMap<>(4,0.75f,true);
// now it will use access order first .
phoneBook.put("Kevin",12345);
phoneBook.put("Jill",98765);
phoneBook.put("Arash",23435);
phoneBook.put("Cimin",254871);
System.out.println("Kevin's number is : " + phoneBook.get("Kevin"));
// now we print out the whole LinkedHashMap , can you guess the order ?
(Map.Entry<String,Integer> entry : phoneBook.entrySet()) {
    System.out.println(entry.getKey() + " : " + entry.getValue());
}
// now the output prints Kevin at the last ( Bottom of the print list );
```

> This order is because we accessed `Kevin`The Most recently .
>
> **So The entry that was modified the longest time ago is at the top , and the most recent at the bottom**
>
> **LinkedHashMap different From normal HashMap , in that they keep track of the order of the entries . **
>
> **ey are also flexible in which you can determin the order by input , or order by access .**

