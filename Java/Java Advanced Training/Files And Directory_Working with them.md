# Managing File and Directories



>  In `Java 7` there is new System for working with Directories and Files .  the classes that are part of this system are part of a package callled `java.NIO` , stands for new-input-output the core of this new system is a class called `Path` that replaces the old File class . 

**Lets See Some Of Its Functions**

```java
public static void main(String[] args) {
    Path path = Paths.get("/temp/loremipsum.txt");
    System.out.println(path.toString()); // returns \temp\loremimpus.txt
    System.out.println(path.getFileName()); // return loremipsun.txt
    System.out.println(path.getNameCounts()); // returns 2 as of \temp\loremipsun
    System.out.println(path.getName(0)) // returns temp
    System.out.println(path.getName(1)) // return loremipsun.txt
    
    // to get the full path of your file
    Path realPath = path.toRealPath(LinkOptions.NOTFOLLOW_LINKS);
    System.out.println(realPath);//returns C:\somefolder\fols\temp\loremipsun.txt
    
    // to copy the file
    Path source = Paths.get("D:\Arash.txt");
    Path target = Path.get("D:\NewOneArash.txt");
    Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);
    
    // TO Delete The File
    Path doDelete = Paths.get("D:\\Arash.txt");
    Files.delete(doDelete);
    
    // Create Directory
    Path newdir = Paths.get("D:\\Samandar");
    Files.createDirectory(newdir);
    
    // Moving the file to that directory
    Path source = Paths.get("D:\\Arash.txt");
    Path newdir = Paths.get("D:\\samandar");
    Files.createDirectory(newdir);        Files.move(source,newdir.resolve(source.getFileName()),StandardCopyOption.REPLACE_EXISTING);
}
```

#### some of its functions

- > `File.copy`(source,target,StandardCopyOptions.REPLACE_EXISTING)

- > `Files.delete`(path)

- > `Files.move`(source,newdir,resolve(source.getFileName()),StandardCopyOptions.REPLACE_EXISTING)

- > `Files.makeDirectory`(path);

### Reading and Writing Text Files :

> for reading from a file we need `Path` and `BufferedReader` , wich BufferedReader is equaled to :

```java
// to read from a file we need BufferedReader
BufferedReader reader = Files.newBufferedReader(source,"UTF-8"); // which source is a path
// and for writing to a file we need BufferedWriter
BufferedWriter writer = Files.newBufferedWriter(target,"UTF-8"); // which target is a path
```

> and now the example is :

```java
public class Main {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("D:\\samandar\\Arash.txt");
        System.out.println(source.getFileName());
        Path target = Paths.get("D:\\newArash.txt");
        System.out.println(target.getFileName());

        Charset charset = Charset.forName("UTF-8");
        ArrayList<String> lines = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(source,charset)){
            String line = null;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try (BufferedWriter writer = Files.newBufferedWriter(target,charset )) {
            // we need to loop through the arrayList wich we filled with the other file
            Iterator<String> iterator = lines.iterator();
            while(iterator.hasNext()) {
                String s = iterator.next();
                writer.append(s,0,s.lenght());
                writer.newLine(); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage);
        }
    }
}
```

### Walking The Directory Tree :open_file_folder:

> for this porpuse we use Path and a class Called MyFileVisitor wich extends the SimpleFileVisitor<Path> , and we overwrite its methods .



#### some of its functions are :

- > `SimpleFileVisitor<Path>`

- > `FileVisitResult.CONTINUE `for function return type

- > `Files.walkFileTree`(fileDir,visitor);

> NOW : first we create the MyFileVisitor that extends the SimpleFileVisitor<Path>

```java
public class MyFileVisitor extends SimpleFileVisitor<Path> {

    MyFileVisitor() {
        super();
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("About To Visited : " + dir);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(attrs.isRegularFile()) {
            System.out.println("Regular File : " + attrs.toString());
        }
        System.out.println(file);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Just Visited : " + dir);
        return FileVisitResult.CONTINUE;
    }
}
```



> and then in the Main class we have : **Notice** : the D\samandar\havij contains three files

```java
Path fileDir = Paths.get("D:\\samandar\\havij\\");
MyFileVisitor visitor = new MyFileVisitor();
Files.walkFileTree(fileDir,visitor);
```

### Finding Files

> with what we have leaned in Reading & Writing to a file , now with this one , we can find the file we want , copy it delete it read it , basically anything we want . the algorithm of finding files is as Follows :

> First we Create a Class ( Just Like Before When We Walked Through Files ) with a little difference , bellow is the `list of types` used in this program 

#### some of its functions

- > `SimpleFileVisitor`

- > `PathMatcher`

- > `Path`

- > `matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern)`

- > `FileFinder`

- > `Files.WalkFileTree(,)`

```java
public class FileFinder extends SimpleFileVisitor<Path> {
    
    private PathMatcher matcher;
    public ArrayList<Path> foundPaths = new ArrayList<>();
    
    public FileFinder(String pattern) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
    }
    @override
    public FileVisitResult visitFile(Path file,BasicFileAttributes attrs) {
        Path name = file.getFileName();
        System.out.println("Examining : " + name);
        if(matcher.matches(name)) {
            foundPaths.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
```

> and in the main file we have :

```java
public class Main {
    public static void main(String[] args) {
        Path fileDir = Paths.get("D:\\Samandar\\mavij");
        FileFinder finder = new FileFinder("*.*");
        try {
            Files.walkFileTree(fileDir,finder);
            ArrayList<Path> foundFiles = finder.foundPaths;
            if(foundFiles.size() > 0) {
                for (Path path:foundFiles) {
                    System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
                }
            } else {
                System.out.println("no files found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```



### Watching a Directory For File Changes

> java7 can easily create a watch service , a service that watches the contents of a directory and reports when any of the Directories Contents are created deleted or modified ,

#### some of its functions

- > `WatchService = FileSystem.getDefault().newWatchService()`

- > `WatchKey`

- > `WatchEvent`

- > `StandardWatchEventKinds.ENTY_CRAETE`  etc...

- > `WatchEvent.Kind<?>`

```java
public class Main {
    public static void main(String[] args) {
        try(WatchService service = FileSystems.getDefault().newWatchService()){
            Map<WatchKey,Path> keyMap = new HashMap<>();
            Path path = Paths.get("D:\\samandar\\havij");
            keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY),path);
            WatchKey watchKey;

            do {
                watchKey = service.take();
                Path eventDir = keyMap.get(watchKey);
                for (WatchEvent<?> event :watchKey.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path eventPath = (Path)event.context();
                    System.out.println(eventDir + " : " + kind + " : " + eventPath);
                }
            }while(watchKey.reset())
        }catch (Exception e) {

        }
    }
}
```

-------

-------

# Part Two

## How To Create a File

> To create a File we use myFile.createNewFile() , like bellow :

```java
public static void main(String[] args) {
    File myFile = new File("D:\\Arash.txt");
    try { // the boolean variable is just for test porpuse
        boolean fileCreated = myFile.createNewFile();
    } catch(IOException e) {
        e.printStackTrace();
    }
}
```

:memo:The `File` Class does not come with functionalities for us to write to it . but it does  have methods for setting file Permssions and Renaming, and getting file `metadata`such as when it was last modified or created .....

:memo:The `File`class does not create a file , lets see some of its functions :

- canRead()
- canWrite()
- canExecute()
- lastModified() , from 1970 , to miliseconds past from 1970
- exists()
- isFile()
- isDerectory()
- getName()
- getAbsolutePath()
- list()

------

## Working with Directories in a file system.

> To get all the files and folders in your current directory you application is running , just use :

```java
public class Users {
    public static void main(String[] args) {
        String[] contents = new File(".").list();
        for(String file: contents) {
            System.out.println(file);
        }
    }
}
```

:memo:To Search only for files inside a directory we use `FilenameFilter()`method

```java
FilenameFilter filter = (file,filename) -> {
    return filename.contains(".");
}; // this is a Functional Interface
String[] contents = new File(".").list(filter);
for(String file:contents) {
    System.out.println(file);
}
```



### how to create new directory

```java
public class Users {
    public static void main(String[] args) {
        new File("myDirectory").mkdir();
    }
}
```

------

## Path Class

> the best way to move , copy and delete files in java is with the path class . this offers the additional functionality which is not available in the file class .

:pushpin:*Deleling a file if exists , using `Path`,`Paths`,`Files`*

```java
public class Users {
    public static void main(String[] args) {
        Path path = Paths.get("Arash.txt");
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

:pushpin:*Another Example*

```java
public class Users {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Education\\havij.mp4");
        System.out.println(path.getParent());
        System.out.println(path.getFileName());
        System.out.println(path.getRoot());
    }
}
```

:pushpin:*Example of Copying A file to another destination*

```java
public static void main(String[] args) {
    Path source = Paths.get("C:\\Users\\Documents\\arash.txt");
    path destination = Paths.get("C:\\Users\\newArash.txt");
    try {
        Files.copy(source,destination);
    }catch(IOException e) {
        e.printStackTrace();
    }
}
```

:pushpin:*Or if the file already exists*

```java
Files.copy(source,destination,REPLACE_EXISTING);
```

## RandomAccessFile

> It is not a `Stream`Nor a `Reader/Writer` , with this class we can use a file , read or write to a file , binary or text

> The Object of this class has a `File Pointer`which is the destination we are using ( the Address Of the File ) , we can move this pointer with `seek(long)`method

```java
RandomAccessFile raf = new RandomAccessFile("1.txt","rw"); // // rw for write and r for read
```

> it is not an `Stream` and not `Read/Writer` , but we can access and read write to file simoltanously

```java
byte ch = raf.readByte(); //reads a single byte
int i = raf.readInt(); // reads 32-bit integer ( binary read )
String line = raf.readLine(); // reads text in a line
raf.seek(5); // 5 bytes from the beginning of the file
raf.writeBytes("this will complete the Demo");
raf.writeDouble(1.2);  // write 8-bytes ( binary )
raf.close();
```

> This class is only for Files , while Stream and Reader/Writer are for network and other things too

---------------

## Scanner Class

> A helper class for getting and proccessing `Text`data .

> Lives in `Java.util`

:pushpin:**Examples Are : **

```java
s = new Scanner("arash.txt");
s = new Scanner(new File("arash.txt"));
s = new Scanner(new FileInputStream("arash.txt"));
s = new Scanner(new FileReader("arash.txt"));
s = new Scanner(System.in);
```

------

## Formatter Class

> is used for outputing text data

```java
Formatter f = new Formatter("arash.txt");
Formatter f = new Formatter(new File("arash.txt"));
Formatter f = new Formatter(new FileWriter("arash.txt"));
Formatter f = new Formatter(new FileOutputStream(arash.txt));
Formatter f = new Formatter(System.out);

```

#### `format()` method of Formatter

```java
f.format("age=%d,name=%s,grade=%.2f",20,"Ali",18.453)
```

-----

## Example Of Using Scanner With Formatter

```java
public static void main(String[] args) {
    File file = new File("D:\\folder\\arash.txt");
    try (Scanner scanner = new Scanner(file);
         Formatter formatter = new Formatter("D:\\folder\\newArash.txt")) {
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(!line.startsWith("BAD")) {
                formatter.format("%s\n",line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
}
```

## Some Important Classes 

#### `DataOutputStream` & `DataInputStream`

> For reading and writing binary data , like readBoolean , readDouble , readChar , readInt , readFloat , readLong , and so is true for output

------

#### `BufferedOutputStream` & `BufferedInputStream` , `BufferReader` & `BufferWriter`

> working with Buffered Input and output . a technic to make the process faster . they are not executed instantly , they wait untill buffer is full , but we can empty a BufferedOutPutStream wish `flush()`method .
>
> BufferReader & BufferWriter are working with text data , BufferReader is faster than `Scanner`.

------

#### `ByteArrayInputStream` & `ByteArrayOutputStream`

> They also work with a flow of binary data . there job is to work with memory , and not file . they are simply an space in memory to save data or read from it .

------

#### `StringReader` & `StringWriter`

> They read and write text data

------

#### `PrintStream`

> is an OutPutStream for text , for example to work with `print` & `println` .
>
> `System.out` is a `PrintStream`

```java
// printing an stream to the console with help of Buffer
FileOutputStream file = new FileOutputStream("D:\\example.txt");
BufferedOutPutStream buffer = new BufferedOutputStream(file);
PrintStream prnt = new PrintStream(buffer);

print.println("Salam");
```

------

#### Decorator Pattern

> Java.io uses Decorator Pattern , which is a Design Pattern .

------

### Example ByteArrayOutputStream

:pushpin:*Example Of writing to the Memory with `DataOutputStream` & `ByteArrayOutputStream`*

```java
ByteArrayOutputStream baos = new ByteArrayOutputStream();
DataOutputStream dos = new DataOutputStream(baos);
byte[] bytes;

dos.writeInt(125487958);
bytes = baos.toByteArray();
```

## Path Class

> Path is a Helper class that only has a Important method named `get()`,which gets an address and returns an Object of type `Path` which contains the address information , for example , it has information about file or folder .

```java
Path path = Paths.get("D:\\arash.txt");
```

### In new Java Version we should use `Path` instead of `File`

> we have `toFile()`In Path Class , and `toPath()`in Path class .

```java
Path path = Paths.get("D:\\arash.txt");
Path parent = path.getParent();
File f = path.toFile();
```

------

## Using Files Class

```java
Path src = Paths.get("D:\\mydirectory\\arash.txt");
if(!Files.exists(src)) return; // if there is no file in this path return
Files.createDirectory(Paths.get("D:\\folder\newFolder")); // creates a Directory
byte[] bytes = Files.readAllBytes(src); // read all of the file and put them in our bytes variable
List<String> lines = Files.readAllLines(src); // read all lines of the file and put them in our ArrayList lines
long size = Files.size(src);
Path copy = Paths.get("D:\\newcopy.txt");
Files.write(copy,bytes);
Files.write(copy,lines,StandardOpenOption.APPEND);
boolean writable = Files.isWritable(src);
```

