[TOC]

# CSS Essential Training Series 1 To 3

## Define Your Base Style

### Note

> all css Elements are eather Block or inline Level Elements .

### What is A Glyph

> In typography ( Science of letters ) a glyph is a symbol that represents a charachter or letter . unicodes ("/2764") are how glyphs are represented & added in the Css . adding slash so the css knows it is a unicode and not a number string .

First Define Your base styles , they would be in effect for the rest of your project , like defining the padding and margin for div elements , so every div would have an specific amount of margin , and it's class won't change it , you don't write it again .

```css
body {
    background-color:white;
    margin:5px;
    font-family:helvetica, arial,sans-serif;
}
p {
    margin:0 0 .75em 0;
    padding:10px;
}
.blue { /** this is a "p" , so it would have above "base" styles **/ 
    color:#669;
}
.menuTop {
    background-image: url(../images/navbar.jpg);
    background-repeat: repeat-x;
    height:55px;
}
```

------------

> `Front End Web Development`: Refers to the languages that run in the Browser : HTML , CSS , JS



:warning:**HTML Versions** : `HTML` , `XHTML` , `HTML5`



---------------------

## Understangind DOM & Html

### Void Elements

> Void elements usually do not Content , Because they Are The Content , like :

**<area> , <base> , <col> , <embed> , <hr> , <img> , <input> , <keygen> , <link> , <meta> , <param> , <source> , <track>**

> They also do not need a closing `/`at there end , like <hr> which just creates a line , although in the previous version they use `/`, but it is no longer needed .

*<img src="D:\\somefile.txt" alt="Description of Image">*

> next we have element's `Attributes`, like `src`or `href`

### Document Object Model ( DOM )

> Represents the Tree Like Structure that is created when writing HTML , Each element is an Object which makes up the Document , hence the name Document Object Model .
>
> elements are often nested meaning the Tags are written inside other tags , and this Makes RelasionShips . like bellow : ( `Is Important Too Look`)

![](F:\Programming Notes\CSS\assets\domtree.png)

---------------------

## Default Browser's Style

> Each Browser has its own user agent Stylesheet , you can view these styles using your browser Developer tool . simply create a basic sample HTML page , then in the devTools of chrome , in the `Element`section , to the right , you see Styles , which browser has written `User Aganet Stylesheet`

> #### Remember : use html to assign meaning to the content not for how it looks

**The Bellow Header Is For HTML5**

```html
<!DOCTYPE html>
```

# CSS

## Multiple Classes

> Seperate Multiple Classes with a Space

```html
<div class="nice good"></div> <!-- They are independent of each other -->
```

> Combine classes, with no space to select both

```html
<div class="nice.good"></div>
```

## PseudoClass

```css
p a {
    // this will apply to only the childs of "p"
}
section p a {
    // this will also apply to the a in the p that is in the section tag
}
```

## Grouping Multiple Selectors

```css
h1, h2, h3 {
    color:red;
}
.class-name h1, h2 {
    color:blue; // the "," seperates them Always .
}
```

#### For Example For "a" we have

- active ( when you press the link )
- hover ( when you hover over the link )
- visited ( when a link is visited )
- focus ( used with keyboard (when a has focus))

**Focus Can Be used for Input box types like :**

```css
a:focus,
input:focus {
    outline: 1px solid black;
}
```

## Selectors Best Practice

> you can use id for your paragraph and give that id to your "a" tags , for jumping to that paragraph like :

```html
<a href="#parag1">Question One</a>
<a href="#parag2">Question Two</a>

<p id="parag1">
    This is Paragraph One
</p>
<p id="parag2">
    this is Paragraph Two
</p>
```

> Leave Id for this kind of works , use Class for CSS .

## Comments in CSS

> Comments in Css are Written with ( /*   */ )
>
> It is good for keep things Organized & Easy to find .

```css
/* Color Pallete
#2B2D42 - DARK BLUE
#8D99AE - LIGHT BLUE
#EDF2F4 - BLUE/WHITE
#EF233C - RED
*/

/* Global Styles
------------------------ */
body {
    color:blue
}

/* Header & Footer
-------------------------- */


/* Else Styles
-------------------------- */
```

## Some Very Good Sites For Choosing Colors

https://coolors.co

with any push of the space you will create a new Pallet

## Using Fonts

> Before You can use your internal "fonts" you must declare and link to font files using `@font-face`
>
> **@font-face** : is used to set the font name and linkt to the font files .

```css
@font-face {
    font-family:'Byekan'; /* This would be the font name */
    src: url(Byekan.ttf);
}
body {
    font-family:'Byekan';
}
```

> Basically you put your "fonts" files in the `fonts`folder , and images in `images` folder , and css in `css`folder , and javaScript files in `js`folder .
>
> so to address the font . first we move one level up ( `because we are in font folder `)

![](F:\Programming Notes\CSS\assets\fonts.png)

> in fontsizes "em" is a relative unit . bellow is an example of how inner em is inherriting ( and so is bigger than ) it's parent

```css
div {
    font-size:2em;
}
p {
    font-size:1.5em; /* One and half of it's parrent "div" */
}
/* or
-------------- */
div {
    font-size:20px;
}
p {
    font-size:1.5em; /* so it is 30 px */
}
```

### rem

> rem is like "em" but it is newer than em and only inherits the html ( root ) , and not the other way around , for example :

```css
html {
    font-size:30px;
}
div {
    font-size:20px;
}
p {
    font-size:1rem; /* this will be relaive to one 30px */
}
```

## font-weight

> determins the Thickness of the font , and it ranges from 100 to 900 .
>
> normal = 400; bold = 700

### line-height

> decrease or increase the size between lines .

### text-transform

> Text-Transform:Capitalize;
>
> Text-Transform:UPPERCASE;
>
> Text-Transform:lowercase;
>
> Text-Transform:none;

## HTML Elements

> There are Two types of elements in HTML , Block Level Elements & Inline Level Elements .

### Block

> Block level elements are the same height as there content
>
> Height = Content
>
> Elements Start on a new Line .
>
> Block elements can wrap other block and inline elements .
>
> examples : <div> , <p> , <h1>

> For inline elements with and height would not have any effent , but if we use `display:block`then it would change it .

### Using display inline or inline-block

> we can use `display:inline`for divs , so they would appear in a same line . in other word they would have specifications of both Inline & Block .
>
> as well as we can use `display:inline-block`for <span> and <a> ( inline elements ) , so they would have specification of block , but they won't have that default margin with them , so they appear in same line .

## Order in Margin & Padding and etc...

```css
padding:top right bottom left
padding:top-bottom left-right
padding:top left-right bottom
```

## and example of a border

```css
.myborder {
    border-width:2px;
    border-style:solid;
    border-color:black;
}
```

### a note

> you can assisgn negetagive margin to an element , to shift it from its place !! :warning:

![](F:\Programming Notes\CSS\assets\minesmargin.png)

## Float

> notice that block level elements take up the whole width , while inline elements don't . so block level elements are stacked on each other , all taking up the whole horizontal ( width ) space .

> by using float you will break the natural flow of the document . for example the parent would not detect the height of the floating element anymore .

![](F:\Programming Notes\CSS\assets\floatelement.png)

> Use overflow:auto , to solve this problem for floats , otherwise the parent can't detect the floated element .

## Using Border Radious

> use border radious , for example if you want your elemnts ( like image ) to be a circle , use border-radius:50%

---------------

## Using Box Model Fix

> we know that padding and border make the size of the box model larger . thus we need to calculate them too .
>
> but there is a fix for it . as bellow , in your html write :

```css
html {
    box-sizing:border-box;
}
*,*:before,*:after {
    box-sizing:inherit
}
```

> and so this is called box model fix , the padding and border will now push inward , and would not effect the actual size of the box

--------------

## Css Attribute Selectors

> [ attribute ] , [ attribute = value ] , like bellow :

```html
Search box : <input type="search"><br>
Text input : <input type="text"><br>
Email input : <input type="email"><br>
Submit input : <input type="submit">
```

```css
input {
    margin:4px;
}
[type] {
    border:1px solid black
}
[type=search] {
    border:2px dashed blue;
}
[type]:focus {
    border:1px solid black;
}
```

------------

## Combinator Selectors

![](F:\Programming Notes\CSS\assets\selectors.png)

### Child Combinators

![](F:\Programming Notes\CSS\assets\combinator_child.png)

-------------

### Sibling Combinators

![](F:\Programming Notes\CSS\assets\siblingCombinators.png)

### Note

> we now we can use multiple classes together , but when selecting like bellow
>
> `.classOne.classTwo {}` it only effects the element that has both classes like :
>
> <a class= "classOne classTwo" href="#">

-------------

## Pseudo-Class Selectors

> A Pseudo-class is a keyword , added to a selector with the `:`Colon Symbol . it's used to specify a certain state . like the hover in `a:hover`

**Examples**

- `:first-child`
- `:last-child`
- `:nth-child()` you can put any number in the paranteces

![](F:\Programming Notes\CSS\assets\childelements.png)

> this `first-child` & `last-child`Only works , when there is only <p> childs in the section element , if we add a <h1> to the top and a <a> to the button they would no longer work , instead we use -> `first-of-type` & `last-of-type`for this situation , like bellow :

```html
<section>
   <h1>heading</h1>
    <p>Paragraph One</p>
    <p>Paragraph Two</p>
    <p>Paragraph Three</p>
    <a>Link One</a>
</section>
```

```css
p:first-of-type {
    color:red;
}
p:last-of-type {
    color:blue
}
/* Now They Work */
```

## Using :nth-child

> there are several keywords you can use with `:nth-child`.

- odd
- even
- (2n+1) any combination

![](F:\Programming Notes\CSS\assets\nthchild.png)

## nth-of-type

> uses the same arguments as `nth-child`but also matches elements type

- `:nth-of-type(odd)`
- `:nth-of-type(even)`
- `:nth-of-type(2n+1)`

```css
.box:nth-child(2n+1)
```

--------------

## Conculusion

> Using the `type`version of above states is better , since you don't have to worry if there are other elements that would count as the first time an element appeared in the html .

-----------------

-----------------



## Pseudo-Element Selectors

- > :before

- > :after

![](F:\Programming Notes\CSS\assets\beforeandafter.png)

![](F:\Programming Notes\CSS\assets\mustbeused.png)

:pushpin:**Example**

```html
<style>
   p:before {
     content:"\"";
     color:red;
     font-size:18px;
   }
   p:after {
     content:"\"";
     color:red;
     font-size:18px;
   }
</style>

<p>this is a sentence</p> <!-- Result : "this is a sentence" -->
```

## Note about creating Navigation Bar

> we can use two approaches , one is old , one is new and requires less code

```html
<nav>
    <a href="#">Home</a>
    <a href="#">About</a>
    <a href="#">Contact</a>
</nav>
<!-- or using longer approach which also needs some css to creare list styles -->
<style>
    .nav ul {
        margin:0;
        padding:0;
        list-style-type:none;
    }
</style>
<div class="nav">
    <ul>
        <li><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li>
    </ul>
</div>
```

> Obviously we should use the first approach with `nav`container , it is easier and requires less code .

> there is a fix you should use with nav

```css
.nav {
    font-size:0;
}
.nav a {
    font-size:16px;
}
```

## Positioning elements

> we have four types : `static` , `relative` , `absolute` , `fixed` .
>
> normally elements are positioned with `static` , meaning they don't have any special positioning and they are in the document flow .
>
> if you use `position:absolute` that element would be removed from the normal document flow .

> we can use `relative`with `absolute`positioning to position it relative to a parent div . but if none is given , it would consider the `body`as its parrent , and would adjust itself relevent to body .

> `Fixed`is another one , but the difference it has with `absolute`, is that it is relative to the viewport , meaning it would maintain it's position , even on the `page scroll`

## Using Float or Display or Position

> `Float` use float with flexible contents like image , when you want text to flow near them . use `Display` if you want to center elements in a line .
>
> `Display` is also good as it is not changing the normal document flow .
>
> `Position` is good when you want to align an element relevent to its parent . or aligning document ourside of the normal document flow .

> `A Rule`is to use background ( page background ) to see where everything is .

## Using Image Background

```css
.myclass {
    background-image : url(../images/arash.jpg);
}
```

> if you are using an image that is part of the content ( like your profile picture ) , use the HTML `img` tag .
>
> if the image is there just for decoration then you should use css . like the background image of a div element .

> if the image is smaller than your div , then it would repeat itself like bellow :

![](F:\Programming Notes\CSS\assets\repeateimage.png)

> to fix this issu use :

```css
.background {
    background-image : ulr(https://unsplash.it/image.jpg);
    background-repeate : no-repeat /* it is the fix */
}
/* you can also use position for your background in a div , just like bellow */
.background {
    background-image : ulr(https://unsplash.it/image.jpg);
    background-repeate : no-repeat;
    background-position : 20px 20px;
    /* you can also use bellow code */
    background-attachment:fixed; /* it is fixed even if you scroll the page */
    background-size:100% 100%;
    /* or you can use */
    background-size:cover;
}

/* The ShortHand Version */

selector {
    background:blue url(image.jpg) no-repeat;
    background-size:cover;
}
```

## applying a forgound color on an image

![](F:\Programming Notes\CSS\assets\transparent.png)

> as you see the image container is the container , and the background color is inside it , this way we can apply a color and make it transparent so the parent image is still visible and the benefit is that we can read the text .

## Another Approach is Using Gradient

```css
selector {
    background:linear-gradient(color,color),
               url(image.png);
}
```

![](F:\Programming Notes\CSS\assets\gradient.png)

> this has the same transparent effect over our image , as it was in our previous example image .

![](F:\Programming Notes\CSS\assets\grati.png)

### Another Example Of this

> pay attention using the fix give a veryy veryyy nice effect when scrolling . the code is like below

```css
.education {
    background:linear-gradient(rgba(),rgba()),
               url(../image/cityWide.png) no-repeat fixed;
    background-size:cover;
}
```

---------------

--------------------------

## Media Queries

> Media queries are used to specify how a document is presented on different media (e.g, screen and print )

## Breakpoints

> BreakPoints are the requirements (e.g, viewport width ) used to determine when to change the styles and layout of your webpage .

> It's common to use several breakpoints to optimize for mobile , tablet , and desktop .

`See poplular Screen Sized in use today at:`http://gs.statcounter.com/screen-resolution-stats

------------

## Mobile First Concept

> Starting with smaller screen may help us make more thoughtfull decisions about what elements are actually neccessary instead of just filling up space .

## Responsive Web Design

> First ) use max-width & min-width , instead of a fixed width .

> Use max-width , min-width as pixel and also use perent for absolute width ( this way combine them together )

> For responsive web designs use Media Queries to apply specific Css styles for different screens

### Important Different Types of Adding Media Queries

> First ) you can write you Media queries in a different css file .
>
> then link to it in header , and use `media` attribute keyword in link , like bellow :

```html
<link media="screen and (max-width:400px)" rel="stylesheet" href="mobile.css">
```

> Second ) Include it in the main css file , just like bellow :

```css
@media (max-width:400px) {
    .selector {
        ..........
    }
}
```

![](F:\Programming Notes\CSS\assets\media.png)

### Using Range in Media Queries

![](F:\Programming Notes\CSS\assets\range.png)

## Sticky Position

> Sticky position is used when you want the header to always appear , even if you scroll the page , you have seen it in many sites .

> Sticky Position has a nice effect , use it ( but notice that some versions of IE may not support it )

#### NOTE

> do Remember that you should use a position like top , when you want to use sticky functionality . like bellow 

```html
<style>
    .mySticky {
        position:sticky;
        top:10;
        background:lightblue;
        padding:10px;
    }
</style>
<div class="mySticky"></div> <!-- you can also put your sticky in the middl of the container div -->
<div class="mainDiv">
    A lot Of Text in here
</div>
```

> and in above example when you scroll the page , the div with class `mySticky` would fly with it .

-----------

## Design With a Grid

> Designing Web pages With A Grid can help help creating a consistent Design flow and symetrical Design Layouts .

![](F:\Programming Notes\CSS\assets\grid-1561054647951.png)

> there are different ways to define a grid , but a common layout for web pages is to use a 12 equal column grid , because twelve 12 is easily devisible by 2 , 3 , 4 , 6 . making it easier to create responsive design . a grid can be created with design softwares like photoshop or Sketch .

![](F:\Programming Notes\CSS\assets\grid-1561054802365.png)

> there are also generators for creating grids like : http://gridcalculator.dk

> then we can create our grid system using Css , just like bellow examples :

**Part One**

![](F:\Programming Notes\CSS\assets\partOne.png)

**Continue of part One**

![](F:\Programming Notes\CSS\assets\partTwo.png)

> and by using this columns that we have written , we can create a whole new row , with any number of our columns ( as long as there sum is 6 ) , just like bellow example :

![](F:\Programming Notes\CSS\assets\partThree.png)

> So this was Designing with Grid System in a Nutshell . bellow is the complete code .
>
> and if you don't know why we have used .container:befor , .container:after { content: " ";display:table} , that is because we wanted to put a line after every column ( which we did by adding a space after and before the container , and make this new charachter , to be a block ( table ) level element by using display:table ) . pretty simple , hah :sweat_smile:

```html
<style>
        html {
          box-sizing:border-box;
        }
        *,*:before,*:after {
          box-sizing:inherit;
        }
       .container {
         font-size:1em;
         margin-bottom:4px;
       }
       .container:before,.container:after {
         content:" ";
         display:table;
       }
       .container:after {
         clear:both;
       }
       .col {
         float:left;
         border:1px solid black;
         text-align:center;
       }
       .col-1 {
         width:16.66%;
       }
       .col-2 {
         width:33.33%;
       }
       .col-3 {
         width:50%;
       }
       .col-4 {
         width:66.66%;
       }
       .col-5 {
         width:83.33%;
       }
       .col-6 {
         width:100%;
       }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="col col-1">col-1</div>
    </div>
    <div class="container">
      <div class="col col-2">col-2</div>
    </div>
    <div class="container">
      <div class="col col-3">col-3</div>
    </div>
    <div class="container">
      <div class="col col-4">col-4</div>
    </div>
    <div class="container">
      <div class="col col-5">col-5</div>
    </div>
    <div class="container">
      <div class="col col-6">col-6</div>
    </div>
    <div class="container">
      <div class="col col-2">col-2</div>
      <div class="col col-4">col-4</div>
    </div>
```

> So now we can make any desired page layout , just by using our grid column system :) , pretty simple :) .

## intro to Css Grid

> grid base layouts are a common part of web Design . when translating these designs to web pages many different methods have been used .

> we started with table based layout . mostly throughout the 1990 . but now tables won't cut it anymore . the new one is css Grid layout . that is now supported by all browsers .

**A Complete Guide To Css Grid Is Here** : https://tympanus.net/codrops/css_reference/grid/

### :pushpin: Take A Look At An Example 

> first in the html a container is needed for all the content items which will form the rows and columns . in this example we have given it the class of `grid-container`, then we will also need a container for each grid item to wrap the content to be included in each grid item . Such as the image and heading . we can see that we gave it the class of `grid-item`.
>
> We haven't added any grid related Css yet . so each grid item stacks on top of each other because they are block elements .
>
> to create the grid layout we should start by adding the display property . as you see in the line two of the css .
>
> this would just initiate the grid base css properties

![](F:\Programming Notes\CSS\assets\systemgrid.png)

> next we add the `grid-template-columns`property , to create three columns we used three values as you see above . to set for each column .

> now see the change with `grid-template-columns`applied

![](F:\Programming Notes\CSS\assets\grid_system.png)

> if you want two columns use 2 in `grid-template-columns`, we can also use `fr`instead of pixels , that means fraction . like :
>
> `grid-template-columns: 1fr 1fr 1fr` ( so each one is one/third of the total container size )
>
> to add four , use four values , and so on ...
>
> the third line `grid-template-rows` in css is to change the height of each columns . the second value 175px is smaller because we want the second row ( the bellow one ) , to be smaller .
>
> `grid-column-gap` & `grid-row-gaps` are for spacing between the columns

![](F:\Programming Notes\CSS\assets\gridsystem.png)

For more Information See : https://gridbyexample.com

#### and here is the code if you want to check this out .

- > `Remember the main part : is using the container`

```html
<style>

       .grid-container {
         display:grid;
         grid-template-columns:200px 200px 200px; /* I want Three Columns */
         grid-template-rows:200px 170px; /* i want two rows one is lesser thatn the other */
         grid-column-gap:10px;
         grid-row-gap:80px;
       }
       .grid-item {
         border:1px solid blue;
         text-align:center;
       }

    </style>
  </head>
  <body>
     <div class="grid-container">
       <div class="grid-item">
         <img src="https://i.pinimg.com/originals/35/a4/43/35a443c9ff20bc7b2f28172a91c31ce2.jpg" />
         <h3>Title One</h3>
       </div>
       <div class="grid-item">
         <img src="https://i.pinimg.com/originals/df/29/5b/df295b5f1f1faa5730b851c5029d784d.jpg" />
         <h3>Title Two</h3>
       </div>
       <div class="grid-item">
         <img src="https://steamuserimages-a.akamaihd.net/ugc/785229283511270725/A5A108C9FABA047FF8FB47885C1C65E36F01C91C/?imw=200&imh=200&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=true" />
         <h3>Title Three</h3>
       </div>
       <div class="grid-item">
         <img src="https://i-cdn.phonearena.com/images/article/64045-image/Awesome-new-Quad-HD-and-1080p-wallpapers-for-your-smartphone-December-2014.jpg" />
         <h3>Title Four</h3>
       </div>
       <div class="grid-item">
         <img src="https://mfiles.alphacoders.com/642/thumb-642286.jpg" />
         <h3>Title Five</h3>
       </div>
       <div class="grid-item">
         <img src="https://steamuserimages-a.akamaihd.net/ugc/785229283511270725/A5A108C9FABA047FF8FB47885C1C65E36F01C91C/?imw=200&imh=200&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=true" />
         <h3>Title Six</h3>
       </div>
     </div>
```

---------------

## FlexBox Intro

> the flexible box layout , or flexbox for short includes many options for aligning elements , and creating flexible items . this layout model is supported by all major modern browsers

### :pushpin:without flexbox

![](F:\Programming Notes\CSS\assets\withoutflexbox.png)

### :pushpin:with flexbox

![](F:\Programming Notes\CSS\assets\withflexbox.png)

> this would align and size the `flex-items`based on the content within . but anyway we can still set specific with to the flex items if you want them to be equally sized . to change the direction , we can change by adding `flex-direction:row-reverse` so it would get reverse , ( the 1 would be in place of 5 )

> we can also use `justify-content:center` or `justify-content:flex-end` we have also `space-between` and `space-around`

:pushpin:**And This Is the Code**

```html
<style>

      .flex-container {
        display:flex;
        flex-direction:row-reverse;
        justify-content:space-around;
      }

      .flex-item {
        border:1px dashed blue;
        padding:10px;
        width:20%;
      }

    </style>
  </head>
  <body>
     <div class="flex-container">
       <div class="flex-item">
         <p>asdf asdf asd f;askfdjasf;j  kasdfhasdfh as;df<br>
         asdfbasdf;b absdf;laksdfj a;sdhfa; sdfas ;dfjas;df <br>
         a;sldkfjas;lfkjas fd<br>
         as;dklfja;slfdkja;slfdkaj;sfdk<br>
         as;dlkfjas;ldkfja;sdfklas;fkja;sdflk</p>
       </div>
       <div class="flex-item">
         2 this is just a text as you see it is nothing out of the ordinary
       </div>
       <div class="flex-item">
         3
       </div>
       <div class="flex-item">
         4
       </div>
       <div class="flex-item">
         5
       </div>
     </div>
```

## CSS Transition Property

> Transition is Actually shorthand for Four different Transition Properties

![](F:\Programming Notes\CSS\assets\transition.png)

## CSS KeyFrames & Animations

> we saw how to create animation effects using the `transition`property . but `transition`only allows us to have a start and an end point .
>
> with `@keyframes`we can create more complex effects by setting multiple points for our animations .

> The `@Keyframes`Rule , requires three things to be defined

- Animation name
- Breakpoints
- Css Properties to be animated

![](F:\Programming Notes\CSS\assets\animation.png)

![](F:\Programming Notes\CSS\assets\animation_Two.png)

> Attention that the property must be the same , like in above case top is changing . we can also add other property , but we have to put it in every frame of the animation , like we did for top in above example .

> the keyframe makes the animation , but dosn't run it , to run it you shall apply it to the element . with `animation-name:bounce` and also you should declare the `animation-duration`for the time , like bellow : ( similar to transition-property ) the `animation-timing-function`& `animation-delay`are also optional .

```css
@keyframes bounce {
    0% {
        top:0px;
    }
    50% {
        top:250px;
    }
    100% {
        top:0px;
    }
}
.ball {
    animation-name:bounce;
    animation-duration:2s;
}
```

> to repreat the animation use the `animation-iteration-count` property . like :

```css
animation-iteration-count:3;
/* or */
animation-iteration-count:infinite;
```

> the longhand and shorthand version are :

![](F:\Programming Notes\CSS\assets\shorthand.png)

:pushpin:**Example**

```html
<style>
@keyframes bounce {
      0% {
        top:0px;
        color:red;
      }
      50% {
        top:500px;
        color:lightblue;
      }
      100% {
        top:0px;
        color:red;
      }
    }
       .ball {
         background-color:red;
         width:100px;
         height:100px;
         position:absolute;
         border-radius:50%;
         animation:bounce 3s ease-out 0.1s 3;
       }
</style>
<body>
    <div class="ball"></div>
</body>
```

----------------

## Using Css Shape

> document sees everything as a rectangle , for example when we float a div . the text flow around it like a rectangle ( `Even when it is a circle`) , to get around that , and make the text wrap it like it is a circle , we use `shape-outside:circle()`,we also have ellipses() , polygon() and etc... , like bellow : ( you can use shape-outside with images too )

![](F:\Programming Notes\CSS\assets\shapeoutside.png)

> we can also remove the `border-radius`and use `clip-path:circle()`, it would cut the div as it is exactly a circle .

## Note On clip-path and using Polygon to create shapes

![](F:\Programming Notes\CSS\assets\circleclippath.png)

![](F:\Programming Notes\CSS\assets\clippath-1561118632936.png)

> you can create any shape with `cleap-path:`

![](F:\Programming Notes\CSS\assets\clipppath.png)

:pushpin:*here is an example of the first image : circle*

![](F:\Programming Notes\CSS\assets\anexampleofcirclepath.png)

```html
<style>
       .myshape {
         width:70px;
         height:140px;
         background:red;
         margin:4px;

         float:left;
         shape-outside:circle();
         clip-path:circle(50% at 0% 50%);
           /* clip-path:circle(50% at 50% 50%); would give a complete circle */
       }
    </style>
  </head>
  <body>
    <div class="myshape"></div>
    <p style="margin:5px;">this is a normal text bot if you want you can event <br>
      do whatever you want with it , fuck it , suck it , actually <br>
      anything you want to do is possible with these shapse .
      <br>so don't be shy and try to be in your home , i think they will
      call me , what do you think , don't yoiu think too ?
      this is a normal text bot if you want you can event <br>
        do whatever you want with it , fuck it , suck it , actually <br>
        anything you want to do is possible with these shapse .
        <br>so don't be shy and try to be in your home , i think they will
        call me , what do you think , don't yoiu think too ?
  </body>
```

