> is a method to register a callback to be executed after a specific type is resolved from the container.

## Use to Register Several Listeners ( bypassing starndar mode or registering in EventServiceProvider

```php
$app->afterResolving(Schedule::class, function ($schedule) {
    Event::listen(
        \App\Events\UserRegistered::class,
        [
            \App\Listeners\SendWelcomeEmail::class,
            \App\Listeners\NotifyAdminOfNewUser::class,
            \App\Listeners\SetupUserProfile::class,
        ]
    );
});
```

> In this case, it's waiting for the `Schedule` class to be resolved before registering the event listeners.
