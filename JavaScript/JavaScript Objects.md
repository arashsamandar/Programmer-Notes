# JavaScript Objects

> you can create a simple object just like :
```javascript
var person = {
   firstName : "arash",
   lastName : "samandar",
   age : 50,
   eyeColor : "blue"
};

$('#nameDiv').val(person.firstName);

// Looping Through An Object
for(x in person) {
   $('#myDiv').html(person[x]);
}
```

> Access Nested **JSON Objects**
```javascript
var myObj = {
   "name":"John",
   "family":30,
   "cars": {
   "car1":"Ford",
   "car2":"BMW",
   "car3":"Benz",
   }
}

myObj.cars.car2 // return BMW , or we can use
myObj.cars["car2"] // return BMW again
```
**Changing AND/OR Deleting the Value in Object**
```javascript
myObj.cars.car2 = "MERCEDES";
delete myObj.cars.car2;
```

> json Array Access
```javascript
var myObj, x;
myObj = {
  "name":"John",
  "age":30,
  "cars":[ "Ford", "BMW", "Fiat" ]
};
x = myObj.cars[0]; // returns Ford
```

> Parse a **JSON response** that is comming from a **`Php` file**

use `JSON.parse` for that reason , and then you can use it like an `Object`
```javascript
xmlhttp.onreadystatechange = function() {
   if(this.readyState == 4 && this.status == 200) {
      myObj = JSON.parse(this.responseText);
      document.getElementById('demo').innerHTML = myObj.name;
   }
}
```

## What is Closure

> a function inside another function is called closure

## Defining Getter & Setters

> we know that we can define (protected) memebers ( the members that are only for that object ) with `let` keyword . but how do we read them or set them , we can get them and set them with get and set , just like bellow

```javascript
function Circle(radius) {
    this.radius = radius;
    let defaultLocation = {x:0,y:0};
    this.draw = function() {
        console.log('draw');
    }
    
    Object.defineProperty(this,'defaultLocation',{
       get: function() {
           return defaultLocation;
       }, // now we can access it very easily . like bellow .
       set:function(value) {
           if(!value.x || !value.y)
               throw new Error('Invalid Location');
           defaultLocation = value;
       }
    });
}

const circle = new Circle(10);
circle.defualtLocation; // returns the default location .
circle.draw();
```

:pushpin:**So Getter & Setter with `Object.defineProperty(this,'yourvalue',{`**

**`get:function(){ return yourvalue;`**

**`}`**

**`})`**

## Prototypes and Prototypical Inheritance

> `prototypes means parent`

![](F:\Programmer-Notes\JavaScript\assets\prototypes.png)

> for example when we create an Array , we have two ____proto____ , like bellow . wich reaches to our first prototype , which is our base object .

![](F:\Programmer-Notes\JavaScript\assets\multilevelInheritance.png)

## Using prototype

> we have two kinds of properties and method in javaScript

```javascript
function Circle(radius) {
    // Instance members
    this.radius = radius;
}

// Prototype members
Circle.prototype.draw = function() {
    console.log('draw')
}

const c1 = new Circle(1);
const c2 = new Circle(2);

// we can even overwrite the __proto__ functions , just like bellow

Circle.prototype.toString = function() {
    return 'Circle with Radius : ' + this.radius;
}

console.log(c1.toString());
```

## Create Your Own Prototype Inheritance

```javascript
function Shape() {
    
}

Shape.prototype.duplicate = function() {
    console.log('duplicate');
}

function Circle(radius) {
    this.radius = radius;
}

Circle.prototype = Object.create(Shape.prototype);
Circle.prototype.constructor = Circle;

Circle.prototype.draw = function() {
    console.log('draw');
}

const s = new Shape();
const c = new Circle(1); // extends from Shape prototype .
```

![](F:\Programmer-Notes\JavaScript\assets\proinherit.png)

> so the circle also have the `duplicate`method from the `Shape`

> :pushpin:**NOW Lets say we want the Cirlce to Have the Color property of the Shape**

```javascript
function Shape(color) {
    this.color = color
}
Shape.prototype.duplicate = function() {
    console.log('duplicate');
}

function Circle(radius,color) {
    Shape.call(this,color);
    this.radius = radius;
}

Circle.prototype = Object.create(Shape.prototype);
Circle.prototype.constructor = Circle;

Cirlce.prototype.draw = function() {
    console.log('draw');
}

const c = new Circle(1,'red');

// to make this extends function with Prototypes Simpler , We put them in a Function like :

function extend(Child,Parent) {
    Child.prototype = Object.Create(Parent.prototype);
    Child.prototype.constructor = Child;
}

// Now We Can Use

function Shape() = {};
function Circle() = {};


extends(Circle,Shape);

const c = new Circle();
```

## Using Method Overriding

> sometime the prototype function of the parent is not good enough for the child , thats where we use method Overriding . Override the method that is Defined in the Base Object .

```javascript
function Shape() {
    
}

Shape.prototype.duplicate = function() {
    console.log('duplicate');
}

function Circle() {
    
}

extend(Circle,Shape);

Circle.prototype.duplicate = function() {
    Shape.prototiype.duplicate.call(this); // optional if you want to call Shapes pro too
    console.log('duplicate Circle');
}

// this is polymoriphism at work , so if we have another child called squre with parent Shape we can do

const shapes = [
    new Circle(),
    new Square(),
];

for(let shape of shapes)
    shape.duplicate(); // gives duplicate circle , duplicate square .
    
```

## Mix Two or More Objects Behaviour Into One ( Composition )

```javascript
const canEat = {
    eat:function() {
        console.log('eating');
    }
};

const canwalk = {
    walk:function() {
        console.log('walking');
    }
}

const canSwim = {
    swim:function() {
        console.log('swim');
    }
}

function Person() {
    
}

function Goldfish() {
    
} 

// and we Compose them with bellow Code

Object.assign(Person.prototype,canEat,canWalk);
const person = new Person();
console.log(person);

Object.assing(Goldfish.prototype,canEat,canSwim);
const goldfish = new GoldFish();
console.log(goldfish);

// we can define a function for simplicity of this MIX

function mixin(target,...sources) {
    Object.assign(target.prototype,...sources)
}
```

 ## ES6 Classes

```javascript
class Circle() {
    constructor(radius) {
        this.radius = radius;
        this.move = function() {
            console.log('move');
        }
    }
    
    draw() {
        console.log('draw');
    }
}

const c = new Circle(1);


```

## Static Classes

> static classes are defined wth `static` before them , they can not be called from an instance of a Class , but directly from the Class itself

```javascript
class Math2 {
    static abs(value) {
        //...
    }
}

Math2.abs(5); // will work , but bellow would not .

// bellow would not work
const mathy = new Math2();
mathy.abs(3); // would not work , because "abs is static"

```

## Using Symbol to Declare private Properties that can not be accessed .

```javascript
const _radius = Symbol();
const _draw = Symbol();
const Circle {
    constructor(radius) {
        this[_radius] = radius; // this is a symbol ( private property ),
        // this type is Symbol and can not be accessed outside of this class .
    }
    
    [_draw]() { // it is private and you can not access it outside of this class
        console.log('hello private draw');
    }
}
```

> or you can use WeakMap(); like bellow

```javascript
const _radius = new WeakMap();
const _move = new WeakMap();

class Circle {
    constructor(radius) {
        _radius.set(this,radius);
        
        _move.set(this,() => {
           console.log('move',this); 
        });
    }
    draw() {
        _move.get(this)();
        console.log('draw');
    }
}

const c = new Circle(1);
// now just call c.draw() in the console and see the result .
```

## Defining Getter & Setter In ES6

> it is much easier that what we had in objects , now we just put a `get`or `set` behind a function and function becomes a getter or setter .

```javascript
const _radius = new WeakMap();

class Circle() {
    constructor(radius) {
        _radius.set(this,radius)
    }
    get radius() {
        return _radius.get(this);
    }
    set radius(value) {
        if(value <= 0) throw new Error('invalid radius')
        _radius.set(this,value);
    }
}

const c = new Circle(1);
c.radius = 10; // we can do it because we have a setter .
```

