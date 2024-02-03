## Service Provider

> `Service Provider` : Play a Crucial role in Laravel Framework. it is the central place where the application's ( primary or custom ) Services gets Bootstraped.
>
> it **binds** the interfaces to their concrete ( class ) implementations
>
> you can register your service and bootstrap it to the `application` like below ( in the `register()` method of the Service Provider )

1) first create your service ( Class ) . like simply create a service ( class ) in the `Services` folder Under the `app` folder of the laravel

2) then create a `ServiceProvider` for it like :

   ```
   php artisan make:provider ArashServiceProvider
   ```

3) then bind it like below in the `ArashServiceProvider` that `extends` the `ServiceProvider` :

   > The `app()->bind()` method in Laravel allows you to bind a key to a closure or class, which tells Laravel's service container how to create instances of that class when it's needed. The key you pass to `app()->bind()` is a string that serves as an alias for the class or object you're binding

   ```php
   // first create the service like :
   class ArashService {
       public function sayHello(){
           return "hello user";
       }
   }
   // then create the provider
   namespace App\Providers;
   
   use Illuminate\Support\ServiceProvider;
   use App\Services\ArashService;
   
   class ArashhServiceProvider extends ServiceProvider
   {
       public function register()
       {
           $this->app->bind('ArashService',function ($app){
               return new ArashService();
           });
       }
   }
   // then use it like below
   class SomeController extends Controller {
       public function someMethod(){
           $arashService = app('ArashService');
           $arashService->sayHello();
       }
   }
   ```

   > other uses of `Service Provider` is to `bind` an `interface` to it's concrete ( class ) implementations , which tells the system when that interface is used which class should be used for it , like bellow :

   ```php
   $this->app->bind(ArashInterface::class,ArashNumberOneConcreteClass::class);
   ```

   > or explaining to the system to only create one `singleton` everywhere you want that class

   ```php
   $this->app->singleton(ArashClass::class,function(){
      return new ArashClass("some argument") ;
   });
   ```

   > or more complex , when to load which one -> when which class ( Controllers ) asks for them, like :
   >
   > Suppose you have an interface `MusicServiceInterface` and two different implementations of this interface, `SpotifyService` and `SoundCloudService`. You want to use these services in two different controllers, `OnlineMusicController` and `OfflineMusicController`. You could register these services in your service provider like this:

   ```php
   $this->app->when(OnlineMusicController::class)
    ->needs(MusicServiceInterface::class)
    ->give(function () {
       return new SpotifyService(env('SPOTIFY_API_KEY'));
    });
   
   $this->app->when(OfflineMusicController::class)
    ->needs(MusicServiceInterface::class)
    ->give(function () {
       return new SoundCloudService(env('SOUNDCLOUD_API_KEY'));
    });
   ```

   > another more complex one to determine which `Concrete Class` goes when :

   >Suppose we have an interface `PaymentGatewayInterface` and two concrete implementations: `StripePaymentGateway` and `PaypalPaymentGateway`.
   >
   >First, we would define the `PaymentGatewayInterface` and the concrete implementations:

   ```php
   interface PaymentGatewayInterface {
       public function charge($amount);
   }
   
   class StripePaymentGateway implements PaymentGatewayInterface {
       public function charge($amount) {
           // Code to charge through Stripe
       }
   }
   
   class PaypalPaymentGateway implements PaymentGatewayInterface {
       public function charge($amount) {
           // Code to charge through PayPal
       }
   }
   ```

   > then

   ```php
   namespace App\Providers;
   
   use Illuminate\Support\ServiceProvider;
   use App\Contracts\PaymentGatewayInterface;
   use App\Services\StripePaymentGateway;
   use App\Services\PaypalPaymentGateway;
   
   class PaymentServiceProvider extends ServiceProvider
   {
       public function register()
       {
           $this->app->bind(PaymentGatewayInterface::class, function ($app) {
               // Logic to determine which payment gateway to use
               // For example, we might check a configuration setting
               if (config('payment.gateway') === 'stripe') {
                   return new StripePaymentGateway();
               } else {
                   return new PaypalPaymentGateway();
               }
           });
       }
   }
   ```

   

   ## Service Container

   > is the actual place that `Service Providers` gets load into. it handles all the `dependencies` needed for the services and manages them
   >
   > The Service Container is a powerful mechanism that stores all of the bindings necessary to execute a Laravel application on a single server. Everything in the application can be bound together with the assistance of a service container. Laravel's service container plays a crucial role in enabling dependency injection, making your code more testable and maintainable. It simplifies the management of dependencies and allows for a high degree of flexibility and control over how your application components are wired together