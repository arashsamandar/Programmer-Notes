

## `NOTE` : in javaScript Functions are Objets

## var & let & const

> variable defined with the `var`keyword are accesible in the Function .
>
> variables defined with the `let`leyword are accesible in the Block .
>
> `const`is also like the `let`, it is accesible inside the block it is defined in .

> > Always Prefer `const`Over `let`, use `let`only when you want to assign it in the block again .

## Objects

> object in javaScript are simply `collection` of `key - value` pairs

```javascript
const Person = {
    name:'Mosh',
    walk() {}, // function
    talk() {}, // function 
}
```

## accesing property of an object when we don't know which property it might be

> we might not know which property is supposed to be accessed , in that case we use `[ ]` like bellow . and if we know which property we want to access we use the `.`notation .

```javascript
const Persone {
    name:'Arash',
    family:'samandar',
    age:31,
}
getPersonValue('name');
// now accesing it in a function when we don't know which value it is
function getPersonValue(value) {
        console.log(Person[value]);
}
```

## Calling a function or getting its reference ( passing its referenc to a variable )

> we call a function when we use `()`, and we pass the reference , when we simply use its name , an example is bellow

```javascript
const Person = {
    name:'Mosh',
    family:'samandar',
    walk() {
        console.log(this);
    }
}
Person.walk(); // calling the function
const walk = Person.walk // passing its reference to walk .
```

:pushpin:**NOTE :** *in javaScript functions are Objects*

> there is a method you can use to pass the `this`, the name of it is `bind`like bellow :

```javascript
const Person = {
    name:'mosh',
    walk() {
        console.log(this);
    }
}
const walk = Person.walk; // calling this function would result in undefined , as this would not point to anything in this case .
const walk = Person.walk.bind(Person); // now "this" refers to Person .
```

## Arrow Functions

> we can write bellow function

```javascript
const square = function(number) {
    return number * number;
}
// like this
const square = (number) => {
    return number * number;
}
// if the body is short and only returns one line we can write it like bellow
const square = (number) => number * number;
// and calling it like
console.log(square(5));
```

#### Now Using Arrow Function for `filter`method .

```javascript
const jobs = [
    {id:1,isActive:true},
    {id:2,isActive:true},
    {id:3,isActive:false},
]
const activeJobs = jobs.filter(function(job) {return job.isActive;})
const activeJobs = jobs.filter(job => job.isActive);
```

## map functions

```javascript
const colors = ['red','blue','green'];
element = document.getElementById('mydiv');
colors.map(function(color) {
    element.innerHTML += '<li>' + color + '</li>';
});

// using Arrow function is way too easier . just like bellow :

colors.map(color => element.innerHTML += '<li>' + color + '</li>');

// using Template Literals , we can even make it simpler ,its a little bit ugly with + sign

colors.map(color => element.innerHTML += `<li>${color}</li>`);
```

> templtate literals are written inside backtick `  charachters , and using dollar sign $ we can put the dynamic value in there . just like the example above .

## Object Destructring

```javascript
// for example we have bellow object
const address = {
    street:'',
    city:'',
    country:'',
};

// so this

const street = address.street;
const city = address.city;
const country = address.city;

// can be written as bellow

const {street,city,country} = address;

// and if you want to change the name of the variable , we have

const {street:st,city:ct,country:cot} = street;

// it is very much like factoring x in an equasion .
```

## Using Spread Operator

> spread operator is `...`three dot . now watch how it works

:pushpin:**There are Two ways to combine Two Arrays**

```javascript
const first = [1,2,3];
const second = [4,5,6];
// using the concat method

const third = first.concat(second);

// or using the Spread Operator

const third = [...first,...second];

// we can use it for cloning an array too

const firstCopy = [...first];
```

> **`Using Spread Operator On Objects`**

```javascript
const first = {
    name:'Mosh',
}
const second = {
    job:'Programmer'
}
const third = {...first,...second,location:'Iran'};

// Cloning an Object

const clone = {...first};
```



### :pushpin:NOTE : that in javascript we can create an Object , without need to create a Class first , but when we want more than one of the Same Object , we create Class .

## Object & Class

```javascript
const person = {
    name:'Mosh',
    walk() {
        console.log("he is walking");
    }
}

class Person {
    
    constructor(name) {
        this.name = name;
    }
    
    walk() {
        console.log("he is walking");
    }
}

const person = new Person("Arash");

// _________________ INHERITANCE _________________

class Person {
    constructor(name) {
        this.name = name;
    }
    walk() {
        console.log("he is walking");
    }
}

class Teacher extends Person {
    constructor(name,degree) {
        super(name)
        this.degree = degree;
    }
    teach() {
        console.log("he is teaching");
    }
}

const arash = new Teacher("Arash",18); // we see that is has it's super class constructor

```

## Modules

> if you see the example above , it is a bit messy . `Modularity`means that we write codes in different files .
>
> and we call each file a `Module`

> we do Modularity by exporting our class to the public , and then we import it wherever we need it .

```java
export class Person {
    constructor(name) {
        this.name = name;
    }
    walk() {
        console.log("he is walking");
    }
}

//________________________________

import {Person} from './person'
export class Teacher extends Person {
    constructor(name,degree) {
        super(name)
        this.degree = degree;
    }
    teach() {
        console.log("he is teaching");
    }
}
```

## named and default modules

```javascript
export function promote() {
    console.log("salam")
}
export default class Person {
    name:"Arash";
    hi() {
        console.log("hello world");
    }
}

// when using default export for a class you don't need to specify it between to braces {} . like bellow

import Person,{promote} from './person';

// we use it only when we have only one object that we want to export .

```

