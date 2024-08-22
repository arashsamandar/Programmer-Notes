## Closures & Their Use :

> `Closures` in javascript , are like a toolbox with all of the neccesary materails they need to function. that is indeed what a `closure` means in javascript .
>
> we use `Closures` to encapsulate ( __Close__ ) the variables and methods of a functions surrounding scope ( block ). as closures remember the pointer to those variables , consts or methods . ( in the context of their parent ( which they were called from ))

examples :

```javascript
function returnSomeFunction(){
    const arashNumber = 10;
    return function addTwoVariables_plusParentConst(a,b){
        return (a+b + arashNumber);
    }
}

const myPlusTenFunction = returnSomeFunction();
console.log(myPlusFunction(2,4)); // returns 16
```

using it in `Memoize` :

```javascript
function memoize<ThisArg = any>(fn: Function){
    const cache: {[key:string]:any} = {};
    return function (this:ThisArg,...args:any[]){
        const keys = JSON.stringify(args);
        if(keys in cache){
            console.log('cached version \n');
            return cache[keys];
        }else{
            const result = fn.apply(this,args);
            cache[keys] = result;
            return result;
        }
    }
}

const myMultiplyingFunction = memoize((a:number,b:number)=>{
    return (a*b);
})

console.log(myMultiplyingFunction(4,5)); // does the operation
console.log(myMultiplyingFunction(4,5)); // returns the cached version from `const cache` we defined
```

