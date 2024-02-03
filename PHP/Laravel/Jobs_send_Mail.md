first

```
php artisan make:job CustomerJob
```

then

```
php artisan queue:table
```

in the `queue.php` and `.env`

```
QUEUE_CONNECTION=DATABASE
```

then

```
php artisan make:mail SendMailable
```

then

```
php artisan queue:work // this is crucial
```

#### or watch bello video to send a mail using Mail Facade and Jobs

```
https://www.youtube.com/watch?v=y2NiXD7nSUQ
```



php artisan make:job arashJob

in `.env` file `Queue-Connection = database`

php artisan queue:table

php artisan migrate

php artisan queue:work

in the queue.php

DATABASE_CONNECTIOIN = DATABASE