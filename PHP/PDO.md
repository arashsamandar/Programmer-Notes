> PDO means `php data object` . it is intruduced from version 5 .

```php
// first creating it with

$dsn = "mysql:host=localhost;dbname=arash;charset=utf8";
$db = new PDO($dsn,'username','password');

// and now the database is ready
```

> fetching data without saving them using the `foreach` loop like bellow

```php
$sql = "SELECT name,family from mytable";

foreach($db->query($sql) as $row) {
    echo $row['name'];
    echo $row['family'];
}
```



> > although for fetching data with pdo we have several methods like bellow

1. fetch() `gets the next row from the result set`
2. fetchAll() `creates an array containing all rows`
3. fetchColumn `gets single column from the next row`
4. fetchObject() `gets the next row as an object`

> using the `fetch`to get them one by one like bellow

```php
$sql = "SELECT name,family FROM mytable";
$result = $db->query($sql);
while($row = $result->fetch()) {
    echo $row['name'];
    echo $row['family'];
}
```

> using the `fetchAll` method to get them all .

```php
$result = $db->query($sql);
$allResult = $result->fetchAll(PDO::fetch_assoc); // it returns an array containing all the result , both in number and in assoc ( name ) , because we only want name i got it the PDO::fetch_assoc
<pre>
    print_r($allResult);
</pre>
```

> using `fetchColumn`

```php
while($col = $result->fetchColumn(2)) {
    echo $col;
}
```

## Ask For The Number Of Results

```php
$result = $db->query($sql);
$numRows = $result->rowCount();
```

> ofcourse you can also do it with the following command in Query

```php
$count = $db->query("SELECT COUNT(*) FROM mytable");
$numCount = $count->fetchColumn();
```

## Inserting Into Database

> when you want to insert into the database or change anything it is better to use `exec`before `query`just like bellow
>
> `exec`method always returns the number of rows affected by the query . while the query if your operation is insert or delete only gives you your queyr . and in the select case returns the data set to you .
>
> use `exec`for `Insert Update Delete` 

```php
$sql = "INSERT INTO mytable (name,family,gender) VALUES 
       ("Arash","samandar","Male")"
$result = $db->exec($sql);
// also get the last inserted ID with
$db->lastInsertId();
```

## catching Errors

> if you want to catch the errors in the try catch block , always use `$db->errorInfo();`like bellow

```php
$db->setAttributes(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION)
$sql = "SELECT name FROM nams" // you see nams is an error
try {
    $result = $db->query($sql);
    $errorInfor = $db->errorInfo();
}catch(Exception $e) {
    $error = $e->getMessage();
}
```

