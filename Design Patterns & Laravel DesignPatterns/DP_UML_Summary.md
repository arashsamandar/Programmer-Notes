[TOC]



### `NOTE :`A Class Must Be Closed For Modification & Open For Extension

## Memento Pattern

![image-20201115142835353](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201115142835353.png)

## State Pattern

![image-20201116152911915](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201116152911915.png)

> __is used when we want to handle a request , based on different `states`__
>
> like what we had in the `Canvas` that had  it's *mouseDown* and *mouseUp* methods , also with Several `Tools` in canvas  , which we created a `Tool Interface` with two methods , `mouseUp` & `mouseDown` . the rest you know ......

## Iterator Pattern

![image-20201117102125597](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201117102125597.png)

-------------------

## Strategy Pattern

> __is used when we want to apply several different operations on a *for example image or etc*__
>
> Like what we had when we wanted to `StoreImage` , we know if for example we have `image compressor type` and `image filter` .
>
> applying such thing would need a long list of __if and else__ statements for everyone of the conditions we want to apply , __Thus we use the `Strategy` Pattern__

![image-20201124221510875](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201124221510875.png)

![image-20201124221530855](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201124221530855.png)

![image-20201124221801220](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201124221801220.png)

> in the `Gang of Four`

![image-20201124221656264](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201124221656264.png)

## the difference between the `state` and the `strategy` Pattern

> we use both of these Patterns to change the bihavior of an Object .
>
> canvas behaves differently based on the `currentTool` we give it .
>
> but in the strategy pattern we don't have a single state , we have __different Behaviors__ which are implemented using different Interfaces .

![image-20201124222112442](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201124222112442.png)

--------------------

## Template Pattern

> lets say we want to build a banking application , and we want to record all the activities , like `Transfer Money` & `Generate Report` & Etc...
>
> like who did what and when , whithin an Audittrail . we want to store this information in an audittrail

![image-20201125194515092](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201125194515092.png)

> in the `Gang Of Four` Book we have bellow :

 ![image-20201125194630372](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201125194630372.png)

--------------------------

## Command Pattern

> lets say we want to build a `GUI` Framework , so Others can use it to create there own GUI Application .
>
> so we have Classes like , `Button` , `TextBox` , etc......

> Problem is , what to do if : *we want an Object (Class) to behave differently , based on where it is used*

> essentially what we want to do is to decouple the `Invoker (Sender)` __From__ `Reciever` .

![image-20201125215509790](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201125215509790.png)

> The Benefits To Use This Command Are :
>
> - Seperate the Sender From the Reciever
>
> - we can pass them around in our code
> - we can store them to a list or database and then execute them one by one
> - we can pass them as an argument of a function
> - the ability to undo

### Undoable Command !

> use it against the `Memento` , When the file size is large or the Cost of the Operation is High .
>
> One of the benefits of using the `Command Pattern` is that you can Undo Them , Like Shown Bellow :

![image-20201125235549891](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201125235549891.png)

 

> is implemented like bellow :

![image-20201126001011617](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201126001011617.png)

> and for the `unexecute()` method we have only the :
>
> ```java
> doc.setContent(prevContent);
> ```

#### So The Schema is Like Bellow :

![image-20201126001224501](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201126001224501.png)

#### NOTE : Commands are the `Links` between `UI Objects` And `Buissiness Objects`

-----------------

## Observer Pattern

> is used when __The State Of An Object Changes , And We Want Other Objects To Be Notified__

![image-20201127040629845](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201127040629845.png)

![image-20201127040706456](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201127040706456.png)

### Observer Pattern (*Different Communicatioins Styles*)

> - `Push Style` { which you already see ( but with a variable that is passed to the `update` method )}

![image-20201127165843791](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201127165843791.png)

> - The Problem with this approach is that it is not `flexible` enough .
> - as it might happen that we change the `value` , or add another `argument` .
> - or each observer may need different types of values .

### Observer Pattern , `Pull Style`

![image-20201127170310979](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201127170310979.png)

> `Definition` : as you see , now the `ConcreteObserver` is coupled to the `ConcreteSubject` .
>
> `But` : this is not a bad type of coupling , because the ConcreteSubject (ConcreteObservable) is not dependent to the ConcreteObserver , its the ConcreteObserver that has a composition relation to the ConcreteSubject (Observable)
>
> `__NOTE__` : in reality what matters is the direction of the coupling , {For Example What We have above is good} , but the reverse of it would be a desaster .

--------------

## Mediator Pattern

> - when we want to collaborate a bunch of objects ( Make Them talk To EachOther Thrugh a `Mediator` or `DialogBox` )
> - `Is An Object (Class)` __That Other Objects Use To Talk To EachOther__
> - so they do not talk to each other directly , they use the Mediator Object for this purpose .
> - `NOTE` : we should use it , when the number of Objects that want to talk to eachOther is large , in this case its note benefitial to use inheritance or other methods .

##### An Example Is Shown Bellow :

![image-20201127183633138](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201127183633138.png)

#### UML

![image-20201127200802519](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201127200802519.png)

#### In `Gangs Of Four`

![image-20201127201132857](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201127201132857.png)

> the only coupling here is the one between the `ConcreteColleague` & `ConcreteMediator` , and this is fine . cause the DialogBox (Mediator) Must know about the UI Object that it contains .

-----------------

##### Using Default Mediator Pattern Like Above Would Intruduce Problems , StackOverflow , For Example :arrow_down_small:

> for example , if in the `ConcreteMediator` implementation , Where it has a reference to every `ConcreteColleague` , we write code like bellow :
>
> ```java
> public class ArticleDialogBox {
>     private TextBox textBox = new TextBox(this);
>     private ListBox listBox = new ListBox(this);
>     public void changed(UIElement element) {
>         if(element == textBox) { // (2) so this is True...
>             listBox.setListBoxTitle(textBox.getTitle()); // Fatal Error goes to (3)
>         } 
>         else if (element == listBox) { // (3) now is True 
>         	textBox.setTitle(listBox.getListBoxTitle())    ; // (4) And StackOverflow !!!
>         }
>     }
>     public void simulateTextBoxChange() {
>         textBox.setTitle("Arash Samandar"); // (1) Thus here goes the trigger
>         System.out.println(listBox.getListBoxTitle());
>     }
> }
> ```
>
> and this is why we can use the Observer Approach...

---------------

## Mediator Pattern ( Using Observer )

> in this approach , the DialogBox (`Mediator`) would play the role of the `Observer` , and every `UIElement` would be the Observable .

![image-20201128214303917](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201128214303917.png)

> for this porpuse :
>
> - first ) *we don't need the abstract class of `DialogBox` aka `Mediator`*
>
>   after that we need classes like bellow :
>
>   ```java
>   public interface EventHandler {
>       void handler();
>   }
>   // and here is the Observable Classes (UI Elements)
>   public class UIElementObservable {
>        private List<EventHandler> eventHandlers = new ArrayList<>();
>   
>       public void addEventHandler(EventHandler eventHandler) {
>           eventHandlers.add(eventHandler);
>       }
>       public void notifyEventHandlers() {
>           for(var eventHandler : eventHandlers) {
>               eventHandler.update();
>           }
>       }
>   }
>   // here goes the definition of the UI Elements that are Observable
>   public class ElementOne extends UIElementObservable {
>       private String content;
>       public void setContent(String content) {
>           this.content = content;
>           notifyEventHandlers();
>       }
>   }
>   // here goes the definition of the Mediator Class
>   public class Mediator {
>       private ElementOne elementOne = new ElementOne();
>       private ElementTwo elementTwo = new ElementTwo();
>       public Mediator() {
>           elementOne.addEventHander(this::caseElementOneChanged);
>           elementTwo.addEventHander(this::caseElementTwoChanged);
>       }
>       public void caseElementOneChanged() {
>           elementTwo.setContent(elementOne.getContent());
>       }
>       public void caseElementTwoChanged() {
>           elementOne.setContent(elementTwo.getContent());
>       }
>   }
>   ```
>
>   

## Two Java Notes

> an interface with only one function ---> is called `Functional Interface` . and would be treated as shown bellow : __Which Is Also Called The `EventHandler`__
>
> ```java
> public interface Observer { // A Functional Interface
>     void update();
> }
> public class something {
>     public myFunctioin(Observer observer);
>     public folanFunc() {
>         //.........
>     }
> }
> // would be written like this
> public class some extends something {
>     public myFunction(new Observer() {
> 		@override
>         update() {
>            // here goes the code
>        } 
>     });
> }
> // the simplified (Lambdas Expression would be like so ....)
> public class some extends something {
>     public myFunction(() -> {});
> }
> // and if it is only one Operation , like one function .
> public class some extends something {
>     public myFunction(() -> yourFunction());
> }
> // the even simpler approach (If you have the function in the same class
> // would be just to reference that function
> // using __this__ keyword
> public class some extends something {
>     public myFunction(this::yourFunction);
>     public yourFunction() {
>         System.out.println("Hello my name is arash samandar");
>     }
> }
> ```
>
> 

----------------------

## Chain Of Responsibility Pattern

![image-20201207070812887](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201207070812887.png)

> and this is it's UML Diagram

![image-20201207071109863](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201207071109863.png)

------------------

## Visitor Pattern

> solves the problem when we want to do an operation for a bunch of classes . so we don't need to rewrite the function in the `interface` for every `class` , ass is the case in bellow example .

![image-20201226184113447](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201226184113447.png)

> another problem with this implementation is that `the code is spread all over the places` , for example if we want to implement a new method in the `interface` called highlight . then every concrete implementation has to has a different implementation . `so the logic for this operation is not in a single place , its spread all over the place`

> solution `using the Visitor` pattern : it seperates the operations .
>
> first the operation is written into an interface , `with different method signatures` , and after that we can implement the concrete `implementation` of these `Operations` . so the `logic` is now `seperated` . and it follows the `Open Close Principle`

![image-20201228104259694](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201228104259694.png)

![image-20201228105647374](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201228105647374.png)

> in the `gang of four Book` here is the UML

![image-20201228105746182](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20201228105746182.png)

---------------------

# `Structural` Design Patterns

-------------------------

## Composite Pattern

> composite pattern solves the problem : when we want to apply an operation to a bunch of classes .
>
> ___Similar to what we have in folders inside folders__ , when we can select multiple objects and apply the operation to them .

![image-20210103182613571](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20210103182613571.png)

> in the `Gang Of Four` Book :

![image-20210103182528588](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20210103182528588.png)

-----------------

## Adapter Pattern

> __we use this pattern to `convert the interface of a class` to a `different form`__

![image-20210103224409248](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20210103224409248.png)

> as we cannot change the source code of the `Caramel` interface , Here `Adapter Pattern` Comes to help . so that we can apply the Caramel Class to our image , by just inheriting a dependecy of it , in our new class which is called `CaramelFilter` and is as expected (Implements the Filter Interface)

> `CaramelFilter` here is the `Adapter` , and `Caramel` is the Adapted .

### Favor `Composition` Over `Inheritance`

----------------------------

----------------------

## Decorator pattern

> `problem` : is when we want to add new `behaviors` to a class , for example we have a class like bellow ,
>
> then we want to add `encryption` , after that we want to add `compression` .
>
> but what to do when we want to do `encryption and compression` .
>
> `solution` : using bellow method , the `EncryptedStream` or `Encrypted` class , dosn't care about the type of the `Stream` , because it implements the `Stream Interface` , so it can operate on any type of `Solid Implementation` of this Stream Class , for example it can work on the `CloudStream` , and etc ....
>
> thus the problem is solved and we don't need to create aditional classes each time , for example we don't need logging , we don't need to first create an Logging with Stream , then a Logging with Encrypted data ... and so on ....

![image-20210104103926423](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20210104103926423.png)

> and in the `Gang Of Four` Book , we have :

![image-20210104104453465](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20210104104453465.png)

--------------

## Facade Pattern

> we use `Facade Pattern` : __provides  simple interface to a complex System__

> for example for sending a message to the user in a mobile app we would have something like bellow 

![image-20210105065310504](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20210105065310504.png)

> here the Main Class has a lot of coupling , now imagin if Message Class or any other of them also has Couplings , this is just too much .
>
> so the aim of the `Facade Pattern` is to `Reduce Coupling` .

> for this reason , we use bellow :

![image-20210105065516400](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20210105065516400.png)

> now the `Main Class` is only `Coupled` with the `NotificationService` , and ofcourse any other class can only be coupled with this `NotificationService` .

#### Facade Means `Front` or `Face`

> so this `NotificationService` is acting as our front of these Operations .

____

## Flywight Pattern

> __a `FlyWeight Is An Object` That We Can Share__
>
> we use this pattern , to save memory .
>
> in this example, as the icon takes too much memory , and we have a solution for it , we take it away from the main 'Point' class , and create a 'PointFactory' class , to know if it is an icon we already have , we don't reproduce it again . the UML for this pattern is as shown bellow :

![image-20210107011434916](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\DP_UML_Summary.assets\image-20210107011434916.png)