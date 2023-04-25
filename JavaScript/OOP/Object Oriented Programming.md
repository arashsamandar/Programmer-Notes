## what is an object

> an object is a container values combined to form a single data structure that is a particular identity .

## how to create an object in JavaScript

> the simplest way to create an object in javascript is to use

```javascript
var emptyObject = {};
```

:pushpin:*Or like this*

```javascript
var person = {
    name:"john",
    family:"smith"
};
person.greet = function() {
    return this.name + " " + this.family;
}
alet(person.greeting());
```

> after defining a function we still can add properties to it . eather by simple way like

```javascript
person.surname = "something";
```

> or by using `defineProperty`

```javascript
var obj = {};
Object.defineProperty(obj,'attrib',{
   value : 42,
    writable:true,
    configurable:false // attrib cannot be deleted
});

delete obj.attrib // won't work
```

> creating an object an then assiging it a method like bellow 

```javascript
var person = {
    name:"arash",
    family:"samandar",
    fullname:function() {
        return this.name + " " + this.family;
    }
}
function sayHelloArash() {
    return "Hello from arash";
}
person.greeting = sayHelloArash;
```

## Defining the constructor

> one way is like bellow

```javascript
function person(name,family) {
    this.name = name;
    this.family = family;
    this.address = "";
    this.email = "";
    this.address = "";
    this.displayFullname() = function() {
        return this.name + " " + this.family;
    }
}
```

> now you have to use `new`keyword when creating one , like bellow :

```javascript
var arash = new person("arash","samandar");
```

## Using the Strict mode

> by using `use strict`the `this`would not be available during the execution of the function , because it may lead to unwanted or some property that dosn't exist .
>
> you can not also use `a = 1` , you must use `var`for every variable you declare
>
> it is remonded that you always use `use strict`at the top of you js file .

## using build in object constructor

```javascript
// Remember that {} means new in javascript
var person = new Object();
person.name = "john";
person.family = "smith";

var number = new Object(12);
var string = new Object("test");
var anotherNumber = new Object(2 * 3);
var person = new Object({name:"john",family:"smith"});
```

> *`The flexibily of javascript object is that you can change them after there creation`*

## using `prototype`to change the structure of an specific object

```javascript
var johnSmith = new Person("john","smith");
var mariRossi = new Person("mari","rossi");
Person.prototype.greets = function() {
    console.log("Hello " + this.name + " " this.family);
}
johnSmith.greets(); // says hello to john wick and is now a method of this object ,
// while mari can not access it .
```



:pushpin:**So far we have only created Object using Literals and Method Constructor**

:pushpin:**Creating objects with those methods is not very popular among developers**

## in these examples we will use `classes`

> this method is intruduced in EcmaScript 2015

```javascript
class Person {
    constructor(name,family) {
        this.name = name;
        this.family = family;
    }
    displayFullname() {
        return this.name + " " + this.family;
    }
}

var johnSmith = new Person("john","smith");
johnSmith.displayFullname();
```

:pushpin:*we can even assing a class to a variable*

```javascript
var Person = class {
    constructor(name,family) {
        this.name = name;
        this.family = family;
    }
}
```

> Modular Design & code reuse are among the reasons that we use Object Oriented Programming .

:pushpin:*a language is object oriented if*

![](F:\Programming Notes\Java\Java OOP\assets\modularity.png)

![](F:\Programming Notes\Java\Java OOP\assets\association.png)

![](F:\Programming Notes\Java\Java OOP\assets\modelingproblem.png)

:pushpin:*an example of association ( which means the relationship between to seperate Objects)*

```javascript
function Person(name,family) {
    this.name = name;
    this.family = family;
    this.parent = null;
}
var johnSmith = new Person("john","smith");
var arashSmith = new Person("arash","smith");
arashSmith.parent = johnSmith;
```

:pushpin:*an Example of Aggregation , which an object embed ( has ) another object in use of itself*

```javascript
function Person(name,family) {
    this.name = name;
    this.family = family;
}
var johnSmith = new Person("john","smith");
var mariRossi = new Person("mari","rossi");

var Company = {
    name:"ACME Inc.",
    employees:[],
}
company.employees.push(johnSmith);
company.employees.push(mariRossi);
```

:pushpin:*the relation that the inner object is dependent on the container object , like bellow*

```javascript
var Person = {
    name:"john",
    family:"samandar",
    address:{  // now address is the dependent object and the relation is a composition .
        street:"police",
        city:"tehran",
        country:"iran"
    }
}
```

## Polymorphizm

> like overriding a method is polymorphizm

:pushpin:*Overloading in C#*

```c#
public int sum(int x,int y) {
    return sum(x,y,0);
}
public int sum(int x,int y,int z) {
    return sum(x,y,z);
}
```

:pushpin:*now n javascript we have*

```javascript
function sum(x,y,z) {
    x = x ? x : 0; // x is x if x exist , otherwise it is 0
    y = y ? y : 0;
    z = z ? z : 0;
}
// but in newer version 2015 we have
function sum(x=0,y=0,z=0) {
    return x + y + x;
}
```

## Inheritance in javaScript 2015

```javascript
class Person {
    constructor(name,family) {
        this.name = name;
        this.family = family
    }
}
class Developer extends Person {
    constructor(name,family,knownLanguage) {
        super(name,family);
        this.knownLanguage = knownLanguage;
    }
}
```

