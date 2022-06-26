> Remember that we created a middleware that which `forces the json response` , and is named
>
> ```ForceJsonResponse```

Next, we’ll add the middleware to our `app/Http/Kernel.php` file in the `$routeMiddleware` array:

```php
'json.response' => \App\Http\Middleware\ForceJsonResponse::class,
```

Then, we’ll also add it to the `$middleware` array in the same file:

```php
\App\Http\Middleware\ForceJsonResponse::class,
```

That would make sure that the `ForceJsonResponse` middleware is run on every request

### https://www.toptal.com/laravel/passport-tutorial-auth-user-access

### you must install passport and do the things neccessary



first name

last name

email 

password

password confirmation

## tokens

> 1) first install the `sanctum` for your `api`

> then create __sanctum__ `toke` with bellow code :arrow_double_down:

```markdown
$user->createToken()->plainTextToken;
```

> delete __sanctum__ `token` with bellow code

```
auth()->user()->tokens()->delete();
```

### validator _ database , validator checks if a column exists in database :

> with bellow code :

```markdown
$validator = Validator::make([
	'email' => 'required|exists:users' // smartly checks if the column email exists in users table
])
```

### Get URL query

> gets it using bellow methods

```markdown
$request->query()
$request->query('name')
$request->url()
$request->fullUrl()
```

### Delete Me

```markdown
Str::random(64) // for creating a token for reset password functionality
```

