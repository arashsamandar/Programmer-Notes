## 1. Container Properties

> ```css
> .container {
>     display: flex;
> }
> ```
>
> First you would need a `Container div` with Property `display: flex;` set to it
>
> ```html
> <div class="container" style="display:flex; flex-direction: row">
>     <div class="item item-1">Item One</div>
>     <div class="item item-2">Item One</div>
>     <div class="item item-3">Item One</div>
> </div>
> ```
>
> Default flex direction is `Horizontal` or `row` . you can put to vertical with `flex-direction: column`

> `Flex` creates a hidden axis on X ( main axis with `justify-content` ) and Y ( verticacl , with `align-items` )

- Justify-Content `horizontal`
- Align-Items `vertical`

### Flex-Wrap

> use `flex-wrap` on the container ( if and when there are two many elements and they are Crushing each other ).
>
> - `align-content` : after using `flex-wrap` you can use it ( align-content ) to align all of them to start, finish, top, bottom , where ever you want ( like `align-items` but for __content__ and __wrap__ )
>
> this way they would fill they next `row` of the html view and would not try to fit all in only one row

### Gap

> use `gap` like `gap: 1rem` , when your elements are too close on several rows or even on their columns . this way they would have some space between them . ( don't confuse it with `justipy-content` and such though )

## 2. Item Properties

### Flex-Grow

> give it to an item to fill the rest of the space ( all space left minus what others absolutely and really need )
>
> ```html
> <div class="container" style="display:flex">
>     <div class="item item-1" style="flex-grow: 1"></div>
>     <div class="item item-1"></div>
>     <div class="item item-1"></div>
> </div>
> ```

### Flex-Shrink

> `flex-shrink` on an item , like `flex-shrink: 5` determines in what portion to others this element should shrink. here set to 5 five means it would shrink five times more than the other `elements` in the `container`
>
> `flex-shrink: 0` : set to zero 0 means that item will not shrink at all ( not even when the others do, due to low space, it would remain and keep its size )

> you may also use `flex-basis` to override the width ( or size ) of the item , like you had it to 150p for width . now in flex-basis you put it `flex-basis: 300px` and it would enlarge and override that initial value it had .	

### Flex

> you can use only `flex` in plase of all the `flex-grow, flex-shrink, flex-basis` , like `flex: 1 number number`

### Align-Self

> like `align-items` but for a single element only . like `align-self: center` would overwrite the `align-items: flex-start` ( that would align them all at the start top of the page ). with `align-self: center` that one element only would be centered and others remain there