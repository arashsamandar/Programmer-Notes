# Writing in Packages & Classes

---

## Using Package

> **NOTE :** Java Uses ( . ) dot , and Php Uses ( / ) slash . for managing what they call `Package` in `Java` and `namespace` in `php` . wich is basically folders for managing different Operations & Models of a program .

> When Writing an `OOP` program , For Example for `Android`
> Seperate Each Part Of The Program , by using `Package` in Java And `namespace` in android .
- Create a **package** for your `Model` , for example the `User Object` , which is `called` a Model .
- 
- Create a **package** Every specific type of `Operation`

![Image](D:\Programming Notes/medley/resources/rkk6ZOIi4_B1pIWIwsV.png)

> `NOTE` : in the **MainActivity class** or **any other ActivityClass** , we seperate the `Steps` of the program , by putting them in **Different Methods** of **that Class** , like bellow :

```java
public static MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // now here goes our different methods
        initializeViews();
        initializeListeners();
        InitializeObjects();
}
```