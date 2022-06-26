# Query Builder

### Retieving All Results From A Table
> The `get` method returns an `Illuminate\Support\Collection` containing the results where each result is an instance of the PHP `stdClass` object
```php
$users = DB::table('users')->get();
foreach ($users as $user) {
    echo $user->name;
}
/*Do not confuse these operation with Model Operations like*/ $users = User::all();
```

### Retrieve A single Row / Column From A Table
> If you just need to retrieve a single row from the database table, you may use the `first` method. This method will return a `single stdClass object`
```php
$user = DB::table('users')->where('name','john')->first();
```

> If you don't even need an entire row, you may extract a single value from a record using the `value` method
```php
$userEmail = DB::table('users')->where('name','john')->value('email');
```

> to Retrieve by ID we use `find`
```php
$user = DB::table('users')->find(1);
```

> Retrieving A List Of Column Values
> If you would like to retrieve a `Collection` containing the values of a `single column`, you may use the `pluck` method
```php
$usersFamily = DB::table('users')->pluck('family');
foreach($usersFamily as $family) {
   echo $family;
}
```

> Retrieving and Processing 100 rows per each request
```php
DB::table('users')->chunk(100,function($users){
    foreach($users as $user) {
       echo $user->name;
    }
});
```

> use `chunkById` for updating thousends of records , it is better and can't malfunction
```php
DB::table('users')->where('active', false)
    ->chunkById(100, function ($users) {
        foreach ($users as $user) {
            DB::table('users')
                ->where('id', $user->id)
                ->update(['active' => true]);
        }
    });
```

---

> The query builder also provides a variety of aggregate methods such as `count`, `max`, `min`,  `avg`, and `sum`.
```php
$price = DB::table('orders')
                ->where('finalized', 1)
                ->avg('price');
```

---

### Determining If Records Exist
> use `exists` and `dosntExists` instead of `count` to know if a user exists or not , just like :
```php
return DB::table('users')->where('finalize',true)->exists();
return DB::table('users')->where('finalize',true)->dosntExists();
```
### 
---
# Selects
### Specifying A Select Clause
> You may not always want to select all columns from a database table. Using the `select` method, you can specify a custom select clause for the query
```php
$users = DB::table('users')->select('name','family')->get();
```
> or you can select like bellow :
```php
$user = DB::table('users')->where('username','solomon')->first()->name;
```
### using Raw and SelectRaw
Sometimes you may need to use a raw expression in a query. To create a raw expression, you may use the `DB::raw` or `DB::selectRaw` method
- Raw
```php
$users = DB::table('users')
                     ->select(DB::raw('count(*) as user_count, status'))
                     ->where('status', '<>', 1)
                     ->groupBy('status')
                     ->get();
```

- Selectraw
```php
$orders = DB::table('orders')->selectRaw('price * ? as price_with_tax')->get();
```

> we also have `whereRaw` / `orWhereRaw` and or `havingRaw` / `orHavingRaw` and `orderByRaw` 
> Wich you can find in the Query Builder Section of Laravel Document . but here is an example :
```php
$orders = DB::table('orders')
->select('department',DB::raw('SUM(price) as total_sales');
->havingRaw('SUM(price) > ?',[2500])->get();
```

---
## Join
### inner join
> to perform a basic `inner join` , you may use the `join` method
```php
$users = DB::table('users')
        ->join('contacts','users.id','=','contacts.user_id')
        ->join('orders','users.id','=','orders.user_id')
        ->select('users.*','contacts.phone','orders.price')
        ->get();
```
> for more Advanced joins see the documet on laravel Query Builder in Join section
> like :
```php
DB::table('users')
        ->join('contacts', function ($join) {
            $join->on('users.id', '=', 'contacts.user_id')->orOn(...);
        })
        ->get();
```

---

### Where Clauses
> the most basic type of `where` clauses in Laravel requires three arguments
>
> 1. name of the column  2. the operator ( wich can be any of the database's supported operators  3. the value to evaluate against the column
```php
$users = DB::table('users')->where('votes', '=', 100)->get();
// for convenient , if you want to see if the value is equal to .. use two arguments
$users = DB::table('users')->where('name','arash')->get();
```

> you may use a veriaty of operators
```php
$users = DB::table('users')->where('name','like','T%')->get();
```

> you can pass `an array` of `conditions` to `where` clause
```php
$users = DB::table('users')->where([[],[])->get(); // like bellow
$users = DB::table('users')->where([['status','=','1'],['message','<>','1']])->get();
```

### Or Statements
```php
$users = DB::table('users')->where('votes', '>', 100)
                            ->orWhere('name', 'John')
                            ->get();
```

---
### Additional Where Clauses
1. whereBetween / orWhereBetween
> The whereBetween method verifies that a column's value is between two values
```php
$users = DB::table('users')->whereBetween('votes',[1,100])->get();
```

2.   whereNotBetween / orWhereNotBetween
```php
$users = DB::table('users')->whereNotBetween('votes', [1, 100])->get();
```

3.   whereIn / whereNotIn / orWhereIn / orWhereNotIn
```php
$users = DB::table('users')->whereIn('id',[1,2,3])->get();
```

4.   whereNull / whereNotNull / orWhereNull / orWhereNotNull
> The `whereNull` method verifies that the value of the given column is `NULL`
```php
$users = DB::table('users')->whereNull('updated_at')->get();
```

5.    whereDate / whereMonth / whereDay / whereYear / whereTime
> The `whereDate` method may be used to `compare` a column's value against a `date`
```php
$users = DB::table('users')->whereDate('created_at', '2016-12-31')->get();
```

6.   whereColumn / orWhereColumn
> The `whereColumn` method may be used to verify that two columns are equal
```php
$users = DB::table('users')->whereColumn('first_name','last_name')->get();
```
> The whereColumn method can also be passed an array of multiple conditions. These conditions will be joined using the and operator
```php
$users = DB::table('users')
                ->whereColumn([
                    ['first_name', '=', 'last_name'],
                    ['updated_at', '>', 'created_at']
                ])->get();
```

---

### Parameter Grouping
> Sometimes you may need to create more advanced where clauses such as "where exists" clauses or nested parameter groupings
```php
DB::table('users')
            ->where('name', '=', 'John')
            ->where(function ($query) {
                $query->where('votes', '>', 100)
                      ->orWhere('title', '=', 'Admin');
            })
            ->get();
```
## Ordering, Grouping, Limit, & Offset

> The `orderBy` method allows you to sort the result of the query by a `given column`
> you can use `desc` or `asc` for the second column
```php
$users = DB::table('users')->orderBy('name','desc')->get();
```

## latest / oldest

> The latest and oldest methods allow you to easily order results by date. By default, result will be ordered by the created_at column. Or, you may pass the column name that you wish to sort by
```php
$usrs = DB::table('users')->latest('created_at')->get();
```

> Mohem
### groupBy / having
```php
$users = DB::table('users')->groupBy('id')
         ->having('id','>',10)
         ->get();
```

### skip / take
```php
$users = DB::table('users')->skip(10)->take(5)->get();
```

---
## Conditional Clauses
> Sometimes you may want clauses to apply to a query only when something else is true. For instance you may only want to apply a where statement if a given input value is present on the incoming request. You may accomplish this using the when method
```php
// NOTE : The when method only executes the given Closure when the first parameter is true
$userID = 1;
$users = DB::table('users')->when($userID,function($query,$userID){
              return $query->where('id',$userID);
})->get();
```

> Now Using `Else` in here with another function
```php
$users = DB::table('users')
                ->when($sortBy, function ($query, $sortBy) {
                    return $query->orderBy($sortBy);
                }, function ($query) {
                    return $query->orderBy('name');
                })
                ->get();
```

---
## Insert
```php
DB::table('users')->insert(['name' => 'arash','family' => 'samandar']);
```
> we can also insert several records by using an array of arrays like :
```php
DB::table('users')->insert([
    ['email' => 'taylor@example.com', 'votes' => 0],
    ['email' => 'dayle@example.com', 'votes' => 0]
]);
```
### Auto-Incrementing IDs
> If the table has an auto-incrementing id, use the insertGetId method to insert a record and then retrieve the ID
```php
$id = DB::table('users')->insertGetId(['name' => 'arash','family' => 'samandar']);
```

---
## Update
> we also have `update` or `updateOrInsert` if the matching record does not exists
```php
DB::table('users')
    ->updateOrInsert(
        ['email' => 'john@example.com', 'name' => 'John'],
        ['votes' => '2']
    );
```

---
## Increment & Decrement
```php
DB::table('users')->increment('votes');

DB::table('users')->increment('votes', 5);

DB::table('users')->decrement('votes');

DB::table('users')->decrement('votes', 5);
```
> You may also specify additional columns to update during the operation:
```php
DB::table('users')->increment('votes',1,['name' => 'arash']);
```

---
## Delete and Truncate
```php
DB::table('users')->where('name','havij')->delete();
DB::table('users')->truncate();
```






















