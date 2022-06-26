## Using File , Scanner , PrintWriter

```java
package main;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File menuItems = new File("D:\\menuItems.txt");
        File menuPrices = new File("D:\\menuPrices.txt"); // this file doesn't exist
        // but it would be created as it is an output file for us .
        String menuItem;
        double price;
        try {
            Scanner in = new Scanner(System.in); // to read from command line
            Scanner input = new Scanner(menuItems);
            PrintWriter output = new PrintWriter(menuPrices); // create the writer to write that file
           
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

-----

## Using Files.newBufferedReader(source,charset)

> Using `Files.newBufferedReader(source,charset)` & `Files.newBufferedWriter(source,charset)` , just like bellow :

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
        
        try (BufferedWriter writer = Files.newBufferedWriter(target,charset)) {
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

-----

## Using FileReader & FileWriter

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

-----

## Using `BufferedReader` with `FileReader` and Vice Versa

> Using `BufferedReader` with `FileReader` & `BufferedWriter` with `FileWriter` 

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

-----

## Using FileInputStram & FileOutputStream

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

------

# using Try with Resources

> when using input and output `resources`it is important to use try with resources whenever you can . using this method makes sure all resources are closed for you .

> the meaning of `Try with Resources` is simple , **you only need to declare your resources in the Try paranteces** Like bellow :

```java
try(//Resources) {
    
} catch(Exception e) {
    System.out.println(e.getMessage);
}
```

> If you can use Try with Resources , Then you should use Try with Resourc