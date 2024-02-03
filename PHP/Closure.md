> a closure is an anonymus function ( that could be easily passed as an argument , can be stored in variables )
>
> NOTE : if you want a closure to have access to a outside sources ( Variables ) , you must define it like bellow

```php
$request = new Request();
function($message) use($requesst) {

}
```

>A `Closure` in PHP is an anonymous function that can access variables imported from the outside scope without using any global variables. It is a callable class to which you've bound your parameters manually[1](https://www.php.net/manual/en/class.closure.php). Closures are useful for various purposes, such as:

- Reducing the size of your code and allowing PHP scripts to load faster
- Implementing higher-order functions, such as, which asks for both the input array (data) and a function (a strategy or a callback) used as a callback for each array item
- Defining a function returning a single filter function for `array_filter()`, out of a family of filter functions, each filter function in the family accepts only elements greater than some minimum value

```php
$arashClosure = function($value){
    return ($value * 5);
}
$firstFiveMultiplier = $arashClosure(5);
// OR
$closure = function($name) {
    return "Hello, $name!";
};
echo $closure("John");
// OR
$numbers = [1, 2, 3, 4, 5];
$evenNumbers = array_filter($numbers, fn($number) => $number % 2 === 0);
print_r($evenNumbers); // Output: Array ( [1] => 2 [3] => 4 )
// for php < 7.4 use below :
$numbers = [1,2,3,4,5,6];
$evenNumbers = array_filter($numbers,function($number){
   if($number%2===0)  return $number;
});
// OR
function createCounter() {
    $count = 0;
    return [
        'increment' => fn() => ++$count,
        'decrement' => fn() => --$count,
        'getCount' => fn() => $count,
    ];
}

$counter = createCounter();
$counter['increment']();
$counter['increment']();
$counter['decrement']();
echo $counter['getCount'](); // Output: 1
```

