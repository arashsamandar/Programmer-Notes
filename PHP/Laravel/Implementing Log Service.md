## Implementing `Log` Service in `Laravel`

> with `Log` i mean creating a mechanism to register and write : *what has happened in the app and who did it* . like i mean *when user registerd to the app* , or when he/she `Sings in` , and etc ...

> simply you could create a `Service` ( create the `Service` class that you want in the `services` folder in the `app` folder. if it doesn't exist create one ) and register it in laravel `ServiceProvider` by running :
>
> ```
> php artisan make:provider LogServiceProvider
> ```
>
> now registering the service in `register` method of the `Service Provider` like : ( it is only my suggestion to use a Service like below and creating Different Classes out of it Considering what you pass to the Constructor of Concrete Classes of the Interface )
>
> ```php
> class LoginServiceProvider implements ServiceProvider {
>     public function register(){
>         $this->app->bind(LogServiceInterface::class,function(Application $app){
> 			// the variable you send when you type
> 			// $folan = new LoginServiceProvider($folanVariable);
> 			// and it would be `evaluated` ( like what type of value it is )
> 			// in your Concrete Classes you write out of that Interface
>             if($argumentYouPassed == 'login'){
>                 return new LoginService('login');
>             }else{
>                 return new RegisterService('register');
>             }
>         })
>     }
> }
> ```

## Sending Argument To Our Custom `Service Provider` 

> there is a little difference and hence : *bind your class ( service ) like bellow*

- First Method Is By Using `Method Chaining` in The Service Class Itself, like so :

- ```php
  public class CustomHello {
      protected $username;
      public function setUsername($username): self{
          $this->username = $username;
          return $this;
      }
      public function sayCustomHello(){
          return "Hello MR " . $this->username['username'] // Because $username would be An Array
      }
  }
  // so in the `Controller` method , it would be like
  public function someMethod(){
      $arashHello = app(CustomHello:class)->setUsername('Arash Khaan');
      $arashHello->sayCustomHello();
  }
  ```

  - second is like bellow ( you should use it `like an array` in your service because it would be sent like ) `$arashHello = app(CustomHello::class,['username'=>'Salamander']);` and thus `username` would be accessed like below `$message = "Hello " . $this->theArgument['username'];`

```php
public class CustomHello {
    protected $username;
    public function __constructor($username){
        $this->username = $username;
    }
    public function sayCustomHello(){
        return "Hello MR " . $this->username['username'] // Because $username would be An Array
    }
}
// now in the Service Provider we have :
public function register(){
    $this->app->bind('App\Services\CustomHello',function($app,$username){
        return new CustomHello($username); // here it must be an array ( i mean $username )
    });
}
public function provides(){
    return ['App\Services\CustomHello'];
}
// now in the controller we call to make this (CustomHello) like so :
public function someMethod(){
    $customHelloService = app(CustomHello::class,['username'=>'Salamander']);
    $customHelloService->sayCustomHello();
}
// now you can test with
public function test_one(){
    $this->get('/folanURL')->assertSeeText("Hello MR Salamander");
}
// Note : `assertSeeText` even checks **if it even include a word or text, like here "Hell" even
// So be carefull that it contains all of the Text like "Hello MR Salamander" & not a part of it
```

