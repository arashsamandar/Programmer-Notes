# Validate

> In the case of a traditional `HTTP request`, a `redirect response` will be generated, while a `JSON response` will be sent `for AJAX requests`.

---

###  Stopping On First Validation Failure
```php
$request->validate([
    'title' => 'bail|required|unique:posts|max:255', // in this case if required fail , the unique or max would not be checked .
    'body' => 'required',
]);
```
> A Note On Nested Attributes
If your HTTP request contains "nested" parameters, you may specify them in your validation rules using "dot" syntax:
```php
$request->validate([
    'author.name' => 'required',
    'author.description' => 'required',
]);
```

> if validation fails , an instance of `$errors` variable would be flashed into the session

> the `$errors` variable is `bound` to the view by `Illuminate\View\Middleware\ShareErrorsFromSession` `middleware` wich is provided
> by the `web middleware` group

```html
@if ($errors->any())
    <div class="alert alert-danger">
        <ul>
            @foreach ($errors->all() as $error)
                <li>{{ $error }}</li>
            @endforeach
        </ul>
    </div>
@endif
```


> we can check by `@error` in blade , to check if an error exists for a given name or not , just like :
```html
<label for="title">Post Title</label>
<input type="text" class="@error('title') is-invalid @enderror">
@error('title')
    <div class="alert alert-danger">{{ $message }}</div>
@enderror
```

> A Note On Optional Fields
> laravel would consider null as a validation error , if you do not want this to happen , write
```php
$request->validate(['title' => 'nullable|max:20']);
```

## Create Your Own Validator Class
1. first type the command `php artisan make:request myrequest`  and the name of your request
1. then in the App -> Http -> Request    folder , in your `MyRequest` class
```php
public function authorize() {
    return true;
}

public function rules() {
    return []; // your array like 'name' => 'required'
}

public function messages() {
   return []; // your messages like 'name.required' => 'vared kardane naam elzamist'
}
```

3. then in your `RegisterController` in your `store` or `create` or whatever the name , write :
```php
public function registerUser(MyRequest $request) {
   $request->validated();
   User::create([]);
}
```




















