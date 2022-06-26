## Making alert boxes in Bootstrap

> we use the class `alert`and for the color `alert-color`, like bellow :

```html
<div class="alert alert-danger" role="alert">
    This is an alert.
</div>
```

> we can also expand the alert like a box , just like bellow :

![](F:\Programming Notes\Bootstrap 4\assets\alertbox.png)

```html
<div>
   <div style="margin: 20px" class="col-8 mx-auto alert alert-success">
       <h1 class="alert-heading">Well Done Arash !</h1>
       <p>This is just amazing arash to see you do this completely right</p>
       <hr>
       <p class="mb-0">so this is goes to the footer of my alerting box welldone</p>
   </div>
</div>
```

#### put a close button for alert

> to put a close button for alert make sure you add this button code bellow :

```html
<button class="close" data-dismiss="alert" aria-lable="Close">
    <span aria-hidden="true">&times;</span>
</button>
```

## Using Badges

![](F:\Programming Notes\Bootstrap 4\assets\badges.png)

> we can even use `badge`inside a button like above , and even put a counter inside it , look at the code .

```html
<button type="button" class="btn btn-primary">
  Notifications <span class="badge badge-light">4</span>
</button>
```

-----------

#### We can Use Pill-badges & even Links with badges

:pushpin:*Example of badge-pill*

```html
<span class="badge badge-pill badge-primary">Primary</span>
```

:pushpin:*Example of link badge*

```html
<a href="#" class="badge badge-primary">Primary</a>
```

## Outline Buttons

> we have seen and we know how to use buttons in bootstrap . but `Outline Buttons`are much more beautiful , and we write them like :

```html
<button type="button" class="btn btn-outline-primary">Primary</button
```

## Using Button Blocks

```html
<button type="button" class="btn btn-primary btn-lg btn-block">Block level button</button>
<button type="button" class="btn btn-secondary btn-lg btn-block">Block level button</button>
```

