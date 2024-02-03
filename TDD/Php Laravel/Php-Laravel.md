First every function must begin with the word __test__

> first i write my sample class and it's method ( in controller here ) named `Calculator`
>
> ```php
> namespace App\Http\Controllers;
> 
> use Illuminate\Http\Request;
> 
> class Calculator extends Controller
> {
>     public function addNumbers($numberOne,$numberTwo) : int {
>         return ($numberOne + $numberTwo);
>     }
> }
> ```

> first create a test file with :
>
> ```
> php artisan make:test ArashTestOne
> ```

> now write the test method there ( must begin with the word "test" like test_one() , *in this case i have created a `Calculator` class in my controllers* and i wanna test one method in it
>
> ```php
> namespace Tests\Feature;
> 
> use App\Http\Controllers\Calculator;
> use Tests\TestCase;
> 
> class CalculatorTest extends TestCase
> {
> 
>     public function test_example()
>     {
>         $calculator = new Calculator();
>         $equalsTo = $calculator->addNumbers(10,40);
>         $this->assertEquals(50,$equalsTo);
>     }
> }
> ```

> then run `php artisan test`

> or like below testing an `End Point` like :
>
> ```php
> namespace Tests\Feature;
> 
> use App\Http\Controllers\Calculator;
> use Illuminate\Foundation\Testing\RefreshDatabase;
> use Illuminate\Foundation\Testing\WithFaker;
> use Tests\TestCase;
> 
> class CalculatorTest extends TestCase
> {
>     public function test_one() {
>         $response = $this->post('/api/mytestroute');
>         $response->assertSeeText("Hello Arash");
>     }
> }
> ```

> this one even checks `Database` :| !!
>
> ```php
> 
>    public function canCreateAPost()
>    {
>        $data = [
>            'title' => $this->faker->sentence,
>            'description' => $this->faker->paragraph,
>        ];
> 
>        $response = $this->json('POST', '/api/v1/posts', $data);
> 
>        $response->assertStatus(201)
>            ->assertJson(compact('data'));
> 
>        $this->assertDatabaseHas('posts', [
>            'title' => $data['title'],
>            'description' => $data['description'],
>        ]);
>    }
> 
> ```

### Unit Test And Feature ( Functional Tests )

> so as you know `unit tests` are smaller and check the smaller portion of the code like how a method of a class works ( these tests also don't have access to Database or Apis ).
>
> on the other hand feature ( funtional tests ) have access to Database and Apis and etc ... and are testing a greator portion of the application .



