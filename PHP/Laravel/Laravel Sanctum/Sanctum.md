## What is Sanctum

> Laravel Sanctum provides a lightweight authentication system for single-page applications (SPAs), mobile applications, and simple, token-based APIs. It allows each user of your application to generate multiple API tokens for their account. These tokens may be granted abilities or scopes, which specify which actions the tokens are allowed to perform

## install Sanctum

```
composer require laravel/sanctum
```

> then install the migration and configs of the sanctum

```
php artisan vendor:publish --provider="Laravel/Sanctum/SanctumServiceProvider"
```

> then use `HasApiTokens` on the `User` model , so you could generate tokens like below

```php
class SomeController extends Controller {
    public function generateToken(Request $request){
        $token = $user->createToken('auth_token')->plainTextToken;
		// then put it in the Header `Authorization: Bearer <token>`
    }
}
```

> then you can protect `routes` like below

```php
Route::middleware(['auth:sanctum'])->get('/user', function (Request $request) {
    return $request->user();
});
// or do `token` checking in the controller Manually with :
$token = $request->bearerToken(); // first getting the token from the request
// next get the user of this request
$user = $request->user();
// next evaluate the token
$tokenModel = $user->tokens()->where('id', hash('sha256', $token))->first();
// now if $tokenModel exists we just check it like :
if ($tokenModel) {
    // token is valid
}else{   
    // token is not valid
}
```

```php
// if you want to delete , delete like below :
$user->tokens()->delete();
```

> you can also add `role` or any other `payload` that you want 

```php
use Illuminate\Http\Request;

Route::post('/tokens/create', function (Request $request) {
    $token = $request->user()->createToken($request->token_name);

    // Manually add the 'role' ability to the token
    $token->forceFill(['abilities' => ['role' => 'user']])->save();

    return ['token' => $token->plainTextToken];
});
```

> and authenticate on route with :

```php
Route::middleware(['auth:sanctum', 'abilities:role'])->get('/user', function (Request $request) {
    return $request->user();
});
```

> also can be checked manually in the controller with below codes :

```php
$token = $request->bearerToken();
$tokenModel = $user->tokens()->where('id', hash('sha256', $token))->first();

if ($tokenModel && $tokenModel->can('role')) {
    // The token is valid and has the 'role' ability
} else {
    // The token is invalid or does not have the 'role' ability
}

```

> Note : to stop redirecting ( if authentication fails in api ( route )) you must provide the header which is
>
> ```
> -H "Accept: application/json"
> ```
>