## Passing Arguments as much as we want :

```typescript
function printThemOut(...args) {
    args.forEach(arg => {
        console.log(arg);
    })
}
// now call it like bellow :
printThemOut('arash','samandar','havij');
// output : arash samandar havij

// of if we want to define as much property as we want in typescript oafter defining that Object

const myObject = {
    name: string;
    family: string;
    [key: string]: any // meaning any string like age or ... as prope
}
let folani: myObject = {'arash','samandar'};
folani.age = 34; // like this one or... etc...
folani.fruite = 'apple'; // cause type is "any"
```

