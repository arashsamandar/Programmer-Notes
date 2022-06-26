[TOC]

## Strategy Design Pattern

#### :warning:Program Through Interface NOT Implementation

> use **Composition Over Extention** , `Has-A is better than IS-A`

> in bellow example first we create the *FlyBihaviour & QuackBehavior* , then we implement them in classes Like *FlyNOWings & Quack* .
>
> And after that we create a  `pubic abstract class Duck` and we compose them ( use them ) inside this class . now look bellow :bell:

```java
public interface FlyBehavior {
    public void fly();
}
```

```java
public interface QuackBehavior {
    pubic void quack();
}
```

> then we have

```java
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I Can't Fly");
    }
}
```

```java
public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}
```

> then we have the abstract Duck class

```java
public abstract class Duck {
    
    FlyBehavior flybehavior;
    QuackBehavior quackbehavior;
    
    public Duck() {}
    
    public void setFlyBehavior(FlyBehavior fb) {
        flybehavior = fb;
    }
    public void setQuackBehavior(QuackBehavior qb) {
        quackbehavior = qb;
    }
    
    abstract void display();
    
    public void performFly() {
        flybehavior.fly();
    }
    
    public void performQuack() {
        quackbehavior.quack();
    }
    
    public void swim() { // every ducks swim
        System.out.println("All Ducks float , Even decoys");
    }
}
```

> Now we can extend this class for Our Duck models .

```java
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    public void display() {
        System.out.println("I'm a real  Mallard Duck");
    }
}
```

```java
public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeek();
    }
    public void display() {
        System.out.println("i'm a rubber duckie");
    }
}
```

> Now in the Real Application we have :bell:

```java
public static void main(String[] args) {
    MallardDuck mallard = new MallardDuck();
    ModelDuck model = new ModelDuck();
    
    mallard.performQuack();
    mallard.performfly();
    
    model.performFly();
    // it print i can't fly
    model.setFlyBehavior(new FlyRocketPowered());
    model.performFly(); // now it flys
}
```

---------------------

------------------------

## Observer Pattern

> **The Observer Pattern :** defines a One-to-many dependency between objects so that when one object changes state , all of its dependents are notified and updated automatically

>they are two types of Observers , pull and push . one that the publisher pushes the information . one that the dependet gets the information itself .

![](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Design Patterns_Foundation Of Programming.assets\onetomany.png)

Whatch This : D:\Education\Lynda\Foundation Of Programming & Databases\Lynda.Foundations.Of.Programming.Design.Patterns.Full_p30download.com\03. The Observer Pattern\03. Understanding the observer pattern.mp4

> first we create the **Observer** & **Dependeent** `Inteface`

```java
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
```

```java
public interface Observer {
    public void update(float temp,float humidity,float pressure);
}
```

> after that we write these classes using the above interfaces

```java
package com.arash.samandar;

import java.util.ArrayList;

public class TempClass implements Subject {

    public float temp;
    public float pressure;
    public float humidity;
    public ArrayList<Observer> observers;

    public TempClass() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(int i=0;i<observers.size();i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(temp,pressure,humidity);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temp,float humidity,float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemp() {
        return temp;
    }
}
```

> now the **Dependent Class**

```java
package com.arash.samandar;

public class CurrentCondition implements Observer,Display {
    private float tempreture;
    private float humidity;
    private Subject subject;

    CurrentCondition(Subject weather) {
        this.subject = weather;
        weather.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.tempreture = temp;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("current condition humidity is : " + this.humidity);
    }
}
```

> Now in Them **Main** Application we Have :bell:

```java
public class Main {
    public static void main(String[] args) {
        TempClass tempClass = new TempClass(); // initiazized the Observers ArrayList
        CurrentCondition currentCondition = new CurrentCondition(tempClass); // gets the Subject and registers itself as One of the Observers .
        tempClass.setMeasurements(23,43,54);
    }
}
```

-----------

--------------

## Decorator Pattern

> Lets Design a coffee shop . ofcource we have a lot of coffee types , but they also have ***decorator like Milk , soy , whip and etc...** and they have an effect on the cost of the coffee

![](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Design Patterns_Foundation Of Programming.assets\coffe.png)

![](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Design Patterns_Foundation Of Programming.assets\milk.png)

> this is an explosion of classes , so lets take a look at a different `Design` :bell:

![](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Design Patterns_Foundation Of Programming.assets\decoy.png)

> we add or set things and then compute its cost  .
>
> but all this depends on the cost method in each Beverage Subclass

```java
if(hasMilk()) {
    cost += .10;
}
if(hasSoy()) {
    cost += 20;
}
if(hasWhip()) {
    cost += 10;
} // and so on it goes ....
```

> > :warning:**Design Principle #5** : Classes should be open for extension but clsoed for Modification

> meaning Design your code so you can add new behavior but without touching the class .

### Lets Redesign with Decorator 

![](D:\Programming Notes\Design Patterns & Laravel DesignPatterns\Design Patterns_Foundation Of Programming.assets\decorator.png)



> ***The Decorator Pattern :*** attached additional responsibilities to an Object dynamically . Decorators provide a flexible alternative to subclassing for extending functionality .

### Implementation

> now lets look at the ***the Beverage Class***, Both the Coffee Classes and There Condiments ( like Milk and so on ... ) extedn it :

```java
public abstract class Beverage {
    public String description = "Unknown Beverage";
    
    public String getDescription() {
        return description;
    }
    
    public abstract double cost();
}
```

> now an example Beverage is :

```java
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }
    public double cost() {
        return .89;
    }
}
```

> now for Condiments we have

```java
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
```

> Now the Milk which is a CondimentDecorator

```java
public class Milk extends CondimentDecorator {
    Beverage beverage;
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + " , Milk";
    }
    pubic double cost() {
        return beverage.cost() + .10;
    }
}
```

#### Now In The Main Method We Have :bell:

```java
public static void main(String[] args) {
    
    Beverage beverage = new HouseBlend();
    beverage = new Milk(beverage);
    beverage = new Soy(beverage);
    
    System.out.println(beverage.getDescription() + " $" + beverage.cost());
}
```

## Top 5 Important Desing Patterns

- > `Singleton`

- > `Facade`  like a compiler can be a facade

- > `Bridge OR Adapter`  like a camera & it's lenz . you can detach and attach different .

- > `Strategy` 

- > `Observer` OR `PUBSUB` , acronym for __publisher__ - __subscriber__

