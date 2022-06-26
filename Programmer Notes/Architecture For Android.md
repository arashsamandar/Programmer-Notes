# Architecture For Android

> in the context of **design patterns for mobile architecture ,** we have sevelar approaches
1. **MVC** , wich is the default architecture for android , known as `model` `view` `controller`
1. **MVP ,** known as `model` `view` `presenter`
1. **MVVM ,** the only difference between `MVVM` and `MVP` is that we use something called `Data Binding`
1. **Viper ,** view , interactor , presenter , entity , router
1. **MVA ,** wich stands for : minimum viable architecture
> **Data Binding :** it means the view changes something , and then a `listener` or a `delegate` , a closure , a method block of  some kind , is triggered within the **MVVM** class .
> also , when the data beneath the mvvm changes , another listener is triggered within the view
```java
// what we do is first we create the cell wich we need .
// after that we should create our ArrayAdapterList , wich we would create it .
// AdapterView is basically a layer between data and the view , wich populates the view with the data .
// so we create and paste our ListView , and with a ListView we gotta have an Adapter , like so .
ListView listview = findviewByID(R.id.folan);

```

