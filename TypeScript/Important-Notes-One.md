[TOC]

-------------------

### custome built Type

```typescript
interface Fruit {
    name: string;
    color: string;
    shape?: number;		// note that "?", it says this property is Optional !
    size?: number;		// note that "?", it says this property is Optional !
}

let fruites: Array<Fruit> = [{'apple','green',11}];

// Important : defining optional properties with [optional: any]: any;

interface Person {
    name: string;
    family: string;
    [key: string]: any;
}
// this means for this interface, as it has [key: string]: any; you can define
// as many properties for this interface as you want ( when using this interface )
let arash: Person = {name:'arash',family:'samandar',havij:'solomon',mavij:34}
// define a complete interface ( with fields and methods )
interface Fruite {
    name: string;
    price: number;
    draw:() => void;
}
// Important : making a property of an Object "readonly", so we can't change it later, like :
let user: {
    id: number,
    name: string,
} = {id:1, name:'arash'};
user.id = 2 // it is currect here

// but now to make a property like "id" readonly , we use readonly keyword
// OBJECT TYPE ONNOTATION AND MORE
let user: {
    readonly id: number,
    name: string
} = {id:1, name:'arash'};
user.id = 2 // will give us error now :)

// define function for an Object like bellow :
let user: {
	readonly id: number,
    name: string,
    getDate: (date: Date) => void;
} = {
    id:1,
    name:'arash',
    getDate: (date: Date) => {
        console.log(date);
    }
}

// IMPORTANT : TYPE ANNOTATION WITH OBJECTS
// As above code is a bit messy and hard to read,
// We Define A Type For This "user" Object
type User = {
    readonly id: number,
    name: string,
    getDate:(date: Date) {
    consolel.log(date);
	}
}
let arash: User = {id:1,name:'arash',getData:(name:string) => void}
// you must pay attention to above "arash" Object, take a look how properties are past , take a good look
// another example for clarity
let myFunction = function (person:{name: string,family: string,age: number,printOut:(name:string) => void) // as you see this function name "myFunction", takes an Object as its argument
{
    console.log(person.name + ' ' + person.family + ' ' + person.age);// look how we pointed out the properties of the "person" object inside this function
}

let myPerson = {
    name:'arash',
    family:'samandar',
    age:34,
    printOut:(name:string) => {
        let folani = myPerson.name;
        let bahmani = myPerson.family;
        console.log('Print Out : ' + folani + ' ' + bahmani + name);
    }
}

myPerson.printOut('print out something pall :)');
myFunction(myPerson);

// another complex code : "how to inizialize an optional parameter for the "printOut" method ?"
// pay attention that you can not do
let myFunction = function(persons:{name:string,family:string,printOut:(myName:string = arash) => void });
// above code is an error,myName could be initiazed, Error : "A parameter initializer is only allowed in a function or constructor implementation."

// instead write it like bellow : "define the method in the myFunction function body"
let myFunction = function (
    person:{name: string,family: string,age?: number,getUser:(name: string,family: string,age: number) => void}
) {
    const age = person.age || 0; // default value
    console.log(person)
}



```

> Note About Last Line Of Code :
>
> ```typescript
> const age = Person.age || 0;
> ```
>
> because i've seen using `&&` like :
>
> ```jsx
> { isLoading && <p>Loading...</p> } // if isLoading is true would return Loading...
> ```
>
>  If all operands are true, the operator will return the value of the last operand.
>
> Otherwise, it will return the value of the first falsy operand encountered.
>
> also preserves non-Boolean values and returns them as they are.

#### Function with `Optional Parameters`

```typescript
function fruites(name:stirng,color:string,shape?:string,seize?:string): void {
    console.log(name + color + shape + seize);
}
```

### Note ::star:

#### what if we want to pass `size`, but we don't want to pass argument number 3 or `shape` ?

> one way is to send `undefined` in place of that `argument` , like bellow :

```typescript
fruites('apple','green',undefined,34);
```

> the other more professional way is to `define two signature` of that `function`

```typescript

function printFruite(name:string,color:string): void;
function printFruite(name:string,color:string,size:number): void;
function printFruite(name:string,color:string,size?:number): void {
    let fullMessage = (size ? `${name} ${color} ${size}` : `${name} ${color}`);
    console.log(fullMessage);
}

printFruite('apple','green',34);

// notice that you first 'have to write both signatures' then implement.
```

### Strongly Typed Arrays

```typescript
// first you must know that in typescript we can define new types with 'type'
type Fruites = 'apple' | 'orange' | 'banana';
// now every variable that has it must be of these types only, like :
let arashBeloveFruit: Fruites = 'apple';

// Now In Arrays We Have :
type MyList = [number,string,string];

let folanArray: MyList = [23,'arash','samandar'];

// make them Optional with "?" , like :

type MyArray = [number?,number?,string?];
let marray: MyArray; // you see that we now could define it without initializing cause its optional
```

### Using Type Assertion

```typescript
let message;
message = 'arash samandar' // note that the message type is 'any' cause 
// to get intellisense for the type 'string', use type assertion :
let folanValue = (<string>message).endsWith('r'); // no you get intellisense after dot .
// or
let folanValue = (message as string).endsWith('r');
```

#### never pass so many `parameters` to a function, instead try to use an `object` , like bellow code

```typescript
// the wrong way :
let variable = (a,b,c,d,e,f,g) => {
    // return something
}
// the currect way : ( but can break at runtime if you pass something other than string)
variable({name:'arash',family:'samandar'});
// to solve that too we have ( inline annotation )
let variable = (person:{name: string,family: string}) => {
    // returns something
}
// or you may define an 'interface'
interface Person {
    name: string,
    family: string
}
let variable = (person: Person) => {
    // returns something
}
interface Point {
    x: number,
    y: number,
}
let getDistance = (pointOne: Point,pointTwo: Point) {
    // calculate Distance
}
// now you can use 'Cohesion' meaning related things should go together
// and create a class
```

### Allocate Memory To an object or variable with `new`

> Remember : if you use a `custom object`, but you don't use `new`, javascript ot typescript wouldn't allocate memory to it

```typescript
let folani: People;
folani.printOut(); // if it uses (this) to point to its fileds, you would get error
// unless you use new
let folani = new People(); // now you don't even need to explicitly define it's type
```

### Access Modifiers

> TypeScript has a new way of defining access modifiers in a class so the code would not look redundant

```typescript
class Arash {
    private name: string;
    private family: string;
    constructor(name?: string,family?: string) {
        // initialising them
    }
}
// instead we could write :
class Arash {
    constructor(private name?: string,private family?: string) {
        // initializing them
    }
}
```

### new way of `Getter` & `Setter` in `TypeScript` & `JavaScript`

```typescript
// in javascript you can use "get" and "set" before a method and it becomes
// getter or setter, the benefit it that you can call the private if has setter and call it like a property !
// so we write Classes in ES6 ( TS or JS ) like bellow Arash :
// Remember that using the "_" is a convention, because the getter & sette
// can not have the same name as the properties.
class Arash {
    constructor(private _name?: string,private _family?: string) {
        this._name = _name;
        this._family = _family;
    }
    get name() {
        return this._name;
    }
    set name(namevalue) {
        if(typeof namevalue === 'string') this._name = namevalue;
        else throw new Error('name is not an string');
    }
    get family() {
        return this._family;
    }
    set family(familvalue) {
        if(typeof familvalue === 'string') this._family = familvalue;
        else throw new Error('name is not an string');
    }
    printOut() {
        console.log(this._name + ' ' + this._family);
    }
}

let newarash = new Arash();
newarash.name = 'arash';
newarash.family = 'salamander';
newarash.printOut();
```

> a complete example with the use of `_` underline as convention

## Debugging TypeScript

### Note For VSCode & Others ( Not webstorm )

> #### For this porpuse
>
> - *First* : if you don't have `typescript` you first install it with `npm --global install typescript`
>
> - *Second* : you must install `npm install --save-dev ts-node`
>
> - *Third:* you must make sure that you ran `tsc --init`, this will create the `typescript config file`, witth the name of `tsconfig.json`
>
> - *Fourth* : in typescript tsconfig.json, uncomment mapping by `sourceMap: true`, this will create the `filename.ts.map` which is for  `debug` porpuses,
>
> - *Fifth* : create `launch.json` file and write or put next line :
>
> - ```
>   "preLunchTask": "tsc build - tsconfig.json"
>   ```
>
>   now you can put `break points` and debug in `VSCode`

-------

## Types In Javascript & typescript

`JavaScript Types` : number, string, boolean, object, null, undefined

`TypeScript Added Types` : any, unknown, never, enum, tuple

---------

## The Problem

> Note bellow code and how it Throws an error. despite the fact works in javascript

```typescript
let arash = new Object();
arash.name = 'samandar';	// this line throws error ( property name doesn't exist )
```

#### now resolve it with `index types`

## Index Types

> to dynamically assign properties to an object in TypeScript.
>
> An index type allows you to define an object that can accept fields with any string as key and any type as value

## Tuples

> Tuples are `Arrays` with `special types`, like bellow :

```typescript
let user:[string, number] = ['arash',34]
```

> Tuples are only good when we have `key value` pair ( meaning only two values ), anything more that would make your code confusing .

## Default Parameter

```typescript
function calculate(income: number,year?: number); // year is optional
// we can also write it like this which i think is a lot better
function calculate(income: number,year = 2023) // now if you don't give it year , year would be 2023
```

---------

## Defining & Destructuring Objects

> we can define object ( and like other values we give it type , like bellow :)

```typescript
let employee: {
    id: number,
    name?: string,
} = {id:1, name:'arash'};
// name is optional and we can define it or not define it .

// IMPORTANT EXAMPLE OF OBJECT DESTRUCTURING IN JS AND TS
const User = {
    name:'arash',
    family:'samandar',
    someprop:{
        havij:'SALAMANDER',
        falili:'something else'
    },
    returnProperties:() => {
        return User.someprop;
    }
}
const { someprop:{havij} } = User;
console.log(havij);
// or use the method `returnProperties` for this purpose and write
// bo
const { havij } = User.returnProperties();
```

## Using Rest Parameter `...` for the Arguments of a Function

> In TypeScript, the rest parameter syntax allows a function to accept an indefinite number of arguments as an array

```typescript
// Important : when you define `...` for the arguments of a function
// Important : then you must treat it as such, like folaniFunc(...myArray);
let printNumbers = function(...args: number[]) {
    args.forEach(arg => {
        console.log(arg);
    })
}
let myNumberArray: number[] = [6,7,3,2];
printNumbers(...myNumberArray);

// In above example, we have defined the type of the args parameter explicitly as an array of number type.
//****We have also spread the myNumberArray array into separate arguments using the spread syntax (...)****.

// IMPORTANT : if you use it like => printNumbers(myNumberArray), you will get error
printNumbers(myNumberArray); // This Is Error

// ----------------------------------- Another Example -----------------------------------
function calculateAverage(...numbers: number[]) {
    let total = 0;
    numbers.forEach((num) => total += num);
    return total / numbers.length;
}

console.log(calculateAverage(1,2,3,4));
```

-----------

## Union Types

> to give a function more than one type ! use it with `|`

```typescript
function kgToLbs(weight: number | string) {
    try {
        if(typeon weight === 'number') throw 'type is a number'
	    else if(typeof weight === 'string') throw 'type is a string'
    }catch(err) {
        if(err == 'number') console.log('variale is a number');
        else if(err == 'string') console.log('variable is a string');
    }
    
}
// or to have different outputs :
type Customer = {
    birthday: Date
};

function getCustomer(id: number): Customer | null {
    return (id === 0) ? null : {birthday: new Date()}
}
```

---------

## Type Intersection In TS

> is like extending from two interface.

```typescript
type draw = {
    drawing:() => void;
}
type resize = {
    resizing:() => void;
}
type UI = draw & resize;

let textbox:UI = {
    drawing() {
      console.log('draw the UI');  
    },
    resizing() {
        console.log('resize the UI');
    }
}
```

---------

## Optional `?` Chaining To Ensure The returny is not `Undefined` or `Null`

```typescript
type Customer = {
    birthday?: Date
};

function getCustomer(id: number): Customer | null | undefined {
    return (id === 0) ? null : {birthday: new Date()};
}

let customer = getCustomer(0);

// Now as the getCustome(0) might return null for birthdate ( which it will )
// For This Case We Use `?` before 'birthday` property of the customer object to check for null
// only returns when "birthday" is not null with :

console.log(customer?.birthday);

// or calling getFullYear() of a Date object ( which if birthday is null will give us error !)
// so

console.log(customer?.birthday?.getFullYear());

// so ".?" checks null and undefined before calling for a property or method
```











