## Variable Types

> we have two type of `variable`types in javaScript , **Primitive & Reference**

![](F:\Programming Notes\JavaScript\JavaScript For Beginners\assets\variableTypes.png)

 

![](F:\Programming Notes\JavaScript\JavaScript For Beginners\assets\referenceTypes.png)

:pushpin:**An exapmle of Reference Data type**

```javascript
let person = {
    name:'arash',
    age:30
}
```

> we can reference an object property by using the `dot`notation , or by using the brackets ( when we don't know the name for example , we use brackets then )

```javascript
let person = {
    name:'arash',
    age:30
}
console.log( person.name );
// or
let selection = 'age';
console.log( person[selection] );
// or directly .
console.log( person['name'] );
```

> **Arrays & Functions are also Objects , and can be behaved like one .**

> you can use `typeof`before them , to see that it shows object . 

> we can call a function by : `myfunction()` , or we can give its Reference by `myfunction`

## Two Types of Equality Operator

> we have `==`which is called , // loose Equality
>
> we have `===`which is called , // Strinct Equality
>
> **NOTE** : we use the second one , because it checks Both the value and the type to be equal .

## Using For Loop in JavaScript

> first one is the simple for

```javascript
for(let i=0;i<10;i++) {
    console.log('hello world');
}
```

> for ... In

```javascript
const person = {
    name:'arash',
    age:30
};

for(let key in person) {
    console.log(key); // one is "name" , the other is "age"
}

for(let key in person) {
    console.log(key,person[key])
}

const colors = ['red','greed','blue'];

for(let index in colors) {
    console.log(index,colors[index]);
}
```

> for...of  , wich is the newer version of for....In

```java
const colors = ['red','greed','yellow'];

for(let color of colors) {
    console.log(color);
}
```

> **NOTE : we use for...in loop to iterate over the props of an Object , and for...of , to iterate through an Array**

## Factory Functions

> Farctory functions create functions ( they are used when we need more than one instance of an Object )

```javascript
function createCricle(radious) {
    return {
        radious,
        draw() {
            console.log('hello circle')
        }
    };
}

const circle1 = createCircle(1);
console.log(circle1); 
     
```

## Constructor Function

> despite the factory functions , this constructor functions doesn't use return .

```javascript
function Circle(redious) {
    this.radious = radious;
    this.draw = function() {
        console.log('Draw');
    }
}

const circle = new Circle(1);
```

## Functions are Objects

## An Important NOTE

> `primitives are copied by their` **Value**
>
> `Object are copied by their` **Reference**

> we use `delete` to delete a member from an Object , like bellow

```javascript
const circle = {
    readius:1,
};

circle.color = 'yellow';
circle.draw = function() {
    console.log('draw');
}

delete circle.color;
delete circle.draw;

console.log(circle);
```

## using Object.keys & Object.entries

> Object.keys returns all the properties of an Object , so we can use for...of ( which we used for iterable like Arrays ,, for Object ) . like bellow :

```javascript
const circle = {
    radius:1,
    draw() {
        console.log('draw');
    }
};

for(let key of Objects.keys(circle)) {
    console.log(key,circle[key]);
} // gives back radius and draw and there value .
```

> Object.entries returns the key:value pair altogether .

```javascript
for(let entry of Object.entries(circle)) {
    console.log(entry); // returns all key:value pairs .
}
```

> check if a property exists in an Object , like bellow 

```javascript
if('radius' in circle) console.log('yes');
```

## Cloning an Objec in JavaScript

```javascript
const circle = {
    radius:1,
    draw() {
        console.log('draw');
    }
};

const another = Object.assign({},circle);
console.log(another);

// we can also assing other new properties when cloning , like bellow

const another = Object.assign({color:'yellow'},circle);
```

> > but the easiest way to clone an Object is to use (...)

```javascript
const another = {...circle};
```

## Strings

> you can build String in two ways

```javascript
// String primitive
const message = 'this is my first message'; // the constructor is string
// String Object
const another = new String('hi this is second example');// the constructor is Object

// some of string functions
message.length;
message.includes(''); // to check for a word
message.startsWith('');
message.endsWith('');
message.indexOf(''); // returns the position of the searched literal .
message.toUpperCase();
message.toLowerCase();
message.trim();
message.trimLeft(); message.trimRight();
const newString = message.replace('first','second'); // to replace
const myArray = message.split(' '); // returns ['this','is','my','first','message'];

// we have also special charachters ,
// for example to put \ in an Strng we write \\
// or \n or \'
```

## Template Literals

> so far we have

- Object   `{}`
- Boolean  `true`,`false`
- String   `''`,`""`
- Template Literals   ``

> template literals help us write our `String`better . so we don't need a backslash like \\\ or \n or \\'

> to show a variable in template literals we use dollar sign `${}` , like `${arash}` , which arash is a variable , we can also put mathematical expressions in here `${2 + 3}` , we can even call a function inside there .

## Date Object

```java
const now = new Date(); // number in miliseconds
const dateOne = new Date('May 11 2008 09:00'); // number passed since this date .
const dateTwo = new Date(2018,4,11,9);

now.setFullYear(2017);
now.setMonth(); now.setHour();

now.toDateString() // "thu May 11 2017";
now.toTimeString();
now.toISOString(); // this is the standar version .
```

## Arrays in JavaScript

> **Notice that although we declare array here in const , it dosn't stop us from manipulating it**

```javascript
const numbers = [3,4];
numbers.push(5,6); // adds at the end
numbers.unshift(1,2); // adds to the start

// to remove an element in a specific position use "splice"

numbers.splice(3,1); // removes one at the position 3 .

numbers.indexOf('a'); // if there is not an element returns -1
numbers.lastIndexOf(1); // returns the last position where there is a 1

// we can also use

numbers.includes(1);

```

## finding Refence Types

```javascript
var array1 = [1,2,3,4,5,6,12,14];
var found = array1.find(function(element){
   return element > 10; // we shall return a boolean .
    // stops at first find , meaning for 12 returns true and ends .
});

const courses = [
{id:1,name:'a'},
{id:2,name:'b'},
];

courses.find(function(course){
   return course.name === 'a'; 
});

// Arrow Function

const course = courses.find(course => {
    return course.name === 'a';
});

// we can even write it like bellow

const course = courses.find(course => course.name === 'a');
```

## Truncate an array

```javascript
let numbers = [1,3,4,5,6];
numbers = [];

// solution Two

numbers.lenght = 0;

// solution three

numbers.splice(0,numbers.lenght);

// solution four
while(numbers.lenght > 0)
    numbers.pop();
```

## Combining and Slicing Two Arrays

```javascript
const first = [2,3,4,5,6];
const second = [9,8,7];

const combined = first.concat(second);

// slice an array in two or more

const slice = combined.slice(2,4);

// combining Objects . object would we combined by there address . meaning 
const first = [{id:1}];
const second = [4,5,6];

const combined = first.concat(second);
first[0].id = 10;
const slice = combined.slice();
console.log(combined); // we get 0:{id:10} , 1:4 , 2:5 , 3:4 

// Another way Of Combining Two Arrays With "Spread Operator"

const combined = [...first,...second];

// Cloning ( Copying ) An Array Using "Speard Operator"

const copy = [...combined];

```

## Iterating Over An Array

```javascript
const numbers = [1,3,4,55,6];

for(let number of numbers) {
    console.log(number);
}

// Another way is ForEach

numbers.forEach(function(number){
   console.log(number); 
});
// Like
number.forEach(number => {
   console.log(number); 
});
// or Like
numbebrs.forEach(number => console.log(number));

// or we can even use the index like bellow ( with two arguments )
numbers.forEach((index,number) => console.log(index,number));


```

## Join Array

```javascript
const numbers = [1,2,3];
const myString = numbers.join(",");

// the oposite of Join in Arrays , is Split in Strings

const message = "this is my message";
const partsArray = message.split(' ');
```

## Sorting Array

> we use `sort`method to accomplish this like bellow

```javascript
const numbers = [3,4,1,7];
numbers.sort();

numbers.reverse();

// sorting an array of Objects
const courses = [
    {id:1,name:'Node.js'},
    {id:2,name:'JavaScript'},
];
// sort this array based on there name , so javascript should come before Node.js

courses.sort(function(a,b){
   // a < b => -1
    // a > b => 1
    // a === b => 0
    
    const nameA = a.name.toLowerCase();
    const nameB = b.name.toLowerCase()
    
    if(nameA < nameB) return -1;
    if(nameA > nameB) return 1;
    return 0; // if they are equal
    
});

```

## Using every & some

```javascript
const numbers = [1,2,4];

const allPositiveBoolean = numbers.every(function(element) { // returns either true or fale
   return value >= 0; // if every element is true in here , returns true, otherwise false
});

// "Some" method , is the same , but suffice with only one true .
```

## Filtering An Array

> this is filtering an array based on a condition , it has `(value,index,array)`Arguments . we work with value in this example

```javascript
const numbers = [1,-1,2,3,4];

const filteredArray = numbers.filter(function(value) {
   return value >= 0; 
});

const filteredArray = numbers(value => {
   return value >= 0; 
});

const filteredArray = numbers.filter(value => value >= 0);


```

## Map & Filter

> another powerfull method that we have is the `map`method , with this method we can convert our array into something elese

```javascript
const numbers = [1,-1,2,3,4];

// map this array to an HTML

const items = numbers.map(number => '<li>' + number + '</li>');
const html = '<ul>' + items.join('') + '</ul>';

// map them to Objects now

const items = numbers.map(number {
       return {value:number};
});

// or like
// if you are converting them to an object you should put them in prantaces like bello for value:number

const items = numbers.map(number => ({value:number}))
```

> > we can also chain them ( filer & map ) together .
> >
> > when you want to create an object out of it in map , you should put it in parntece bef 

```javascript
const numbers = [1,-2,3,4,5];
const items = numbers.filter(number => number >= 0).map(num => ({value::num}))
// Chaining them together
const items = numbers
      .filter(n => n>=0)
      .map(n => ({value:n})
      .filter(obj => obj.value > 1)
       .map(obj => obj.value);
```

## Reduce Method

> reduce method is good for summing up all the elements in an array , like bellow :

```javascript
const numbers = [1,-1,2,3];

const sum = numbers.reduce((accumilator,currentValue) => {
    return accumilator + currentValue;
},0);

// or Write Like This

const sum = numbers.reduce((accumilator,currentValue) => accumilator + currentValue);
```

## Functions In JavaScript

> Function Decleration

```javascript
function walk() {
    console.log('walk');
}
```

> Function Expression

```javascript
// Anonymous Function Expression
let run = function() {
    console.log('run');
};

run();

let move = run; // both move and run are referencing the same function .
```

> one of there difference is we can call the function declaration before it is initialized , but we can not do so with the Function Expression .

> :warning:Every Function in javaScript has an special Object called `arguments`

```javascript
function sum(a,b ) {
    console.log(arguments);
    return a + b;  
}
// by using this function we can pass az many Arguments as we want .
function sum() {
    let total = 0;
    for(let value of arguments) {
        total += value;
    }
}

console.log(sum(1,2,3,4,5));
```

> :warning:Using the `Rest` Operator `...` 

```javascript
function sum(...args) {
    args.reduce((a,b) => a + b); // a = accumilator , b = currentValue
}

// Another Example

function(discount,...prices) {
    let total = 0;
    const total = prices.reduce((a,b) => a + b);
    return total * ( 1 - discount );
}
```

## Default Parameters

```javascript
function interest(principal,rate = 3.5,years =5) {
    
}
```

> > :warning:if you give one parameter a default value , the next parameters should also have default value .

## Getters & Setters

```javascript
const person = {
    firsNama:'arash',
    lastName:'samandar'
};

console.log(`${person.firstName} ${person.lastName}`);

const person = {
    firsNama:'arash',
    lastName:'samandar',
    fullName() {
        return `${person.firstName} ${person.lastName}`
    }
};

// Using Getters & Setters

const person = {
    firstName:'arash',
    lastName:'samadnar',
    get fullName() {
        return `${person.firstName} ${person.lastName}`
    }
    
    set fullName(value) {
        const parts = value.split(' ');
        this.firstName = parts[0];
        this.lastName = parts[1];
    }
}

person.fullName = 'john Smith';
```

> :warning:**NOTE : To define Getters & Setters , just put get or set , before a function in an Object** , as easy as that

## Error Handling

```javascript
const person = {
    firstName:'arash',
    lastName:'samandar',
    set fullName(value) {
        if(typeof value !== 'string')
            throw new Error('value is not a string');
        
        const parts = value.split(' ');
        if(parts.lenght !== 2)
            throw new Error('Enter a First & Last Name');
        
        this.firstName = parts[0];
        this.lastName = parts[1];
    }
};

try {
    person.fullName = null;
} catch(e) {
    alert(e);
}
```

