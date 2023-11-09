# Create New User Type

1. first create a new model
1. The Model Should `extends` the `Authenticatable` 
```php
namespace App;
use Illuminate\Foundation\Auth\User as Authenticatable;

class Admin extends Authenticable {

}
```

3. create a `guard` and the `provider` in `auth.php`
```php
'guards' => [
     'admin' => [
               'driver' => 'session',
               'provider' => 'admins',
           ],
   ]
   
   'providers' => [
   
       'admins' => [
                  'driver' => 'eloquent',
                  'model' => App\Admin::class,
            ]
    ]
```

> you can use this `guard` in `LoginController` with `attempt` to login this type of user

```php
if(Auth::guard('admin')->attempt(['username' => $username, 'password' => $password])) {
     return redirect()->intended('/adminHome');
}
```

> then you can check if this type is loggedin with `check`

```php
// in blade or in controller :
@if(auth::guard('admin')->check())
    <div> Welcome Admin </>
@endif
```
