## `Service Container` & `Service Provider`

> `Service Provider` : is the real place that `Services` would be stored. it does all the Class ( Services ) `Dependecies`, also their `Dependecy Injection`

> 'Service Provider' : is the actual place that all application `Services` get `Registered` and `Bootstraped`. you may also create one with first) create a class ( service ) and write your service like below :
>
> ```php
> <?php
> 
> namespace App\Services;
> 
> class GreetingService
> {
>     public function greet($name)
>     {
>         return "Hello, {$name}!";
>     }
> }
> // then we have to create our `provider`
> // and register the service there
> <?php
> 
> namespace App\Providers;
> 
> use Illuminate\Support\ServiceProvider;
> use App\Services\GreetingService;
> 
> class GreetingServiceProvider extends ServiceProvider
> {
>     public function register()
>     {
>         $this->app->bind(GreetingService::class, function ($app) {
>             return new GreetingService();
>         });
>     }
> 
>     public function boot()
>     {
>         // This is where you can perform bootstrapping actions.
>     }
> }
> 
> // then register it in the `config/app.php`
> 
> 'providers' => [
>     // Other Service Providers
> 
>     App\Providers\GreetingServiceProvider::class,
> ],
> 
> // then using it
> 
> <?php
> 
> namespace App\Http\Controllers;
> 
> use App\Services\GreetingService;
> 
> class GreetingController extends Controller
> {
>     protected $greetingService;
> 
>     public function __construct(GreetingService $greetingService)
>     {
>         $this->greetingService = $greetingService;
>     }
> 
>     public function greet($name)
>     {
>         return $this->greetingService->greet($name);
>     }
> }
> ```
>
> 
>
> ```
> php artisan make:provider ArashServiceProvider
> ```
>
> `Service Provider` : is also used for DRY , it is used to hide the complex application so the Controller that is only Resposible for handling Http request doesn't get plouted . also can be reused everywhere and service container hanles the dependencies of them

## Request & Middlewares

> you can create your custom `registerRequest` like below
>
> ```php
> php artisan make:request registerRequest
> ```
>
> then it does have 3 methods like : `authorize` , `rules` , `messages` that you may alter
>
> - authorize : to authorize the user that wants to do request
> - rules : to write the rules like ` 'name' => 'required|min:5'` 
> - messages : to customize messages like `'name.required'=>'name is requiree'`

### Middleware

> create middleware with `php artisan make:middleware ArashMiddleware` .
>
> then do process what you want from the sent `request` in the `handle` method and if ok you should use `return $next($request)` or else `return response()->json(['message'=>'folan is required'])`
>
> also then register it in the `app/http/kernel.php` in the `route` middleware , or if you want this middleware to be applied on every request that the system gets ( then write them in the global ( `$middleware` )) array

### how to use it :

> use middleware on `Route` like below :
>
> ```php
> Route::get('/folanURL',[Controllers\TestController::class,'register'])->middleware('arash');
> // or in the controller itself like below :
> class TestController extends Controller{
>     public function __construct(){
>         $this->middleware('arash');
>     }
> }
> ```