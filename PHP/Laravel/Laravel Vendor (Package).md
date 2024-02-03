# What is a `vendor` in Laravel & how to make it

> the `vendor` is equivalent of `package` , and its the primary way to `add functionallity` to your laravel application

>Any of these packages may be used with Laravel by requesting them in your `composer.json` file.
>
>simply with below commands :

```
composer require laravel/sanctum
```

> no above would install the `Sanctum` package for the app
>
> after that for installing it's configuration files and Migrations we shall run below :

```
php artisan vendor:publish --provider="Illuminate\App\Folan\SanctumServiceProvider"
```

>These packages may have routes, controllers, views, and configuration specifically intended to enhance a Laravel application