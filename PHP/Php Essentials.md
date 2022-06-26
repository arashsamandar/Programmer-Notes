## what is the php core engine ?

> the php core engine for php 4 is `zend 1`& for 5 and over is `zend 2` .
>
> NOTE : **we have oop since version 5** 

## What are the benefints of Using Php ?

- free
- open source
- cross platform
- larg community
- web desing in mind

## Some of Php String Functions are :

- strtolower();
- strtoupper();
- ucfirst();
- ucwords();
- trim();
- strstr();
- str_replace();
- strpos();
- strlen();
- substr();
- strchr();

## some of Php Array Functions are :

- max();

- min();

- count();

- sort();

- rsort()

- print_r();

- implode("*",$numbers); // converts to String with * between them .

- explode("*",$num_String); // converts to Array .

- in_array(24,$numbers);

- array_pop

- array_push

- array_shift

- array_unshift

- array_slice

- array_splice

## some of Php Numeric Functions are :

- abs(0 - 100);

- pow(2,4);

- round($float,1); // round to one decimal

- ceil(); // round UP

- floor();  // round down

- sqrt(100); // 10

- fmod(20,7); // is the Modulo ( returns the remainder )

- is_int($float); // is it an integer or not .

- is_float($float); // same as above

- is_numeric();



## Return Multiple Values From an Array in Php

```php
function add_sub($val1,$val2) {
    $add = $val1 + $val2;
    $sub = $val1 - $val2;
    return array($add,$sub);
}

list($adding,$subtracting) = add_sub(4,56);
echo $adding;
echo $subtracting
```

> so by using `array`and `list`

## How to show php Errors

> you can set the `display_error = on` and `error_reporting = E_ALL` in `php.ini`

**OR in the ini file we can write**

> `ini_set('display_errors','on')`

## There are Four 4 Main Category of errors

- Fatal Errors (PHP understands the code but could note execute)
- Sytax Erros (php could not understand the process the code)
- Warnings ( php found a problem , but was able to recover )
- Notices ( php is offerin advice )

## Some Functions We might use for Debugging

- echo
- print_r($array)
- gettype($variable)
- var_dump($variable)
- get_defined_vars(); // array of all the defined variable

> the most Popular Debugger for Php is `Xdebug`
>
> we also have `DBG` and `FirePHP`

# Building Web Pages

## There are 3 ways to get data from users on the web 

- URLs/Links  GET
- Forms  POST
- Cookies  COOKIE

*NOTE : we use `urlencode()`function for GET ( for the parameters we send in the URL Query )*

## Headers & Redirection

```php
function redirect($path) {
    header("Location: $path");
    exit
}
```

## Cookies

> Cookies are the small datas that the websites asks your browser to keep around

> Whithout Cookies web servers don't recognize when multiple page request comes from a same user .

> Cookies go in the Headers , so if there is no request or response , we can't see them .

### Setting Cookie Values

```php
setCookie($name,$value,$expire);

$name = "test";
$value = 44;
$expire = time() + (60*60*24*7); // one week
setcookie($name,$value,$expire);
```



