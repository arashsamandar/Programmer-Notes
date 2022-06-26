## In Polimorphysm

> in `polymorphism` when you have a method that might change from one class to another , you will use the `Abstract` key . like bellow

```java
public abstract class UIControl {
    public void focus() {
        System.out.println("Control Focus");
    }
    public abstract void draw();
}
```

```java
public class TextBox extends UIControl {
    @override
    public void draw() {
        System.out.println("Drawing a TextBox");
    }
}
// -----------------------------------
public class Button extends UIControl {
    @override
    public void draw() {
        System.out.println("Drawing a Button");
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        drawControl(new TextBox());
        // the result is : Drawing a TextBox.
    }
    public static void drawControl (UIControl control) {
        control.draw();
    }
}
```

------------------------

## Rule : Every Class Should Have only a single resposibility

> to build maintanable software we should build classes that have single responsibility .

-------------

## Rule : a class must be `Open for Extension` but close `for modification`

![image-20201021155520347](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201021155520347.png)

> you can see this principle is well `built` in the `state pattern`

> as such whenever we need a new functionality , we just add another class that implements the `Tool` interface .

> this principle makes a class `robust and extensible`



## Patterns

### `memento` 

> *Definition* :  we have a class and we want to be able to undo the Operations done through the class 
>
> in other words : we want our class to have a state , and a history of that state , so we can undo what we assigned to our class field , using the EditorState & History .

----------------------------

### `State Pattern`

> *Definition* : we have a class , in this class there are methods ==> that have a lot of `if` and `else if` and `else` statements . so ==> this is too much , what if we want to intruduce a new if in the future , do we have to again write an extra `if` in every on those methods ?
>
> so we decide this class must have an `State` which contains all of the methods that have nested `else and if` , we call it `ClassnameState` , ==> all of the functions that have a bunch of nested `else & if` would be implemented in this `State` `Interface` .
>
> after that we implement that `interface` in our `Classes` , meaning every one of them has a different implementation of the functions in that `interface`

-------------------------

### `Iterator Pattern`

> we want to create a mechanism to be able to iterate over the objects of our class .

> thus we create an iterator class , inside the history class ( which holds the different values Of the Object )

> bellow you can see the UML of it .

![image-20201022122702862](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201022122702862.png)

----------------------

### `Strategy Pattern`

> Strategy Pattern uses the `Polymorphism` & `Abstraction` .
>
> Lets assume we want a mechanism to Store the images that the user uploads  and obviously this mechanism has methods for `Compressing the image` and also we want to be able to `add filter to image` , so it violates the rule ( the class should have only single responsibility .)
>
> Now what we do is : we seperate the filter and compress operations and we put them in other classes .
>
> But we use `Interface` , and follow `Write to Interface` . the definition is bellow :

![image-20201022143033708](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201022143033708.png)

![image-20201022143107493](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201022143107493.png)

> :notebook_with_decorative_cover:Now whenever we want a new functionality ( whether for Compressing the image or for Filtering it ) . for example to intruduce a new filter functionality . we just add a new class , as is the situation for new Compress .

## the Difference Between the `Strategy Pattern` & `State pattern`

> bellow you can see they are similar in some ways , but
>
> in State pattern our Canvas Object can behave differently , depending of the current tool .
>
> the difference between these two is : in the State pattern , the Object can have single state , that is the current tool . and all it's behaviour are represented by the subclass of the Tool interface .
>
> in Contrast in the Strategy pattern we don't have a single State , different behaviors are represented using different Strategy Objects

![image-20201022143523788](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201022143523788.png)

#### `Strategy Pattern`

![image-20201022144951043](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201022144951043.png)

------------------------------

### `Template Method Pattern`

> lets imagin we have a banking system . there are several operations . `and` we want to save ( record ) the time and person who does this Operation .
>
> thats when we use the `template method pattern` .
>
> we have several classes with an `execute` method , and in all of this classes execute method , we must have a mechanism for `recording` this execution ( Operation ) . thus we use the `template method pattern` .
>
> for implementing this pattern , we can use Strategy Approach `Polymorphism` , but yet better , we can use `Inheritance`

#### __Using Polymorphism Principle , ( Would Turn It Like Strategy Pattern)__

- ![image-20201022225530490](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201022225530490.png)Using `Inheritance` for `template method pattern` , as `execute()` method defines an Skeleton

![image-20201022230039935](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201022230039935.png)

> as every one of these classes has `execute()` method . we put it in the Task `abstract` class .
>
> and what happens after would be dependent on the Type Of Operation (Class)
>
> we implement the `doExecute()` in the `inherited` classes .

-----------------

> Representation of the `Tempalte Method Pattern` In the Gang Of Four Book , is Bellow

![image-20201022230458961](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201022230458961.png)

> as you see we have `multiple Abstract methods Operations` that are called in the `templatemethod()` 
>
> so `Template Method Pattern` is when we have a common `Method` that would be execute a bunch of methods , and as these methods may vary depending on what kind of Operation we have , we define them as abstract and implement them in Other classes that extend this class . ( the classes that do different Operations )

> we Refer to this `Operations` or `Methods` , as `HOOKS` .
>
> `HOOKS` are very common and you might see them in a variaty of frameworks

![image-20201022231334801](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201022231334801.png)

--------------------------

### `Command Pattern`

### The Problem

> lets imagin we want to make a GUI Framework , that others use to build there GUI Applications . for example

```java
public class Main {
    public static void main(String[] args) {
        // Button
        // CheckBox
        // TextBox
    }
}
```

> and our Button implementation is like bellow

```java
public class Button {
    private String lable; // every button has a label
    public void click() {
        // now this is the problem , cause we don't know what operations would be writter here
    }
}
```

> The Point Of the `Command Pattern` is to `Decouple` the `invoker` or `Sender` from the `Reciever` . 
>
> With This Structure , this Button can talk to CustomerService , or This Sender Can Talk to the Reciever , Without Being aware of it .
>
> thats the porpuse of the `Command pattern` : to decouple the sender from the reciever .

![image-20201024002945265](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201024002945265.png)

### the definition in the Gang Of Four Book

![image-20201024003023634](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201024003023634.png)

> Implementing the `Undo Mechanism` in the `Command Pattern` , What bellow :arrow_double_down:

> we Seperate the `UndoableCommand Interface` from the `Command` Interface , __*Thats Because Not Every Command Is Undoable*__ , Like Save . which is __Undoable__

![image-20201024111744578](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201024111744578.png)

> it has a difference with the `memento pattern` , memento pattern stores an `State` , but it may be costly to do so in the command , for example if the Operation is on a video .
>
> The Other Reason : __Is because Every Command Knows How to Undo Itself__

> now look at the Implementation

![image-20201024112324129](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201024112324129.png)

```java
// execute has these methods
prevContent = doc.getContent();
document.makeBold();
history.push(this);

// unexecute has these methods
doc.setContent(prevContent);

// and the UncoCommand has these methods
last = history.pop;
last.unexecute();
// history class knows nothing about the Commands
// this is part of the bussiness layer of the application
```

> `Commands` are the link `between User Interface Objects` and `Bussiness Objects`

-------------------------

### `Observer Pattern`

> bellow we have three classes , we want our `DataSource` Class to Talk to the Other Two Classes , but without being Tightly Coupled to Them . So we introduce a new Interface `Observer` , and have the DataSource Talk to That Interface .
>
> when we `setValue(value)` in the `DataSource` , we need to notify these Observers , so we use the `Polymorphism` Relation .
>
> we simply iterate Over the list of Observers and call the `Update()` method .
>
> so we have polymorphic behavior here , depending of the Type of Observer we have , different method would be called .
>
> each Concrete Implementation __like the SpreadSheet or Chart__ will figure out how to Update Themselfs .

![image-20201024182438347](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201024182438347.png)

> so we introduce a new interface and have the `DataSource` Talk to that interface , and the two classes implement this Interface .

![image-20201024182726208](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201024182726208.png)

> The `UML` in the Gang Of Four Book

![image-20201024183150348](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201024183150348.png)

> here the `ConcreteSubject` is like our `DataSource` class , in the UML above this one .

---------------------

#### Observer `push style` of the `Communication`

![image-20201027132301788](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201027132301788.png)

> this approach has a `fatal error` , that is if the `ConcreteObserver` want something else ,
>
> or in case each Observer needs a different set of values .
>
> the subject always thinks that this `Observer Interface` and the `ConcreteObservers` always need this `value` fild .
>
> then we have to change the code in our `interaface` to be something else .
>
> so this `push style` approach is not flexible enough .
>
> :star:__what if each Observer needs Different sets of Values !?__

> for solving this error , we use `Pull Style Communication` .
>
> instead of the subject pushing the value to the Observers , the Observers can pull the data they need when changes accure , so each `CocreteObserver` must have a Reference to the `ConcereteSubject` .

![image-20201027132933913](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201027132933913.png)

> we don't want our `ConcreteSubject` or `DataSource` to Be Changed when a new type of Observer is Written .

#### :star:*in reality there is no 0 `zero` coupling in software , we always have some kind of `coupling`*

#### :star:*But What matters , is the `direction` of the `coupling` .*

> now lets couple the Observers to the ConcereteSubject

```java
public class ClassOne implements Observer {
    private ConcreteSubject conSub;
    public ClassOne(ConcreteSubject conSub) {
        this.conSub = conSub
    }
    public void update() {
        System.out.println("Now this is pull Style : " + conSub.getValue());
    }
}
```

> as simple as that , `you don't need to change the Subject and ConcreteSubject` .
>
> you change them if you want to use the `Push Style`
>
> in the `Pull Style` as you see we only change the `Observers` which implement the `Observer` Interface

-------------------------

### `Mediator Pattern`

> imaging your `barnameye gavdaree` , in that application , we had a `ListBox` , and then we had a `TextBox` and a `Button`
>
> when we click on `an item` in the `ListBox`
>
> the TextBox gets filled with that text
>
> and the button becomes active



> so ho do we `implement` this ?

- > One way is using `Inheritance` , But this is wrong , take a look

![image-20201028120324614](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201028120324614.png)

- > and then we have to make them `Talk To EachOther` , Like Bellow :

![image-20201028120412807](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201028120412807.png)

> __as you can see__ => __The Login Of this Application Gets Spread All Over The Place__

> Thus this is not a good approach .

#### `Solution` :

> we make a change in the `UIControl Classes` , To create a class called `DialogBox` , then we want all these classes to talk to an abstract class called `DialogBox` .
>
> So every UIClass should know the DialogBox that contains it .
>
> so we implement an abstract method called `Changed(control)` , that gets changed whenever every of this UIControls get changed .
>
> *the `control` parameter for which class it is*

![image-20201028120922548](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201028120922548.png)

> so we have a single place to figure out how these Objects interact . so the logic of the application dosn't gets spread to all these classes .

> as the `DialogBox` is an abstract class . now we implement it for our application an call it `ArticlesDialogBox` .
>
> and in this class we implement our change method . and this is where we implement all the interactions between our UIControll Classes .

![image-20201028121443069](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201028121443069.png)

> the reason this is called the `Mediator pattern` is because this `DialogBox` is `Mediating` the interactions of these objects .
>
> so they don't know each other , they only know the `Mediator Class`

> bellow is the classic structor .

![image-20201028121835591](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201028121835591.png)

> `Mediator` for our `DialogBox` , and `Concerete Mediator` is our `ArticlesDialogBox`
>
> `Colleague` for our `UIControl` and `ConcreteColleague` for our `UIControl Classes` Like `TextBox` , `ListBox` , `Button`
>
> they can talk to eachother indirectly , via this mediator .
>
> the only type of coupling we have here , is between `ConcreteMediator` & `ConcreteColleague`
>
> and this is completely fine , because on a particular dialogbox , we definitly have to know about the controls on that dialogbox .



### Impelementing the `Mediator Pattern` , Using the `Observer`

![image-20201028174420026](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201028174420026.png)

> here the `UIControl` doesn't have a relation to the `DialogBox` anymore .
>
> they don't know even if it existes or not .
>
> they are going to talk to each other , indirectly , using the Observer . they are going to notify the DialogBox .
>
> they only talk using the `Observer` and `attach(observer)`



## `Chain Of Responsibility` Pattern

> This is Simply a bunch of Objects that assemble together to accomplish a task
>
> like bellow

```java
public class WebServer {
    public void handle(HttpRequest request) {
        // Authentication
        // Logging
        // Compression
        //Now we Create a seperate class for each one for maintaining the simple responsibilty in this class ( it should not implement all in here) , and each one of these classes gets an HttpRequest (Wich again is a class) in themselfs .
        var authenticator = new Authenticator();
        authenticator.authenticate(request); // like here
        // and then
        // var logger = new Logging(request) AND etc.....
    }
}
```

> But the problem is that all the code for maintaining this connection to webserver is all in one place .
>
> problem : if in the future we want to change the order , ( for example remove the authentication ) or add a functionality , we should yet again come and change the code here
>
> for solving this problem we use `ChainOfResponsibility Design Pattern` .
>
> By Creating `a Pipeline` or `Chain of Objects` for achieving this ( Proccessing our Request ( Or any Request it would be for you ))

-----------------

#### One Way Is Like Bellow

![image-20201030202448793](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201030202448793.png)

> This Violates The `Open Close Principle` , Open for Extension and Close for Modification .

> All the code is in One place , 
>
> ```java
> authenticate();
> log();
> compress();
> ```
>
> so we have a problem if we want to change or add new functionality .



> we need `a proccessing Pipeline` . each Object only knows about it's next Object . and then pass it over ( if valid for example ) .

![image-20201030202850550](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201030202850550.png)

![image-20201030203446670](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Important Notes.assets\image-20201030203446670.png)

> we have a `Handler` *Abstract Class* , which has a reference to Itself with the filed `next`
>
> then to implement the `handle()` method of it , we implement the solid ones like `Authenticate` and `Logger` and Etc...

> as you can see our `WebServer` class (Which processes the request ) has a relation to the `Handler Abstract Class` , but knows nothing about the Authenticator , nor the Logger .
>
> thus we can add or remove any of them , whenever we want :)
>
> this is called the Chain of Responsibility Pattern .

