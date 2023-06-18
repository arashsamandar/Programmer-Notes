### Using `bind` method to tie an object to `this`

```javascript
function printThis() {
    console.log(this);
}
const arash = {
    name:'arash'
}
printThis(); // will print window object
// now to bind 'arash' object to it
const itsArash = printThis.bind(arash);
printThis(); // now it prints arash object
```

### *Heap* & *Stack* memory in JS

> `heap` memory is used for objects and such and is dynamic and its size could grow, and there is no special pointer to their address and they may be stored in different places of 
>
> In summary, stack memory is used for storing primitive values and references to objects/functions, while heap memory is used for storing objects and functions themselves. Stack memory is faster and more cache-friendly, while heap memory is more flexible and can allocate memory dynamically.

### Using `bind` & `call`

> well you already know `bind` , and as fo call => it is used when you want to bind an object to this, without needing to create a whole new function .
>
> another benefit of `call` is that you can pass `arguments` to it to work of that this => "which is that object", like bellow :

```javascript
function printOutThis() {
    console.log(this);
}
const jeff = {
    name:'jeffry'
}
printOutThis.call(jeff,1,2,3); // jeff goes as this in bind() method

// but if you where to use 'bind()' method , you where needing another function like bellow

const printOutJeff = printOutThis.bind(jeff);
// but with call we have
printOut.call(jeff)
```

## Method Chaining With `This`

> to do method chaning like
>
> ```javascript
> function Horse(name) {
>     this.name = name;
>     this.poop = function() {
>         console.log('horse shit');
>     }
> }
> const myHorse = new Horse('sparrow');
> // now to chain them to gether we got to use 'THIS' :
> function Horse(name) {
>     this.name = name;
>     this.poop = function () {
>         console.log('horse shit');
>         return this; // this line of code for method chaning
>     }
> }
> let myHorse = new Horse('sparrow');
> myHorse.poop().poop().poop(); // now we can chain using return this
> 
> ```
>
> 