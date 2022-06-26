## Formating Numbers

> to format numbers , for big numbers like `Long` , put an `L` at the end of your number .
>
> for `Float` numbers , put an `F` at the end of your number .
>
> like bellow :
>
> ```java
> long arash = 1223423523L;
> float ali = 12.99F;
> ```

## Note About Primitive & Reference Types

> `Primitive` types are copied by there value , `Reference` Types are copied by there reference .

## Arrays In Java

> Remember :star: __In Java Arrays Have A Fixed Size__

> Showing An Array :star: *you can show an array with* __Arrays__ .
>
> ```java
> int[] arash = new int[5];
> // or
> int[] arash = {1,2,3,4,5};
> // now for showing it
> System.out.println(Arrays.toString(arash));
> // we get [1,2,3,4,5]
> ```
>
> Also use `deepToString` for multidimentional Arrays .

## Converting String To Integer (Using Wrapper Classes (Helper Classes))

> an example is bellow :
>
> ```java
> public static void main(String[] args) {
>     
>     String x = "1";
>     int y = 3
>     int result = Integer.parseInt(x) + y;
>     System.out.println(result) // 4
>     
>         // we also have
>         // Double , Float , Short , every One of them have parseDouble , parseFloat and so on
> }
> ```
>
> 

## Deviding Numbers in Java

```java
public static void main(String[] args) {
    int x = 3,y = 4;
    double result = ((double)x/y);
    // so we shall use the explicit upper casting here .
}
```



## Formating Numbers

#### Using The `NumberFormat` Class .

> and remember the `NumberFormat` is an `abstract` class , so we can not instantiate it .

> so to use it we should use the `Factory Pattern` of it , and use one of it's `get` methods . to return an instance of this class for us .



## Reading Value From Terminal In Java

> for this porpuse we can use the `Scanner` class , With it's `next` method , like bellow :
>
> ```java
> public static void main(String[] args) {
>     Scanner scanner = new Scanner(System.in);
>     byte age = scanner.nextByte();
>     System.out.println("You Are " + age);
>     // --------------------------------------------------------
>     // or if you want to use String
>     String age = scanner.next(); // or scanner.nextLine(); which gets an entire line
>     String nameAndFamily = scanner.nextLine(); // Arash Aghashahi
> 	// good for this cases where you have spaces like above
>     // ---------------------------------------------------------
>     // if you don't even want the first spaces to be include , use
>     String nameAndFamily = scanner.nextLine().trim();
> }
> ```
>
> 