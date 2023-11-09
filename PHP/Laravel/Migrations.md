## Define a Forein Key in the Migration

```php
public function up() {
	$table->integer('user_id')->unsigned();
	$table->foreign->('user_id')->references('id')->on('id');   
}
```

