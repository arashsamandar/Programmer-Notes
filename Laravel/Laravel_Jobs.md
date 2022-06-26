## how to create and use `jobs` in laravel

> first we create a job using bellow command :

```
php artisan make:job ArashJob
```

> every job has a` __constructor` and `handle` method
>
> we put our `jobs` code in the `handle()` __method__ , like bellow :arrow_double_down:

```php
class ArashJob implements ShouldQueue
{
    use Dispatchable, InteractsWithQueue, Queueable, SerializesModels;

    public function __construct()
    {

    }

    public function handle()
    {
        sleep(5);
        Log::alert('hello arash');
    }
}
```

> no we can call our job with creating a new instance of it , like bellow :

```php
public function testJob() {
    (new ArashJob())->handle();
}
```

## Using Queue

> check the `queue.php` and see that it is using the `database` , it is okay buy diffault

> now check the `.env` file and see that __QUEUE_CONNECTION__ is set to database

```php
QUEUE_CONNECTION=database
```

> now create the table with artisan command , like bellow :

```php
php artisan queue:table

php artisan migrate
```

a `jobs` table would be created now

> and now we are ready to `dispatch` __jobs__ to the `queue`
>
> dispatch it with bellow code in your `controllers`

```
ArashJob::dispatch();
```

> now if you check the database , the `jobs` table would have a record of our job

> now lets run the job in the back ground , to do that we need a `worker`

```
php artisan queue:work
```



> we can use the `delay` method to tell the queue worker to wait for example 5 second .

```php
ArashJob::dispatch()->delay(5);
```

> __NOTE__ : we can terminate a job if it took too long , using the property of job class named `public $timeout = 5`

```php
class ResetPasswordEmailJob implements ShouldQueue
{
    use Dispatchable, InteractsWithQueue, Queueable, SerializesModels;
    
    // here we go :
    public $timeout = 5; // waits five seconds and if job took more that this to respond , it would terminate it .

    public function __construct()
    {

    }

    public function handle()
    {
        sleep(5);
        Log::alert('hello arash');
    }
}
```

