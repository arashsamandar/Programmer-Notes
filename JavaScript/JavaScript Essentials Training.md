# JavaScript Essentials Training

> Different Primary Data Types In JavaScript
- Number
- BigInt
- String
- Boolean
- null
- undefined
- Symbol
- a variable also can be a function ( see Anonymous Fucntions Section )
use `typeof` to understand which type a `variable` is

---

> Different Types Of Functions In JavaScript
- Named Functions
```javascript
function arash() {
   // do some jobs
   return some;
}
```
- Anonymous Functions , ( they don't have a name )
```javascript
var samandar = function(a,b) {
   var x = a + b;
   return x;
}
// and now calling it would be like :
console.log(samandar(4,7));
```
- Immediately invoked Function Expressions
```javascript
(function(){
   var result = x + y;
   console.log(result);
}(); // because it dosn't have a name () is at the end , to trigger the function

// use with arguments

var firstFraction = 7/9;
var secondFraction = 13/25;
var theBiggest = (function(a,b){
    a > b ? return a : return b;
})(firstFraction,secondFraction)

console.log(theBiggest);
```


> an interesting example of a function that uses the `global` `variable` like it's arguments
```javascript
var a = 10 , b = 20;
function findTheBiggestNumber() {
   a > b ? console.log(a) : console.log(b);
}
findTheBiggestNumber();

// NOTE now if the var a= 10 , b = 20 where under this function , the function would not work
// to make this function independent of the global variable that we defined , use Arguments
// like so :
function findBiggestNumber(a,b) {
   // all the same like above
}
var firstFraction = 3/4 , secondFraction = 5/7;
findBiggestNumber(firstFraction,secondFraction); // or
```

---

> using `const`
```javascript
// for const , you can not change the value of const , after you define it .
const ARASH_FULL_NAME = "arash samandar";
```

> using `Let`  , if you don't want your `local variable` to overlap eachOthers Value , you have to use `Let` , like bellow :
> in other word : if you want to limit the scope of a variable to just one `code block` use `Let`
```javascript
function logScope() {
   let localVar =  2;
   if(localVar) {
      let localVar = "i'm different!";
      console.log("nested localVar : " , localVar);
   }
   console.log("logScope localVar : " , localVar);
}

logScop(); // the result is nested localvar : i'm different , and logScope localVar : 2
// if we used var in both places , we would get the same result for both .
```

---

---

# Objects Definition
> Objects are data Models that allow us to combine properties and methods for specific data set in an structured way

**where are we using object ?**
> for a single title , for example a simple Course with its properties , we can use variable . but if we have a list of courses , we have to use a multi-dimentianal array , and even then it would become hard to manage .

---


## **Create An Object**

Approach One :
```javascript
var Course = new Object();

// these ara like variables of this object . ( or properties )
course.title = "javaScript Essential Training";
course.instructor = "Arash Samandar";
course.level = 1;
course.published = true;
// and etc....
```

Approach Two
```javascript
var course = {
   title : "javascript essential training",
   instructor : "arash samandar",
   level : 1,
   published : true,
   views : 0,
   updateViews : function() {
      return ++course.views;
   }
}
console.log(course.views);
course.updateViews();
console.log(course.views);
```

Approach Three . **Important :** Create With **Constructor**
```javascript
function User(name,family,age,job,level,rate,type) {
    this.name = name;
    this.family = family;
    this.age = age;
    this.job = job;
    this.level = level;
    this.rate = rate;
    this.updateRate = function() {
        return ++this.rate;
    };
}

// now you can create any Object of this type , Using just :
var arash = new User("arash","samandar",30,"programmer",5,958,"Master");
arash.family // return samandar
arash.rate // returns 958
arash.updateRate // return 959

// we can even create an Array of this Object , just like :
var userArrays = new Array();
userArrays = [
   new User("mohsen","yegane",12,"Graphist",2,512,"beginner");
   new User("amir","pashayee",20,"Designer",6,689,"Advanced");
]

console.log(userArrays[0].family) // returns yegane
```

---

## Closures
> basically what closures are , is function ( code block ) inside function , and return the function instead of returning the result to the variable . lets see :
```javascript
function doSomeMath() {
   var a = 5;var b = 4;
   function multiply() {
      var result = a*b;
      return result;
   }
   return multiply;
}

var theResult = doSomeMath() // this theResult now have the entire multiply() function , in it
console.log("the result : ",theResult()) // it would return 20 , strange isn't it :)
```
> NOTE : Closures only work because Browser Detects that this returned function ( the `multiply` is chaned to `doSomeMath` by the used variable a and b wich are insid it .

### the use of Closures
> for example ems in css are difficult to calculate , by using Closures we can make things simpler
```javascript
function giveMeEms(pixels) {
   var baseValue = 16;
   function doTheMath() {
      return pixels/baseValue;
   }
   return doTheMath;
}

var smallSize = giveMeEms(12);
var xlargeSize = giveMeEms(32);

console.log("small size : " , smallSize()) // calculates and returns what you want
console.log("xlarge size : " , xlargeSize()) // calculates and returns what you want
```

---

## Document Object Model ( DOM )
the browser is an object , and the document it displays is an object too .
**Some Functions Of It :**

- `window.innerWidth`
- `window.open`
- window is the top Object in the BOM
![Image](D:\Programming Notes/medley/resources/ByGttDEpV_H1JptTraN.png)

---
## Target Elements In The Dom With QuerySelector

```javascript
document.body; // the body elements
document.title // the title element
documet.URL // the URL element
```

> now for DOM elements
```javascript
// traditionally we used
document.getElementById();
document.getElementByClassName();
document.getElementByTagName();
// but the new way is by using querySelector
// querySelector returns the first element that matches the specified selection
// querySelectorAll which returns the node list of all that match the specified selection
document.querySelector('.main-nav a');
document.querySelectorAll('.post-content p');
```

another example
```javascript
document.querySelector('.main .has-children a');
// this would look and give the first a in the element with class has-children which is in the element with class .main
```

another example
```javascript
document.querySelector(".social-nav a[href*='linkedin.com']");
// any link pointing to linkedin inside the element with the class .social-nav
```

another example
we can use multiple selection , by using comma (,) between them
```javascript
document.querySelectorAll(".menu li a, .social-nav li a");
```

















