# Authentication
1. The authentication configuration file is located at  `config/auth.php`
1. At its core, Laravel's authentication facilities are made up of `guards` and `providers`

---

### Redirecting
> by default laravel redirects to `/home` for changing that in :
`LoginController`  `RegisterController`  `ResetPasswordController`  `ValidationController` . 
```php
public class RegisterController extends Controller {
    protected $redirectTo = '/myPage';
}
```

---

### Retrieving The Authenticated user
> you can use
```php
$user = Auth::user(); // gets the currently Authenticated user
$user = Auth::id(); // gets the ID of currently Authenticated user
```

> To get the Authenticated User in your `Controller` you can use :
```php
public function checkUser(Request $request) {
    $request->user(); // this will return the currently Authenticated User .
}
```

> to determin if the current user is Authenticated or not you may use `Auth::check()`
```php
if(Auth::check()) {
   // the user is Authenticated
}
```

---
### protecting Routes & Controllers
> you can use the `auth` `middlware`
1. for protecting Routes
```php
Route::get('/usersHomePage',function(){})->middleware('auth'); // now only authenticated users can access this route .
```

2. for protecting Controllers
```php
public function __construct() {
     $this->middleware('auth');
}
```

---
### Redirecting Unauthenticated Users
> When the auth middleware detects an unauthorized user, it will redirect the user to the `login named route`. You may modify this behavior by `updating` the `redirectTo` `function` in your  `app/Http/Middleware/Authenticate.php` file


---
### Using Auth
```php
public function authenticate(Request $request) {
    $credentials = $request->only('username','password');
    if(Auth::attemp($credentials)) {
       return redirect()->intented('/dashboard');
    }
}
```

### Adding Extra Conditions to the Auth :
```php
public function authenitication(Request $request) {
   $username = $request->input('username');
   $password = $request->input('password');
   if(Auth::attempt(['username' => $username,'password' => $password,'active' => 1])) {
      // The user is active, not suspended, and exists.
   }
```

---
### Authenticate Different Users
> we will use `guard` on the `Auth` to be able to `authenticate` different users type
```php
if (Auth::guard('admin')->attempt($credentials)) {
    // this is an admin
}
```
> and then you can check it in blade or in controller with
```php
@if(auth::guard('admin')->check()) <div> Welcome Admin </div> @endif
```

---
### Logging Out
```php
Auth::logout();
```

---
### Remembering Users
> If you would like to provide `remember me` functionality in your application, you may pass a boolean value as the second argument to the `attempt` method , `Attention :` to use this functionality you must have a column named `remember_token` with `varchar(100)`
```php
if(Auth::attempt(['username' => $username,'password' => $password],$remember)) {
}
```

> NOTE : if a user is comming through `Remember Me` functionality , you can check it with :
```php
if(Auth::viaRemember()) {
   // do this is user is authenticated using Remember Me
}
```


---
### Authenticating A User Instance
> If you need to `log an existing user instance` into your application, you may `call the Login` method with the user instance
```php
$user = User::find(1);
Auth::login($user)
Auth::guard('admin')->login($user);
```


---
### Http Basic Authentication `is an interesting feature..`
> provides a Quick way to authenticate for a page , without login page !!

![Image](D:\Programming Notes/medley/resources/HJagTQ5qE_rJpgcricE.png)
> NOTE : it uses `email` as username so you need `middleware` Knowledge to change its
> implement with just an attache `middlware('auth.basic')` to your `Route`
```php
Route::get('/Mobiles','Controller@controllerFunction')->middleware('auth.basic');
```

> `How to Change Basic Http Request To get username instead of email`

1. create a middleware that extends  `Illuminate\Auth\Middleware\AuthenticateWithBasicAuth`
2.   to create it use `php artisan make:middleware CustomBasicHttpAuth` where in that file we write
```php
namespace app\Http\Middleware;

use Closure;
use Illuminate\Auth\Middleware\AuthenticateWithBasicAuth;

class BasicAuthMiddleware extends AuthenticateWithBasicAuth
{
    public function handle($request, Closure $next, $guard = null, $field = null)
    {
        $this->auth->guard($guard)->basic($field ?: 'username'); //place here the name of your field

        return $next($request);
    }

}
```

3.   then in the `kernel.php` in the `$routeMiddleware` register your `middleware` like :

```php
protected $routeMiddleware = [
        'samandar' => \App\Http\Middleware\BasicAuthMiddleware::class,
        ]
```

```php
protected $routeMiddleware = [
    'samandar' => \App\Http\Middleware\BasicAuthMiddleware::class,
]
// and use it in your web.php file like this :

Route::get('/test','MyController@myFunction')->middleware('samandar') // all good now
```



















