## What is Laravel Lumen & How To Install it

See This For Complete Guide : https://mattstauffer.com/blog/introducing-lumen-from-laravel/

> you can install `laravel lumen` very easily via PhpStorm Composer , new , look for `laravel/lumen` , and then install it . the other approach is to read the documetation on `laravel lumen` , and then you have to set the port in the console .

> so first you install it as you install `laravel/laravel` but now `laravel/lumen` ,

> after that you need to set the port for your `Microservice` or `Lumen`you have Created , so you should write in the terminal the following code : *php -S localhost:8000 -t public*

> in the created project , in the app -> bootstrap -> app.php
>
> enable the `facades`& `elequent`
>
> there is actually a lot there that you can enable for your `MicroService`

> also Remember To manipulate the `.env`file , for it to work with the Database

## What is Laravel Lumen

>[Lumen](http://lumen.laravel.com/) is a new project from Laravel creator Taylor Otwell. It's a "micro-framework", meaning it's a smaller, faster, leaner version of a full web application framework. PHP has two other popular micro-frameworks, Slim and Silex.

- is a 'micro-framework'
- meaning its smaller , faster , leaner version of a full web application
- php also has two other popular 'micro-frameworks' like Slim and Silex

## What is Lumen For ?

>Lumen is for projects and components that can benefit from the convenience and power of Laravel but can afford to sacrifice some configurability and flexibility in exchange for a speed boost.

>Lumen is targeted at [microservices](http://martinfowler.com/articles/microservices.html)-- small, loosely-coupled components that usually support and enhance a core project. Microservices are separated components with bounded contexts (meaning they have well-defined interfaces between each other), so in a microservice architecture you might have several small Lumen apps that support another, possibly Laravel-powered, app.

## Wrap It Up

:pushpin:**What is a WebService**

> `Web Service` : A way to expose the functinality/data of One Application to another . applications Using HTTP eg. GET , POST , DELETE , PUT

> `Micro-Service` : A service orienterd architecture ( SOA ) of developing software application such that the application is made up of multiple loosely-coupled and independent modules .

> `API` : The 'language' used by different modules and applications to communicate with each other .