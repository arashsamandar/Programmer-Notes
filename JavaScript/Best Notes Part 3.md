# Best Notes Part 3

> Different Ways of Including a `Function` in your `Node`

**example**
```markup
<button onclick="this.innerHTML=Date()">The Time Is</button>
// or
<button onclick="myfunction()">the time is</button>
// or
$('#btnOne').on('click',function(){
   return yourAnswer
});
```

> some `String` functions
1. `lenght` , wich return the number of charachters in an string
1. `indexOf` return -1 if not exists
1. `split` like : str.split(',') , wich return an array
1. `replace` like : str.replace('arash','samandar');
1. `toUpperCase` and `toLowerCase`

