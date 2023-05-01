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
```

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




















