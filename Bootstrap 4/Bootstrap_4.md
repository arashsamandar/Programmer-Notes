# Bootstrap 4 Essential Training

#### :pushpin: Remember `Bootstrap Is Designed As Mobile-First Framework`

[TOC]

## Installation

> Before Installing `Bootstrap`, you will also need `JQuery`for bootstrap to work . so you have to download it .
>
> and for some features of bootstrap you will also need `Popper.js` , you can download it from https://popper.js.org ( popper basically have some functionality for popup tooltips and ...)

#### There Are several ways like

- Css and JS
- Bootstrap CDN
- Source files
- Package Managers

> The good part of using the CDN version of Bootstrap is that if someone has visited a site that needed bootstrap , when he comes to our site ( that uses bootstrap ) . it looks , and if browser has visited another site with bootstrap ( it would be in a cache ) .
>
> in a simple way browser dosn't download it again , if it had visited a site with bootstrap already

> you can also Download bootstrap Using `composer`package managers , and also NPM .

#### if you have gone to http://www.getbootsrap.com

> under Compiled CSS and JS click download . you will get a zip file , extract it , you have three types of files in css folder . the "map" files , are for those who want to contribute or change the bootstrap . they are not needed for you . the reboot files are for reseting the css of the browser so they work more concistently with bootstrap .
>
> only `bootstrap.css` or its minimized version , is the file that you need . also you need the javascript too . in js folder , you will only need `bootstrap.js` , or it's menified version

## Simple Installation

> Go to bellow address . and under `Starter template` , just copy the three lines bellow and you are done .

**Address** : https://goo.gl/4552jR

![](F:\Programming Notes\Bootstrap 4\assets\bootstrapdownload.png)

**Also Remember To copy the above `stylesheet`css file which has no border on it**

**And also you may want to get the compelete version of `JQuery`**

----------

## Bootstrap.reboot

> always use `bootstrap.reboot` file , it makes your site looks the same on all browsers . and also looks better . so first of all import `bootsrap.reboot` css file 

## What is a Container in Bootstrap

> a container is a bootstrap class that allows everything to fit to the default grid in bootstrap .

> always use container , it makes your text nicer ( and very importantlly ) makes your content `Responsive`

------------

#### display class

> you can use `class="display-1"`To `4`, and all of them are bigger than `h1`

> we have also `lead`, which makes a paragraph look bigger and bolder .

----------------

## Typographic Utilities

- Using `text-justify`class to justify your paragraph

- using `text-lowercase`& `text-uppercase`

- using `text-capitilize`

  > using `text-xx-position`

you can use it to change text direction at each level of view port width breakpoints , like for example `sm`is standing for `576px` , and so on .... like bellow image :

![](F:\Programming Notes\Bootstrap 4\assets\textjustify.png)

> the image says ( Center The image when it is bigger than 576px )

:pushpin: **like :**

```html
<h1 class="text-center text-sm-right text-md-left">Hello world</h1>
```

------------

## Blockquotes & Lists

- list-unstyled

  *Inline Lists*

  - list-inline *on UL*
  - list-inline-item *on LI*

```html
<div style="text-align: center">
    <div>
        <ul class="list-unstyled list-inline">
            <li class="list-inline-item">hello</li>
            <li class="list-inline-item">Goodbye</li>
        </ul>
    </div>
</div>
```

----------

> using `class="blockquote"`gives your paragraph a Very Very nice dimmed line . you can also use `class="blockquote-footer"`for the end of the quote

```html
<blockquote class="blockquote">
    hello this is a very
    very long quote that
    i have written it
    <div class="blockquote-footer">
        Arash
    </div>
</blockquote>
```

> for `persion`use `class="blockquote-reverse"`

## Bootstrap Colors

> Bootstrap has a number of colors , that we can even use these colors for text . like bellow

![](F:\Programming Notes\Bootstrap 4\assets\colorsbootstrap.png)

> we just write `text`and after that the name , like `text-primary`which is kind of like dark blue .

> or by using `bg`prefix and then the name of the color ( this is used for backgrounds )

![](F:\Programming Notes\Bootstrap 4\assets\colors.png)

----------

## Working With Images

> if you want to make an image responsive and adjust to be the width of the container , you  should use `img-fluid`, and so it will respond to the container size .
>
> we have also `rounded`which gives the image a very nice corner .

![](F:\Programming Notes\Bootstrap 4\assets\roundedImage.png)

![](F:\Programming Notes\Bootstrap 4\assets\figure.png)

> if you used `display:block`for your image , you can add the class `mx-auto`to make it center in the screen

## CSS Variable ( Browser Support is Limited )

> to use variable we have to use `var()`and we also use `:root`to redefine our variables . if you want to override bootstrap colors or classes , you have to use `!important`

![](F:\Programming Notes\Bootstrap 4\assets\variables-1561194996256.png)

> now see how we implement them .
>
> we can also define a bunch of variable and use them ourselfs

```css
:root {
    --pink:#C4226F; /* we have overrided a bootstrap color variable */
    --arashcolor:#123F54;
}
```

```html
<h1 style="color:var(--arashcolor)">this is my color</h1>
```

## Bootstrap Grid

> bootstrap grid has three parts , the first one is `container`the second is `row`and then `columns`
>
> we have `container`which snaps at certain poits in bellow , and we have `container-fluid`which is 100 percent of the view port size and shrinks with view port . `container`is better at my view .

#### These are the Breakpoints fot 12-column

![](F:\Programming Notes\Bootstrap 4\assets\breakpoints.png)

![](F:\Programming Notes\Bootstrap 4\assets\breakpoints-1561198771585.png)

> also you can even put images in `container`so they would be responsive . ofcource you can just use `img-fluid` or `figure-img`or `img-thumbnail` or `round`for the image . or using `mx-auto`would make image be centered to the screen . and at last `container`makes it responsive .

> One important thing . when you use background for a `div`, for example a div has set to background be an image , and then you put an image in front of it
>
> if you want the inner image to be always in the same position and responsive ( put the inner image (the image in the div ) in a `container` class)

## mx-auto

> Remember Using `mx-auto`for any image or element that you want to be centered

> also when you are creating `columns`inside `rows`, if you want to eliminate the spacing between them . you can use `no-gutters`
>
> `no-gutters`is Very Very effective when using with columns , and when you don't want space between columns

## row

> a row should be in a `container`

### and example of using `container`& `row` & `col`

![](F:\Programming Notes\Bootstrap 4\assets\usingcolums-1561199658188.png)

> in the above picture every article ( which is recognizable by image ) is inside a `col`, and a `div "row"`wraps them , and a `section "container"`wraps them all .

## using Columns and see and write there breakpoints

![](F:\Programming Notes\Bootstrap 4\assets\colomns.png)

> now in place of `BP`you can set , where this column should change its style , for example :
>
> `col-sm-`when reaches `sm`breakpoints which is `567` ( will continue to take the width of the container untill it hits the `sm` treshhold which is `567`)
>
> another example : `col-md-6`=> takes up the `6 col` of the container as long as it is > 768 . then if it is smaller than the breakpoint it would expand to get the full row . if you don't define the `md`the column always tries to be `6`unit of the row .

> always use comments to see where you container or row ends , just like bellow

```html
<div class="container">
    <div class="row">
        <div class="col">
            
        </div> <!-- col -->
    </div> <!-- row -->
</div> <!-- container -->
```

> we used above example so when the code is getting larger and scrollable , we can see the end of our class section , `very very usefull`

-----------

## Multiple Columns Classes

### Like

```html
<section class="col-sm-6 col-md-4">
    <!-- Your Content or Article Or Whatever -->
</section>
```

> what above code meanis is basicallly if the width is at the range of `sm` => then the column would take `6 out of 12` , and when the column is at the range of `md`it would take `4 out of 12`
>
> it is very nice and descriptive and tells the column to what to do at different breakpoint , how many quantities should it take => if it is in `sm range` , and how many if it is in `md range`

-----------

## Offset Columns

![](F:\Programming Notes\Bootstrap 4\assets\offset.png)

> Offset in bootstrap means Space between colums ( kind of like margin ) Above is the syntax we use for offset .

:pushpin:*Example*

```html
<div class="container mx-auto">
    <div class="row">
        <div class="col-md-4 col-sm-4 offset-1" style="width: 100px;height: 100px;background:lightgreen;">Number One</div>
        <div class="col-md-4 col-sm-4 offset-1" style="width: 100px;height: 100px;background:darkgreen;">Number Two</div>
    </div>
</div>
```

> to avoid changing in different size of viewport , just use `col-number`=> `col-4`, other wise you will get some unatual behaviour at certain point . which sometimes you want , but sometimes you don't want .

------------

## Nested Columns ( Columns Inside Columns )

![](F:\Programming Notes\Bootstrap 4\assets\nestedcolumns.png)

### `Attention`

> also when you are creating `columns`inside `rows`, if you want to eliminate the spacing between them . you can use `no-gutters`

> `no-gutters`is Very Very effective when using with columns , and when you don't want space between columns

### Here is An Example Of nesting `row`=> `column`inside a `column`

![](F:\Programming Notes\Bootstrap 4\assets\columninsidecolumn-1561206249405.png)

> as you see we have created a `row`inside the `div`element that has `class="col-sm-4"` , so we have created a row inside a column element and put another column inside the colum . and you see the shape it gaves us . ( the thinner bar in right of the image ) .

### `Attention`

> a practical use of column inside column is when you want to use `input`and a persian text beside it . see another example :

```html
<style>
    .mycolOne {
        width: 100px;height: 100px;background:lightgreen;
    }
    .mycolTwo {
        width: 100px;height: 100px;background:darkgreen;
    }
</style>
<div class="container mx-auto">
    <div class="row">
        <div class="col-4 offset-1 mycolOne" >Number One</div>
        <div class="col-4 offset-1 mycolTwo">
            <div class="row">
                <div style="height: 100px;background: lightgray" class="col-4">
                    hello
                </div>
            </div>
        </div>
    </div>
</div>
```

:pushpin:*And Here Is It's Image*

![](F:\Programming Notes\Bootstrap 4\assets\illustrationColumnsInsideColumn.png)

-------------

## Custom Order

![](F:\Programming Notes\Bootstrap 4\assets\ordermatters.png)

## Very Important for Label and Input Text

> !IMPORTANT : use `no-gutters`in the `row`class , and `col-auto` for columns , if you want `label` to stick to the `input text` , just like bellow code :
>
> Remember `class="row no-gutters"`, `class="col-auto"`

:pushpin:**Here is an example code with its image**

![](F:\Programming Notes\Bootstrap 4\assets\nogutters.png)

```html
<div class="container" dir="rtl">
        <div class="row no-gutters">
            <div class="col-auto no-gutters" style="background: lightgoldenrodyellow">
                <label for="username" class="text-left" style="padding-top: 5px">username</label>
            </div>
            <div class="col-auto no-gutters" style="background: lightgrey">
                <input type="text" id="username" class="form-control"/>
            </div>
        </div>
    </div>
```



> also use `order`**Very Important** : when you want the label to be in the right in `persian`
>
> use `class="d-flex`, use `d-flex`if you want two elements to appear beside one another .

## A CSS Note

> you can use `vh`to expand your height to be the size of Viewport Height `vh` , just like

```html
<div style="width:100vh"> <!-- this would expand this div to the end of the viewport -->
    
</div>
```

----------------

## Aligning Contents ( Columns ) Vertically and Horizontally

> to align content vertically use `align-content-center` `end`, `start` , and you have to apply it to the `row`
>
> you can apply align vertically `align-self-end` , this is goes to the `column` , `align-self-center`,`align-self-start`
>
> to align contents horizontally , in the `row` just write `justify-content-center` , `justify-content-around`  which puts some spacing between columns , `justify-content-between` , and lastly `justify-content-end`

---------

## Display Properties

> they are other methods beside the grid to control how elements are positioned within Bootstrap .

![](F:\Programming Notes\Bootstrap 4\assets\display.png)

> these are the same as css , **but** the good side of Bootstrap is that we can use it for making page Responsible . you start with `d`, like this `d-sm-block` make elements as block when view port is smaller than 576

## Using Print for Printers

![](F:\Programming Notes\Bootstrap 4\assets\print.png)

## Using Flex

> basically what flex does . it that it sets the flexible length on flexible items. for example if we have a div with three other div inside it , by appling flex to the container div , every inner div inside gets the same width . see definition and example at : https://www.w3schools.com/cssref/css3_pr_flex.asp

![](F:\Programming Notes\Bootstrap 4\assets\flex.png)

### we have also classes like

- fixed-(top , bottom , left , right)
- sticky-(top,bottom)

> using flex is very usefull , you can use it like `d-md-flex`or `d-md-inline-flex` and a lot of other options , flex is actually very usefull .
>
> also `d-flex`makes the dives align in a row , instead of the normal div ( which are blocks ) and take the whole width of the parent and stack on top of each other . `flex`makes them in a row instead of staking on top of each other .

:pushpin:**Before Using d-flex**

![](F:\Programming Notes\Bootstrap 4\assets\beforeUsingFlex.png)

:pushpin:**after using d-flex**

![](F:\Programming Notes\Bootstrap 4\assets\afterUsingFlex.png)

> we can also use d-inline-flex or d-sm-inline-flex or d-block-flex , and others........

## Flexbox Container Options

![](F:\Programming Notes\Bootstrap 4\assets\flex-1561220668678.png)

![](F:\Programming Notes\Bootstrap 4\assets\flexing.png)

![](F:\Programming Notes\Bootstrap 4\assets\order.png)

![](F:\Programming Notes\Bootstrap 4\assets\justify.png)

![](F:\Programming Notes\Bootstrap 4\assets\wrap.png)

![](F:\Programming Notes\Bootstrap 4\assets\vertical.png)

> using `d-flex flex-column`makes our div aligned in a line , like bellow :

```html
<style>
        .item {
            background:#f0ad4a;
            text-align: center;
            width:150px;
            height: 30px;
            border:1px solid white;
        }
    </style>

    <div class="container bg-danger">
        <div class="bg-info d-flex flex-column" style="height: 100vh">
            <div class="item">Exotic</div>
            <div class="item">Grooming</div>
            <div class="item">Health</div>
        </div>
    </div>
```

--------

## Individual Flex Element

![](F:\Programming Notes\Bootstrap 4\assets\alignself.png)

![](F:\Programming Notes\Bootstrap 4\assets\order-1561225635915.png)

> OK , so we have `align-self-start`and so on... to `align`every element itself .

## Floating Elements

![](F:\Programming Notes\Bootstrap 4\assets\float.png)

> we have `float-left`,`float-right`& etc...
>
> the good part of it , is that we have `BD`, or the breakpoints we can use to enable floats at certain points .

----------

## Margin/Padding in Bootstrap

![](F:\Programming Notes\Bootstrap 4\assets\margin.png)

> number `1`is `.25rem` ,`2` is `0.5rem` , and so on....

> like `pb-3`> means padding bottom 1.5rem . or `ml-3`> means margin left 1.5rem . 
>
> `mx-3`means margin to the left and right at the same time
>
> `my-3`means margin top and bottom at the same time .
>
> as you know we have also `mx-auto`which kind of centers the element vertically .

## Visible & Invisible

> we have already seen the display wich is `d`in previous chapter .
>
> we also have a class `invisible`which just hides an element . and we have `visible`

![](F:\Programming Notes\Bootstrap 4\assets\display-1561284460114.png)

## Sizing In Bootstrap

> we can also adjust the size by percent in bootstrap , as we described in bellow diagram .

![](F:\Programming Notes\Bootstrap 4\assets\sizing.png)

> like `w-25`which says take the width of 25%

## Bootstrap Borders

![](F:\Programming Notes\Bootstrap 4\assets\borders.png)

![](F:\Programming Notes\Bootstrap 4\assets\rounded.png)

> rounded like `rounded-top`or `rounded-circle`which makes an element circle
>
> we use border like `border-primary`or etc....

---------------------

# Second Chapter

## Create basic Navigation

> easiest example of creating nav with bootstrap is as follows :
>
> basically you give the `ul`a class of `nav`, and then give every `li`a class of `nav-item`and every `a`element a class of `nav-link`

```html
<div class="container" dir="rtl">
        <div class="row">
            <section class="col-12">
                <ul class="nav">
                    <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Mission</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Services</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Staff</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Testimonials</a></li>
                </ul>
            </section>
        </div>
    </div>
```

> in addition you can use `disable`for an element to make it `gray`like .
>
> also you can use `nav-tabs`in the ul `nav nav-tabs`which makes it more beautiful . and you can assign a class `active`to one of the `li`elements . so it would appear as active . and we also said about the `disable`class too .

#### make the nave take full space by

> by using `nav-justified`or `nav-fill`

> also you can use `flex-column`to make them stack ( good option for smaller screen sizes )

> so we have

- nav
- nav-item
- nav-link
- nav-fill
- nav-justify
- active
- disable
- nav-tabs
- flex-column

## Creating Navbars

> `class="navbar"`is a class that goes on in the main container . navbar default stacks , so we need to use , `navbar-expand ` like bellow image :

![](F:\Programming Notes\Bootstrap 4\assets\navbar.png)

> this class for align them horizontally

![](F:\Programming Notes\Bootstrap 4\assets\navbarcolors-1561289211686.png)

> inside `navbar-nav`container goes the `nav-item`& `nav-link` like before .

:pushpin:*Bellow is an example of how to create a very nice `navbar`*

```html
<nav class="navbar justify-content-end bg-dark navbar-dark navbar-expand-sm">
    <div class="container">    
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="#">Home</a>
            <a class="nav-item nav-link" href="#">Mission</a>
            <a class="nav-item nav-link" href="#">Services</a>
            <a class="nav-item nav-link" href="#">Staff</a>
            <a class="nav-item nav-link" href="#">Testimonials</a>
        </div>
    </div>
</nav>
```

> you can shift `navbar-nav`with `mr-auto`or `ml-auto`meaning margin-left auto 

> so what we have here is basically , first we need a `Div` element with the classes like `nabvar`,`navbar-expand`(to make it in a row , because bootstrap is mobile first) , then `bg-dar`for the color , and to tell the navbar the color we use `navbar-dar`.
>
> then in the inner `Div`we have the class `navbar-nav` .
>
> for better aligning make sure you put `navbar-nav`in a container

----------

## Using Branding and Text in a Navbar

### We have

- > navbar-brand ( is used very much for `headlines` ) , we can use navbar brand inside our `navbar-nav`

- > navbar-text

:pushpin:*Example*

```html
<nav class="navbar justify-content-end bg-dark navbar-dark navbar-expand-sm">
        <div class="container">
        <div class="navbar-brand" dir="ltr">Samandar</div>
        <div class="navbar-nav nar-tabs">
            <a class="nav-item nav-link" href="#">Home</a>
            <a class="nav-item nav-link" href="#">Mission</a>
            <a class="nav-item nav-link" href="#">Services</a>
            <a class="nav-item nav-link" href="#">Staff</a>
            <a class="nav-item nav-link" href="#">Testimonials</a>
        </div>
        </div>
    </nav>
```

#### Note

> we use `navbar-brand` before the `navbar-nav`
>
> we use `navbar-text`after the `navbar-nav`
>
> also pay attention that we have used `d-none d-sm-inline-block`so the brand is not visible at small sizes ( less than 567px ) .

## DropDown

> `dropdowns`can be activated in two ways ,
>
> 1 ) through the use of javaScript
>
> 2) by using a data attribute `data-toggle="dropdown"`

- dropdown
- dropdown-toggle ( adds an ancher to show its a dropdown )
- dropdown-menu
- dropdown-item
- id  & aria attributes

:pushpin:*Here is an Example*

```html
<nav class="navbar bg-dark navbar-dark navbar-expand-sm">
        <div class="container">
            <div class="navbar-brand d-none d-sm-block">Samandar</div>
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="#">Home</a>
                <div class="dropdown">
                    <a class="nav-item nav-link dropdown-toggle" data-toggle="dropdown" id="missions" aria-haspopup="true" aria-expanded="false" href="#">Mission</a>
                    <div class="dropdown-menu" aria-labelledby="missions">
                        <a class="dropdown-item" href="#" >Havij</a>
                        <a class="dropdown-item" href="#" >Resolute</a>
                        <a class="dropdown-item" href="#" >MSE</a>
                    </div>

                </div>

                <a class="nav-item nav-link" href="#">Services</a>
                <a class="nav-item nav-link" href="#">Staff</a>
                <a class="nav-item nav-link" href="#">Testimonials</a>
            </div>
            <div class="navbar-text d-none d-sm-inline-block">hello it's me baby</div>
        </div>
    </nav>
```

### NOTE

> use `class="dropdown-menu float-right pull-right"`to make the drop down right aliened .

## Add Form Elements To The Menu

> to add form in the menu , just after the `navbar-nav`div we add <form class="form-inline"> as you see it has the class `form-inline`, and then we just add the controls inside this form .

## Positioning Elements

- fixed-top
- fixed-bottom
- sticky-top

> you can use `fixed-top`class on a `navbar`if you want the nav to remain even when we are scrolling the page .

## Collapsable Content

> collapsable content classes for menu

- collapse
- navbar-collapse
- id

> also the thing that collapses the menu ( the hamberger thing ) is also going to have other classes , and the first class it gets is called the `navbar toggler`

## Example Of How to create a nice right aligned menu

```html
<nav class="navbar bg-dark navbar-dark navbar-expand-sm">
        <div class="container">

            <button class="navbar-toggler ml-auto" type="button"
                    data-toggle="collapse" data-target="#myTogglerNav"
                    aria-controls="myTogglerNav" aria-expanded="false">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="myTogglerNav">

                <div class="navbar-nav ml-auto">

                    <a class="nav-item nav-link" href="#">Home</a>

                    <div class="dropdown">
                        <a class="nav-item nav-link dropdown-toggle" data-toggle="dropdown" id="missions"
                           aria-haspopup="true" aria-expanded="false" href="#">Mission</a>
                        <div class="dropdown-menu float-right pull-right" aria-labelledby="missions">
                            <a class="dropdown-item" href="#">Havij</a>
                            <a class="dropdown-item" href="#">Resolute</a>
                            <a class="dropdown-item" href="#">MSE</a>
                        </div>

                    </div>

                    <a class="nav-item nav-link" href="#">Services</a>
                    <a class="nav-item nav-link" href="#">Staff</a>
                    <a class="nav-item nav-link" href="#">Testimonials</a>

                </div><!-- navbar-nav -->
            </div><!-- collapse -->
        </div> <!-- container -->
    </nav>
```

