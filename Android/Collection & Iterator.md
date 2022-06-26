# Collection & Iterator

> An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework. Iterators differ from enumerations in two ways:

- Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
- Method names have been improved.
## Example
```java
public String buffer = "";
List<String> myList = new ArrayList<>();
Collections.addAll(myList,"arash","samandar","newsha","armash","karmash");


Iterator iterator = myList.Iterator();
while(iterator.hasNext()) {
   buffer += iterator.next()
}

// or

for(Iterator<String> iterator = myList.iterator():iterator.hasNext();) {
   // do whatever
}
```

You Can Also Use For
```java
for(String i : list) {
   if(i = "samandar") {
       list.remove(i);
   }
}
```


---
## Define And Using HashMap

HashMap
Java HashMap is HashTable based implementation of Map

- HashMap is unsynchronized while HashTable is synchronized.
- HashMap permits null while HashTable doesn’t.

> Defining the Hashmap
```java
public Map<String,int> mymap = new HashMap<String,int>();
mymap.put("some",2);
mymap.get("some");
```

### Iterate through HashMap
The Easy Way Is To Use A For Loop
```java
public Map<String,String> mymap = new HashMap<String,String>();
for(Map.Entry<String,String> entry : mymap.entrySet()) {
   String key = entry.getKey();
   String value = entry.getValue();
}
```


```java
public Map<String,String> mymap = new HashMap<String,String>();
Iterator iterator = mymap.entrySet().iterator();
while(iterator.hasNext()) {
   Map.Entry pair = (Map.Entry)iterator.next();
   String value = pair.getKey() + " " + pair.getValue();
   iterator.remove();
}
```


---

# Set

> some characteristics of `set`
- Set is an interface which extends Collection. It is an unordered collection of objects in which duplicate values cannot be stored.
- Basically, `Set` is `implemented` by `HashSet`, `LinkedHashSet` or `TreeSet` (sorted representation).
- Set has various methods to add, remove clear, size, etc to enhance the usage of this interface

Example of HashSet
```java
public Set<String> myset = new HashSet<>();
public String buffer = "";
Collections.addAll(myset,"arash","morteza","milad","amir");
Iterator iterator = myset.iterator();
while(iterator.hasNext()) {
   buffer += " " + iterator.next();
}
```

### TreeSet
- **TreeSet implements the SortedSet interface so duplicate values are not allowed.**
- **Objects in a TreeSet are stored in a sorted and ascending order.**

Example of TreeSet
```java
String buffer = "";
TreeSet<String> mytree = new TreeSet<>();
Collections.addAll(mytree,"a","b","c","p","d","q","m","e","f","g");
// the best option of TreeSet is that it is sorted
Iterator iterator = mytree.iterator();
while(iterator.hasNext()) {
    buffer += "," + iterator.next();
}
showResult.setText(buffer);
```

### we also have TreeMap

---

# Thread and MultiThreading 

**IMPORTANT : this is an important concept in java , make sure you visit and read bellow address :**
https://www.wideskills.com/java-tutorial/java-threads-tutorial


---

## JAVA Enum

> Enumerations are the most elegant way to define and use constants in your application.

### why you should care ?
> Well, you use enums in your Java code. If you don’t then you do something wrong or have very simple applications without much complex functionality.

- **Every enum constant is always implicitly** `public static final`.

Example
```java
public enum GO {
   RED,GREED,YELLOW
}
```

> Java enums are more powerful than C/C++ enums . In Java, we can also add variables, methods and constructors to it. The main objective of enum is to define our own data types



### `values()`, `ordinal()` and `valueOf()` methods :

- `values()` method can be used to return all values present inside enum ( for example return to a
- `ordinal()` Order is important in enums.By using ordinal() method, each enum constant index can be found, just like array index.
- `valueOf()` method returns the enum constant of the specified string value, if exists.

AN EXAMPLE FOR ANDROID
```java
//defining enum
public enum Fruits {

    ORANGE("ORANGE"),APPLE("BROWN"),BANANA("YELLOW"),MELLON("GREEN")
    ,ASTRRAWBARRY("REDISH"),CHERRY("RED"),GRAPES("PURPULE");

    public String color;

    Fruits(String fruiteColor) {
        this.color = fruiteColor;
    }

    public String getFruitColor() {
        return this.color;
    }
}
```

Using Enum in an android App with A button That Gets Input ( fuite name ) from EditText
```java
public class MainActivity extends AppCompatActivity{

    TextView fruitNames;
    TextView fruitColors;
    EditText fruitname;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    public void initializeViews() {
        fruitNames = findViewById(R.id.fruitnames);
        fruitColors = findViewById(R.id.fruitcolors);
        fruitname = findViewById(R.id.fruitname);
    }

    public void ButtonClick(View view) {
        fruitNameString = fruitname.getText().toString();
        Fruits fr = Fruits.valueOf(fruitNameString.toUpperCase());
        fruitNames.setText(fr.toString());
        fruitColors.setText(fr.getFruitColor());
        switch (fr) {
            case APPLE:fruitNames.setText("THIS IS AN APPLE");break;
            case BANANA:fruitNames.setText("THIS IS A BANANA");break;
            // and so on
            default:fruitNames.setText("FRUITE DOES NOT EXIST");
        }
    }

}
```

**NOTE :** bellow examples **may not be for android.**
Example Of Using
```java
enum Day 
{ 
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, 
    THURSDAY, FRIDAY, SATURDAY; 
} 

public class Test 
{ 
    Day day; 
  
    public Test(Day day) 
    { 
        this.day = day; 
    } 
  
    public void dayIsLike() 
    { 
        switch (day) 
        { 
        case MONDAY: 
            System.out.println("Mondays are good."); 
            break; 
        case FRIDAY: 
            System.out.println("Fridays are better."); 
            break; 
        case SATURDAY: 
        case SUNDAY: 
            System.out.println("Weekends are best."); 
            break; 
        default: 
            System.out.println("Midweek days are so-so."); 
            break; 
        } 
    } 
    public static void main(String[] args) 
    { 
        String str = "MONDAY"; 
        Test t1 = new Test(Day.valueOf(str)); 
        t1.dayIsLike(); 
    } 
} 
```

Example of using this functions
```java
enum Color 
{ 
    RED, GREEN, BLUE; 
} 
  
public class Test 
{ 
    public static void main(String[] args) 
    { 
        Color arr[] = Color.values(); 

        for (Color col : arr) 
        { 
            System.out.println(col + " at index " + col.ordinal()); 
        } 
        System.out.println(Color.valueOf("RED")); 
        
    } 
} 
```

### Enum with Customized Value in Java
> By default enums have their own string values, we can also assign some custom values to enums.

```java
enum  Fruits
{
    APPLE(“RED”), BANANA(“YELLOW”), GRAPES(“GREEN”);
}
```

> to use customized value and use ( get ) it in enum, we have to do Two things
- We have to create parameterized constructor for this enum class.
- We have to create one getter method to get the value of enums.
```java
enum TrafficSignal 
{ 
    RED("STOP"), GREEN("GO"), ORANGE("SLOW DOWN"); 
    
    private String action; 

    public String getAction() 
    { 
        return this.action; 
    } 

    private TrafficSignal(String action) 
    { 
        this.action = action; 
    } 
} 
  
public class EnumConstructorExample 
{ 
    public static void main(String args[]) 
    { 
        TrafficSignal[] signals = TrafficSignal.values(); 
  
        for (TrafficSignal signal : signals) 
        { 
            System.out.println("name : " + signal.name() +  " action: " + signal.getAction() ); 
        } 
    } 
} 
```



















