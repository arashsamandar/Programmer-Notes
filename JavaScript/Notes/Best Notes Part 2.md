# Best Notes Part 2
---

> how to create an element and attache it to dome
```javascript
var newParagraph = document.createElement("p");
var paragraphText  = document.createTextNode("Some Dummy Text");
newParagraph.appendChild(paragraphText);
// now use append() or prepend() to add your Element to the dom

// we also have insertBefore() and insertAter() ..
```

> example of creating a `div` and `appending` it to the `main` div

The HTML CODE
```html
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<script src="Delete.js"></script>
<style>
    .maindiv {
        text-align: center;width: 80%;margin: 0 auto;height: 900px;background-color: antiquewhite
    }
    body {margin: 0;padding: 0}
</style>
</head>
    <body>
        <div id="sam" class="maindiv">
            hello friend
        </div>
    </body>
</html>
```

**Now We Attach 2 `Div` with this code**
```javascript
window.onload = function (e) {

    var mynewDiv = document.createElement('div');
    mynewDiv.style.backgroundColor = 'black';
    mynewDiv.style.color = 'white';
    mynewDiv.attributes.id = 'newDiv';
    var textOfDiv = document.createTextNode("this is the text inside my new div");
    mynewDiv.appendChild(textOfDiv);

    var element = document.getElementById('sam');
    element.appendChild(mynewDiv);


    // Well so we learned , to create a node in Our Html Page we would have to first .
    // createa the node , then create its fill , third ,

    var myNewElement = document.createElement('div');
    var myNewElementFill = document.createTextNode('and this is its text node');
    myNewElement.style.backgroundColor = 'red';
    myNewElement.style.color = 'black';
    myNewElement.style.fontWeight = 'bold';
    myNewElement.attributes.href = 'www.google.com';
    myNewElement.appendChild(myNewElementFill);
    element.appendChild(myNewElement);
}
```

> how get the `Exact Position` of an `Element`
```javascript
var myUl = document.getElementByTagName('ul');
var firstLiInUl = myul.getElementByTagName('li')[0];
```


> just like `adding` an `element` , we also can `remove` an `element`
```javascript
$('#mydiv').find('input:last').remove();
$("#mydiv").find("input:first").remove();
```

> some `jquery` methods to find elements
```javascript
$('li').parents();
$('li').parents('ul');

$('ul').childrends();
$('div').childrens('ul');

$('li').siblings('li');
```

> animate function
```javascript
var grid = $('.myClass');
var list_of_lists = grid.find('li');
list_of_lists.css('background','red');
list_of_lists.animate({width : '-=100'},2000);
```

> using `:nth-child`
```javascript
$("ul").find(":nth-child(2)").append("<li>samanar</li>");
```

> using `addClass` `removeClass` `hasClass` `toggleClass`
```javascript
$("#elementId").addClass('your-class');
$("#elementId").removeClass('your-class');

// and also :

$("#elementId").toggleClass('your-class');

// to check if a class exist :

if($("#elementId").hasClass('your-class')) {
   // do something
}
```





























