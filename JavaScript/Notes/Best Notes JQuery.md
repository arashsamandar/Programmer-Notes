# Best Notes JQuery

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

// setting Attribute of an Element
$("#element").attr("src","http://google.com");
document.getElementById("element").src = "http://www.google.com"
```

> Set Content - `text()`, `html()`, and `val()`
- `text()` - Sets or returns the text content of selected elements
- `html()` - Sets or returns the content of selected elements (including HTML markup)
- `val()` - Sets or returns the value of form fields

> what is a **Callback Function ?**
A callback function is a function `passed into` another function `as an argument`, which is then invoked inside the outer function to complete some kind of routine or action. ... A good example is the callback functions executed inside a .then() block chained onto the end of a promise after that promise fulfills or rejects.

> **CallBack Function** for text(), html(), and val()
```javascript
$(function(){
   $('#btn1').click(function(){
      $('#test1').text(function(i,originalText){
         return "Old Text : " + originalText + "new Text : " + "Hello World" + "index : " + i;
      });
   });
});
```

> use `typeof` to determine the type of a `variable` , like :
```javascript
typeof "" + "<br>"  // the output is string
typeof 314 + "<br>" // the output is number

var car;
typeof car + "<br>" // the output is undefined
```

> **IMPORTANT : TO SEE EVERYTHING ABOUT JAVASCRIPT , SEE** https://www.w3schools.com/js/js_examples.asp


