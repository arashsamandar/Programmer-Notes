## OOP When you have too many data ( Objects ). use FP when you have too many Operations

# Use Whenever Possible

- __Functions Only__
- __No Side Effects__
- __Fixed Control Flow__

## Functions Can Return anything `Imaginable`

### Old was the `Declaritive` & `Command` Way 

- __Imperitive__

> reduce footprints and `Side Effects` of running your code & functions 

```php
function squared_sum(x, y){
    $sum = (x + y);
    $squared = $sum^2;
    return $squared;
}

/*** Better ***/

function squared_sum(x, y){
    return (x + y)^2;
}

```

> first code will create `additional`, `unimportant` variables to store data, using ( and address ) memory in places were it was not really needed.