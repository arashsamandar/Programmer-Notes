## how to export and import classes

> you use `export`for exporting a class ( later to be used by another class ) .
>
> and in that class we use `import`to import the class .
>
> if the class is exported as default , you don't need to put it in the {} braces , **these are called named exports**
>
> unamed exports just use the **export** front of them .
>
> *Even a function can be exported from a file to another , to later be used* , so these type are named exports . and we use them inside braces {} .

> :pushpin:**NOTE** : *you have to use ES6 and one port for all your `js`files. use type="module" and a server like Wamp for this functionality to work*

**Examples**

```javascript
export default class Person {
    constructor(name) {
        this.name = name;
    }
    walk() {
        console.log(this.name);
    }
}
```

```javascript
import Person from './Person';
// there is no need for {person} , because it is exported
// as default
export function sayhello() { // unamed function exported
    console.log("hello world");
}

export default class Teacher extends Person {
    constructor(name,degree) {
        super(name);
        this.degree = degree;
    }
    walkitalki() {
        console.log(this.name + " " + this.degree);
    }
}
```

**And in the Main app  we have**

```javascript
import Teacher,{sayhello} from './Teacher';

const arash = new Teacher("Arash",18);
console.log(arash);
```

