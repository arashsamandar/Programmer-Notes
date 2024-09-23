### 1.Program loads from public/index.php with script :

```php
define('LARAVEL_START', microtime(true));
require __DIR__.'/../vendor/autoload.php';
(require_once __DIR__.'/../bootstrap/app.php')
    ->handleRequest(Request::capture());
```

### 2.which as you see requres & sends the captured Request to the >> boostrap/app.php :

```php
return Application::configure(basePath: dirname(__DIR__))
    ->withRouting(
        web: __DIR__.'/../routes/web.php',
        commands: __DIR__.'/../routes/console.php',
        health: '/up',
    )
    ->withMiddleware(function (Middleware $middleware) {
        //
    })->create();
```

which in turn first returns the result of create() , withMiddleware() , withRouting() , on
the return of 3.Application::configure().

### 3.Application::configure() is a method of Illuminate\Foundation\Application .
  but it does not instantiate that class . it has a method like :

```php
public static function configure(?string $basePath = null)
    {
        $basePath = match (true) {
            is_string($basePath) => $basePath,
            default => static::inferBasePath(),
        };

        return (new Configuration\ApplicationBuilder(new static($basePath)))
            ->withKernels()
            ->withEvents()
            ->withCommands()
            ->withProviders();
    }
````

which this in turn uses the Configuration\ApplicationBuilder instance ( makes one ) and calls all methods you see like `withKernels` on it

### 4.the rest ( like providers array ) would be gathered from 
  Config/app.php 