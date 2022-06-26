# Using Try Catch Throw Final

> using  `Try` , `Catch` , `finally`

example One :
```javascript
try {
   alertMe('hello john');
} catch (err) {
   alert(err.message); // error message would be shown in alertbox , since alertMe is not Defined
} finally {
   alert('try again'); // and finally try again would be shown in another alertbox after err.message alertbox.
}
```

> **Important :** using `Throw` with Try and Catch

**very usefull :** we can use `Throw` in try catch blocks , to answer different circumstances .
```javascript
var x;
  try { 
    if(x == "") throw "empty";
    if(isNaN(x)) throw "not a number";
    if(x == undefined) throw "variable is undefined";
    x = Number(x);
    if(x < 5) throw "too low";
    if(x > 10) throw "too high";
  }
  catch(err) {
    alert(err); // would return "not a number" in alertBox
    // or
    alert(err.message); // would return "undefined" in alertBox
  }
```

**See How We Handle Different Scenario with using `throw` instead of `else**`
```javascript
var x = 'samandar';
    try {
        if(x > 10) throw "big number"
        if(x < 10) throw "small number"
        if(isNaN(x)) throw "not a number"
    } catch (error) {
        if(error == "big number") {
            alert("x is bigger than 10");
        } else if (error == "small number") {
            alert("x is lesser than 10");
        } else if(error == "not a number") {
            alert("x is not a number at all");
        }
    }
```

**To Put It Simple**
```javascript
var x;
try {
   if(x == undefined) throw "unde"
} catch (err) {
   if(err == "unde") {
      // do whatever you want now
      alert("variable is undefined");
   }
}
```







