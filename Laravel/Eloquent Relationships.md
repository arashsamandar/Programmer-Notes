# Eloquent Relationships

## one to one
```php
class User extends Model {
    public function phones() {
       return $this->hasOne('App\Phone'); // if you don't mention the foreign key , by default it expects Phone Model To have a user_id in its records
    }
}
```

> Once the relationship is defined, we may retrieve the related record using Eloquent's dynamic properties. Dynamic properties allow you to access relationship methods as if they were properties defined on the model
```php
$Userphone = User::find(1)->phones;
```

> Eloquent determines the `foreign key` of the relationship based on the `model name`. In this case, the Phone model is automatically assumed to have a `user_id` foreign key. If you wish to override this convention, you may pass a second argument to the `hasOne` method
```php
return $this->hasOne('App\Phone','foreign_key');
```

### Defining The Inverse Of the Relationship
> so the `hasOne` becomes `belongTo` for that Model :
```php
class Phone extends Model {
    public function users() {
       return $this->belongsTo('App\User','forein_key','local_key'); // you can override the default key as
       // above example.
    }
}
```

---

## One To Many

```php
class Post extends Model {
   public function comments(){
       return $this->hasMany('App\Comment');
   }
}
```

---

### Acceing the Model
```php
$comments = Post::find(1)->comments;
foreach($comments as $comment) {
   // do whatever
}
```

> Since all relationships also serve as query builders, you can add further constraints to which comments are retrieved by calling the comments method and continuing to chain conditions onto the query

> `MOHEM` 
```php
$comment = Post::find(1)->comments()->where('title','foo')->first(); // gets the first comment wich it's post has the title of foo
// or
$comment = Post::find(1)-comments()->first()->property_of_comment // gets the property of the first comment that belongs to post with id 1
// or
$comment = Post::find(1)->comments; // returns all comments for post with id of 1 , wich you can use in a foreach loop or like bellow :
$commentOne = $comment[0]->message;
// or
$comment = Post::find(1)->comments()->get() // NOTE if you don't use it like property , you have to call the get() on it .
// or
$user = User::find(1); // as every user has messages , we can do :
$MessageOneFromUser = $user->messages[0]->message;
// or to use query
$user = User::find(1);
$userActiveMessages = $user->messages()->where('active',1)->get(); // as every user has messages
// see more at the Quering Relations Section
```

---

## One To Many Inverse
```php
class Comment extends Model {
   public function post() {
      return $this->belongsTo('App\Post','post_id','id');
   }
}
```

> Accessing the `post` of specific `comment`
```php
$comment = Comment::find(1);
echo $comment->post->title;
```

---
## Many To Many
> Many-to-many relations are slightly more complicated than hasOne and hasMany
> `Example` : a User may Have Many Roles and a Role May Belong To Many Users , like Admin for example
> `Define` : to define it we need three tables , like : `users` `roles` `role_user`
> The  role_user table is derived from the alphabetical order of the related model names, and contains the `user_id` and `role_id` columns.

```php
class User extends Model
{
    public function roles()
    {
        return $this->belongsToMany('App\Role','role_user','user_id','role_id');
    }
}
```

```php
class Role extends Model
{
    public function users()
    {
        return $this->belongsToMany('App\User','role_user','role_id','user_id');
    }
}
```

## Querying Relations

```php
$user = User::find(1);
$userActiveMessages = $user->messages()->where('active',1)->get();
```
### Querying Relationship Existence
```php
$user = User::find(1)->has('messages')->get();
$posts = App\Post::has('comments', '>=', 3)->get();
```


> `whereHas` and `orWhereHas`

```php
// for example getting all active messages of a user number 2
$ActiveMessageOfUserTwo = Message::where('active',1)->whereHas('users',function($query){
               $query->where('user_id',2);
})->get();
```

---
## Inserting & Updating Related Models

```php
$message = new Message;
$message->active = 1;
$message->text = "hello from laravel";
User::find(2)->messages()->save($message);
```

> inserting more than one , with `saveMany`
```php
User::find(2)->messages()->saveMany([
    new Message(['active' => 1,'text' => 'hello']),
    new Message(['active' => 0,'text' => 'goodbye'])
]);
```


### Recursively Saving Models & Relationships
> If you would like to save your model and all of its associated relationships, you may use the  `push` method
```php
$post = App\Post::find(1);
$post->comments[0]->message = 'Message';
$post->comments[0]->author->name = 'Author Name';
$post->push();
```


### The Create & createMany Methods
```php
$post = App\Post::find(1);
$comment = $post->comments()->create([
    'message' => 'A new comment.',
]);
```

---
## Belongs To Relationships
> When updating a `belongsTo` relationship, you may use the `associate` method.
```php
$account = App\Account::find(10);
$user->account()->associate($account);
$user->save();
```
## Counting Related Models
> If you want to count the number of results from a relationship without actually loading them you may use the `withCount` method, which will place a `{relation}_count` column on your resulting models. For example:
```php
$posts = App\Post::withCount('comments')->get();
foreach ($posts as $post) {
    echo $post->comments_count;
}
```

> You may add the "counts" for multiple relations as well as add constraints to the queries
```php
$user = User::where('id',2)->withCount('messages')->get();
$userTwo_numberOfMessages = $infos[0]->messages_count;
// or
$posts = App\Post::withCount(['votes', 'comments' => function ($query) {
    $query->where('content', 'like', '%foo%');
}])->get();
echo $posts[0]->votes_count;
echo $posts[0]->comments_count;
```






























