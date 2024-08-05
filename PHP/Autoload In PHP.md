> ## Using Autoload without Composer
>
> Here's a basic example of how to use autoload without Composer:
>
> 1. Create a directory structure for your project, for example:
>
>    Copy
>
>    ```
>    my_project/
>    ├── classes/
>    │   ├── Foo.php
>    │   └── Bar.php
>    └── index.php
>    ```
>
> 2. In the `Foo.php` and `Bar.php` files, define your classes:
>
>    php
>
>    Copy
>
>    ```
>    // Foo.php
>    class Foo
>    {
>        public function doSomething()
>        {
>            echo "Doing something in Foo class.";
>        }
>    }
>    
>    // Bar.php
>    class Bar
>    {
>        public function doSomething()
>        {
>            echo "Doing something in Bar class.";
>        }
>    }
>    ```
>
> 3. In the `index.php` file, create a custom autoload function and register it using `spl_autoload_register()`:
>
>    php
>
>    Copy
>
>    ```
>    // index.php
>    function my_autoloader($className)
>    {
>        $file = __DIR__ . '/classes/' . $className . '.php';
>        if (file_exists($file)) {
>            require_once $file;
>        }
>    }
>    
>    spl_autoload_register('my_autoloader');
>    
>    $foo = new Foo();
>    $foo->doSomething(); // Output: Doing something in Foo class.
>    
>    $bar = new Bar();
>    $bar->doSomething(); // Output: Doing something in Bar class.
>    ```
>
>    In this example, the `my_autoloader()` function is responsible for loading the class files when they are needed. The `spl_autoload_register()` function registers the autoloader, so that PHP can use it to load the classes.
>
> ## Using Autoload with Composer
>
> Now, let's see how to use autoload with Composer:
>
> 1. Install Composer on your system if you haven't already. You can download it from the official website: https://getcomposer.org/download/
>
> 2. In your project directory, run the following command to initialize a new Composer project:
>
>    Copy
>
>    ```
>    composer init
>    ```
>
>    This will create a `composer.json` file in your project directory.
>
> 3. Open the `composer.json` file and add the following configuration to define the autoload settings:
>
>    json
>
>    Copy
>
>    ```
>    {
>        "autoload": {
>            "psr-4": {
>                "MyProject\\": "src/"
>            }
>        }
>    }
>    ```
>
>    This tells Composer to use the PSR-4 autoloading standard and map the `MyProject` namespace to the `src/` directory.
>
> 4. Create the `src/` directory and add your class files there. For example:
>
>    Copy
>
>    ```
>    my_project/
>    ├── composer.json
>    ├── src/
>    │   ├── Foo.php
>    │   └── Bar.php
>    └── index.php
>    ```
>
> 5. In the `Foo.php` and `Bar.php` files, define your classes with the `MyProject` namespace:
>
>    php
>
>    Copy
>
>    ```
>    // Foo.php
>    namespace MyProject;
>    
>    class Foo
>    {
>        public function doSomething()
>        {
>            echo "Doing something in Foo class.";
>        }
>    }
>    
>    // Bar.php
>    namespace MyProject;
>    
>    class Bar
>    {
>        public function doSomething()
>        {
>            echo "Doing something in Bar class.";
>        }
>    }
>    ```
>
> 6. In the `index.php` file, include the Composer autoloader and use the classes:
>
>    php
>
>    Copy
>
>    ```
>    // index.php
>    require_once 'vendor/autoload.php';
>    
>    use MyProject\Foo;
>    use MyProject\Bar;
>    
>    $foo = new Foo();
>    $foo->doSomething(); // Output: Doing something in Foo class.
>    
>    $bar = new Bar();
>    $bar->doSomething(); // Output: Doing something in Bar class.
>    ```
>
>    The `require_once 'vendor/autoload.php';` line includes the Composer autoloader, which will automatically load the classes when they are needed.
>
> These examples should give you a good starting point for using autoload and Composer in your PHP projects. The key things to remember are:
>
> 1. Autoload without Composer: Use a custom autoloader function and register it with `spl_autoload_register()`.
> 2. Autoload with Composer: Define the autoload settings in the `composer.json` file, use namespaces for your classes, and include the Composer autoloader in your code.