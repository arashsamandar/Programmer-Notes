## create model with -mfs

> this command creates Model , Factory & Seeder
>
> ```
> php artisan make:model Petition -mfs
> ```

> now to create the controller run :
>
> ```
> php artisan make:controller PetitionController --api --model=Petition
> ```

> then we create a Petition Resource with :
>
> ```
> php artisan make:resource PetitionResource
> ```
>
> api resources are Templates where you define how you want the JSON data to be returned to the user when they send an api request .

> when we want to return more than one resource , more than one petition , we create a resource collection
>
> ```
> php artisan make:resource PetitionCollection
> ```

## Working With Factory & Seeder

> to create the `Model` With the migration, Factory & Seeder , you need to run :
>
> ```
> php artisan make:model Petition -mfs
> ```

## Fill The Database With Factory & Seeder

> after you ran the above command , you have Seeder and Migration and Factory Created .
>
> now go to the Factory and in its `definition` Method . write something like bellow :

```php
public function definition()
    {
        return [
            'title' => $this->faker->word,
            'category' => $this->faker->text,
            'description' => $this->faker->text(200),
            'auther' => $this->faker->name,
            'signees' => $this->faker->numberBetween(0,100000)
        ];
    }
```

> then go to your model seeder file and run the following :

```php
class PetitionSeeder extends Seeder
{
    public function run()
    {
        Petition::factory(50)->create();
    }
}
```

--------------

### Send data to the view ( Moden Way )

```php
$petitions = Petitioin::all();
return view('index')->with('petition',$petition);
```

### Send data from api

> to send data in our api , Laravel has Api resources , we have created one in above codes . in the `PatitionResource` we can customize what we want to send , which fields to hide and which to show and how to structure them and etc ...

> in this `PetitionResource` file we have bellow code :
>
> ```php
> public function toArray($request)
> {
>     return parent::toArray($request);
> }
> // we change it to what we want ( overload ) , like bellow code :
> public function toArray($request)
>     {
>         return [
>           'id' => $this->id,
>           'title' => $this->title,
>           'auther' => $this->auther,
>         ];
>     }
> ```
>
> But , when we are returning `a list of resource` , we use `PetitionCollection` which we defined in above codes .
>
> like bellow :
>
> ```php
> class PetitionCollection extends ResourceCollection
> {
> 
>     public function toArray($request)
>     {
>         return [
>           'data' => $this->collection,
>         ];
>     }
> }
> ```
>
> now in the `PetitionController` we have bellow :
>
> ```php
> public function index() {
>     $petitions = Petition::all();
>     return PetitionResource::collection(Petition::all());
> }
> // or
> public function index() {
>     return new PetitionCollection(Petition::all());
> }
> ```

## Create method

```php
public function store(Request $request)
{
     $petition = Petition::create($request->only([
         'title','description','category','auther','signees',
     ]));
     return new PetitionResource($petition);
}
```

-----------

----------------

# The Entire PetitionController Codes

```php
<?php

namespace App\Http\Controllers;

use App\Http\Resources\PetitionCollection;
use App\Http\Resources\PetitionResource;
use App\Models\Petition;
use Illuminate\Http\Request;

class PetitionController extends Controller
{
    public function index()
    {
        return new PetitionCollection(Petition::all());
    }


    public function store(Request $request)
    {
        $petition = Petition::create($request->only([
            'title','description','category','auther','signees',
        ]));
        return new PetitionResource($petition);
    }


    public function show(Petition $petition)
    {
        return new PetitionResource($petition);
    }


    public function update(Request $request, Petition $petition)
    {
        $petition->update($request->only([
            'title','description','category','auther','signees'
        ]));
        return new PetitionResource($petition);
    }


    public function destroy(Petition $petition)
    {
        $petition->delete();
        return response()->json(null,204);
    }
}

```

# Send Back The Response In A Different Fasion

> for example for the `index` method , instead of returning the `new ResourceCollection($petition)` we use the `response` , like bellow :
>
> ```php
> public function index()
>     {
>         return response()->json(new PetitionCollection(Petition::all()),200);
>     	// or you could use HTTP Response Instead of the `200` code , like bellow :
>     	return response->json(new 	ResourceCollection(Petition::all()),
>                               Response::HTTP_OK)
>     }
> ```
