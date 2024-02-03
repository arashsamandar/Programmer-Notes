## Facades

> Facades in Laravel provide a static interface to classes that are available in the application's service container. They serve as "static proxies" to underlying components in the Laravel framework, providing a terse, expressive syntax that is easy to read and understand.
>
> For instance, the `Schema` class is actually a facade that provides access to the underlying database schema builder. It provides a clean, fluent interface to creating and modifying database tables.

```php
Schema::create('users', function ($table) {
    $table->increments('id');
});
```

## Schema

> Schemas in Laravel refer to the database structure. They provide a database agnostic way of manipulating tables, meaning they work well with all databases supported by Laravel and have a unified API across all these systems. For example, you can create, modify, or drop tables using the Schema class.

```php
Schema::create('users', function($table){
    $table->increments('id');
});
```

