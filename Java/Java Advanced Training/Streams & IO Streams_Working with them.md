# Streams

## Reading & Writing Byte Streams

> in many java application we need a more Raw Approach , the ability to `read and write` to files `One Byte at a time` , so we need to learn how to work with `Streams`, primarily designed to work with `binary data`

> Generally we Use `Streams`a lot , ( which are basically a sequence of Data ) , but for Reading Them and/or Write to them , we need to Understand them , and thats Where we use `Readers`, to convert them from ByteStream , to Charachter stream , like in example bellow :

```java
BufferedReader buserInput = new BufferedReader(new InputStreamReader(System.in));
// here System.in is an InputStream , which reads one byte at a time
// InputStreamReader reads one Charachter at a time
// BufferedReader reads an entire String at a time
// of if it is a Socket
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream));
// or for writing data we have
PrintWriter out = new PrintWriter(soc.getOutputStream());
```

> two primary classes we should learn how to use first called `FileInputStream` & `FileOutputStream` , we need to close them , but by defining them in `try()` they will close automatically

- One Note is That Both Two Files In Bellow Example Must be In the Same Path , and the output file dosn't even need to be defined
- as they read binary data , it doesn't make any difference , you can copy an image with this code

```java
public class Main {
    public static void main(String[] args) { // we wrote in try , so we don't need to close them
        try (FileInputStream in = new FileInputStream("D:\\samandar\\havij\\Arash.txt");
             FileOutputStream out = new FileOutputStream("D:\\samandar\\havij\\some.txt")
        ) {
            int c;
            while((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Reading & Writing Charachter Streams

> is used mostly for text documents , as they have Charachters , the difference is that we use `FileReader` and `FileWriter`to accomplish it .

```java
public class Main {
    public static void main(String[] args) { // we wrote in try , so we don't need to close them
        try (FileReader in = new FileReader("D:\\samandar\\havij\\Arash.txt");
             FileWriter out = new FileWriter("D:\\samandar\\havij\\some.txt")
        ) {
            int c;
            while((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Using Buffered Streams

> when we are dealing with large Files , its a good idea to wrap your FileReaders & Filewriters  inside a Class That would Buffer the Operation . Buffering the Read and Write Operations is a good way of automatically managing memory . so we eficiently putting content into memory and taking it out .

> we use `BufferedReader` & `BufferedWriter` for this Operation , you can use the BufferedReader & BufferedWriter `Wraped auround` of any Reader or Writer , Such as FileReader & FileWriter .

*Now Look what we do with the above Example in here with the use of `BufferedReader & Writer`*

```java
public class Main {
    public static void main(String[] args) { // we wrote in try , so we don't need to close them
        try (BufferedReader in = new BufferedReader(new FileReader("example.txt"));          
             BufferedWriter out = new BufferedWriter(new FileWriter("newfile.txt"));
        ) { // the rest is exactly the same
            int c;
            while((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Scanning Tokenized Text

> is basically a text file with comma and tabs in it , the `Scanner` class can be used to easily read this sort of Tokenized Text . and it works well for very large files . for this porpuse we use `Scanner.useDelimiter(",")` now watch the example bellow :

```java
public class Main {
    public static void main(String[] args) { // we wrote in try , so we don't need to close them
        try (
            Scanner s = new Scanner(new BufferedReader(new FileReader("example.txt")));
        ) { 
            s.useDelimiter(","); // this file has comma between its words
            while(s.hasNext()) {
                System.out.println(s.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
    }
}
```

-----

-------

# Streams Advanced

### Definition

> Streams provide a clean and simple way to iterate Over a Collection in java , instread of Using a ForEach loop , Streams allow Functional Programmin Techniques to be used . these Streams are not to be confused with input & output Streams which are something completely Different .

*For example in a ForEach loop like bellow , it uses something called external iteration , what actually happens under the hood , is an iterator object is created , the iterator object controls the iteration process* :pushpin:

```java
for(Book book : books) {
    if(book.getAuthor().startsWith("J")) {
        System.out.println(book.toString());
    }
}
```

>There are a few issues with external iteration.

- > `First` : it is difficult to write a program that runs two external iterations of a collection in parallel.

- > `Second` :  it needs a lot of boilerplate codes to write. This can sometimes make it difficult to read. If you have large for loops that contain lots of code, and especially if there are lots of nested for loops, it can be difficult or time consuming to work out

- > `Third` : with a forEach loop, what you are doing is fused with how you are doing it. There is not much abstraction between the code and the implementation.

### Now Streams Provide a Solution To These Issues :

> Streams use Internal iteration instead of external iteration .

*For Example The Above Code is Converted To* :pushpin:

```java
books.stream().filter(book - > {
    return book.getAuthor().startsWith("J");
}).forEach(System.out::println);
```

:memo:*The first method called `stream()`*

:memo:*Next is the `filter()` method , Streams have two different types of methods : `lazy methods` And `eager methods` , in this example the filter() method is an example of a lazy method .*

:memo:*Finally there is `forEach()` method , wich is an eager method , this prints out all of the objects in the stream .*

### Concolusion

> So instead of Creating an iterator object which a forEach loop does, it creates a stream object.
>
> if the author begins with J, then it adds that item to the stream. It doesn't print out the book straightaway, instead, it waits 'til the end when it has a stream of all the list items which there String begins with "A" .
>
> Then it prints out that stream .

> :star:instead of using nested forEach loops , we simply add more .filter() to it

:pushpin:*Another Example*

```java
public class Book {
    private String author;
    private String title;
    Book(String author,String title) {
        this.author = author;
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    @override
    public String toString() {
        return "Author is : " author + " + With Title : " + title;
    }
}
```

```java
// and in the Library class , in Which i made it main
public class Library {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books = populateLibrary(); // populating it
        // new run the Stream on it
        books.stream().filter(book -> {
            return book.getAuthor().startsWith("M");
        }).filter(book -> {
            return book.getTitle().startsWith("M");
        }).forEach(System.out::println);
    }
    
    public List<Book> populateLibrary() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Arash","Power Rules"));
        books.add(new Book("cimin","rule of ermaf"));
        books.add(new Book("Moghadam","Mathematical Algebra"));
    }
}
```

> :warning:**​it would have been a mess if we tried to write this code with two nested forEach loop like we did in the starting tests**

## Implementing Paraller Streams

> One of the advantages of using Streams over using for loops , is that we can run iterations in Parallel . it sound like a complicated task , and if we have been using for loops it would have been verryyy complicated , but now we just need to use `paralellStream()`instead of `stream()`

```java
public class Library {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.parallerStream().filter(book -> {
           return book.getAuthor().startsWith("M"); 
        }).forEach(System.out::println);
    }
    public List<Book> populateLibrary() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Arash","Power Rules"));
        books.add(new Book("cimin","rule of ermaf"));
        books.add(new Book("Moghadam","Mathematical Algebra"));
    }
}
```

:warning:**The OutPut is the same , but the speed is different**

> although it is very easy to use parallel streams , this dosn't mean that we necesseraly should ,  `Firstly` : there is only really a performance impact only When you are using a veryyy large amount of data , use normal stream for normal data sets .
>
> **IMPORTANT : this code is dependent on how many cores your `CPU` has available , **

-------------

# Streams 2

## Understanding I/0 in java

> Streams are a way of reading data or writing data . streams represent the real flow of data , and a bit like real streams of water , they could only go in one direction .

> out put Stream Writes out data .

> and Input Stream Read in data .

> if you want to have data going two ways , you would need two seperate Streams

- System.out.print()
- reading and writing files in a program
- taking user inputs from the console
- Communicating Through Sockets 

### There are two core abstract classes in java Streams API

#### `InputStream`& `OutputStream`

![](F:\Programming Notes\Java\Java Advanced Training\assets\InputOutput.png)

> As they are abstract classes you can't implement them , but they each have several concrete implementations for handling different types of data .

#### Some Concerete Implementation of InputStream

- FileInputStream
- ByteArrayInputStream
- FilterInputSteam
- And more....

#### Some Concerete Implementation of InputStream OutPutStream

- FileOutPutStream
- ByteArrayOutPutStream
- FilterOutPutStream
- And more.....

#### There Are Two More Abstract Classes

- > eader

- > Writer

> These are similar to inputStream & outputStream , and the are built on the same Concepts . but the main difference is that : inputStream & outputStream move bytes around . whereas Reader & Writer Moves charachter . Charachters are easier and more Intuitive .

## Reading Console With Scanner

> `System.in` is an `InputStream` used for reading standard input e.g. from keyboard in java

```java
public class Users {
    public static void main(String[] args) {
        System.out.print("Enter Your Name : ");
        Scanner s = new Scanner(System.in);
        String name = s.next();
        System.out.print("Enter Your Age : ");
        int age = s.nextInt();
        int chos = s.nextInt();
    }
}
```

> you can also use `Scanner.useDelimiter()` and specify a new token , for example comma ","