## Seven 7 Primitives in JS

- string
- number
- bigint
- boolean
- symbol
- null
- undefiend

> note that when you pass Objects in JS , it would be by Reference, and you know it means the data could be manipulated

## Some DataStructures in JS

- Arrays
- Sets -> goes to heap memory ( meaning no garbage collection )
- Maps -> goes to heap memory ( no garbage collection )

> of course we can use `weakMap` and etc... to address this

## Asynchronous & MultiThreading in JS

```javascript
// to show multiThreading we could use a CallBack function like :
setTimeOut(function() {
    console.log('folani khoobe')
},5000)
// this approach shows what i'm trying to say with MultiThreading
// but could lead to CallBack Hell,
```

### Thats  Why  We Use `Promises` For MultiThreading

> a __Promise__ is a Wrapper for a Value That it's value is Unknown Right Now , but will __resolve__ to a value in the future .
>
> like maybe a call to a third party API, that will return the data at some point in future
>
> we can use __reject__ if something goes south , to raise an error .

```javascript
const arashPromise = new Promise(
	(resolve,reject) => {
        if(greateSuccess) {
            resolve('success');
        } else {
            reject('failure');
        }
    }
)
```

> you may use __.then__ and __.catch__ to handle these cases with resolve or reject, like bellow code :

```javascript
.then(success => {
    console.log('yay!',success);
})
.catch(err => {
    console.log('oh no!',err);
})
```

### Best  Of  All Is *ASYNC FUNCTION*, That will automatically return a *promise*

> where it will automatically return a promise . and whats more is :
>
> we can use __await__ key to wait for the __promise__
>
> __error hadleling__ , to manage errors always use *Try-Catch* in async functions

```javascript
async function asyncFunc() {
    try {
        const result = await promise;
    } catch(error) {
        console.log(e)
    }
}
```

## `Dynamic Imports` , reduce the page load time by using  Them

> an example would be like bellow , that instead of importing every file at the start of the program . you will use import them when needed __using modules__ and __await__, like bellow :

```javascript
const lazyBundle = await import('./lazy.js');
```

> a good example is bellow :

in the `bahman.js` we have :

```javascript
export const arash = 'hello world';
```

now in the `folan.js` we have :

```javascript
// in some place in our code, we await the import();
// meaning program will load but this piece of code ( functionality )
// will use 'await' to wait for the `bahman.js` to be loaded

const myLaterValue = await import('./bahman.js');
console.log(myLaterValue);
```





