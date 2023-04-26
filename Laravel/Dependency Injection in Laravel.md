> the mechanism of Laravel Dependency Injection is like bellow

> first you create a `Title` class , like bellow
>
> ```php
> class Title { // note that we have removed the "extends Model"
>     
>     $titles_array = ['this','that','some','thing'];
>     
>     // and we can have methods like bellow ( to use it in the Controller)
>     
>     public function get() {
>         return $this->titles_array;
>     }
> }
> 
> // now in the controller we can have :
> 
> class MyController extends Controller {
>     
>     public function __construct(Title $titles) {
>         $this->titles = $titles->get();
>     }
>     
>     public function di() {
>         dd($this->titles);
>     }
> }
> ```
>
> 