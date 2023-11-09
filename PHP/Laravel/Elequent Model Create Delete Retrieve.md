## Elequent Model `Create` `Delete` `Retrieve`

The Eloquent ORM ( object Relational Mapper ) is a simple ActiveRecord
see forthereMore description if you want in ORM and there implementation in laravel

---

### create a model and naming convention

to make a model with its migration `-m` and controller `-c` use : `php artisan make:model Flight -mc`
by convention ( if you don't tell the Model wich table to use ) , its gonna use the Plural version of that name like `flights` or `snake case` for longer names like `UsersComments` becomes `users_comments`

### define wich table to use
you can define wich `table` to use by `protected $table = 'my_flights';`

if you don't want to use `timestamps` you can define `public $timespatms = 'false'`

```php
namespace App;
use Illuminate\Database\Eloquent\Model

class Flight extends Model {
protected $table = 'my_flights';
public $timespams = 'false';
}
```

### default Attibute values
if you like to set default attributes for some values in your table use `$attributes`

```php
protected $attributes = ['delayed' => false, ];
```

---


### Retrieving Models
Think of each Eloquent model as a powerful `query builder`

```php
$flights = App\Flight::all();
foreach ( $flights as $flight ) {
    echo $flight->name;
}
```

```php
$flights = App\Flight::where('active',1)
               ->orderBy('name','desc')
               ->take(10)
               ->get();
```


```php
App\Flight::chunk(100, function($flights) {
       foreach($flights as $flight) {
          // do whatever you want
       }
});
```

```php
foreach(App\Flight::where('name','tehran')->cursor() as $flight_names) {
        if(!empty($flight_names->date)) {
            return $flight_names->date;
        }
}
```

```php
$first_flight = App\Flight::find(1);

$threeFlightsNumber = App\Flight::find([1,3,4]);

$first_flight = App\Flight::where('active',1)->first();
```

---


### check if a Model Exists or not

```php
// use findOrFail or firstOrFail and they throw ModelNotFoundException if a Model does not exist , it would return page not found or 404
$model = App\Flight::findOrFail(1);
$model = App\Flight::where('date','>',100)->firstOrFail();
```

---

### Retrieving Aggregates

using `count` `sum` `max`

```php
$activeFlights = Flight::where('active',1)->count();

$highest_price = Flight::where('active',1)->max('price');
```

---

### create new model
```php
public function store(Request $request) {
     $newUser = new User;
     $newUser->name = $request->input('name');
     $newUser->family = $request->input('family');
     // call the save method on it and Done , user is saved in database .
     $newUser->save();
}
```

> `update` exactly the same way , by retrieving the model , then assing every value , then calling the `save` method .

```php
$flight = App\Flight::find(1);
$flight->name = 'New Flight Name';
$flight->save();
```

### Mass Updates
```php
User::where('active',1)->where('name','arash')
      ->update(['active' => 0 , 'name' => 'samandar']);
```

---

### Mass Assignment
> use `$fillable` for mass Assignment , laravel by default don't let mass assignment with
> `create` method , by using `$fillable` then you can mass assign .

```php
User::create(['name' => 'folan' , 'family' => 'folan']);
// yaa agar model ra az ghabl dari 
$user = new User;
$user->fill(['name' => 'arash' , 'family' => 'samandar']);
```

you can use `protected $guarded = []` to mention attributes you don't want to be `$fillable` 

> notice you can use eather `$guarded` or `$fillable` , NOT BOTH .

```php
public class User {
    protected $guarded = ['id'];
    // now every other attribute is $fillable by default , and you do not need to define $fillable again . 
}
```


> using `firstOrnew()` or `firstOrCreate()` to create a model with a given attribute if it already dosn't exist . `notice with firstOrCreat()` you gotta save the instance then .
> or using `updateOrCreate()`

```php
$flight = App\Flight::firstOrCreate(
    ['name' => 'Flight 10'],
    ['delayed' => 1, 'arrival_time' => '11:30']
);
// or
$flight = App\Flight::firstOrNew(
    ['name' => 'Flight 10'],
    ['delayed' => 1, 'arrival_time' => '11:30']
);
// or
$flight = App\Flight::updateOrCreate(
    ['departure' => 'Oakland', 'destination' => 'San Diego'],
    ['price' => 99, 'discounted' => 1]
);
```

---

### Delete Model
> Deleting Model by using `delete()` or `destroy()`
```php
$user = User::find(1);
$user->delete() // in this example we first retrieved the model

App\Flight::destroy(1);
App\Flight::destroy(1, 2, 3);
```

> Deleting by Query
```php
$user = User::where('active',1)->delete();
```

---

### Observers
> pay attention you can use `Event` and `Listeners` for your Model too . they are registered in `EventServiceProvider` in `$listen`array , as `key` `value`pair .
1. observer is used to create different methods for example for `created` `updated` `deleted` 
1. create an `observer` for your `Model` with `php artisan make:observer UserObserver -m=User` 
1. we register the `observer` in `boot` method of `AppServiceProvider`
```php
public function boot()
{
    User::observe(UserObserver::class);
}
```

> a typical observer class would look like this :

```php
class UserObserver
{
    public function created(User $user){}

    public function updated(User $user){}
    
    public function deleted(User $user){}
    
} // you an do anything you want with these .
```
