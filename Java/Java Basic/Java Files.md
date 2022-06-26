# intrudoction

# intro

> Everything in a OS is a File , we have file systems in os that lets us work with files ( Read & Write ) to the files 

> There Are Two types of files : `Text`& `Binary`

:memo:*This Category is about how we save them , not how we see them , for example although we see a PDF file as a text , but we can not open it with a notepad , the file is not saved as a text file , its a binary file .*

- **Text Files**

> `Charachters` are ther building blocks of these type of files . like `txt` , `html` , `xml` , `Json`

- Binary Files

> `Bytes` are the building blocks of a binary file . like `exe`,`zip`,`docx`,`pdf`

#### Charachters In Java

> java support `Unicode` for charachters , and the Old version of `Unicode`is `ASCII` , which for example dosn't supports Farsi/Persion or Japenes ,  `Unicode` is also called `Charset` 

> :warning:There are different ways of `encoding`, which means converting charachters to numbers .

> different types of encoding like `UTF-8`,`UTF-16`,`UTF-32`, so `Unicode`is a `Charset` wich uses encodings like the one we mentioned

#### :memo: Java Is using UTF-16

---------

--------------

## Streams

> The flow of data or Stream , is a flow of data or information that flows in or out of a Programm .

##### `Close()`

> we must use close() to close() the stream , because file is a resource . otherwise the resource that we have got from the Operating System would not be freed

> :memo:File & Stream Does not have a Garbage Collector in java , so we Must close() them

> :memo:Put the close() in `catch`& also in `finally` blocks , so we can make sure it is close . or as always that we do , we define it in the `try references`, inside the `try(.....){}` so it would be closed automatically

```java
try {
    FileInputStream inf = new FileInputStream("file.fileExtention");
    ArrayList<Byte> list = new ArrayList<>();
    int bCode;
    while(-1 != (bCode = inf.read())) {
        list.add((byte)bCode);
    }
} finally {
    if(inf != null);
       inf.close();
}
```



------

#### FileReader & FileWriter To wolk with Text Files

> :memo:**If you don't want to rewrite to a file and you just want to append to it use `.append()` if the writer**, also when creating a writer pass `true`as the second argument , which means you want to append to the file and you don't want to rewrite it like :

```java
FileWriter writer = new FileWriter("Arash.txt",true);
writer.write("this is a new line \n");
```



#### FileOutPutStream

```java
int[] numbers = {1234567890,1234567891,1234567892};
byte[] array = intToByteArray(numbers); // lenght of this array is 12 ( as every integer is 4 bytes)
```



:memo:**NOTE : **we could have saved this for example as Charachters , ( by convering every element in the numbers array , would be converted to 10 charachter ( we would devide the number , and convert every number to a charachter)) , and then when we saved them . it coud have occupy an space equals to 30 bytes ( or more if we used encodings like utf-16 or utf-32 ) . but with our method it would only be 12 method



