# Events and Listeners
> If you want to simply track changes in your Model , use `Observers`

Eloquent models fire several events, allowing you to hook into the following points in a model's lifecycle:  `retrieved`, `creating`, `created`, `updating`, `updated`, `saving`, `saved`, `deleting`, `deleted`,  `restoring`, `restored`. Events allow you to easily execute code each time a specific model class is saved or updated in the database. Each event receives the instance of the model through its constructor.

1. To get started, define a `$dispatchesEvents` property on your Eloquent model that maps various points of the Eloquent model's lifecycle to your own `event classes`
1. After defining and mapping your Eloquent events, you may use `event listeners` to handle the events.
```php
class User extends Model {
   protected $dispatchesEvents = ['saved' => UserSave::class,'updating' => UserUpdate::class];
}
```

> to create an Event and its Listener for a Model , go to `EventServiceProvider` and its array create your `Event ('key')` and `Listener('value')`
> in the `protected $listen Array` we have :
```php
protected $listen = [
        Registered::class => [
            SendEmailVerificationNotification::class,
        ],
        'App\Events\UserRegistered' => ['App\Listeners\CreateARegisteredLog'],
    ];
```

> then create these Files using `php artisan event:generate`

then you can call the Event From your model like :
```php
class User extends Model {
    // using mass asignment in function
    public function storeUser(Request $request) {
         $user = User::create([
             'name' => $request->input('name');
             'family' => $request->input('family');
         ]);
         event(new UserRegistered($user)); // it would call the UserRegistered Event Wich we would get in the CreateARegisteredLog class
    }
}
```

> and in your `UserRegistered` method
```php
public $user;
public function __construct($user) {
    $this->user = $user;
}
```

> then in the `Listener` `handler()` method we handle ( write our code for that event ).
```php
public function handle(UserRegistered $event)
    {
        $log = new Log;
        $log->user_id = $event->user->id;
        $log->type = 'User Registered';
        $log->save();
    }
```














