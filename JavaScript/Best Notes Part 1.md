# Best Notes Part 1

`NOTE` : One Important Thing You Should Know First Is :
> `Jquery` Does Not Support Everything .
>  So a Lot Of Our Script , Does Not Have `Jquery` in it

> Difference Between Selecting With `JQuery` And Selecting With `JavaScript`

```javascript
// Return Element With ID = id01
var myElement = $("#id01");
var myElement = document.getElementById("id01");

// Return All <p> elements
var myElements = $("p");
var myElements = document.getElementByTagName("p");

// Return All Elements With Class = .intro
var myElement = $(".intro");
var myElement = document.getElementByClassName("intro");

// -------------------------- More Important Ones --------------------------

// Return a list of all <p> elements with class="intro".
var myElements = $("p.intro");
var MyElements = document.querySelectorAll("p.intro");

// Set Inner Text of an HTML element
myElement.text("Hello Sweden!");
myElement.textContent = "Hello Sweden!";

// get inner Text of an HTML element
var myText = myElement.text();
var myText = myElement.textContent || myElement.innerText;

// set HTML Content of an Element
myElement.html("<p>Hello World</p>");
myElement.innerHTML = "<p>Hello World</p>";

// Get HTML Content
var content = myElement.html();
var content = myElement.innerHTML;

// Hide an HTML Element
myElement.hide();
myElement.style.display = "none";
// or Show an HTML Element
myElement.show();
myElement.style.display = "";

// Styling HTML Element
myElement.css("font-size","35px");
myElement.style.fontSize = "35px";

// Removing Element
myElement.remove();
element.parentNode.removeChild(element);

// Get Parent Element
var myParent = myElement.parent();
var myParent = myElement.parentNode();
```

**To change the Style of an Element We write**
```javascript
element.style.display = '';
// or with jquery
element.css('display','none');
```

**To get or assign the value of a certain `input types` we write**
```javascript
var textInputs = $('input[type=text]');
// then you can get the value of each of them by using index
textInputs[0].value = "new Value";
```

**To concat to a String in javaScript we have**
```javascript
var arash = "Arash";
arash += "_Samandar" // the result would be -> Arash_Samandar
```

**To Remove a String From a String We Have**
```javascript
var test = "_1_5_8";
test.replace('_1','');
```

**To Split a String to an Array ( for example by `underline` ) we have**

```javascript
var test = "_1_2_4";
var testArray = test.split("_");
// the values would be ["", "1", "2", "4"]
```

> **In Php** we convert an **String of words** ( or whatever ) , we **implode** to an **array** like
```javascript
$str = "1,2,3,4";
$array = preg_split('/\,/',$str) // this would return $array=[1,2,3,4];
Again In Php use : array_shift($array) , to Remove The First Element Of an array
```

> **Convert To String**
```javascript
var x = 123;
document.getElementById('folan').innerHTML = x.toString()
// or
var x = 432;
document.getElementById('bahman').innerHTML = String(x);
```

> **Check IF Variable Is An `Array**`
```javascript
// NOTE : as you know , we can call the constructor name by calling ' .constructor ' on a variable
// now to check if the variable is an Array we have :
var fruits = ["banana","Orange","Apple","Mango"];
document.getElementById("demo").innerHTML = isArray(fruits);

function isArray(myArray) {
   return myArray.constructor.toString().indexOf("Array") > -1;
}
```
And we can check every variable to know if its type is
1. Number

1. Binint

1. String

1. Boolean

1. Array

1. undefined

1. null

1. Symbol

1. Object

1. Date

  **And All By Only Using This `.Constructor` On Our Variable .**
  **Another example :**
```javascript
var myDate = new Date();
document.getElementById("demo").innerHTML = isDate(myDate);

function isDate(myDate) {
  return myDate.constructor.toString().indexOf("Date") > -1;
}
```
