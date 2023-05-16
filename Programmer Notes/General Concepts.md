## Relation Between Objects

- `Association` : when one object uses the other in it's field or somewhere in its implementation, is shown by a __simple arrow__, is a `has-a` relationship
- `Dependency` : is a weaker variant of association that usually implies that there’s no permanent link between objects. Dependency typically (but not always) implies that an object accepts another object as a method parameter
- `Composition` : Composition is a “whole-part” relationship between two objects, one of which is composed of one or more instances of the other. The distinction between this relation and others is that the component can only exist as a part of the container
- `Aggregation` : Aggregation is a less strict variant of composition, where one object merely contains a reference to another

![image-20230506062909739](E:\Programmer-Notes\Programmer Notes\General Concepts.assets\image-20230506062909739.png)

- `Composition`

  ![image-20230506062942688](E:\Programmer-Notes\Programmer Notes\General Concepts.assets\image-20230506062942688.png)

- `Dependency`

![image-20230506063008610](E:\Programmer-Notes\Programmer Notes\General Concepts.assets\image-20230506063008610.png)

- `Association`

  ![image-20230506063043224](E:\Programmer-Notes\Programmer Notes\General Concepts.assets\image-20230506063043224.png)

### Difference Between `Association` & `Aggregation`

> `association` one object uses for example a method of another object , like a person object that has-a address object . *that one class has a reference to another class.*
>
> `aggregation`  represents a whole-part relationship. The aggregated object is part of the whole object, but it can exist independently of the whole object. It is represented by a "part-of" relationship. An example of aggregation is a car object has a wheel object. If the car is destroyed, the wheel can still exist.

-----------------

-------------------

![image-20230506063716056](E:\Programmer-Notes\Programmer Notes\General Concepts.assets\image-20230506063716056.png)

> like bellow codes :

![image-20230506065639869](E:\Programmer-Notes\Programmer Notes\General Concepts.assets\image-20230506065639869.png)

>After making this change, you won’t probably feel any immediate benefit. On the contrary, the code has become more complicated than it was before. However, if you feel that this might be a good extension point for some extra functionality, or that some other people who use your code might want to extend it here, then go for it.

#### Example Code In TypeScript

```typescript
class Cat {
    private energy: number = 0;
    public eat(food: Suasage) {
        console.log('eat something ' + food.getNutriants('Sausage'));
    }
}

interface Food {
    getNutriants(typeofNutriatns: string): void;
}

class Suasage implements Food {
    getNutriants(typeofNutriatns: string) {
        return 'Sausage Nutiriants'
    }
}

let mew: Cat = new Cat();
let sasi: Suasage = new Suasage();
mew.eat(sasi);
```

> another example when we want to create a "software development company", that has many employees that do different jobs and contribute to the company .

> a bad way to go is this :

![image-20230506072318575](E:\Programmer-Notes\Programmer Notes\General Concepts.assets\image-20230506072318575.png)

> thi fixed version is this :

![image-20230506072353469](E:\Programmer-Notes\Programmer Notes\General Concepts.assets\image-20230506072353469.png)

> no this `Company` class is still dependent on the `Employee` class .
>
> better approach is to make it `abstract` , like bellow :

![image-20230509082344747](E:\Programmer-Notes\Programmer Notes\General Concepts.assets\image-20230509082344747.png)

-------------

## Prefer To Use `Composition` Over `Inheritance`