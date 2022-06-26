# Testing and Advanced Exception Handling



### Using The Assert Keyword

> Notice : Assert is a keyword or Command , so you don't wrap it in parantesis. what Assert does , it that checks if the argument input is correct or not ( very usefull )

> **NOTE :** in IntelliJ Idea , before you use assertion go to run -> debug... -> edit Configuration... -> in the VM Options -> add -ea , and we put assertion keyword before the function that we defined bellow . 

> **Notice :** it is a good way to get unvalid input

```java
// how to use it
public static void main(String[] args) {
        assert true; // create first in here and assign true to it
        Scanner in = new Scanner(System.in);
        System.out.print("Type Your First Number : ");
        String  s1 = in.next();
        assert checkInput(s1); // you the function we wrote at the end of this file
        System.out.print("What Operation Do You Want : ");
        String op = in.next();
        System.out.print("Type Your Second Number : ");
        String s2 = in.next();
        assert checkInput(s2); // you the function we wrote at the end of this file to check if the input is an integer and correct ( it is the best way to get the error without making the program crash

        if(op.equals("+")) {
            System.out.println("sum is : " + (Integer.valueOf(s1) + Integer.valueOf(s2)));
        } else if(op.equals("-")) {
            System.out.println("subtraction is : " + (Integer.valueOf(s1) - Integer.valueOf(s2)));
        }
    }
    public static boolean checkInput(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
```

----

### Using The Finally Keyword

> use finally in try catch when there is a bit of code , that you want to be executed , even if try fails . like bellow that we open a stream and file , so whether the code works or not , we have to close them at the end , even if it didn't work

```java
try {
   FileReader fr = new FileReader("myText.tx"); // notice file name ( location )is wrong
   BufferdReader br = new BufferedReader(fr)
   String s;
   while(s = (br.readLine()) != null) {
      System.out.println(s):
   } catch(FileNotFoundException e) {
     // TODO: handle exceptio
   } finally {
      
   }
}
```

----

### Peacking and Polling With Queues

> **<u>Question</u> : how to get an element from the list and assign it to an Object :**

> **<u>Answer</u> :** to pick() and object from the list and assign it to an Object , to pull() object from a class ( also removes it from the list ) , the difference is pick() just pick the object and assign it , whereas the pull() would assing the Object and also remove the object from thelist



```java
LinkedList<Olive> list = new LinkedList<>();
display(list) // that we have write before shows the order of the queue of the objects in the list
Olive o1 = list.pick() // or list.pickFirst();
System.out.println(o.toString());
display(list); // all of the obects are still in the list
Olive o2 = list.pull(); // the head of the list would be removed and returned to o2 we can also use.pullFirst() or .pullLast()
display(list); // now one of them is removed
```



------

### Test-Driven Development with Assert Keyword



> assert is a way of testing a condition in your code , for example : lets say you are going to pass a value into your method , and you want to make sure that value passed a certian condition before you send it in . you could `assert` that condition



> **NOTE** : you can't rely on `assert` for real functionallity in your application, it is merely for Testing when you are coding



> **Notice** :  assert keyword is merely for testing your application , when debugging if the compiler sees `assert = false` it would imediately throw exception and terminate . thats why we used `assert` in above examples in function like bellow , and **Rememeber** : you should add -ea to variable ( like described above in assertion section )



```java
public boolean checkInput(String s1) {
    try {
        Integer.parsInt(s1);
        return true;
    } catch (Exception e) {
        return false;
    }
}

Scanner in = Scanner(System.in);
String s1 = in.next();
assert = checkInput(s1);
```

----

### Defining and Throwing Custom Exception

> Defining a `Custom Exception` class :

```java
public class WrongFileException extends Exception {
    public static final long serialVersionUID = 42L;
    @override
    public String getMessage() {
        return "you chosed the wrong message...";
    }
}
```

> Now use it with Throw

```java
try {
    if(fileContents.equals("Right File")) {
        System.out.println("You Chosed The Right File");
    } else {
        throw(new WrongFileException);
    }
} catch(WrongFileException e) {
    System.out.println(e.getMessage);
}
```



# Advanced Exception Handling

> assert is a way of testing a condition in your code , for example : lets say you are going to pass a value into your method , and you want to make sure that value passed a certian condition before you send it in . you could `assert` that condition

> **NOTE** : you can't rely on `assert` for real functionallity in your application, it is merely for Testing when you are coding

> **NOTICE** : assert keyword is merely for testing your application , when debugging if the compiler sees `assert = false` it would imediately throw exception and terminate . thats why we used `assert` in above examples in function like bellow , and **Remember**: you should add -ea to variable ( like described above in assertion section )

```java
public boolean checkInput(String s1) {
    try {
        Integer.parsInt(s1);
        return true;
    } catch (Exception e) {
        return false;
    }
}

Scanner in = Scanner(System.in);
String s1 = in.next();
assert = checkInput(s1);
```

------

# Defining and Throwing Custom Exception

> Defining a `Custom Exception` class :

```java
public class WrongFileException extends Exception {
    public static final long serialVersionUID = 42L;
    @override
    public String getMessage() {
        return "you chosed the wrong message...";
    }
}
```

> Now use it with Throw

```java
try {
    if(fileContents.equals("Right File")) {
        System.out.println("You Chosed The Right File");
    } else {
        throw(new WrongFileException);
    }
} catch(WrongFileException e) {
    System.out.println(e.getMessage);
}
```

