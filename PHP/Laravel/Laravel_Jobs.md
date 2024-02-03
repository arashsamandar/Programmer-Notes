## how to create and use `jobs` in laravel

## Jobs

> represent units of work that need to be executed `asynchronously`. Jobs encapsulate the task to be performed and can include data or instructions required for its execution
>
> **so job means the code ( task ) that you want to execute `Asyncronously`**
>
> **Note :** In Laravel, jobs are classes that implement the `Illuminate\Contracts\Queue\ShouldQueue`

## immediate Job Dispatch

```php
ExampleJob::dispatch($data);
```

> In this case, `$data` is the data that you want to pass to the job. The `dispatch` method sends the job to the queue, and it will be processed as soon as a worker is available

> like below code
>
> ```php
> class ArashJob implements ShouldQueue
> {
>     use Dispatchable, InteractsWithQueue, Queueable, SerializesModels;
> 
>     public $myName = "";
> 
>     public function __construct($myName)
>     {
>         $this->myName = $myName;
>     }
> 
>     public function handle()
>     {
>         Log::alert('Hello ArashJob Runed : the Task you wanted to run Asynchronously behind the Scene Sir ! ' . $this->myName);
>     }
> }
> // TestController.php > and run it like
> public function testingImmediateDispatchedJobs(){
>         ArashJob::dispatch("HELLHELLOHELLO Value");
> }
> ```
>
> and run it with
>
> ```php
> Route::get('/somepoint',[TestController::class,'testingImmediateDispathcedJobs']);
> ```
>
> and now just call the above `route` will result in dispatching the job ( running it Asynchronously )

## Jobs Chaining

>**Job Chaining** : Job chaining in Laravel allows you to create sequences of jobs executed in a synchronous order. This feature enables you to build complex workflows by breaking them down into smaller, manageable steps. To chain jobs, use the `withChain()` method when dispatching the first job in the sequence:

```
CreateUserJob::withChain([
    new SendWelcomeEmailJob(),
    new LogRegistrationActivityJob(),
    new NotifyAdminJob(),
])->dispatch();
```

> In this example, `CreateUserJob` is the first job in the chain, and it specifies the subsequent jobs in the `withChain()` method. Laravel will ensure that these jobs are executed in the specified order

# Using Queue For Jobs

## Workers

> These are processes or threads responsible for executing queued jobs. They continuously monitor the task queue and pick up jobs for execution. Laravel provides tools to manage and scale workers efficiently

## Queues

> Queues are named channels where jobs are placed for processing. You can configure multiple queues to prioritize and organize tasks based on their importance and resource requirements
>
> When you dispatch a job, it gets added to the queue. The queue driver stores the job's details in a persistent storage (like a database), and a worker retrieves the job from the queue and executes it. Once the job is processed, it is removed from the queue
>
> to process a queued job you need a `queue worker` which you can create with :
>
> ```
> php artisan queue:work --queue=emails --tries=3
> ```
>
> This command runs a worker that processes jobs from the `emails` queue and retries failed jobs up to three times

## Using Queue

> **Laravel Queue** : The Laravel queue system is a powerful tool that allows you to defer the processing of a time-consuming task, such as sending an email, until a later time, thus drastically speeding up web requests to your application

>Remember, you need to have a queue driver configured in your Laravel application to use queues

> check the `queue.php` and see that it is using the `database` , it is okay by diffault

> now check the `.env` file and see that __QUEUE_CONNECTION__ is set to database

```php
QUEUE_CONNECTION=database
```

```php
php artisan queue:table

php artisan migrate
```

a `jobs` table would be created now

```
ArashJob::dispatch();
```

> now if you check the database , the `jobs` table would have a record of our job

> now lets run the job in the back ground , to do that we need a `worker`

```
php artisan queue:work
```

