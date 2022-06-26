# Serialization

> In java we can send an Object as a Stream of data . for example we can send this Stream of Object to anothere computer , or we can save it to a File .

-----

## Introduction

> Serialization : The process of turning an `Object` into a `Stream of data`is `Serialization`means `turning an Object into an Stream of Binary data` . we use the `Serializable`Interface for this porpuse .

```java
class Student implements Serializable {
    String name;
    double[] grades;
    transient double average;
    Student(String name,double[] grades,double average) {
        this.name = name;
        this.grades = grades;
        this.average = average;
    }
    public double getAverage() {
        return this.average;
    }
    public String getName() {
        return this.name;
    }
    public double[] getGrades() {
        return this.grades;
    }
}
```

#### :pushpin: In This Example We Write An Object to a File

```java
FileOutputStream fOne = new FileOutputStream("D:\\myObject.dll");
ObjectOutputStream out = new ObjectOutputStream(fOne); // The Serialization mechanizm is implemented by this line
Student st = new Student("Ali",new double[]{1,2,3,4});
out.writeObject(st);
// at this point our object is exported as binary to the file "myObject.dll"
```

:round_pushpin:*Example of Deserializing the above file*

```java
FileInputStream fileInputStream = new FileInputStream("D:\\myObject.dll");
ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
Student student = (Student)objectInputStream.readObject();
System.out.println(student.getName()); // returns Ali
System.out.println(student.getAverage());// return 0 | because it was a transient and its value would not be saved
```

---------

#### :pushpin:In This Example we Write An Object To The Memory

```java
class User implements Serializable {
    public String username;
    public transient String password;
    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }
}
```

*Now In The Main Method*

```java
public static void main(String[] args) {
    byte[] bytes;
    try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos)) {
        // serializing User Object
        out.writeObject(new User("Arash","samandar"));
        bytes = bos.toByteArray();
        
    }
    
    try(ByteArrayInputStream bis = new ByteArrayInputStream()
        ObjectInputStream in = new ObjectInputStream(bis)) {
        // Deserializing User Object
        User des = (User)in.readObject();
        System.out.println(des.username + " " + des.password);//password is null because its transient
        
    }
    
    
}
```

----------

> **transient property** : if we don't want a property to be converted when serializing , we would define it as transient .

```java
class User implements Serializable {
    private String username;
    private transient String password;
}
```

> Deserialization : and then we can use that `Object`in another place , like another computer .

> a lot of classes in java implement the `Serializable`Interface like : ArrayList , Integer , String .
>
> and if we want our class to be Serializable we have to implement this method in our class .

-----------

-------------

