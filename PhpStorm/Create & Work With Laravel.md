## Create & Work With Laravel Project In PhpStorm

> you can go to

```javascript
File -> new Project -> Composer -> Laravel/Laravel
```

> after that you need to set and change some things in the laravel project , like bellow :

> you need this address for composer `C:\ProgramData\ComposerSetup\bin\composer.phar` ( if You already have composer installed )

## Adding Laravel Plugin for PhpStorm

1) go to settings -> plugins -> laravel plugin -> add

## Next

> in `AppserviceProvider.php` in `Boot()` Method Pase : `Schema::defaultStringLength(191);`



> in `verifyCSRFToken.php` in `protected $except = [];` add `'*'` // To disable CSRF protection



> Install phpdocumentor : Press CTRL + SHIFT + X >> Paste 

`composer req phpdocumentor/reflection-docblock:^2.0`



**Important**

> `composer req barryvdh/laravel-ide-helper`

> in AppserviceProvider in register() , add the following :

```php
if ($this->app->environment() !== 'production') {
        $this->app->register(\Barryvdh\LaravelIdeHelper\IdeHelperServiceProvider::class);
}
```

> Then Add :

```php
Barryvdh\LaravelIdeHelper\IdeHelperServiceProvider::class,
```

To > `config/app.php`

------

7 ) go to settings and search for laravel ( enable plugin for this project )

8 ) go to Tools >> composer dependencies >> search for : caouecs/laravel4-lang ( install it )

9 ) go to Tools >> composer dependencies >> search for : laravelcollective/html ( install it )

10 ) add this :

```
  'Form' => Collective\Html\FormFacade::class,
  'Html' => Collective\Html\HtmlFacade::class,
  
  to your config/app.php file in alies section
  
  -----------------------------------------------------
  add this :
  Collective\Html\HtmlServiceProvider::class, 
  
  to you config/app.php file in serviceproviders section
  ---------------------------------------------------------
```

11) IMPORTANT :: if you don't want to land on login when you type localhost:8000 ,
    go to the controller that return view() ( your home ) and in its __construct
    remove auth

11 ) YOU HAVE TO CHANGE RedirectIfAuthenticated.php handle function ( /home) to ( / )
	  

11 ) php artisan ide-helper:generate

12 ) artisan clear-compiled

13 ) Settings >> Tools >> Command Line Tool Support >> Add

------

alies : artisan
path to php executable : php.exe
path to script : ( search in your project for artisan file )

click OK

------

npm install  // If You Want to Install Node-Modules Folder For Vue Or AnyOther Like Bulma Or Else

npm run dev // for development

npm run production // for production