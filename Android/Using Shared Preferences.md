# Using Shared Preferences
> **Android** provides many ways of **storing data** of an application. One of this way is called `Shared Preferences`. Shared Preferences allow you to **save** and **retrieve** data in the form of **key**,**value** pair.

> An `Example` is when you want to `keep a user Logged in` , in the program , so they don't need to enter there **username** and **password** , every time they visit .
```java
// so we create a package named utils , and two classes names Constants and the class that        works with that 
//
public class Constants {
   public static String KEY_EMAIL = "email";
   public static String KEY_PASSWORD = "password";
}
```

> **and the functioning method**
