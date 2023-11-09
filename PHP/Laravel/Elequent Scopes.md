# Elequent Scopes

---

## Local Scopes

> Local scopes allow you to define common sets of constraints that you may easily re-use throughout your application
```php
class User extends Model {
    public function popularUsers($query) {
        return $query->where('votes','>',100);
    }
    
    public function activeUser($query) {
       return $query->where('active',1);
    }
}
```

### Using Local Scopes
```php
$user_ActivePopular = App\User::popular()->active()->get();
// Combine Scopes With Or
$user = App\User::popular()->orWhere->active()->get();
```

> using :
### Dynamic Scopes
```php
class User extends Model {
    public function myDynamic($query,$value) {
        return $query->where('type',$value);
    }
}
// and using it with
$user = User::myDynamic('admin')->get();
```

---

## Global Scopes

> Global scopes allow you to add constraints to all queries for a given model.
>  To write a Global Scope You Need To :
1. you need to implement `Illuminate\Database\Eloquent\Scope` `interface` 
1. you need to define `apply()` function
1. in wich `apply()` method may add `where()`
```php
namespace App\Scope

use Illuminate\Database\Eloquent\Scope;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\Model

class AgeScope implements Scope {
     public function apply(Builder $builder,Model $model) {
          $builder->where('age','>',24);
     }
}
```

### Applying Global Scopes
> To assign a global scope to a model, you should override a given model's boot method and use the  `addGlobalScope` method:
```php
namespace App;

use App\Scope\AgaeScope;
use Illuminate\Database\Eloquent\Model;

class User extends Model {
    public function boot() {
       parent::boot();
       static::addGlobalScope(new AgeScope);
    }
}
```

> After adding the scope, a query to `User::all()` will produce the following SQL:
```sql
select * from `users` where `age` > 200
```

### Anonymous Global Scopes
- anonymous scopes do not need to be written in a class wich implements `scope` interface.
- they can be directly written  to the `Model` `boot()` class
```php
class User extends Model {
     public function boot() {
          Parent::boot();
          static::addGlobalScope('ageScope', function Builder($builder)) {
              $builder->where('age','>',20);
          });
     }
}
```

### Removing Global Scope
- use `withoutGlobalScope('scopename');`
- or to remove all scopes use `withoutGlobalScopes();`
```php
$user = User::withoutGlobalScope('ageScope')->get();
//or
$user = User::withoutGlobalScopes()->get();
// remove some of global scopes :
$user = User::withoutGlobalScope([FirstScope::class,SecondScope::class])->get();
```
