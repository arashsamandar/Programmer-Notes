## `Polymorphic` Relation :

> Used to Share a `Table` or `Model` Two ( 2 ) or More Models

- use **morphTo** on the **shared model** 
- use **morphMany** on the models that share it.

:apple: __Example__ using in messagin application

```php
/*
	use relationship name : `sender` , `receiver` , `imageable`
	Laravel will infer the `sender_type` , `sender_id` , `reciever_type` , `reciever_id`
	`imageable_type` , `imageable_id` , from it.
	
	Remember to have the columns needed for your Relation.
*/

// Message table Migration :
public function up(): void
    {
        Schema::create('messages', function (Blueprint $table) {
            $table->id();
            $table->string('message');
            $table->unsignedBigInteger('sender_id');
            $table->unsignedBigInteger('receiver_id');
            $table->string('sender_type');
            $table->string('receiver_type');
            $table->boolean('is_read')->default(false);
            $table->timestamps();
        });
    }

// on the `Message` model :
public function sender(): MorphTo
    {
        return $this->morphTo();
    }

    public function receiver(): MorphTo
    {
        return $this->morphTo();
    }

// on the `User` and `Admin` model :
public function sentMessages(): MorphMany
    {
        return $this->morphMany(Message::class, 'sender');
    }

    public function receivedMessages(): MorphMany
    {
        return $this->morphMany(Message::class,'receiver');
    }

// no using them on your $user or $admin instances
```

-----------

## morphedOne & morphedByMany

- **`morphOne`:** Similar to `hasOne`, but for polymorphic relationships. It's used when a single model can belong to one of several different models.

  php

  Copy

  ```php
  // Example: An Image can belong to a User or a Product
  class Image extends Model 
  {
      public function imageable()
      {
          return $this->morphTo(); 
      }
  }
  
  class User extends Model 
  {
      public function image()
      {
          return $this->morphOne(Image::class, 'imageable');
      }
  }
  ```

- **`morphedByMany`:** Analogous to `belongsToMany`, enabling many-to-many polymorphic relationships.

  php

  Copy

  ```php
  // Example: Posts and Videos can have Tags
  class Tag extends Model
  {
      public function posts()
      {
          return $this->morphedByMany(Post::class, 'taggable');
      }
  
      public function videos()
      {
          return $this->morphedByMany(Video::class, 'taggable');
      }
  } 
  ```

**In essence:**

- `morphOne`: One-to-one polymorphic (one side can have only one).
- `morphMany`: One-to-many polymorphic (one side can have multiple).
- `morphedByMany`: Many-to-many polymorphic (both sides can have multiple).

## morphToMany & morphedByMany

> Needs an Intermadiate Table

```php
class Tag extends Model
{
    public function posts()
    {
        return $this->morphedByMany(Post::class, 'taggable');
    }

    public function videos()
    {
        return $this->morphedByMany(Video::class, 'taggable');
    }
}

class Post extends Model 
{
    public function tags()
    {
        return $this->morphToMany(Tag::class, 'taggable');
    }
}
```

