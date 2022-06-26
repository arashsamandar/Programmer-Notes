# JavaScript Array

### Array functions
1. `instanceOf`
```javascript
var fruits = ['banana','apple','orange'];
if(fruits instanceof Array) { // returns true
}
// or
Array.isArray(fruits); // return true
```

2. `push` The array.push("something") method appends a new Element to the `end` of an array
2. `unshift()` the array.unshift("something") method appends a new Element to the Beginning of an array
3. `pop` the array.pop() method removes the `end` element of an array
3. `shift` the array.shift() method removes the `beginning` element of an array
4. `join` the array.join("_") method joins array elements into a string , like :
```javascript
var fruits = ["Banana", "Orange", "Apple", "Mango"];
var str = fruits.join(" * "); // now str is Banana*Orange*Apple*Mango
```

5. `concat` the arrayOne.concat(arrayTwo) `or` arrayOne.concat(arrayTwo,arrayThree) is used to join arrays together .

6.  `slice` The slice( ) method copies a given part of an array and returns that copied part as a new array

7. `splice` removes values at certain indexes , like :
```javascript
var arash = new Array();
arash = [1,2,3,4]; // how to remove element 3 in this array ?
arash.splice(arash.indexOf(3),1); // starts from index of element 3 and cuts one !
arash; // [1,2,4];
```

8. `toString` , array.toString() , converts array to string

---

### Iterating Throgh an Array
1. `forEach` , using array.forEach(yourFunction());
```javascript
var myArray = ['Apple','Orange','Banana','PineApple','Kiwi','Tomato'];
var newArray = new Array();
myArray.forEach(myOperationOn);

function myOperationOn(value,index,array) {
    if(value.toLowerCase().indexOf('o') != -1) {
        newArray.push(value);
    }
}
newArray; // is ['Orange','Tomato'];
```

2. `map` Creates a new Array by performing a function on each array element
```javascript
var array = new Array();
var arrayTwo = array.map(myFunction);
function myFunction(value,index,array) {
   ((value % 2) == 0) ? return value : return 0;
}
```

3. `filter` Creates a new array with all array elements that passes a test.
```javascript
var numbers = [45, 4, 9, 16, 25];
var over18 = numbers.filter(myFunction);
function myFunction(value, index, array) {
  return value > 18;
}
```

4. `reduce` used in this example to get the sum of all array Elements
```javascript
var numbers = [23,12,11,65,30,85];
var sum = numbers.reduce(myFunction);
function myFunction(total,value,index,array) {
   return total + value;
}
```

5. `every` and `some` function of array : these two basically return `true` or `false` , writing them is like above, but for `every` it would check the situation for every element in the array , if the situation for every element is right the `var check = myArray.every(myfunction());` the check would be true , for some it is not necessery that condition be right for all , just one is enough .

6. `find`  or  , very usefull if you want to find something with some circumstances in an array
```javascript
var numbers = [4, 9, 16, 25, 29];
var first = numbers.find(myFunction); // returns the first one , 25
function myFunction(value, index, array) {
  return value > 18;
}
```















