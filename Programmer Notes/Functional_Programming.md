#### Functional Programming is a programming Paradigm

## What is programming Paradigm ?

> as we know functional programming is a programming paradigm

> programming paradigm is simply a way of thinking about solving the problems , you can think of it as a programming tool set .

> functional programming is rooted conceptually in mathematics .

> functional programming is language independent .

#### Key principle in functional programming ?

> is that functional programming thinks of all computation as the execution of a series of mathematical functions .

*All computation is the execution of mathematical functions*

> in mathematics a function is simply mapping a number to number , like

$$
f(x) = x^2
$$

> as we can see for example it relates number 2 to number 4 .

$$
f(x,y) = f(x) + f(y)
$$

> in functional programming , functions ofcourse can't change there input , because it is not a variable , they are numbers .
>
> in simple way you can't change any variables .
>
> this is a concept known as Immutability .
>
> meaning for example you can't have a counter .
>
> this is programming without variable assignment .

---------------

*An Example is Sum Function in haskell* 

> do remember that in functional programming we try to assing arguments to functions , and in normal programming we assing value to variable .

```haskell
sum[1..10];

sum::[int]->int
sum[n] = n;
sum(n:ns) = n + sum[ns];

// now we have

sum[4,5,6] // now we look for above patterns
// it is like the 4=n and 5,6=ns ( the third one);
= 4 + sum[5,6]
= 4 + 5 + n
= 4 + 5 + 6
```

> this type of programming for example is in a game

> when we want to say when the `bullet` hits the `baloon`

## The Use of functional programming

>**Functional Programming** is used in situations where we have to perform lots of different operations on the same set of data. Lisp is used for artificial intelligence applications like Machine learning, language processing, Modeling of speech and vision, etc

## Benefits of functional programming

1. [Pure functions are easier to reason about](https://alvinalexander.com/scala/fp-book/benefits-of-functional-programming#pure-functions-are-easier-to-reason-about)
2. [Testing is easier, and pure functions lend themselves well to techniques like property-based testing](https://alvinalexander.com/scala/fp-book/benefits-of-functional-programming#testing-is-easier-and-pure-functions-lend-themselves-well-to-techniques-like-property-based-testing)
3. [Debugging is easier](https://alvinalexander.com/scala/fp-book/benefits-of-functional-programming#debugging-is-easier)
4. [Programs are more bulletproof](https://alvinalexander.com/scala/fp-book/benefits-of-functional-programming#programs-are-more-bulletproof)
5. [Programs are written at a higher level, and are therefore easier to comprehend](https://alvinalexander.com/scala/fp-book/benefits-of-functional-programming#programs-are-written-at-a-higher-level-and-are-therefore-easier-to-comprehend)
6. [Function signatures are more meaningful](https://alvinalexander.com/scala/fp-book/benefits-of-functional-programming#pure-function-signatures-are-meaningful)
7. [Parallel/concurrent programming is easier](https://alvinalexander.com/scala/fp-book/benefits-of-functional-programming#parallel-programming)