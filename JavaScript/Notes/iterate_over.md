#### how to iterate over arrays , including simple arrays and arrays of objects

> there are two methods , one is __for...in__ loop

```javascript
let newArray = [1,2,11,4,5,6];
// now iterate over the simple array with for(let i in newArray)
for(let i in newArray) {
    console.log(newArray[i]);
}
```

> second is __for...of__ loop, like bellow

```javascript
const obj = {a:1,b:2,c:3}

for(let prop of Object.keys(obj)) {
    console.log(`${prop} : ${obj[prop]}`);
}
```

> third is Object.entries() method: This method returns an array of all enumerable properties of an object, each represented as an array with two elements - the property name and its value. You can then use a for...of loop to iterate over the array. Here is an example:

```javascript
const obj = { a: 1, b: 2, c: 3 };

for (let [prop, value] of Object.entries(obj)) {
  console.log(`${prop}: ${value}`);
}

```

> This will output the same result as the previous examples